//Author: Rocky Xia
public class LinkedListStack {

    private Node top;

    public LinkedListStack(){
        this.top = null;
    }

    public void push(int number){
        if(top == null){
            top = new Node(number);
        }
        else {
            Node temp = top;
            top = new Node(number);
            top.next = temp;
        }
    }

    public int pop(){
        int number = top.stuff;
        top = top.next;
        return number;
    }

    private class Node {

        private int stuff;
        private Node next;

        private Node(int stuff){
            this.stuff = stuff;
            this.next = null;
        }
    }

}
