public class UniqueNumberFilter {
    public static void main(String[] args) {
        int iPrevNum = 0;
        int iCurrNum = 0;
        String sNumSeq = "";

        iCurrNum = StdIn.readInt();
        sNumSeq += iCurrNum;

        while (!StdIn.isEmpty()) {
            iPrevNum = iCurrNum;
            iCurrNum = StdIn.readInt();
        
            if (iCurrNum != iPrevNum) {
                sNumSeq += " " + iCurrNum;
            }
        }

        StdOut.println(sNumSeq);
    }
}