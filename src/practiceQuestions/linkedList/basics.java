package practiceQuestions.linkedList;

class LinkedList{

    private Node head;
    private Node tail;
    int size = 0;
    private class Node{
        private Node next;
        private Node prev;
        private int data;
        Node(int value){
            this.data = value;
        }
        Node(int value, Node next){
            this.next = next;
            this.data = value;
        }
    }
    void insertFirst(int data){
        Node node = new Node(data);
        node.next = head;
        head = node;
        if (tail == null){
            tail = head;
        }
        size++;
    }
    void insertLast(int data){
        Node node = new Node(data);
        node.prev = tail;
        tail.next = node;
        tail = node;
        size++;
    }
    void insert(int data, int index){
        if (index == 0){
            insertFirst(data);
            return;
        }
        else if (index == size){
            insertLast(data);
            return;
        }
        Node traversalNode = head;
        for (int i = 1;i < index;i++){
            traversalNode = traversalNode.next;
        }
        traversalNode.next = new Node(data, traversalNode.next);
        size++;
    }
    void removeFirst(){
        if (head == null) return;
        if (head.next == null){
            head = tail = null;
            return;
        }
        head = head.next;
        size--;
    }
    void removeLast(){
        if (tail == null) return;
        if (tail.prev == null){
            tail = head = null;
            return;
        }
        tail = tail.prev;
        size--;
    }
    void delete(int index){
        if(index == 0){
            removeFirst();
            return;
        }
        else if(index == size){
            removeLast();
            return;
        }
        Node traversalNode = head;
        for(int i = 1;i<index;i++){
            traversalNode = traversalNode.next;
        }
        traversalNode.next = traversalNode.next.next;
        size--;
    }
    void printLL(){
        Node traversalNode = head;
        while(traversalNode != null){
            System.out.print(traversalNode.data + " -> ");
            traversalNode = traversalNode.next;
        }
        System.out.print("end");
    }
}

class DoublyLinkedList{

