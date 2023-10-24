import java.util.Arrays;

public class BinarySearch {

    public static int search(String sKey, String[] sList) {
        return search(sKey, sList, 0, sList.length);
    }

    public static int search(String sKey, String[] sList, int iLow, int iHigh) {
        if (iHigh <= iLow) {
            return -1;
        }

        int iMid = iLow + (iHigh - iLow) / 2;
        int iCompareResult = sList[iMid].compareTo(sKey);

        if (iCompareResult > 0) {
            return search(sKey, sList, iLow, iMid);
        } else if (iCompareResult < 0) {
            return search(sKey, sList, iMid + 1, iHigh);
        }

        return iMid;
    }

    public static void main(String[] args) {
        String[] sWordsList = StdIn.readAllStrings();
        int iWordsListCount = sWordsList.length;

        double dStart = System.currentTimeMillis() / 1000.0;

        // Need to sort the list before we can perform a Binary Search
        // Arrays.sort(sWordsList);
        MergeSortV2.sort(sWordsList);

        for (int i = 0; i < 10 * iWordsListCount; i++) {
            String sKey = sWordsList[StdRandom.uniformInt(iWordsListCount)];
            if (search(sKey, sWordsList) == -1) {
                StdOut.println(sKey);
            }
        }

        double dNow = System.currentTimeMillis() / 1000.0;
        StdOut.println(Math.round(dNow - dStart) + " seconds");
    }
}