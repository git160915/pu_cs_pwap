public class LRS {

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
        String sLRS = "";

        for (int i = 0; i < iStringLength; i++) {
            for (int j = i + 1; j < iStringLength; j++) {
                String sLCP = lcp(s.substring(i, iStringLength), s.substring(j, iStringLength));
                if (sLCP.length() > sLRS.length()) {
                    sLRS = sLCP;
                }
            }
        }

        return sLRS;
    }

    public static void main(String[] arg) {
        String sLongString = StdIn.readAll();
        StdOut.println(lrs(sLongString));
    }
}