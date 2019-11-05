import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

//Author: Rocky Xia
public class CodeRunner {
    public static int[] arr = new int[] {2, 1, 5, 9, 3, 8, 4, 7, 0, 6};

    public static void main(String[] args){
        SortThis sortArray = new SortThis(arr);
        BinarySearch search = new BinarySearch(arr);
        //sortArray.insertionSort();
        //sortArray.selectionSort();
        //sortArray.mergeSort();
        sortArray.quickSort();
        sortArray.printArray();
        for(int i = 0; i < arr.length; i++){
            StdOut.println(search.find(i));
        }
    }

    public static int[] getArray(int length, int range){
        int[] arr = new int[length];
        Random random = new Random();
        for(int i = 0; i < length; i++){
            arr[i] = random.nextInt(range);
        }
        return arr;
    }
}
