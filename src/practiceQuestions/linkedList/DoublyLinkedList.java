package practiceQuestions.linkedList;

public class DoublyLinkedList {
    //private -> public for questions
    public Node head; //private
    public Node tail; //private
    int size = 0;

    public static class Node {  //private
        public Node next;//private
        public Node prev;//private
        public int data;//private

        Node() {
            this.data = 0;
            this.next = null;
        }

        Node(int value) {
            this.data = value;
        }

        Node(int value, Node next) {
            this.data = value;
            this.next = next;
        }
    }

    void insertFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        node.prev = null;
        if (head != null) {
            head.prev = node;
        }
        head = node;
        if (head.next == null) {
            tail = node;
        }
        size++;
    }

    void insertLast(int data) {
        Node last = new Node(data);
        if (tail == null){
            tail = head = last;
            return;
        }
        tail.next = last;
        last.prev = tail;
        tail = last;
        size++;
    }

    void insert(int data, int index) {
        if (index == 0) {
            insertFirst(data);
            return;
        } else if (index == size) {
            insertLast(data);
            return;
        }
        Node traversalNode = head;
        for (int i = 1; i < index; i++) {
            traversalNode = traversalNode.next;
        }
        Node newNode = new Node(data, traversalNode.next);
        newNode.next.prev = newNode;
        traversalNode.next = newNode;
        newNode.prev = traversalNode;
        size++;
    }

    void removeFirst() {
        if (head == null) return;
        if (head.next == null) {
            head = tail = null;
            return;
        }
        head = head.next;
        size--;
    }

    void removeLast() {
        if (tail == null) return;
        if (tail.prev == null) {
            tail = head = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }

    void delete(int index) {
        if (index == 0) {
            removeFirst();
            return;
        } else if (index == size) {
            removeLast();
            return;
        }
        Node traversalNode = head;
        for (int i = 1; i < index; i++) {
            traversalNode = traversalNode.next;
        }
        traversalNode.next = traversalNode.next.next;
        traversalNode.next.prev = traversalNode;
        size--;
    }

    void printLL() {
        Node traversalNode = head;
        while (traversalNode != null) {
            System.out.print(traversalNode.data + " -> ");
            traversalNode = traversalNode.next;
        }
        System.out.print("end");
    }

    void reversePrint() {
        Node traversalNode = tail;
        while (traversalNode != null) {
            System.out.print(traversalNode.data + " -> ");
            traversalNode = traversalNode.prev;
        }
        System.out.print("end");
    }
}
