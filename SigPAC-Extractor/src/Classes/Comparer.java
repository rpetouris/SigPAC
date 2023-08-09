package Classes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Comparer extends Shared{
    /**
     * Constructor for Shared, contains shared features between Extractor and Comparer classes
     *
     * @param inputScanner scanner that detects user inputs
     */
    public Comparer(Scanner inputScanner) {
        super(inputScanner);
    }

    public void dataComparer() {
        System.out.println("SigPAC Extractor por Rafael Petouris");

        System.out.println("Archivo 1");
        String firstFileName = super.fileNameInput();
        System.out.println("Ha decidido abrir el archivo \"" + firstFileName + "\"");
        File firstFile = new File("./Files/" + firstFileName + ".txt").getAbsoluteFile();

        System.out.println("Archivo 2");
        String secondFileName = super.fileNameInput();
        System.out.println("Ha decidido abrir el archivo \"" + secondFileName + "\"");
        File secondFile = new File("./Files/" + secondFileName + ".txt").getAbsoluteFile();

        System.out.println("Comparando Información:");

        List<List<Recinto>> sorted = dataSorter(firstFile, secondFile);

        String sortedDataString = generateSortedString(firstFileName, secondFileName, sorted);

        System.out.println(sortedDataString);
    }


    private static String generateSortedString(String firstFileName, String secondFileName, List<List<Recinto>> sorted) {
        String sortedDataString = "=================================\n";

        sortedDataString += "Recintos sólo en " + firstFileName + ": \n";
        for (Recinto r: sorted.get(0)) {
            sortedDataString += r.toString() + "\n";
        }

        sortedDataString += "-------------------------------\n";

        sortedDataString += "Recintos sólo en " + secondFileName + ": \n";
        for (Recinto r: sorted.get(1)) {
            sortedDataString += r.toString() + "\n";
        }

        sortedDataString += "-------------------------------\n";

        sortedDataString += "Recintos en común entre los dos archivos: \n";
        for (Recinto r: sorted.get(2)) {
            sortedDataString += r.toString() + "\n";
        }

        sortedDataString += "=================================\n";
        return sortedDataString;
    }

    private List<List<Recinto>> dataSorter(File file1, File file2) {
        List<List<Recinto>> listArray = new ArrayList<>();
        List<Recinto> firstFile = listFiller(file1);
        List<Recinto> secondFile = listFiller(file2);

        List<Recinto> onlyFirst = new ArrayList<>();
        List<Recinto> onlySecond = new ArrayList<>();
        List<Recinto> common = new ArrayList<>();

        for ( Recinto r : firstFile) {
            if (secondFile.contains(r)){
                common.add(r);
            } else {
                onlyFirst.add(r);
            }
        }

        for ( Recinto r : secondFile) {
            if (!firstFile.contains(r)){
                onlySecond.add(r);
            }
        }

        System.out.println(
                "Only First: " + onlyFirst.size() + ",\n" +
                "Only Second: " + onlySecond.size() + ",\n" +
                "Common: " + common.size()
        );

        listArray.add(onlyFirst);
        listArray.add(onlySecond);
        listArray.add(common);

        return listArray;
    }

    private List<Recinto> listFiller(File file){
        List<Recinto> fileText = new ArrayList<>();
        try {
            Scanner fileScanner = new Scanner(file);

            Recinto recinto;
            while (fileScanner.hasNextLine()) {
                String currentLine = fileScanner.nextLine();
                recinto = extractRecinto(currentLine);

                fileText.add(recinto);
            }
            //System.out.println(fileText.get(0));
            fileScanner.close();
        } catch (Exception e) {
            System.out.println("Hay un error en el archivo " + file.getName());
            if (e.getClass().equals(ArrayIndexOutOfBoundsException.class)) {
                System.out.println("El archivo está corrupto. Pruebe a rehacer el paso 1.");
            } else if (e.getClass().equals(FileNotFoundException.class)){
                System.out.println("El archivo no se ha encontrado. Compruebe que el nombre sea el correcto");
            }
            return new ArrayList<>();
        }

        return fileText;
    }

    private static Recinto extractRecinto(String currentLine) {
        String[] currentLineArray = currentLine.split(" ");
        Recinto recinto = new Recinto();

        recinto.setCodProvincia(Integer.parseInt(currentLineArray[0]));
        recinto.setCodMunicipio(Integer.parseInt(currentLineArray[1]));
        recinto.setAgregado(Integer.parseInt(currentLineArray[2]));
        recinto.setZona(Integer.parseInt(currentLineArray[3]));
        recinto.setCodPoligono(Integer.parseInt(currentLineArray[4]));
        recinto.setCodParcela(Integer.parseInt(currentLineArray[5]));
        recinto.setCodRecinto(Integer.parseInt(currentLineArray[6]));
        recinto.setNumParcelaAgricola(Integer.parseInt(currentLineArray[7]));
        recinto.setCodProducto(Integer.parseInt(currentLineArray[8]));
        recinto.setVariedad(Integer.parseInt(currentLineArray[9]));
        recinto.setSuperDeclarada(Double.parseDouble(currentLineArray[10].replace(',', '.')));
        recinto.setIrrigacion(currentLineArray[11].charAt(0));
        recinto.setUsoSigPac(currentLineArray[12]);

        return recinto;
    }

}
