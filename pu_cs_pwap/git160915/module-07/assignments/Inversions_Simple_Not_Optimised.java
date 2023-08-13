public class Inversions_Simple_Not_Optimised {

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
        long lInversions = 0;
        int iTmpNum = 0;

        for (int i = 0; i < iPermutation.length; i++) {
            iPermutation[i] = i;
            iPermutationTmp[i] = i;
        }
        
        lInversions = count(iPermutation);
        for (int i = 0; i < iPermutation.length && lInversions < k; i++) {
            for (int j = iPermutation.length - 1; j > i && lInversions < k; j--) {
                iTmpNum = iPermutation[j];
                iPermutation[j] = iPermutation[j - 1];
                iPermutation[j - 1] = iTmpNum;

                lInversions = count(iPermutation);
            }
        }

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