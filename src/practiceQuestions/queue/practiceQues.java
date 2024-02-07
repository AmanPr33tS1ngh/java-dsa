package practiceQuestions.queue;

import java.util.Stack;

class MyQueue {
    // leet code
    Stack<Integer> input;
    Stack<Integer> output;
    public MyQueue() {
        this.input = new Stack<>();
        this.output = new Stack<>();
    }

    public void push(int x) {
        this.input.push(x);
    }

    public int pop() {
        if(!this.output.isEmpty())return this.output.pop();
        while(!this.input.isEmpty()){
            this.output.push(this.input.peek());
            this.input.pop();
        }
        return this.output.pop();
    }

    public int peek() {
        if(!this.output.isEmpty()) {
            return this.output.peek();
        }
        while(!this.input.isEmpty()){
            this.output.push(this.input.peek());
            this.input.pop();
        }
        return this.output.peek();
    }

    public boolean empty() {
        return this.input.isEmpty() && this.output.isEmpty();
    }
}


public class practiceQues {
    public static void main(String[] args){
        MyQueue mq = new MyQueue();
        //    ["MyQueue","push","push","peek","pop","empty"]
        //    [     [],    [1],  [2],   [],     [],     []]
        mq.push(1);
        mq.push(2);
        System.out.println(mq.peek());
        System.out.println(mq.pop());
        System.out.println(mq.empty());
    }

}
