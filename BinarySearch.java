import edu.princeton.cs.algs4.StdOut;

//Author: Rocky Xia
public class BinarySearch {

    private int[] arr;

    public BinarySearch(int[] arr){
        this.arr = arr;
    }

    //Returns the index
    public int find(int number){
        int startIndex = 0;
        int endIndex = arr.length - 1;
        int index = arr.length/2;
        while(arr[index] != number){
            int previousIndex = index;
            if(arr[index] < number){
                startIndex = index;
                index = index + (endIndex - startIndex)/2;
            }
            else if(arr[index] > number){
                endIndex = index;
                index = startIndex + (endIndex - startIndex)/2;
            }

            if(index == previousIndex){
                return previousIndex + 1;
            }
        }
        return index;
    }

}
