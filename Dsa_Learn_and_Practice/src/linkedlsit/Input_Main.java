package linkedlsit;

import java.util.Scanner;

public class Input_Main {
    // Function to create a linked list from user input
    static Node createLinkedList(Scanner sc, int length) {
        if (length == 0) return null;

        Node head = new Node(sc.nextInt());
        Node temp = head;

        for (int i = 1; i < length; i++) {
            Node newNode = new Node(sc.nextInt());
            temp.next = newNode;
            temp = temp.next;
        }
        return head;
    }

    // Function to print linked list
    static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    static void display(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of linked lists: ");
        int n = sc.nextInt();

        Node[] lists = new Node[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter length of linked list " + (i + 1) + ": ");
            int len = sc.nextInt();

            System.out.println("Enter " + len + " elements:");
            lists[i] = createLinkedList(sc, len);
        }

        System.out.println("\nLinked Lists Entered:");
        for (int i = 0; i < n; i++) {
            System.out.print("Linked List " + (i + 1) + ": ");
            printLinkedList(lists[i]);
        }
        // Add_Two_Numbers_Linked_List addTwoNumbersLinkedList = new Add_Two_Numbers_Linked_List();
        //display(addTwoNumbersLinkedList.addTwoNumbers(lists[0],lists[1]));
       // Odd_Even_Linked_list oddEvenLinkedList = new Odd_Even_Linked_list();
        //display(oddEvenLinkedList.oddEvenList(lists[0]));

//        Sort_Linked_List sortLinkedList = new Sort_Linked_List();
//        sortLinkedList.sortList(lists[0]);
//        display(lists[0]);
    }
}
