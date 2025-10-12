import java.util.Scanner;

class LinkedListNode {
    public int data;
    LinkedListNode next;

    LinkedListNode(int data) {
        this.data = data;
        this.next = null;
    }
}

public class CustomLinkedList {

    LinkedListNode head;
    LinkedListNode tail;

    public CustomLinkedList() {
        head = tail = null;
    }

    // Helper method to handle insertion when the list is empty
    private void insertEmptyList(int data) {
        LinkedListNode newLinkedListNode = new LinkedListNode(data);
        head = tail = newLinkedListNode;
    }

    // Insert a LinkedListNode at the head of the list
    void insertAtHead(int data) {
        LinkedListNode newLinkedListNode = new LinkedListNode(data);

        // If the list is empty, handle this case
        if (head == null) {
            insertEmptyList(data);
        } else {
            newLinkedListNode.next = head;
            head = newLinkedListNode;
        }
    }

    // Insert a LinkedListNode at the tail of the list
    void insertAtTail(int data) {
        LinkedListNode newLinkedListNode = new LinkedListNode(data);

        // If the list is empty, handle this case
        if (head == null) {
            insertEmptyList(data);
        } else {
            tail.next = newLinkedListNode;
            tail = newLinkedListNode;
        }
    }

    // Print the list
    void printList() {
        if (head == null) {
            System.out.println("The list is empty.");
            return;
        }

        LinkedListNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            CustomLinkedList list = new CustomLinkedList();

            // Initial insert at head
            list.insertAtHead(0);

            // Asking user to input the size of the list
            System.out.print("Enter the list size: ");
            int size = sc.nextInt();

            // Edge case: if size is 0, we don't insert anything
            if (size == 0) {
                System.out.println("No elements to insert.");
            } else {
                // Insert elements at the tail based on user input
                while (size > 0) {
                    System.out.print("Input the element: ");
                    int element = sc.nextInt();
                    list.insertAtTail(element);
                    size--;
                }
            }

            // Print the final list
            list.printList();
        }
    }
}