public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        // Edge cases and special conditions
        if (n == 0 && k == 0) return 1;
        if (k < -n || k > n) return 0;

        long[][] iTrinomialTriangle = createTrinomialTriangle(n);

        /*
        for (int iRow = 0; iRow < iTrinomialTriangle.length; iRow++) {
            if (iRow == n) {
            for (int iCol = 0; iCol < iTrinomialTriangle[0].length; iCol++) {
                if (iTrinomialTriangle[iRow][iCol] > 0)
                    StdOut.print(iTrinomialTriangle[iRow][iCol] + " ");
                else
                    StdOut.print("  ");
            }
            StdOut.println();
            }
        }
        */

        return iTrinomialTriangle[n][n + k];
    }

    private static long[][] createTrinomialTriangle(int n) {
        long[][] iTrinomialTriangle = new long[n + 1][(n * 2) + 1];

        int iMidPoint = iTrinomialTriangle[0].length / 2;

        // Initialise the first row
        iTrinomialTriangle[0][iMidPoint] = 1;
        for (int iRow = 1; iRow < iTrinomialTriangle.length; iRow++) {
            iTrinomialTriangle[iRow][iMidPoint] =
                iTrinomialTriangle[iRow - 1][iMidPoint - 1] +
                iTrinomialTriangle[iRow - 1][iMidPoint] +
                iTrinomialTriangle[iRow - 1][iMidPoint + 1];

            for (int iCol = 0; iCol < iRow; iCol++) {
                int iLeft = iMidPoint - iCol - 1;
                int iRight = iMidPoint + iCol + 1;

                // To the right of midpoint
                iTrinomialTriangle[iRow][iLeft] =
                    iTrinomialTriangle[iRow - 1][(iLeft - 1 + iTrinomialTriangle[0].length) % iTrinomialTriangle[0].length] +
                    iTrinomialTriangle[iRow - 1][iLeft] +
                    iTrinomialTriangle[iRow - 1][iLeft + 1];

                // To the right of midpoint
                iTrinomialTriangle[iRow][iRight] =
                    iTrinomialTriangle[iRow - 1][iRight - 1] +
                    iTrinomialTriangle[iRow - 1][iRight] +
                    iTrinomialTriangle[iRow - 1][(iRight + 1) % iTrinomialTriangle[0].length];
            }
        }

        return iTrinomialTriangle;
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);
        int iK = Integer.parseInt(args[1]);

        StdOut.println(trinomial(iN, iK));
    }
}