public class Inversions {

    // Return the number of inversions in the permutation a[].
    public static long count(int[] a) {
        long lNumInversions = 0;

        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    lNumInversions++;
                }
            }
        }

        return lNumInversions;
    }

    // Return a permutation of length n with exactly k inversions.
    public static int[] generate(int n, long k) {
        int[] iPermutation = new int[n];
        int[] iPermutationTmp = new int[n];
        long lInversionCal = k;
        int iNumberToShift = 0;
        long lInversions = 0;
        int iTmpNum = 0;

        for (int i = 0; i < iPermutation.length; i++) {
            iPermutation[i] = i;
            iPermutationTmp[i] = i;
        }
        
        if (k == 0) {
            return iPermutation;
        }
        
        for (int i = iPermutation.length - 1; i <= lInversionCal && i > 0; i--) {
            if (i <= lInversionCal) {
                iNumberToShift = i;
                lInversionCal -= i;
                // StdOut.println(iNumberToShift + ", " + lInversionCal);
            }
        }

        int iLastElement = iPermutation.length - 1;
        for (int i = iNumberToShift; i < iPermutation.length && iNumberToShift > 0; i++) {
            iPermutation[iLastElement - i] = iPermutationTmp[i];
        }

        int iStartIndex = iLastElement - iNumberToShift + 1;
        for (int i = 0; iStartIndex + i < iPermutation.length; i++) {
            iPermutation[iStartIndex + i] = iPermutationTmp[i];
        }

        int iFinalNumToShift = iLastElement - (int) lInversionCal;
        iTmpNum = iPermutation[iLastElement];
        for (int i = iLastElement; i > iFinalNumToShift; i--) {
            iPermutation[i] = iPermutation[i - 1];
        }
        iPermutation[iFinalNumToShift] = iTmpNum;

        /*
        lInversions = count(iPermutation);
        for (int i = 0; i < iPermutation.length && lInversions < k; i++) {
            for (int j = iPermutation.length - 1; j > i && lInversions < k; j--) {
                iTmpNum = iPermutation[j];
                iPermutation[j] = iPermutation[j - 1];
                iPermutation[j - 1] = iTmpNum;

                lInversions = count(iPermutation);
            }
        }
        */

        return iPermutation;
    }

    // Takes an integer n and a long k as command-line arguments,
    // and prints a permutation of length n with exactly k inversions.
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);
        long lK = Long.parseLong(args[1]);

        // StdOut.println("n: " + iN + ", k: " + lK);
        int[] iPermutation = generate(iN, lK);

        for (int i = 0; i < iPermutation.length; i++) {
            StdOut.print(iPermutation[i] + " ");
        }
        StdOut.println();
    }
}