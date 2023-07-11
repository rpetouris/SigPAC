import Classes.Extractor;
import Classes.Shared;

import java.util.Scanner;


public class Main {
    static Scanner inputScanner = new Scanner(System.in);
    static Shared shared;
    static Extractor extractor = new Extractor(inputScanner);

    public static void main(String[] args) {
        System.out.println("SigPAC ToolKit por Rafael Petouris");

        shared = new Shared(inputScanner);

        String option = "";

        while (!option.equals("3")) {
            System.out.println(
                    "-------------------------------- \n" +
                            "Por favor, indique el número de la opción a realizar: \n" +
                            "1 - Escanear pdf a tabla \n" +
                            "2 - Comparar diferencias entre tablas \n" +
                            "3 - Cerrar aplicación \n" +
                            "-------------------------------- "
            );

            option = inputScanner.nextLine();

            optionSwitchCase(option);
        }


        inputScanner.close();

    }

    /**
     * Switch case for selection of tools to use.
     *
     * @param option the option selected.
     */
    private static void optionSwitchCase(String option) {
        switch (option) {
            case "1":
                System.out.println("Ha elegido 'Escanear pdf a tabla:'");
                extractor.pdfExtractor();
                break;
            case "2":
                System.out.println("Ha elegido 'Comparar diferencias entre tablas'");
                System.out.println("Esta opción no está aún desarrollada. Lamento las molestias.");
                break;
            case "3":
                System.out.println("Muchas gracias por usar este servicio.\n" +
                        "Si ha tenido problemas, por favor contacte con r.petouris@gmail.com");
                break;
            default:
                System.out.println("La opción introducida no es válida. Introduzca un número del 1 al 3. \n" +
                        "Inténtelo de nuevo \n");
                break;
        }
    }
}