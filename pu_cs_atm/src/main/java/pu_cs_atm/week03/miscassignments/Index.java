package pu_cs_atm.week03.miscassignments;

import pu_cs_atm.week02.miscassignments.Queue;
import edu.princeton.cs.introcs.*;

public class Index {

    public static void main(String[] args) {
        BST<String, Queue<Integer>> bst = new BST<String, Queue<Integer>>();
        int iIndex = 0;

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();

            if (!bst.contains(word)) {
                bst.put(word, new Queue<Integer>());
            }

            bst.get(word).enqueue(iIndex);

            iIndex++;
        }

        for (String s : bst.keys()) {
            StdOut.print(s + " ");

            for (Integer i : bst.get(s)) {
                StdOut.print(i + " ");
            }

            StdOut.println();
        }
    }
}