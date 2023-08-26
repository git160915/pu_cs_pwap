public class Huntingtons {

    // Returns the maximum number of consecutive repeats of CAG in the DNA string.
    public static int maxRepeats(String dna) {
        int iMaxRepeats = 0;
        int iCurrRepeats = 0;
        int iCurrIndexOfCAG = 0;
        int iPrevIndexOfCAG = 0;

        iCurrIndexOfCAG = dna.indexOf("CAG");
        if (iCurrIndexOfCAG < 0) {
            return iMaxRepeats;
        } else {
            iCurrRepeats++;
            
            // StdOut.println("MaxRepeats: " + iMaxRepeats + ", Prev: " + iPrevIndexOfCAG + ", Curr: " + iCurrIndexOfCAG);
        }

        while (iCurrIndexOfCAG < dna.length() - 2) {
            iPrevIndexOfCAG = iCurrIndexOfCAG + 1;
            iCurrIndexOfCAG = dna.indexOf("CAG", iPrevIndexOfCAG);

            if (iCurrIndexOfCAG > iPrevIndexOfCAG) {
                if (iCurrIndexOfCAG - iPrevIndexOfCAG == 2) {
                    iCurrRepeats++;

                    // StdOut.println("CurrRepeats: " + iCurrRepeats + ", Prev: " + iPrevIndexOfCAG + ", Curr: " + iCurrIndexOfCAG);
                } else if (iCurrRepeats > iMaxRepeats) {
                    // Save the current repeats as the maximum repeats up to this point
                    iMaxRepeats = iCurrRepeats;

                    // If we have a new max sequence, we also reset the current repeats count
                    iCurrRepeats = 1;

                    // StdOut.println("MaxRepeats: " + iMaxRepeats + ", Prev: " + iPrevIndexOfCAG + ", Curr: " + iCurrIndexOfCAG);
                } else {
                    // Reset the current count when it encounters a new sequence
                    iCurrRepeats = 1;
                }
            } else {
                // This handles the case where the sequence that is the max repeats is the last sequence of consecutive CAGs
                if (iCurrRepeats > iMaxRepeats) {
                    iMaxRepeats = iCurrRepeats;
                    iCurrRepeats = 1;
                    // StdOut.println("MaxRepeats: " + iMaxRepeats + ", Prev: " + iPrevIndexOfCAG + ", Curr: " + iCurrIndexOfCAG);
                }

                return iMaxRepeats;
            }
        }

        return iMaxRepeats;
    }

    // Returns a copy of s, with all whitespace (spaces, tabs, and newlines) removed.
    public static String removeWhitespace(String s) {
        return s.replace("\n", "").replace("\t", "").replace(" ", "");
    }

    // Returns one of these diagnoses corresponding to the maximum number of repeats:
    // "not human", "normal", "high risk", or "Huntington's".
    public static String diagnose(int maxRepeats) {
        int[] iRepeatsList = {0, 10, 36, 40, 181};
        String[] sDiagnosisRef = {"not human", "normal", "high risk", "Huntington's", "not human"};
        
        for (int i = 0; i < iRepeatsList.length; i++) {
            if (maxRepeats < iRepeatsList[i]) {
                return sDiagnosisRef[i - 1];
            } else if (i == iRepeatsList.length - 1) {
                return sDiagnosisRef[i];
            }
        }

        return "undefined";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        In in = new In(args[0]);
        int iMaxRepeats = 0;
        String sInput = removeWhitespace(in.readAll());

        // StdOut.println(sInput);
        iMaxRepeats = maxRepeats(sInput);
        StdOut.println("max repeats = " + iMaxRepeats);
        StdOut.println(diagnose(iMaxRepeats));
    }
}