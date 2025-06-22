import java.io.*;
import java.util.Scanner;

/**
 * FileHandlingUtility
 * -------------------
 * This program demonstrates basic file operations in Java:
 * - Writing to a file
 * - Reading from a file
 * - Modifying (overwriting) file content
 *
 * 
 * Internship: CodTech Internship - Task 1
 */

public class FileHandlingUtility {

    static final String FILE_NAME = "sample.txt"; // File to work with
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- File Handling Utility ---");
            System.out.println("1. Write to File");
            System.out.println("2. Read from File");
            System.out.println("3. Modify File");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Clear buffer

            switch (choice) {
                case 1:
                    writeToFile();
                    break;
                case 2:
                    readFromFile();
                    break;
                case 3:
                    modifyFile();
                    break;
                case 4:
                    System.out.println("Exiting program.");
                    break;
                default:
                    System.out.println("Invalid choice. Please select again.");
            }

        } while (choice != 4);
    }

    /**
     * Appends text entered by the user to the file.
     */
    public static void writeToFile() {
        try (FileWriter fw = new FileWriter(FILE_NAME, true);
             BufferedWriter bw = new BufferedWriter(fw)) {

            System.out.print("Enter text to write: ");
            String text = scanner.nextLine();
            bw.write(text);
            bw.newLine();
            System.out.println("Text written successfully!");

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    /**
     * Reads and displays the content of the file.
     */
    public static void readFromFile() {
        try (FileReader fr = new FileReader(FILE_NAME);
             BufferedReader br = new BufferedReader(fr)) {

            String line;
            System.out.println("\n--- File Content ---");
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please write to the file first.");
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    /**
     * Replaces the entire content of the file with new input.
     */
    public static void modifyFile() {
        try (FileWriter fw = new FileWriter(FILE_NAME, false);
             BufferedWriter bw = new BufferedWriter(fw)) {

            System.out.print("Enter new content to overwrite the file: ");
            String newText = scanner.nextLine();
            bw.write(newText);
            bw.newLine();
            System.out.println("File modified successfully!");

        } catch (IOException e) {
            System.out.println("Error modifying file: " + e.getMessage());
        }
    }
}

