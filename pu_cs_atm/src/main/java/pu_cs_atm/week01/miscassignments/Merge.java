package pu_cs_atm.week01.miscassignments;

import edu.princeton.cs.introcs.*;

public class Merge {

    private static String[] aux;

    public static void merge(String[] sList, int iLow, int iMid, int iHigh) {
        int i = iLow;
        int j = iMid;
        int iSizeOfCurrList = iHigh - iLow;

        for (int k = 0; k < iSizeOfCurrList; k++) {
            if (i == iMid) {
                aux[k] = sList[j++];
            } else if (j == iHigh) {
                aux[k] = sList[i++];
            } else if (sList[j].compareTo(sList[i]) < 0) {
                aux[k] = sList[j++];
            } else {
                aux[k] = sList[i++];
            }
        }

        for (int k = 0; k < iSizeOfCurrList; k++) {
            sList[iLow + k] = aux[k];
        }

        return;
    }

    public static void sort(String[] sList) {
        aux = new String[sList.length];
        sort(sList, 0, sList.length);
    }

    public static void sort(String[] sList, int iLow, int iHigh) {
        int iSizeList = iHigh - iLow;
        
        if (iSizeList <= 1) {
            return;
        }

        int iMid = iLow + iSizeList / 2;
        sort(sList, iLow, iMid);
        sort(sList, iMid, iHigh);
        merge(sList, iLow, iMid, iHigh);
    
        return;
    }

    public static void main(String[] args) {
        String[] sWordsList = StdIn.readAllStrings();
        sort(sWordsList);

        for (int i = 0; i < sWordsList.length; i++) {
            StdOut.println(sWordsList[i]);
        }
    }
}