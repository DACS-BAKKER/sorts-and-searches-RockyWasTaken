import edu.princeton.cs.algs4.StdOut;

import java.util.Random;

//Author: Rocky Xia
public class BirthdayProblem {

    public static int[] arr;

    public static void main(String[] args){
        int experiments = 0;
        int findAverage = 0;
        int arraySize = 10000000;
        double prediction = Math.sqrt((arraySize * Math.PI)/2);
        for(int i = 0; i < 1000000000; i++){
            makeArray(arraySize);
            experiments++;
            findAverage += findFirstRepeat();
        }
        StdOut.println("Theoretical Result: " + prediction);
        StdOut.println("Average Experimental Result: " + (double)findAverage/experiments);
    }

    public static void makeArray(int size){
        arr = new int[size];
        Random random = new Random();
        for(int i = 0; i < size; i++){
            arr[i] = random.nextInt(size - 1);
        }
    }

    public static int findFirstRepeat(){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] == arr[j]){
                    return i;
                }
            }
        }
        return -1;
    }

    public static void printArray(){
        for(int i = 0; i < arr.length; i++){
            StdOut.print(arr[i] + " ");
        }
        StdOut.print("\n");
    }

}
