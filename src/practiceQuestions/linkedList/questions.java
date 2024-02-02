package practiceQuestions.linkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
class Node {
    /** CODING NINJAS **/
    public int data;
    public Node next;

    Node()
    {
        this.data = 0;
        this.next = null;
    }

    Node(int data)
    {
        this.data = data;
        this.next = null;
    }

    Node(int data, Node next)
    {
        this.data = data;
        this.next = next;
    }
};

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
    static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null)return null;
        ListNode tA = headA;
        ListNode tB = headB;
        while(tA != tB){
            tA = tA.next;
            tB = tB.next;
            if(tA == tB){
                return tA;
            }
            if(tA == null){
                tA = headB;
            }
            if(tB == null){
                tB = headA;
            }
        }
        return tA;
    }
    static ListNode midNode(ListNode head) {
        if (head == null || head.next == null)return head;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    static ListNode deleteMidNode(ListNode head) {
        if (head == null || head.next == null)return null;
        ListNode slow = head;
        ListNode fast = head;
        boolean fastAhead = false;
        while(fast != null && fast.next != null){
            if(fastAhead){
                slow = slow.next;
            }
            fastAhead = true;
            fast = fast.next.next;
        }
        if (slow != null && slow.next != null) {
            slow.next = slow.next.next;
        }
        return head;
    }
    static ListNode betterDeleteMidNode(ListNode head) {
        if (head == null || head.next == null)return null;
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    static Node deleteMidNode(Node head) {
        if (head == null || head.next == null)return null;
        Node slow = head;
        Node fast = head;
        boolean fastAhead = false;
        while(fast != null && fast.next != null){
            if(fastAhead){
                slow = slow.next;
            }
            fastAhead = true;
            fast = fast.next.next;
        }
        if (slow != null && slow.next != null) {
            slow.next = slow.next.next;
        }
        return head;
    }
    static boolean detectCycle(ListNode head) {
        if (head == null || head.next == null)return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return true;
        }
        return false;
    }
    static int getLengthOfCycle(Node slow, Node fast){
        int count = 0;
        do{
            fast = fast.next;
            count += 1;
        }while(slow != fast);
        return count;
    }
    static int lengthOfCycle(Node head) {
        if (head == null || head.next == null) return 0;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return getLengthOfCycle(slow, fast);
        }
        return 0;
    }
    static ListNode getStateOfCycle(ListNode head, ListNode fast){
        ListNode start = head;
        while(fast != start){
            fast = fast.next;
            start = start.next;
        }
        return fast;
    }
    static ListNode findStartOfCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return getStateOfCycle(head, fast);
        }
        return null;
    }

    static Node getStateOfCycle(Node head, Node fast){
        Node start = head;
        while(fast != start){
            fast = fast.next;
            start = start.next;
        }
        return fast;
    }
    static Node findStartOfCycle(Node head) {
        if (head == null || head.next == null) return null;
        Node slow = head;
        Node fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) return getStateOfCycle(head, fast);
        }
        return null;
    }

    class Node {
        public int data;
        public Node next;
        public Node prev;

        Node()
        {
            this.data = 0;
            this.next = null;
            this.prev = null;
        }
        Node(int data)
        {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
        Node(int data, Node next, Node prev)
        {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
//    class Node<T> {
//        T data;
//        Node<T> next;
//        Node<T> prev;
//
//        public Node(T data) {
//            this.data = data;
//        }
//    }
    static Node deleteNodeWithKey(Node head, int key) {
        if (head == null) return null;
        Node temp = head.next;
        Node prev = null;
        Node next = null;
        while(temp != null){
            if(temp.data == key){
                if(temp == head){
                    head = temp;
                }
                next = temp.next;
                prev = temp.prev;
                if(next != null){
                    next.prev = prev;
                }
                if(prev != null){
                    prev.next = next;
                }
            }
            temp = temp.next;
        }
        return head;
    }
    static Map<Integer,Integer> findPair(Node head, int k) { // two pointer approach
        Map<Integer,Integer> mp=new HashMap<>();
        Node left= head;
        Node right = head;
        while(right!=null && right.next !=null)
        {
            right = right.next;
        }
        while(left.data <= right.data){
            int sum = left.data + right.data;
            if(sum == k){
                mp.put(left.data, right.data);
            }
            else if(sum < k){
                left = left.next;
            }else{
                right = right.prev;
            }
        }
        return mp;
    }

    static Node rotateLL(Node head, int k){
        if(head == null || head.next == null || k == 0) return head;
        int lengthOfLL = 1;
        Node temp = head;
        while(temp.next != null){
            temp = temp.next;
            lengthOfLL += 1;
        }
        int kModLen = k % lengthOfLL;
        if (kModLen == 0) return head;
        int counter = 1;
        temp.next = head;
        temp = head;

        while(temp.next != null){
            if (counter == lengthOfLL - kModLen) break;
            temp = temp.next;
            counter += 1;
        }
        Node first = temp.next;
        temp.next = null;
        return first;
    }
    static ListNode rotateLL(ListNode head, int k){
        if(head == null || head.next == null || k == 0) return head;
        int lengthOfLL = 1;
        ListNode temp = head;
        while(temp.next != null){
            temp = temp.next;
            lengthOfLL += 1;
        }
        int kModLen = k % lengthOfLL;
        if (kModLen == 0) return head;
        int counter = 1;
        temp.next = head;
        temp = head;

        while(temp.next != null){
            if (counter == lengthOfLL - kModLen) break;
            temp = temp.next;
            counter += 1;
        }
        ListNode first = temp.next;
        temp.next = null;
        return first;
    }
    static LinkedListNode mergeTwoLL(LinkedListNode first, LinkedListNode second){
        if(first == null) return second;
        if(second == null) return first;

        LinkedListNode<Integer> temp1 = first;
        LinkedListNode<Integer> temp2 = second;
        LinkedListNode<Integer> head1;
        LinkedListNode<Integer> head;
        if(temp1.data <= temp2.data){
            head = temp1;
            head1 = temp1;
            temp1 = temp1.next;
        }else{
            head = temp2;
            head1 = temp2;
            temp2 = temp2.next;
        }
        while(temp1 != null && temp2 != null){
            if(temp1.data <= temp2.data){
                head.next = temp1;
                temp1 = temp1.next;
            }else{
                head.next = temp2;
                temp2 = temp2.next;
            }
            head = head.next;
        }
        while (temp1 != null){
            head.next = temp1;
            temp1 = temp1.next;
            head = head.next;
        }
        while (temp2 != null){
            head.next = temp2;
            temp2 = temp2.next;
            head = head.next;
        }
        return head1;
    }
    static ListNode mergeTwoLL(ListNode list1, ListNode list2){
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode temp1 = list1;
        ListNode temp2 = list2;
        ListNode head1;
        ListNode head;
        if(temp1.val <= temp2.val){
            head = temp1;
            head1 = temp1;
            temp1 = temp1.next;
        }else{
            head = temp2;
            head1 = temp2;
            temp2 = temp2.next;
        }
        while(temp1 != null && temp2 != null){
            if(temp1.val <= temp2.val){
                head.next = temp1;
                temp1 = temp1.next;
            }else{
                head.next = temp2;
                temp2 = temp2.next;
            }
            head = head.next;
        }
        while (temp1 != null){
            head.next = temp1;
            temp1 = temp1.next;
            head = head.next;
        }
        while (temp2 != null){
            head.next = temp2;
            temp2 = temp2.next;
            head = head.next;
        }
        return head1;
    }

    class Nodes {
        public int data;
        public Nodes next;
        public Nodes child;

        Nodes()
        {
            this.data = 0;
            this.next = null;
            this.child = null;
        }
        Nodes(int data)
        {
            this.data = data;
            this.next = null;
            this.child = null;
        }
        Nodes(int data, Nodes next, Nodes child)
        {
            this.data = data;
            this.next = next;
            this.child = child;
        }
    }
    static Nodes FlattenLinkedList(Nodes head){
        if(head == null) return null;
        Nodes row = head;
        Nodes newLL = new Nodes(-1);
        Nodes newLLHead = newLL;
        while (row != null && newLL != null){
            Nodes col = row.child;
            newLL.next = row;
            while (col != null){
                newLL.next = col;
                newLL = newLL.next;
                col = col.child;
            }
            row = row.next;
            newLL = newLL.next;
        }
        return newLLHead.next;
    }
}

