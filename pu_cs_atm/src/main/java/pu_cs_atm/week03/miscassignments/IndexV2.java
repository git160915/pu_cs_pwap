package pu_cs_atm.week03.miscassignments;

import pu_cs_atm.week02.miscassignments.Queue;
import edu.princeton.cs.introcs.*;

public class IndexV2 {

    public static void main(String[] args) {
        ST<String, Queue<Integer>> st = new ST<>();
        int iIndex = 0;

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();

            if (st.contains(word)) {
                st.get(word).enqueue(iIndex);
            } else {
                Queue<Integer> queue = new Queue<>();
                queue.enqueue(iIndex);
                st.put(word, queue);
            }

            iIndex++;
        }

        for (String s : st.keys()) {
            StdOut.printf("%s ", s);

            for (Integer i : st.get(s)) {
                StdOut.printf("%d ", i);
            }

            StdOut.println();
        }
    }
}