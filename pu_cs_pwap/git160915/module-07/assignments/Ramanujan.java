public class Ramanujan {

    // Is n a Ramanujan number?
    public static boolean isRamanujan(long n) {
        long dUpperLimit = (long) Math.cbrt(n);
        long iRunningNum = 0;
        int iCountSumCube = 0;
        long lA, lC, lE, iBTmp = 0, iDTmp = 0;
        double dB, dD, dF;
        boolean bPrintDebug = false;


        if (bPrintDebug) {
            StdOut.println(dUpperLimit);
        }

        while ((iRunningNum < dUpperLimit) && (iCountSumCube <= 2)) {
            iRunningNum++;

            if (iCountSumCube == 0) {
                // Generate first cube
                lA = iRunningNum * iRunningNum * iRunningNum;

                // Find a matching cube of b
                iBTmp = n - lA;
                dB = Math.cbrt(iBTmp);

                if (dB % 1 == 0) {
                    iCountSumCube++;

                    if (bPrintDebug) {
                        StdOut.println(iRunningNum + ", a: " + lA + ", b: " + dB + ", " + iCountSumCube);
                    }
                }
            } else if (iCountSumCube == 1) {
                // Generate first cube
                lC = iRunningNum * iRunningNum * iRunningNum;

                // Find a matching cube of d
                iDTmp = n - lC;
                dD = Math.cbrt(iDTmp);

                if (dD % 1 == 0) {
                    if (lC != iBTmp) {
                        iCountSumCube++;

                        if (bPrintDebug) {
                            StdOut.println(iRunningNum + ", c: " + lC + ", d: " + dD + ", " + iCountSumCube);
                        }
                    }
                }
            } else {
                // Generate first cube
                lE = iRunningNum * iRunningNum * iRunningNum;

                // Find a matching cube of d
                dF = Math.cbrt(n - lE);

                if (dF % 1 == 0) {
                    if (lE != iBTmp && lE != iDTmp) {
                        iCountSumCube++;
                        
                        if (bPrintDebug) {
                            StdOut.println(iRunningNum + ", e: " + lE + ", f: " + dF + ", " + iCountSumCube);
                        }
                    }
                }
            }
        }

        return (iCountSumCube == 2);
    }

    // Takes a long integer command-line arguments n and prints true if
    // n is a Ramanujan number, and false otherwise.
    public static void main(String[] args) {
        long lNumInput = Long.parseLong(args[0]);

        StdOut.println(isRamanujan(lNumInput));
    }
}