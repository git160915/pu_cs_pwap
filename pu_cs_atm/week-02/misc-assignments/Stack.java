public class Stack<Item> {

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