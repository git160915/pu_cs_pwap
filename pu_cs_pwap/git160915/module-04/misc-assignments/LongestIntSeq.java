public class LongestIntSeq {
    public static void main(String[] args) {
        int iLongestSeq = 0;        // Longest Sequence of Integers thats the same
        int iCurrLongestSeq = 0;    // The count of the current sequence of Integers thats the same
        int iCurrSeqNum = 0;        // The Integer that is the current sequence of same Integers
        int iPrevNum = 0;           // Previous read in Integer
        int iCurrNum = 0;           // Current read in Integer

        // Read in the first integer
        iCurrNum = StdIn.readInt();

        // Initialise to 1;
        iCurrLongestSeq = 1;
        iLongestSeq = iCurrLongestSeq;

        // Handle case when only 1 number is input
        iCurrSeqNum = iCurrNum;

        while (!StdIn.isEmpty()) {
            iPrevNum = iCurrNum;
            iCurrNum = StdIn.readInt();

            if (iCurrNum == iPrevNum) {
                iCurrLongestSeq++;

                // If this is the last number then do the longest number checks
                if (StdIn.isEmpty()) {
                    if (iCurrLongestSeq >= iLongestSeq) {
                        iLongestSeq = iCurrLongestSeq;
                        iCurrSeqNum = iPrevNum;
                    }
                }
            } else {
                if (iCurrLongestSeq >= iLongestSeq) {
                    iLongestSeq = iCurrLongestSeq;
                    iCurrSeqNum = iPrevNum;
                }

                // Re-initialise to 1;
                iCurrLongestSeq = 1;
            }
        }

        StdOut.println("Longest run: " + iLongestSeq + " consecutive " + iCurrSeqNum + "s");
    }
}
