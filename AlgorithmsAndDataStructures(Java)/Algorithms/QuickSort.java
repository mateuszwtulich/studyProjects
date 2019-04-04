public class QuickSort
{
    int array[];

    public QuickSort(int arr[]) {
        array = arr;
    }

   private int parting(int arr[], int lower, int higher)
    {
        int pivot = arr[higher];
        int i = (lower-1);
        for (int j=lower; j<higher; j++)
        {
            if (arr[j] <= pivot)
            {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[higher];
        arr[higher] = temp;

        return i+1;
    }

    public void sort(int arr[], int lower, int higher)
    {
        if (lower < higher)
        {
            int pi = parting(arr, lower, higher);

            sort(arr, lower, pi-1);
            sort(arr, pi+1, higher);
        }
    }

    public int[] getArray(){
        return array;
    }
}
