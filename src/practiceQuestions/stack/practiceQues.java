package practiceQuestions.stack;


import java.util.LinkedList;
import java.util.Queue;

class QuesNode {
    int val;
    QuesNode next;
    QuesNode prev;
    QuesNode(int val){
        this.val = val;
    }
}

class CustomStack {
    // leet code ques
    int[] arr;
    int top = 0;
    CustomStack (){}
    public CustomStack(int maxSize) {
        this.arr = new int[maxSize];
    }

    public void push(int x) {
        if (this.top < 0 || this.top >= this.arr.length) {
            System.out.println("Overflow");
            return;
        };
        this.arr[this.top++] = x;
    }

    public int pop() {
        if(this.top <= 0)return -1;
        return this.arr[--this.top];
    }
    // increase values of each with val
    public void increment(int k, int val) {
        for (int i = 0; i < k; i++) {
            if(i >= this.top) break;
            this.arr[i] += val;
        }
    }
}

class MinStack {
    // leet code ques
    QuesNode head;
    QuesNode tail;
    int size = 0;
    int min = Integer.MAX_VALUE;
    public MinStack() {}

    public void push(int val) {
        this.size++;
        if(this.tail == null){
            this.head = new QuesNode(val);
            this.tail = head;
            this.min = val;
            return;
        }
        if(this.min > val){
            this.min = val;
        }
        QuesNode node = new QuesNode(val);
        this.tail.next = node;
        QuesNode tail = this.tail;
        this.tail = node;
        this.tail.prev = tail;
    }

    public void pop() {
        if(this.tail == null)return;
        this.tail = this.tail.prev;
        QuesNode temp = this.tail;
        int minVal = Integer.MAX_VALUE;
        while(temp != null){
            if(minVal > temp.val){
                minVal = temp.val;
            }
            temp = temp.prev;
        }
        this.min = minVal;
        this.size--;
    }

    public int top() {
        if(this.tail == null)return -1;
        return this.tail.val;
    }

    public int getMin() {
        return this.min;
    }
}
class MyStack {
    Queue<Integer> q;
    int top;
    public MyStack() {
        this.q = new LinkedList<>();
    }

    public void push(int x) {
        this.q.offer(x);
        for (int i = 0; i < this.q.size() -1; i++) {
            this.q.offer(q.peek());
            this.q.remove();
        }
        this.top = x;
    }

    public int pop() {
        return this.q.remove();
    }

    public int top() {
        if(this.q.isEmpty())return -1;
        return this.q.peek();
    }

    public boolean empty() {
        return this.q.isEmpty();
    }
}

public class practiceQues {
    public static void main(String[] args) {

//        ["CustomStack","push","push","pop","push","push","push","increment","increment","pop","pop","pop","pop"]
        //  [3],          [1],  [2],    [],     [2], [3],   [4],    [5,100],    [2,100]
//        CustomStack cs = new CustomStack(3);
//        cs.push(1);
//        cs.push(2);
//        cs.pop();
//        cs.push(2);
//        cs.push(3);
//        cs.push(4);
//        cs.increment(5, 100);
//        cs.increment(2, 100);
//        cs.pop();
//        cs.pop();
//        cs.pop();
//        cs.pop();

//        MinStack ms = new MinStack();
//        ["MinStack","push","push","push","push","getMin","pop","getMin","pop","getMin","pop","getMin"]
//        [[],          [2],    [0], [3],   [0],    [],     [],     [],     [],     [],     [], []]
//        [ null,       null,  null,  null, null,   0,      null,   0,      null,   0,    null, 2]
//        [null,        null,   null, null,  null,  0,      null,   2,      null,   2,    null, 2]
//        ms.push(2);
//        ms.push(0);
//        ms.push(3);
//        ms.push(0);
//        System.out.println(ms.getMin());
//        ms.pop();
//        System.out.println(ms.getMin());
//        ms.pop();
//        System.out.println(ms.getMin());
//        ms.pop();
//        System.out.println(ms.getMin());
        MyStack ms = new MyStack();
        ms.push(1);
        ms.push(2);
        System.out.println(ms.top());
        System.out.println(ms.pop());
        ms.empty();
    }
}
