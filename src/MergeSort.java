public class MergeSort {
    public void sort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            // Ordena a primeira e a segunda metade
            sort(arr, left, mid);
            sort(arr, mid + 1, right);

            // Mescla as metades
            merge(arr, left, mid, right);
        }
    }

    private void merge(int[] arr, int left, int mid, int right) {
        // Cria arrays temporários
        int n1 = mid - left + 1;
        int n2 = right - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        // Copia os dados para os arrays temporários
        for (int i = 0; i < n1; ++i) {
            L[i] = arr[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = arr[mid + 1 + j];
        }

        // Mescla os arrays temporários
        int i = 0, j = 0;
        int k = left;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Copia elementos restantes de L[] se houver
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Copia elementos restantes de R[] se houver
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
}