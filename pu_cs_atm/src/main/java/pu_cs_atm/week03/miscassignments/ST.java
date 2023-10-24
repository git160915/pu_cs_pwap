package pu_cs_atm.week03.miscassignments;

import pu_cs_atm.week02.miscassignments.Queue;
import edu.princeton.cs.introcs.*;

public class ST<Key extends Comparable<Key>, Value> {

    private Node root = null;

    private class Node {
        Key key;
        Value value;
        Node left;
        Node right;

        public Node(Key key, Value value) {
            this.key = key;
            this.value = value;
        }
    }

    public boolean contains(Key key) {
        return get(key) != null;
    }

    public Value get(Key key) {
        return get(root, key);
    }
    
    public Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }

        int comp = key.compareTo(x.key);
        if (comp < 0) {
            return get(x.left, key);
        } else if (comp > 0) {
            return get(x.right, key);
        }

        return x.value;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    public Node put(Node x, Key key, Value value) {
        if (x == null) {
            return new Node(key, value);
        }

        int comp = key.compareTo(x.key);
        if (comp < 0) {
            x.left = put(x.left, key, value);
        } else if (comp > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }

        return x;
    }

    public void inorder(Node x, Queue<Key> queue) {
        if (x == null) {
            return;
        }

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
        ST<String, Integer> st = new ST<>();
    
        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();

            if (st.contains(word)) {
                st.put(word, st.get(word) + 1);
            } else {
                st.put(word, 1);
            }
        }

        for (String s : st.keys()) {
            StdOut.printf("%8d %s\n", st.get(s), s);
        }
    }
}