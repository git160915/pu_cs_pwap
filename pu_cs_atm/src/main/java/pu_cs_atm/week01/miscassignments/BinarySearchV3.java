package pu_cs_atm.week01.miscassignments;

import java.util.Arrays;
import edu.princeton.cs.introcs.*;

public class BinarySearchV3 {

    public static int search(String key, String[] list) {
        return search(key, list, 0, list.length);
    }

    public static int search(String key, String[] list, int low, int high) {
        if (high <= low) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        int compare = list[mid].compareTo(key);

        if (compare > 0) {
            return search(key, list, low, mid);
        } else if (compare < 0) {
            return search(key, list, mid + 1, high);
        }

        return mid;
    }

    public static void main(String[] args) {
        String searchKey = args[0];
        In inFile = new In(args[1]);
        String[] sWordsList = inFile.readAllStrings();

        // Arrays.sort(sWordsList);
        MergeSortV2.sort(sWordsList);

        int iFoundKey = search(searchKey, sWordsList);

        if (iFoundKey >= 0) {
            StdOut.println("Found key in file at position, " + iFoundKey + ".");
        } else {
            StdOut.println("Did not find key in file.");
        }
    }
}