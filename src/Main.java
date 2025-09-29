import java.util.Random;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        // Defina os tamanhos dos arrays para os testes
        int[] arraySizes = {10, 1000, 10000, 100000};
        int numTests = 1; // Número de vezes para rodar cada teste para a média

        System.out.println("Análise de Algoritmos de Ordenação");

        // Loop através de cada tamanho de array definido
        for (int size : arraySizes) {
            System.out.println("\n----------------------------------------");
            System.out.println("Testando com array de tamanho: " + size);
            
            // Arrays para armazenar os tempos de cada algoritmo
            long[] bubbleSortTimes = new long[numTests];
            long[] mergeSortTimes = new long[numTests];
            long[] quickSortTimes = new long[numTests];

            // Executa os testes múltiplas vezes para obter a média
            for (int i = 0; i < numTests; i++) {
                int[] originalArray = generateRandomArray(size);

                int[] bubbleArray = Arrays.copyOf(originalArray, size);
                long startTimeBubble = System.nanoTime();
                new BubbleSort().sort(bubbleArray);
                long endTimeBubble = System.nanoTime();
                bubbleSortTimes[i] = endTimeBubble - startTimeBubble;

                
                int[] mergeArray = Arrays.copyOf(originalArray, size);
                long startTimeMerge = System.nanoTime();
                new MergeSort().sort(mergeArray, 0, mergeArray.length - 1);
                long endTimeMerge = System.nanoTime();
                mergeSortTimes[i] = endTimeMerge - startTimeMerge;


                int[] quickArray = Arrays.copyOf(originalArray, size);
                long startTimeQuick = System.nanoTime();
                new QuickSort().sort(quickArray, 0, quickArray.length - 1);
                long endTimeQuick = System.nanoTime();
                quickSortTimes[i] = endTimeQuick - startTimeQuick;
            }

            double avgBubbleSortTime = Arrays.stream(bubbleSortTimes).average().orElse(0.0);
            double avgMergeSortTime = Arrays.stream(mergeSortTimes).average().orElse(0.0);
            double avgQuickSortTime = Arrays.stream(quickSortTimes).average().orElse(0.0);

            System.out.printf("Tempo médio (Bubble Sort):   %.2f milissegundos\n", avgBubbleSortTime / 1_000_000.0);
            System.out.printf("Tempo médio (Merge Sort):    %.2f milissegundos\n", avgMergeSortTime / 1_000_000.0);
            System.out.printf("Tempo médio (Quick Sort):    %.2f milissegundos\n", avgQuickSortTime / 1_000_000.0);
        }
    }

    /**
     * Gera um array de inteiros com números aleatórios.
     * @param size O tamanho do array.
     * @return O array gerado.
     */
    public static int[] generateRandomArray(int size) {
        int[] arr = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(size * 10);
        }
        return arr;
    }
}