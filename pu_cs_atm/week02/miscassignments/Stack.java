package pu_cs_atm.week02.miscassignments;

import java.util.Iterator;
import StdOut;
import StdIn;

public class Stack<Item> implements Iterable<Item> {

    private Node firstNode;
    private int iStackSize;

    private class Node {
        private Item item;
        private Node next;
    }

    private Stack() {
        firstNode = null;
        iStackSize = 0;
    }

    public boolean isEmpty() {
        return (iStackSize == 0);
    }

    public int size() {
        return iStackSize;
    }

    // Keep adding to the stack at the first node
    public void push(Item item) {
        Node secondNode = firstNode;
        firstNode = new Node();
        firstNode.item = item;
        firstNode.next = secondNode;
        iStackSize++;

        // StdOut.print("(push)" + firstNode.item + " ");
    }

    // Pop from the first node
    public Item pop() {
        Item item = firstNode.item;
        firstNode = firstNode.next;
        iStackSize--;

        /*
        StdOut.print("(pop)" + item + " ");
        if (firstNode == null) {
            StdOut.print("Empty ");
        }
        */

        return item;
    }

    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    public class ListIterator implements Iterator<Item> {

        Node current = firstNode;

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            Item item = current.item;
            current = current.next;
            return item;
        }

        public void remove() {
            return;
        }
    }

    public static void main(String[] args) {
        Stack<String> stack = new Stack<String>();

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.equals("-")) {
                StdOut.print(stack.pop() + " ");
            } else {
                stack.push(word);
            }
        }
        StdOut.println();
    }
}