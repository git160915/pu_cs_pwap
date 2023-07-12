public class MissingInteger {
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);
        boolean[] iListOfIntegers = new boolean[iN];
        int iCurrInt = 0;

        for (int i = 0; i < iListOfIntegers.length - 1; i++) {
            iCurrInt = StdIn.readInt();

            if (!iListOfIntegers[iCurrInt-1]) {
                iListOfIntegers[iCurrInt-1] = true;
            }
        }

        for (int i = 0; i < iListOfIntegers.length; i++) {
            if (!iListOfIntegers[i]) {
                StdOut.println("The missing value is: " + (i+1));
            }
        }
    }
}