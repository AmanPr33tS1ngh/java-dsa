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
            this.next = null;
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
        size += 1;
    }
    void insertLast(int data){
        Node node = new Node(data);
        node.prev = tail;
        tail.next = node;
        tail = node;
        size += 1;
    }
    void add(int data, int index){
        if (index >= size || index < 0){
            return;
        }
        if (index == 0){
            insertFirst(data);
            return;
        }
        if (index == size - 1){
            insertLast(data);
            return;
        }
        int i = 0;
        Node traversalNode = head;
        while(i < index - 1){
            traversalNode = traversalNode.next;
            i++;
        }
        Node newNode = new Node(data);
        traversalNode.next = newNode;
        traversalNode.next.next =newNode;
        tail = traversalNode.next;
        size += 1;
    }
    void removeFirst(){
        if (head == null) return;
        if (head.next == null){
            head = tail = null;
            return;
        }
        head = head.next;
    }
    void removeLast(){
        if (tail == null) return;
        head = head.next;
    }
    void delete(int data){
        if (head == null){
            return;
        }
        Node traversalNode = head;
        if (traversalNode.data == data){
            head = traversalNode.next;
            size -= 1;
            return;
        }
        while(traversalNode.next != null){
            if(traversalNode.next.data == data){
                traversalNode.next = traversalNode.next.next;
                size -= 1;
                break;
            }
            traversalNode = traversalNode.next;
        }
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
    int length = 0;
    private class Node{
        private Node next;
        private Node prev;
        private int data;
        Node(int value){
            this.data = value;
        }
    }
    void add(int data){
        if (head == null){
            head = new Node(data);
            head.prev = null;
            return;
        }
        Node traversalNode = head;
        while(traversalNode.next != null){
            traversalNode = traversalNode.next;
        }
        traversalNode.next = new Node(data);
        traversalNode.next.prev = traversalNode;
        tail = traversalNode.next;
        length += 1;
    }
    void delete(int data){
        if (head == null){
            return;
        }
        Node traversalNode = head;
        if (traversalNode.data == data){
            head = traversalNode.next;
            length -= 1;
            return;
        }
        while(traversalNode.next != null){
            if(traversalNode.next.data == data){
                traversalNode.next = traversalNode.next.next;
                traversalNode.next.prev = traversalNode;
                length -= 1;
                break;
            }
            traversalNode = traversalNode.next;
        }
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
        while(traversalNode.prev != null){
            System.out.print(traversalNode.data + " -> ");
            traversalNode = traversalNode.prev;
        }
        System.out.print("end");
    }
}

class CircularLinkedList{
    private Node head;
    private Node tail;
    int length = 0;
    private class Node{
        private Node next;
        private Node prev;
        private int data;
        Node(int value){
            this.data = value;
        }
    }
    void add(int data){
        if (head == null){
            head = new Node(data);
            tail = head;
            return;
        }
        Node traversalNode = head;
        while(traversalNode != tail){
            traversalNode = traversalNode.next;
        }
        traversalNode.next = new Node(data);
        traversalNode.next.next = head;
        traversalNode.next.prev = traversalNode;
        tail = traversalNode.next;
        length += 1;
    }
    void delete(int data){
        if (head == null){
            return;
        }
        Node traversalNode = head;
        if (traversalNode.data == data){
            tail.next = tail.next.next;
            head = traversalNode.next;
            length -= 1;
            return;
        }
        while(traversalNode.next != head && traversalNode.next != null){
            if(traversalNode.next.data == data){
                traversalNode.next = traversalNode.next.next;
                traversalNode.next.prev = traversalNode;
                length -= 1;
                break;
            }
            traversalNode = traversalNode.next;
        }
    }
    void printLL(){
        if (head == null){
            return;
        }
        System.out.print(head.data + " -> ");
        Node traversalNode = head;
        while(traversalNode != head.next){
            System.out.print(traversalNode.data + " -> ");
            traversalNode = traversalNode.next;
        }
        System.out.print("end");
    }
    void reversePrint(){
        if (tail == null){
            return;
        }
        System.out.print(tail.data + " -> ");
        Node traversalNode = tail.prev;
        while(traversalNode.prev != head.next){
            System.out.print(traversalNode.data + " -> ");
            traversalNode = traversalNode.prev;
        }
        System.out.print("end");
    }
    void print(){
        if (tail == null){
            return;
        }
        Node traversalNode = tail;
        while(traversalNode.next != null){
            System.out.print(traversalNode.data + " -> ");
            traversalNode = traversalNode.prev;
        }
        System.out.print("end");
    }
}

public class basics {
    public static void main(String[] args){
//        LinkedList l = new LinkedList();
//        System.out.println(l.length);
//        l.add(5);
//        l.add(4);
//        l.add(3);
//        l.add(2);
//        l.add(1);
//        l.add(5);
//        l.add(6);
//        l.add(7);
//        l.add(8);
//        l.add(9);
//        l.add(10);
//        l.add(11);
//        l.printLL();
//        l.delete(5);
//        System.out.println();
//        System.out.println(l.length);
//        l.printLL();
//        l.delete(5);
//        System.out.println();
//        System.out.println(l.length);
//        l.printLL();
//        // Double linked list
//        DoublyLinkedList dll = new DoublyLinkedList();
//        System.out.println(l.length);
//        dll.add(5);
//        dll.add(4);
//        dll.add(3);
//        dll.add(2);
//        dll.add(1);
//        dll.add(5);
//        dll.add(6);
//        dll.add(7);
//        dll.add(8);
//        dll.add(9);
//        dll.add(10);
//        dll.add(11);
//        dll.printLL();
//        dll.delete(5);
//        System.out.println();
//        System.out.println(l.length);
//        dll.printLL();
//        dll.delete(5);
//        System.out.println();
//        System.out.println(l.length);
//        dll.printLL();
//        System.out.println();
//        dll.reversePrint();
        // Circular linked list
        CircularLinkedList cll = new CircularLinkedList();
//        System.out.println(cll.length);
        cll.add(5);
        cll.add(4);
        cll.add(3);
        cll.add(2);
        cll.add(1);
//        cll.add(5);
        cll.printLL();
//        cll.delete(5);
        System.out.println();
//        System.out.println(cll.length);
//        cll.printLL();
//        cll.delete(5);
//        System.out.println();
//        System.out.println(cll.length);
        cll.printLL();
        System.out.println();
        cll.reversePrint();
        System.out.println();
        cll.print();
    }
}
