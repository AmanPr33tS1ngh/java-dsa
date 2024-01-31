package practiceQuestions.linkedList;

import java.util.List;

class ListNode {

    /**
     * LEET CODE
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
class LinkedListNode {
    /** CODING NINJAS **/

    int data;
    LinkedListNode next;

    LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}
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
    static ListNode OddEvenLinkedList(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode odd = head;
        ListNode evenHead = head.next;
        ListNode even = head.next;
        while (even != null || even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
    static ListNode ZeroesOnesTwosLL(ListNode head){
        if (head == null || head.next == null) return head;
        ListNode zero = new ListNode(-1);
        ListNode zeroHead = new ListNode(-1);

        ListNode one = new ListNode(-1);
        ListNode oneHead = new ListNode(-1);

        ListNode two = new ListNode(-1);
        ListNode twoHead = new ListNode(-1);

        ListNode node = head;

        while(node != null){
            if(node.val == 0) {
                zero.next = node;
                zero = node;
            }
            else if(node.val == 1) {
                one.next = node;
                one = node;
            }
            else if(node.val == 2) {
                two.next = node;
                two = node;
            }
            node = node.next;
        }
        zero.next = oneHead.next != null ? oneHead.next : twoHead.next;
        oneHead.next = twoHead.next;
        return zeroHead.next;
    }
//    [1,2,3,4,5,6,7,8]
    static ListNode removeNthFromEnd(ListNode head, int n){
        if (head == null || head.next == null) return head;
        ListNode fast = head;
        ListNode slow = head;
        int length = 0;
        int slowCounter = 0;
        while(slow != null){
            if (fast != null && fast.next != null && fast.next.next != null){
                fast = fast.next.next;
                length += 2;
            }
            else if (fast.next != null && fast.next.next == null){
                fast = fast.next;
                length += 1;
            }

            if (length - slowCounter == n - 1 && fast.next == null){
                slow.next = slow.next.next;
            }
            slowCounter += 1;
            slow = slow.next;
        }
        return head;
    }

    static ListNode reverseLinkedList(ListNode head){
        if(head==null || head.next == null)return head;
        ListNode node = head;
        ListNode prev = null;
        while(node != null){
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        };
        return prev;
    }
    static LinkedListNode reverseLinkedList(LinkedListNode head){
        if(head==null || head.next == null)return head;
        LinkedListNode node = head;
        LinkedListNode prev = null;
        while(node != null){
            LinkedListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        };
        return prev;
    }


        static int solve(LinkedListNode head){

            if(head.data==-1) return 1;

            int carry = solve(head.next);

            head.data+=carry;

            carry=(head.data/10);

            head.data%=10;

            return carry;

        }



     static LinkedListNode addOneToList(LinkedListNode linkedListNode) {

        if(linkedListNode==null)return linkedListNode;

        LinkedListNode temp=linkedListNode;

        int carry = solve(temp);

        if(carry>0){

            LinkedListNode newNode=new LinkedListNode(carry);

            newNode.next=linkedListNode;

            linkedListNode=newNode;

        }

        return linkedListNode;

    }

}