    private Node head;
    private Node tail;
    int size = 0;
    private class Node{
        private Node next;
        private Node prev;
        private int data;
        Node(int value){
            this.data = value;
        }
        Node(int value, Node next){
            this.data = value;
            this.next = next;
        }
    }
    void insertFirst(int data){
        Node node = new Node(data);
        node.next = head;
        node.prev = null;
        if (head != null){
            head.prev = node;
        }
        head = node;
        if(head.next == null){
            tail = node;
        }
        size++;
    }
    void insertLast(int data){
        Node last = new Node(data);
        tail.next = last;
        last.prev = tail;
        tail = last;
        size++;
    }
    void insert(int data, int index){
        if (index == 0){
            insertFirst(data);
            return;
        }
        else if (index == size){
            insertLast(data);
            return;
        }
        Node traversalNode = head;
        for (int i = 1;i < index;i++){
            traversalNode = traversalNode.next;
        }
        Node newNode = new Node(data, traversalNode.next);
        newNode.next.prev = newNode;
        traversalNode.next = newNode;
        newNode.prev = traversalNode;
        size++;
    }
    void removeFirst(){
        if (head == null) return;
        if (head.next == null){
            head = tail = null;
            return;
        }
        head = head.next;
        size--;
    }
    void removeLast(){
        if (tail == null) return;
        if (tail.prev == null){
            tail = head = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
        size--;
    }
    void delete(int index){
        if(index == 0){
            removeFirst();
            return;
        }
        else if(index == size){
            removeLast();
            return;
        }
        Node traversalNode = head;
        for(int i = 1;i<index;i++){
            traversalNode = traversalNode.next;
        }
        traversalNode.next = traversalNode.next.next;
        traversalNode.next.prev = traversalNode;
        size--;
    }
    void printLL(){
        Node traversalNode = head;
        while(traversalNode != null){
            System.out.print(traversalNode.data + " -> ");
            traversalNode = traversalNode.next;
        }
        System.out.print("end");
    }
    void reversePrint(){
        Node traversalNode = tail;
        while(traversalNode != null){
            System.out.print(traversalNode.data + " -> ");
            traversalNode = traversalNode.prev;
        }
        System.out.print("end");
    }
}

class CircularLinkedList{
    private Node head;
    private Node tail;
    int size = 0;
    private class Node{
        private Node next;
        private Node prev;
        private int data;
        Node(int value){
            this.data = value;
        }
        Node(int value, Node next){
            this.data = value;
            this.next = next;
        }
    }
    void insertFirst(int data){
        Node node = new Node(data);
        node.next = head;
        node.prev = null;
        if (head != null){
            head.prev = node;
        }
        head = node;
        if(head.next == null){
            tail = node;
            tail.next = head;
        }
        size++;
    }
    void insertLast(int data){
        Node last = new Node(data);
        last.next = head;
        tail.next = last;
        last.prev = tail;
        tail = last;
        head.prev = tail;
        size++;
    }
    void insert(int data, int index){
        if (index == 0){
            insertFirst(data);
            return;
        }
        else if (index == size){
            insertLast(data);
            return;
        }
        Node traversalNode = head;
        for (int i = 1;i < index;i++){
            traversalNode = traversalNode.next;
        }
        Node newNode = new Node(data, traversalNode.next);
        newNode.next.prev = newNode;
        traversalNode.next = newNode;
        newNode.prev = traversalNode;
        size++;
    }
    void removeFirst(){
        if (head == null) return;
        if (head.next == null){
            head = tail = null;
            return;
        }
        tail.next = head.next;
        head = head.next;
        size--;
    }
    void removeLast(){
        if (tail == null) return;
        if (tail.prev == null){
            tail = head = null;
            return;
        }
        tail = tail.prev;
        head.prev = tail;
//        tail.next = head.next;
        size--;
    }
    void delete(int index){
        if(index == 0){
            removeFirst();
            return;
        }
        else if(index == size){
            removeLast();
            return;
        }
        Node traversalNode = head;
        for(int i = 1;i<index;i++){
            traversalNode = traversalNode.next;
        }
        traversalNode.next = traversalNode.next.next;
        traversalNode.next.prev = traversalNode;
        size--;
    }
    void printLL(){
        Node traversalNode = head;
        do{
            System.out.print(traversalNode.data + " -> ");
            traversalNode = traversalNode.next;
        }while(traversalNode != head);
        System.out.print("end");
    }
    void reversePrint(){
        Node traversalNode = tail;
        do{
            System.out.print(traversalNode.data + " -> ");
            traversalNode = traversalNode.prev;
        }while(traversalNode != tail);
        System.out.print("end");
    }
}

public class basics {
    public static void main(String[] args){
//        LinkedList l = new LinkedList();
//        System.out.println(l.size);
//        l.insertFirst(15);
//        l.insertFirst(20);
//        l.insertLast(15);
//        l.insertLast(20);
//        l.insert(5, 0);
//        l.insert(4, 1);
//        l.insert(3, 2);
//        l.insert(2, 3);
//        l.insert(1, 4);
//        l.insert(5, 5);
//        l.insert(6, 6);
//        l.insert(7, 7);
//        l.insert(8, 8);
//        l.insert(9, 9);
//        l.printLL();
//        l.removeFirst();
//        System.out.println();
//        System.out.println(l.size);
//        l.delete(5);
//        System.out.println();
//        System.out.println(l.size);
//        l.removeLast();
//        System.out.println();
//        System.out.println(l.size);
//        l.printLL();
//        l.delete(5);
//        System.out.println();
//        System.out.println(l.size);
//        l.printLL();
//        // Double linked list
//        DoublyLinkedList dll = new DoublyLinkedList();
//        System.out.println(dll.size);
//        dll.insertFirst(5);
//        dll.insertFirst(4);
//        dll.insert(3, 0);
//        dll.insert(2, 1);
//        dll.insert(1, 2);
//        dll.insert(5, 3);
//        dll.printLL();
//        System.out.println();
//        dll.removeFirst();
//        dll.printLL();
//        System.out.println();
//        dll.removeLast();
//        dll.delete(2);
//        dll.printLL();
//        System.out.println();
//        dll.reversePrint();
////        System.out.println();
////        dll.printLL();
//        dll.insertLast(5);
//        dll.insertLast(6);
//        System.out.println();
//        dll.printLL();
//        System.out.println();
//        dll.reversePrint();
//        dll.insert(8, 2);
//        dll.insert(9, 1);
//        dll.insert(10, 1);
//        dll.insert(11,2);
//        dll.printLL();
//        dll.delete(5);
//        System.out.println();
//        System.out.println(dll.size);
//        dll.printLL();
//        dll.delete(5);
//        System.out.println();
//        System.out.println(dll.size);
//        dll.printLL();
//        System.out.println();
//        dll.reversePrint();
        // Circular linked list
        CircularLinkedList cll = new CircularLinkedList();
//        System.out.println(cll.length);
        cll.insertFirst(5);
        cll.insertFirst(4);
        cll.insertFirst(3);
        cll.insertLast(2);
        cll.insertLast(1);
        cll.insert(10, 3);
        cll.insert(11, 3);

//        cll.add(5);
        cll.printLL();
        cll.delete(5);
        cll.removeFirst();
        cll.removeLast();
        cll.removeFirst();
        cll.removeLast();
        cll.removeLast();
        System.out.println();
        cll.reversePrint();
//        System.out.println(cll.length);
//        cll.printLL();
//        cll.delete(5);
//        System.out.println();
//        System.out.println(cll.length);
//        cll.printLL();
//        System.out.println();
//        cll.reversePrint();
//        System.out.println();
//        cll.printLL();
    }
}
