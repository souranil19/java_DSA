package linked_list;

public class LinkedList {

    // creating HEAD and TAIL of the list
    public static Node head;
    public static Node tail;

    public static int size;

    public static class Node {
        // data stored in the node
        int data;
        // for storing reffrence
        Node next;

        // constructor
        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // making a function that adds a node in front of head

    public void addFirst(int data) {
        // step 1 creating a new node

        Node newNode = new Node(data);
        size++;

        // if in our list there was no nodes that means null list the

        if (head == null) {
            head = tail = newNode;
            return;
        }
        // step 2 linking it with the orignal head
        newNode.next = head;
        // step 3 making it as the new head
        head = newNode;
    }

    // function for adding node in last
    public void addLast(int data) {

        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            tail.next = null;
            return;
        }

        tail.next = newNode;
        tail = newNode;

    }

    // function for adding a node in middle
    public void addMiddle(int index, int data) {

        /*
         * if our index is 0 means we are adding
         * element in first position in this case we
         * need to change out head so we will call add first function
         */

        if (index == 0) {
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;

        int i = 0;
        Node temp = head;
        // finding the index
        while (i < index - 1) {

            temp = temp.next;
            i = i + 1;
        }

        newNode.next = temp.next; // breaking the chain from index and adding our new node
        temp.next = newNode; // rejoining the chain to our new node

    }

    public int removeFirst() {

        if (size == 0) {
            System.out.println("Linked list is empty");
            return Integer.MIN_VALUE;
        }

        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;

            return val;
        }

        int val = head.data;
        head = head.next;
        size--;
        return val;
    }

    public int removeLast() {
        int val = tail.data;

        if (size == 0) {
            System.out.println("Linked List is empty");
            return Integer.MIN_VALUE;
        }

        if (size == 1) {

            head = tail = null;
            size--;
            return val;
        }

        Node temp = head;
        for (int i = 0; i < size - 2; i++) {
            temp = head.next;
        }

        temp.next.next = null;
        tail = temp;
        size--;
        return val;

    }

   

    public void print() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public Node findMiddle(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null) {
            return slow.next;
        }

        return slow;
    }

   
    public static void main(String args[]) {

        LinkedList ll = new LinkedList();

        ll.addFirst(10);
        ll.addFirst(20);
        ll.print();

        
    }

}
