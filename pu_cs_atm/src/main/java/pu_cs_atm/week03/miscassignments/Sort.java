package pu_cs_atm.week03.miscassignments;

import edu.princeton.cs.introcs.*;

public class Sort {

    public static void main(String[] args) {
        BST<String, Integer> st = new BST<String, Integer>();

        while (!StdIn.isEmpty()) {
            String key = StdIn.readLine();

            st.put(key, 0);
        }

        for (String s : st.keys()) {
            StdOut.println(s);
        }
    }
}