public class Queue<Item> {

    // represents the start of the queue (this is the one we will pop)
    private Node firstNode;

    // represents the most recent item (last item) that was pushed onto the queue
    private Node lastNode;

    // size of the queue
    private int iSizeOfQueue;

    private class Node {
        Item item;
        Node next;
    }

    public Queue() {
        firstNode = null;
        lastNode = null;
        iSizeOfQueue = 0;
    }

    public boolean isEmpty() {
        return (iSizeOfQueue == 0);
    }
    
    public int sizeOf() {
        return iSizeOfQueue;
    }

    public void enqueue(Item item) {
        Node secondLastNode = lastNode;
        lastNode = new Node();
        lastNode.item = item;
        
        if (secondLastNode == null) {
            firstNode = lastNode;
        } else {
            secondLastNode.next = lastNode;
        }
        
        iSizeOfQueue++;

        // StdOut.print("(push)" + lastNode.item + " ");
    }

    public Item dequeue() throws IllegalAccessException {
        if (isEmpty()) {
            throw new IllegalAccessException("Queue is empty");
        }

        Item item = firstNode.item;
        firstNode = firstNode.next;
        iSizeOfQueue--;

        /*
        StdOut.print("(pop)" + item + " ");
        if (firstNode == null) {
            StdOut.print("Empty ");
        }
        */

        return item;
    }

    public static void main(String[] args) {
        Queue<String> queue = new Queue<String>();

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.equals("-")) {
                try {
					StdOut.print(queue.dequeue() + " ");
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            } else {
                queue.enqueue(word);
            }
        }

        StdOut.println();
    }
}