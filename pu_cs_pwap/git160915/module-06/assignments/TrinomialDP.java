public class TrinomialDP {

    // Returns the trinomial coefficient T(n, k).
    public static long trinomial(int n, int k) {
        // Holds the x with the index representing the power
        // iX[0] = 2 means 2x^0 = 2
        // iX[1] = 2 means 2x^1 = 2x
        // iX[2] = 2 means 2x^2 = 2x^2
        // iX[3] = 2 means 2x^3 = 2x^3
        // ...
        int[] iX = new int[(2 * n) + 1];

        // Holds the expansion of the trinomial for 
        // The lenght is 3^n is for the trinomial (1 + x + x^2)^3
        // The values represent the exponent/power.
        // iFormulaExpansion[0] = 1 means x^1
        // iFormulaExpansion[0] = 3 means x^3
        // iFormulaExpansion[0] = 4 means x^4
        int[] iFormulaExpansion = new int[(int) Math.pow(3, n)];

        // Holds the base trinomial (1 + x + x^2) formula
        int[] iBaseFormula = {0, 1, 2};
        
        // Iterate through iBaseFormula n times
        // This will fill up the iFormulaExpansion array fully
        iFormulaExpansion[0] = iBaseFormula[0];
        iFormulaExpansion[1] = iBaseFormula[1];
        iFormulaExpansion[2] = iBaseFormula[2];
        for (int i = 1; i < n; i++) {
            int iLoopStart = (int) Math.pow(iBaseFormula.length, i);
            int iLoopEnd = (int) Math.pow(iBaseFormula.length, i + 1);

            for (int j = iLoopStart; j < iLoopEnd; j++) {
                iFormulaExpansion[j] = iFormulaExpansion[j % iLoopStart] + iBaseFormula[(int) (j / iLoopStart)];
            }
        }

        for (int i = 0; i < iFormulaExpansion.length; i++) {
            iX[iFormulaExpansion[i]]++;
            StdOut.print(iFormulaExpansion[i] + ", ");
        }
        StdOut.println();
        StdOut.println(iFormulaExpansion.length);

        return iX[n + k];
    }

    // Takes two integer command-line arguments n and k and prints T(n, k).
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);
        int iK = Integer.parseInt(args[1]);

        StdOut.println(trinomial(iN, iK));
    }
}