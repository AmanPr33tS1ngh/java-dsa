package practiceQuestions.linkedList;

public class CircularLinkedList {

    //private -> public for questions
    public Node head; //private
    public Node tail;//private
    int size = 0;

    public static class Node {//private
        public Node next;//private
        public Node prev;//private
        public int data;//private

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
            tail.next = head;
        }
        size++;
    }

    void insertLast(int data) {
        Node last = new Node(data);
        last.next = head;
        tail.next = last;
        last.prev = tail;
        tail = last;
        head.prev = tail;
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
        tail.next = head.next;
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
        head.prev = tail;
//        tail.next = head.next;
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
        do {
            System.out.print(traversalNode.data + " -> ");
            traversalNode = traversalNode.next;
        } while (traversalNode != head);
        System.out.print("end");
    }

    void reversePrint() {
        Node traversalNode = tail;
        do {
            System.out.print(traversalNode.data + " -> ");
            traversalNode = traversalNode.prev;
        } while (traversalNode != tail);
        System.out.print("end");
    }
}
