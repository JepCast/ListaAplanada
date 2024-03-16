package org.example;

class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node(int val) {
        this.val = val;
    }
}

public class Main {
    public Node flatten(Node head) {
        if (head == null) return null;

        Node curr = head;
        while (curr != null) {
            if (curr.child != null) {
                Node next = curr.next;
                Node childTail = flatten(curr.child);
                curr.next = curr.child;
                curr.child.prev = curr;
                curr.child = null;
                if (next != null) {
                    childTail.next = next;
                    next.prev = childTail;
                }
                curr = childTail;
            }
            curr = curr.next; // Move to the next node after processing child
        }
        return head;
    }

    public static void main(String[] args) {
        Main solution = new Main();

        // Construct the input linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;
        head.next.next.next.next = new Node(5);
        head.next.next.next.next.prev = head.next.next.next;
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.prev = head.next.next.next.next;

        // Construct child nodes with proper prev pointers
        head.next.next.child = new Node(7);
        head.next.next.child.prev = head.next.next;
        head.next.next.child.next = new Node(8);
        head.next.next.child.next.prev = head.next.next.child;
        head.next.next.child.next.next = new Node(9);
        head.next.next.child.next.next.prev = head.next.next.child.next;
        head.next.next.child.next.next.next = new Node(10);
        head.next.next.child.next.next.next.prev = head.next.next.child.next.next;

        head.next.next.child.next.child = new Node(11);
        head.next.next.child.next.child.prev = head.next.next.child.next;
        head.next.next.child.next.child.next = new Node(12);
        head.next.next.child.next.child.next.prev = head.next.next.child.next.child;

        // Call the flatten function
        Node flattenedHead = solution.flatten(head);

        // Print the flattened list (corrected loop)
        Node current = flattenedHead;
        System.out.print("Salida: [");
        while (current != null) {
            System.out.print(current.val);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }
}
