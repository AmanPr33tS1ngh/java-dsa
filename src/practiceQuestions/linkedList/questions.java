package practiceQuestions.linkedList;

public class questions {
    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insertLast(1);
        dll.insertLast(2);
        dll.insertLast(3);
        dll.insertLast(4);
        dll.insertLast(5);
        dll.insertLast(6);
        dll.insertLast(7);
        dll.insertLast(8);
        dll.printLL();
        System.out.println();
        reverseDoublyLinkedListPrint(reverseDoublyLinkedList(dll));
    }

    static DoublyLinkedList reverseDoublyLinkedList(DoublyLinkedList dll){
        DoublyLinkedList.Node node = dll.head;
        while(node != null){
            DoublyLinkedList.Node temp = node.next;
            node.next = node.prev;
            node.prev = temp;

            node = node.prev;
        }

        return dll;
    }
    static void reverseDoublyLinkedListPrint(DoublyLinkedList dll){
        DoublyLinkedList.Node node = dll.tail;
        while(node != null){
            System.out.print(node.data + " -> ");
            node = node.next;
        }
        System.out.print("END");
    }
}

