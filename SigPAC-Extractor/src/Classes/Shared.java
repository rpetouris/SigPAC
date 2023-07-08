package Classes;

import java.util.Scanner;

public class Shared {

    private static Scanner inputScanner;

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
    static String fileNameInput() {

        System.out.println("Por favor, escriba el nombre del pdf a leer:");
        String fileName = inputScanner.nextLine();

        return fileName;
    }
}
