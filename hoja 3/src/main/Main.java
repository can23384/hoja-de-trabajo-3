import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class Main {
    private static final String FILENAME = "numeros.txt";
    private static final int NUMBERS_TO_GENERATE = 3000;

    public static void main(String[] args) {
        // Generar números aleatorios y guardarlos en el archivo
        generateRandomNumbers();

        // Leer los números del archivo y guardarlos en un arreglo
        int[] numbers = readNumbersFromFile();

        // Ordenar los números utilizando cada algoritmo de sort
        System.out.println("Original Array:");
        algoritmos.printArray(numbers);

        System.out.println("\nSorting using Gnome Sort:");
        int[] gnomeSorted = numbers.clone();
        algoritmos.gnomeSort(gnomeSorted);
        algoritmos.printArray(gnomeSorted);

        System.out.println("\nSorting using Merge Sort:");
        int[] mergeSorted = numbers.clone();
        algoritmos.mergeSort(mergeSorted);
        algoritmos.printArray(mergeSorted);

        System.out.println("\nSorting using Quick Sort:");
        int[] quickSorted = numbers.clone();
 //       algoritmos.quickSort(quickSorted, 0, quickSorted.length - 1);
        algoritmos.printArray(quickSorted);

        System.out.println("\nSorting using Radix Sort:");
        int[] radixSorted = numbers.clone();
        algoritmos.radixSort(radixSorted);
        algoritmos.printArray(radixSorted);

        // "Un sort" que elija la pareja
        System.out.println("\nChoosing Pair:");
        int[] pairChosen = numbers.clone();
        algoritmos.choosePair(pairChosen, 0, 1);
        algoritmos.printArray(pairChosen);
    }

    private static void generateRandomNumbers() {
        Random random = new Random();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILENAME))) {
            for (int i = 0; i < NUMBERS_TO_GENERATE; i++) {
                writer.write(Integer.toString(random.nextInt(10000)));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static int[] readNumbersFromFile() {
        int[] numbers = new int[NUMBERS_TO_GENERATE];
        try {
            java.nio.file.Path path = java.nio.file.Paths.get(FILENAME);
            java.util.List<String> lines = java.nio.file.Files.readAllLines(path);
            int i = 0;
            for (String line : lines) {
                numbers[i++] = Integer.parseInt(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return numbers;
    }
}