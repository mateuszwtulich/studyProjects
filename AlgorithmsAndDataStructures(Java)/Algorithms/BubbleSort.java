public class BubbleSort {

    public int[] sort(int[] array){

        for(int i=array.length; i>=0; i--){

            for(int j=1; j<i; j++){
                if(array[j-1]> array[j]){
                    int temp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = temp;
                }
            }
        }
        return array;
    }
}
