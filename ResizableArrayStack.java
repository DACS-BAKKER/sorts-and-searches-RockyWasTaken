//Author: Rocky Xia
public class ResizableArrayStack {

    private int[] arr;
    private int indexCounter;

    public ResizableArrayStack(){
        arr = new int[10];
        indexCounter = 0;
    }

    public void push(int number){
        if(indexCounter == arr.length - 1){
            int[] newArray = new int[arr.length * 2];
            for(int i = 0; i < indexCounter; i++){
                newArray[i] = arr[i];
            }
            indexCounter++;
            newArray[indexCounter] = number;
            arr = newArray;
        }
        else {
            indexCounter++;
            arr[indexCounter] = number;
        }
    }

    public int pop(){
        int number = arr[indexCounter];
        indexCounter--;
        if(indexCounter == (arr.length - 1)/4){
            int[] newArray = new int[arr.length/2];
            for(int i = 0; i < indexCounter; i++){
                newArray[i] = arr[i];
            }
            arr = newArray;
        }
        return number;
    }

}
