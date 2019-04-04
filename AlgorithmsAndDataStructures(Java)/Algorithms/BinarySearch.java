import java.util.Scanner;

public class BinarySearch {
    private int size;
    private int[]list;
    private int arr[];
    private int counter =0;

    public BinarySearch(int size){
        this.size = size;
        list = new int[size];
        arr = new int[size];
    }
    public BinarySearch(int size, int[]list){
        this.size = size;
        this.list = list;
        arr = new int[size];
        counter = size;
    }

    public void addElem(){
        Scanner scan = new Scanner(System.in);
        int element = scan.nextInt();
        list[counter]= element;
        counter++;
    }

    public void addElem(int element){
        list[counter]=element;
        counter++;
    }

    public String search(int elem){
        boolean isElem = false;
        System.out.println("\n" + "Sorted array: ");

        for(int i = 0; i<size; i++){
            int min = i;
            for(int j = i ; j<size; j++) {
                if (list[j]  < list[min]) {
                    min = j;
                }
                if (j==(size-1)){
                    int temp = list[i];
                    arr[i] = list[min];
                    list[i] = list[min];
                    list[min] = temp;
                }
            }
            if(arr[i]==elem){
                isElem = true;
            }
            System.out.print(arr[i]+",");
        }
        if(isElem==false){
            return "not";
        }

        counter = size/2;
        int bufor = counter;

        while(arr[counter-1]!=elem){
            if(bufor%2!=0) {
                bufor = (bufor / 2) + 1;
            }else if(bufor%2==0){
                bufor = bufor/2;
            }

            if(arr[counter-1]>elem){
                counter-=bufor;
            }
            else if(arr[counter-1]<elem){
                counter+= bufor;
            }
            if(counter==0){
                counter =1;
            }
        }
        return Integer.toString(counter);
    }
}
