package practiceQuestions.linkedList;

public class LinkedList {
    //private -> public for questions
    public Node head;//private
    public Node tail;//private
    int size = 0;

    public static class Node { //private
        public Node next;//private
        public Node prev;//private
        public int data;//private

        Node(int value) {
            this.data = value;
        }

        Node(int value, Node next) {
            this.next = next;
            this.data = value;
        }
    }

    void insertFirst(int data) {
        Node node = new Node(data);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size++;
    }

    void insertLast(int data) {
        Node node = new Node(data);
        node.prev = tail;
        tail.next = node;
        tail = node;
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
        traversalNode.next = new Node(data, traversalNode.next);
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
}
