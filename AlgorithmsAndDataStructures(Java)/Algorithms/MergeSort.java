public class MergeSort {
    int array[];

    public MergeSort(int arr[]){
    array = arr;
    }

    private void merge(int arr[], int first, int middle, int last) {
        int size1 = middle - first + 1;
        int size2 = last - middle;

        int arr1[] = new int[size1];
        int arr2[] = new int[size2];

        for (int i = 0; i < size1; ++i)
            arr1[i] = arr[first + i];
        for (int j = 0; j < size2; ++j)
            arr2[j] = arr[middle + 1 + j];

        int i = 0, j = 0;
        int k = first;

        while (i < size1 && j < size2) {
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
            } else {
                arr[k] = arr2[j];
                j++;
            }
            k++;
        }

        while (i < size1) {
            arr[k] = arr1[i];
            i++;
            k++;
        }

        while (j < size2) {
            arr[k] = arr2[j];
            j++;
            k++;
        }
    }

    public void sort(int arr[], int first, int last) {
        if (first < last) {
            int m = (first + last) / 2;
            sort(arr, first, m);
            sort(arr, m + 1, last);

            merge(arr, first, m, last);
        }
    }

    public int[] getArray(){
        return array;
    }
}

