import edu.princeton.cs.algs4.StdOut;

import javax.print.attribute.standard.PresentationDirection;
import java.util.Timer;

//Author: Rocky Xia
public class StackComparison {

    public static ResizableArrayStack arrayStack;
    public static LinkedListStack listStack;

    public static void main(String[] args){
        //testConstructionTime();
        testOperationTime();
    }

    //It turns out I'm an idiot and the construction of both data structures are fast enough to be counted as instantaneous
    public static void testConstructionTime(){
        long start;
        long end;
        double arrayTime;
        double listTime;

        start = System.currentTimeMillis();
        arrayStack = new ResizableArrayStack();
        end = System.currentTimeMillis();
        arrayTime = (end - start)/1000;

        start = System.currentTimeMillis();
        listStack = new LinkedListStack();
        end = System.currentTimeMillis();
        listTime = (end - start)/1000;

        StdOut.println("Resizable Array Construction Time: " + arrayTime);
        StdOut.println("Linked List Construction Time: " + listTime);
    }


    public static void testOperationTime(){
        //Variables
        long start;
        long end;
        double arrayTime;
        double arrayTimeResize;
        double arrayTimeMoreResize;
        double listTimeEmpty;
        double listTime;

        //Construct the arrays
        arrayStack = new ResizableArrayStack();
        listStack = new LinkedListStack();

        //Test for operations under normal circumstances
        start = System.currentTimeMillis();
        for(int i = 0; i < 1000000000; i++){
            arrayStack.push(0);
            arrayStack.pop();
        }
        end = System.currentTimeMillis();
        arrayTime = (end - start)/1000;

        //Test for operations with resizing of a small array
        for(int i = 0; i < 10; i++){
            arrayStack.push(0);
        }
        start = System.currentTimeMillis();
        for(int i = 0; i < 1000000000; i++){
            arrayStack.push(0);
            arrayStack.pop();
        }
        end = System.currentTimeMillis();
        arrayTimeResize = (end - start)/1000;

        //Test for operations with resizing a big array
        for(int i = 0; i < 160; i++){
            arrayStack.push(0);
        }
        start = System.currentTimeMillis();
        for(int i = 0; i < 1000000000; i++){
            arrayStack.push(0);
            arrayStack.pop();
        }
        end = System.currentTimeMillis();
        arrayTimeMoreResize = (end - start)/1000;

        //Test linked list stack while it's empty
        start = System.currentTimeMillis();
        for(int i = 0; i < 1000000000; i++){
            listStack.push(0);
            listStack.pop();
        }
        end = System.currentTimeMillis();
        listTimeEmpty = (end - start)/1000;

        //Test linked list stack while it has an element
        listStack.push(0);
        start = System.currentTimeMillis();
        for(int i = 0; i < 1000000000; i++){
            listStack.push(0);
            listStack.pop();
        }
        end = System.currentTimeMillis();
        listTime = (end - start)/1000;

        StdOut.println("Resizable array operation time without resize occurring: " + arrayTime);
        StdOut.println("Resizable array operation time with resize occurring: " + arrayTimeResize);
        StdOut.println("Resizable array operation time with resize occurring on a large array: " + arrayTimeMoreResize);
        StdOut.println("Linked list operation time with an empty stack: " + listTimeEmpty);
        StdOut.println("Linked list operation time: " + listTime);
    }

}
