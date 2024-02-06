package practiceQuestions.queue;
import java.util.Queue;

class CustomQueue{
    int[] arr;
    int front = 0;
    int rear = 0;
    int size;
    CustomQueue(){}
    CustomQueue(int size){
        this.arr = new int[size];
    }
    void push(int val){
        if(this.size >= this.arr.length)return;
        this.arr[this.rear % this.arr.length] = val;;
        this.rear++;
        this.size++;
    }
    void pop(){
        if(this.size <= 0)return;
        this.size--;
        this.arr[this.front % this.arr.length] = -1;
        this.front++;
    }
    int peek(){
        if(this.size <= 0)return -1;
        return this.arr[this.front % this.arr.length];
    }
    boolean isEmpty(){
        return this.front == this.rear;
    }
}


public class QueueBasics {
    public static void main(String[] args) {
        CustomQueue q = new CustomQueue(5);
        q.push(5);
        System.out.println(q.peek());

        q.push(4);
        System.out.println(q.peek());

        q.push(3);
        System.out.println(q.peek());

        q.push(2);
        System.out.println(q.peek());

        q.push(1);
        System.out.println(q.peek());

        q.push(1);
        System.out.println(q.peek());
        q.pop();
        System.out.println(q.peek());

        q.pop();
        System.out.println(q.peek());

        q.pop();
        System.out.println(q.peek());
        q.push(4);
        System.out.println(q.peek());
    }
}
