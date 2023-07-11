package Classes;

import java.util.Scanner;

public class Shared {

    private static Scanner inputScanner;

    /**
     * Constructor for Shared, contains shared features between Extractor and Comparer classes
     *
     * @param inputScanner scanner that detects user inputs
     */
    public Shared(Scanner inputScanner) {
        this.inputScanner = inputScanner;
    }

    public static Scanner getInputScanner() {
        return inputScanner;
    }

    /**
     * Method to scan fileName from user input.
     *
     * @return String fileName
     */
    public static String fileNameInput() {

        System.out.println("Por favor, escriba el nombre del pdf a leer:");
        String fileName = inputScanner.nextLine();

        return fileName;
    }
}
