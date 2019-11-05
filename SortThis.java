import edu.princeton.cs.algs4.StdOut;

//Author: Rocky Xia
public class SortThis {

    public int[] arr;

    public SortThis(int[] arr){
        this.arr = arr;
    }

    public void insertionSort(){
        int lowest;
        for(int i = 0; i < arr.length; i++){
            lowest = arr[i];
            for(int j = i; j >= 0; j--){
                if(lowest < arr[j]){
                    arr[j + 1] = arr[j];
                    arr[j] = lowest;
                }
            }
        }
    }

    public void selectionSort(){
        int lowest;
        int lowestIndex;
        int temp;
        for(int i = 0; i < arr.length; i++){
            lowest = arr[i];
            lowestIndex = i;
            temp = arr[i];
            for(int j = i + 1; j < arr.length; j++){
                if(arr[j] < lowest){
                    lowest = arr[j];
                    lowestIndex = j;
                }
            }
            arr[i] = lowest;
            arr[lowestIndex] = temp;
        }
    }

    //Easier way to call method in other classes
    public void mergeSort(){
        arr = mergeSortStuff(arr);
    }

    //Actual merge sort method
    private int[] mergeSortStuff(int[] arr){
        if(arr.length == 1){
            return arr;
        }
        else {
            int counter = 0;
            int[] leftArray = new int[arr.length/2];
            int[] rightArray = new int[arr.length - arr.length/2];
            for(int i = 0; i < leftArray.length; i++){
                leftArray[i] = arr[i];
                counter++;
            }
            for(int i = 0; i < rightArray.length; i++){
                rightArray[i] = arr[counter];
                counter++;
            }
            return merge(mergeSortStuff(leftArray), mergeSortStuff(rightArray));
        }
    }

    private int[] merge(int[] leftArray, int[] rightArray){
        int leftIndex = 0;
        int rightIndex = 0;
        int[] anotherArray = new int[leftArray.length + rightArray.length];
        for(int i = 0; i < anotherArray.length; i++){
            if(leftIndex > leftArray.length - 1){
                anotherArray[i] = rightArray[rightIndex];
                rightIndex++;
            }
            else if(rightIndex > rightArray.length - 1){
                anotherArray[i] = leftArray[leftIndex];
                leftIndex++;
            }
            else {
                if(leftArray[leftIndex] < rightArray[rightIndex]){
                    anotherArray[i] = leftArray[leftIndex];
                    leftIndex++;
                }
                else {
                    anotherArray[i] = rightArray[rightIndex];
                    rightIndex++;
                }
            }
        }
        return anotherArray;
    }

    //Easier way to call method in other classes
    public void quickSort(){
        quickSortStuff(0, arr.length - 1);
    }

    //Actual quick sort method
    private void quickSortStuff(int startIndex, int endIndex){
        if(startIndex < endIndex){
            int newPivot = partialSort(startIndex, endIndex);
            quickSortStuff(startIndex, newPivot - 1);
            quickSortStuff(newPivot + 1, endIndex);
        }
    }

    private int partialSort(int startIndex, int endIndex){
        int pivotValue = arr[endIndex];
        int reference = startIndex;
        for(int i = startIndex; i < endIndex; i++){
            if(arr[i] < pivotValue){
                int temp = arr[reference];
                arr[reference] = arr[i];
                arr[i] = temp;
                reference++;
            }
        }
        int temp = arr[endIndex];
        arr[endIndex] = arr[reference];
        arr[reference] = temp;
        return reference;
    }

    public void printArray(){
        for(int i = 0; i < arr.length; i++){
            StdOut.print(arr[i] + " ");
        }
        StdOut.print("\n");
    }

}
