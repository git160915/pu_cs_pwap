package pu_cs_atm.week01.miscassignments;

import edu.princeton.cs.introcs.*;

public class WhiteFilter {
    public static int search(String key, String[] a) {
        for (int i = 0; i < a.length; i++) {
            if (a[i].compareTo(key) == 0) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        In whiltelistfile = new In(args[0]);
        String[] sWhiteList = whiltelistfile.readAllLines();

        while (!StdIn.isEmpty()) {
            String key = StdIn.readString();
            if (search(key, sWhiteList) != -1) {
                StdOut.println(key);
            }
        }
    }
}