public class LRSArray {

    public static String lcp(String s, String t) {
        int iShortestString = Math.min(s.length(), t.length());

        for (int i = 0; i < iShortestString; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                return s.substring(0, i);
            }
        }

        return s.substring(0, iShortestString);
    }

    public static String lrs(String s) {
        int iStringLength = s.length();
        String[] sListSubstrings = new String[iStringLength];
        String sLRS = "";

        for (int i = 0; i < iStringLength; i++) {
            sListSubstrings[i] = s.substring(i, iStringLength);
        }

        Merge.sort(sListSubstrings);

        for (int i = 0; i < sListSubstrings.length - 1; i++) {
            String sLCP = lcp(sListSubstrings[i], sListSubstrings[i + 1]);
            if (sLCP.length() > sLRS.length()) {
                sLRS = sLCP;
            }
        }

        return sLRS;
    }

    public static void main(String[] arg) {
        String sLongString = StdIn.readAll();
        StdOut.println(lrs(sLongString));
    }
}