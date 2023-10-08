public class BST<Key extends Comparable<Key>, Value> {

    private Node root = null;

    private class Node {
        private Key key;
        private Value val;
        private Node left;
        private Node right;

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
        }
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    public Value get(Key key) {
        return get(root, key);
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    private Value get(Node x, Key key) {
        if (x == null)
            return null;
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            return get(x.left, key);
        else if (cmp > 0)
            return get(x.right, key);
        else
            return x.val;
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null)
            return new Node(key, val);
        int cmp = key.compareTo(x.key);
        if (cmp < 0)
            x.left = put(x.left, key, val);
        else if (cmp > 0)
            x.right = put(x.right, key, val);
        else
            x.val = val;
        return x;
    }

    private void inorder(Node x, Queue<Key> queue) {
        if (x == null)
            return;
        inorder(x.left, queue);
        queue.enqueue(x.key);
        inorder(x.right, queue);
    }

    public Iterable<Key> keys() {
        Queue<Key> queue = new Queue<Key>();
        inorder(root, queue);
        return queue;
    }

    public static void main(String[] args) {
        // frequency counter
        BST<String, Integer> st = new BST<String, Integer>();
        while(!StdIn.isEmpty()) {
            String key = StdIn.readString();

            if (st.contains(key)) {
                st.put(key, st.get(key) + 1);
            } else {
                st.put(key, 1);
            }
        }

        for (String s : st.keys()) {
            StdOut.printf("%8d %s\n", st.get(s), s);
        }
    }
}