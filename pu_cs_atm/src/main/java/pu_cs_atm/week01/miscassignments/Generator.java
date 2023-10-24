package pu_cs_atm.week01.miscassignments;

import edu.princeton.cs.introcs.*;

public class Generator {

    public static String randomString(int strLength, String alphabet) {
        char[] cRandomList = new char[strLength];

        for (int i = 0; i < strLength; i++) {
            int iRandom = StdRandom.uniformInt(alphabet.length());
            cRandomList[i] = alphabet.charAt(iRandom);
        }

        return new String(cRandomList);
    }

    public static void main(String[] args) {
        int iNumOfRandomStrings = Integer.parseInt(args[0]);
        int iLenghtOfRandomString = Integer.parseInt(args[1]);
        String alphabet = args[2];

        for (int i = 0; i < iNumOfRandomStrings; i++) {
            StdOut.println(randomString(iLenghtOfRandomString, alphabet));
        }
    }
}