package practiceQuestions.stack;

class Stack{
    // Stack implementation using array
    int[] arr;
    int top = -1;
    Stack (){}
    Stack(int size){
        this.arr = new int[size];
    }
    void push(int value){
        if (value < 0 || value > this.arr.length) {
            System.out.println("Overflow");
            return;
        };
        this.arr[++this.top] = value;
    }
    void pop(){
        this.top--;
    }
    int peek(){
        return this.arr[this.top];
    }
    int size(){
        return this.top;
    }
    boolean isEmpty(){
        return this.top == -1;
    }
}
class Node {
    int val;
    Node next;
    Node prev;
    Node(int val){
        this.val = val;
    }
}

class StackUsingLL{
    // No length
    Node head;
    Node tail;
    int size = 0;
    // Stack implementation using Linked List
    StackUsingLL (){}
    void push(int value){
        this.size++;
        if(this.head == null){
            this.head = new Node(value);
            this.tail = head;
            return;
        }
        Node node = new Node(value);
        this.tail.next = node;
        Node tail = this.tail;
        this.tail = node;
        this.tail.prev = tail;
    }
    void pop(){
        if(this.tail == null)return;
        this.tail = this.tail.prev;
        this.size--;
    }
    int peek(){
        if(this.tail == null)return -1;
        return this.tail.val;
    }
    int size(){
        return this.size;
    }
    boolean isEmpty(){
        return this.head == null;// || this.size = 0;
    }
}
public class StackBasics {
    public static void main(String[] args) {
//        Stack st = new Stack(5);
//        System.out.println(st.top);
//        st.push(1);
//        st.push(2);
//        st.push(3);
//        st.push(4);
//        System.out.println(st.peek());
//        st.push(5);
//        st.push(6);
//        System.out.println(st.peek());
//        st.pop(6);
//        System.out.println(st.peek());
//        st.push(6);
    }
}
