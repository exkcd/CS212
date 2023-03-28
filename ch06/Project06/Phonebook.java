/*
 * Use a Doubly Linked List to contain a directory of names and phone numbers associated with those names. Implement
 * the use of a TreeSet to search for a specific name either at the head or tail of the Doubly Linked List
 *
 * R Stone
 */

import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Phonebook {
    Node head, tail = null;

    public static void main(String[] args) {
        Phonebook dList = new Phonebook();

        dList.addNode(new PhonebookData("Michael Jackson", "484-867-5209"));
        dList.addNode(new PhonebookData("P Sherman", "443-904-2332"));
        dList.addNode(new PhonebookData("Marilyn Monroe", "484-904-2222"));
        dList.addNode(new PhonebookData("David Jones", "650-455-2222"));
        dList.addNode(new PhonebookData("Roy Rogers", "484-885-2222"));
        dList.addNode(new PhonebookData("Sam Smith", "484-223-1234"));
        dList.addNode(new PhonebookData("Sam Smith", "484-223-1234"));


        dList.display();

        Scanner scanner = new Scanner(System.in);

        boolean competent = true;
        do {
            System.out.println("Would you like to search from the start or end of the list? ('h' for list head, 't' for list tail)");
            String ans = scanner.nextLine().toLowerCase();

            if (ans.equals("h")) {
                competent = false;
                System.out.println("Starting search from head test...");
                System.out.print("Enter search item (or q to quit): ");

                String searchItem = scanner.nextLine();

                while (!searchItem.equals("q")) {
                    SortedSet<PhonebookData> sortedSet = dList.searchHeadFirst(searchItem);
                    if (sortedSet.size() != 0) {
                        for (PhonebookData node : sortedSet) {
                            System.out.println(node.toString());
                        }
                    } else {
                        System.out.println("No search results found...");
                    }

                    System.out.print("\nEnter search item (or q to quit): ");
                    searchItem = scanner.nextLine();
                }
            } else if (ans.equals("t")) {
                competent = false;
                System.out.println("Starting search from head test...");
                System.out.print("Enter search item (or q to quit): ");

                String searchItem = scanner.nextLine();

                while (!searchItem.equals("q")) {
                    SortedSet<PhonebookData> sortedSet = dList.searchTailFirst(searchItem);
                    if (sortedSet.size() != 0) {
                        for (PhonebookData node : sortedSet) {
                            System.out.println(node.toString());
                        }
                    } else {
                        System.out.println("No search results found...");
                    }

                    System.out.print("\nEnter search item (or q to quit): ");
                    searchItem = scanner.nextLine();
                }
            } else {
                System.out.println("-_-");
            }
        } while (competent);
    }

    public void addNode(PhonebookData data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            head.previous = null;
            tail.next = null;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
            tail.next = null;
        }
    }

    public void addPhoneData() {
    }


    public void display() {
        Node current = head;
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        System.out.println("Nodes of doubly linked list: ");
        while (current != null) {
            System.out.println(current.data + " ");
            current = current.next;
        }
    }

    public SortedSet<PhonebookData> searchHeadFirst(String searchItem) {
        SortedSet<PhonebookData> sortedSet = new TreeSet<>();

        Node current = head;

        if (head == null) {
            System.out.println("List is empty");
            return null;
        }
        System.out.println("Data found:");
        while (current != null) {
            if (current.data.name.toLowerCase().contains(searchItem.toLowerCase().strip()) || current.data.mobilePhone.contains(searchItem)) {
                sortedSet.add((PhonebookData) current.data);
            }
            current = current.next;
        }
        return sortedSet;
    }

    public SortedSet<PhonebookData> searchTailFirst(String searchItem) {
        SortedSet<PhonebookData> sortedSet = new TreeSet<>();
        Node current = tail;
        if (tail == null) {
            System.out.println("List is empty");
            return null;
        }

        while (current != null) {
            //Checks each node by incrementing the pointer.
            if (current.data.name.toLowerCase().contains(searchItem.toLowerCase().strip()) || current.data.mobilePhone.contains(searchItem)) {
                sortedSet.add((PhonebookData) current.data);
            }
            current = current.previous;
        }
        return sortedSet;
    }

    static class Node {
        PhonebookData data;
        Node previous;
        Node next;

        public Node(PhonebookData data) {
            this.data = data;
        }
    }
}