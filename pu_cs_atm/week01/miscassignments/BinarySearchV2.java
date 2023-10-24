import java.util.Arrays;

/**
 * 
 */
public class BinarySearchV2 {

    /**
     * @param sSearchKey
     * @param sSearchList
     * @return
     */
    public static int search(String sSearchKey, String[] sSearchList) {
        return search(sSearchKey, sSearchList, 0, sSearchList.length);
    }

    /**
     * @param sSearchKey
     * @param sSearchList
     * @param iLow
     * @param iHigh
     * @return
     */
    public static int search(String sSearchKey, String[] sSearchList, int iLow, int iHigh) {
        if (iHigh <= iLow) {
            return -1;
        }

        int iMid = iLow + (iHigh - iLow) / 2;
        int compare = sSearchList[iMid].compareTo(sSearchKey);

        if (compare < 0) {
            return search(sSearchKey, sSearchList, iMid + 1, iHigh);
        } else if (compare > 0) {
            return search(sSearchKey, sSearchList, iLow, iMid);
        }

        // else they match so return the location we found the sSearchKey in sSearchList 
        return iMid;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        String key = args[0];
        String[] wordList = new In(args[1]).readAllStrings();
        int searchResult = search(key, wordList);

        Arrays.sort(wordList);

        if (searchResult >= 0) {
            StdOut.println("Found search key '" + key + "' at position, " + searchResult + " in list of words");
        } else {
            StdOut.println("Did not find search key '" + key + "' in list of words");
        }
    }
}