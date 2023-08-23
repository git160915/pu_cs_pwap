public class MaximumSquareSubmatrix {

    // Returns the size of the largest contiguous square submatrix
    // of a[][] containing only 1s.
    public static int size(int[][] a) {
        int[][] iTmpMatrix = new int[a.length][a[0].length];
        int iMaxSubMatrixSize = 0;
        // int iMaxRow = 0;
        // int iMaxCol = 0;

        // Initialise the first "row" and first "col" of the temporary array that
        // we will use to progressively count the size of largest submatrix
        for (int i = 0; i < a.length; i++) {
            iTmpMatrix[i][0] = a[i][0];

            if (iTmpMatrix[i][0] > iMaxSubMatrixSize) {
                iMaxSubMatrixSize  = iTmpMatrix[i][0];
            }
        }

        for (int i = 0; i < a.length; i++) {
            iTmpMatrix[0][i] = a[0][i];

            if (iTmpMatrix[0][i] > iMaxSubMatrixSize) {
                iMaxSubMatrixSize  = iTmpMatrix[0][i];
            }
        }

        // Loop through the input matrix "a" and check if the current value at (iRow, iCol) == 1, 
        // then calculate the size of the submatrix based on the values above, to the left and
        // diagnally above to the left
        // Take the min and then add 1 if the value at (iRow, iCol) == 1
        for (int iRow = 1; iRow < a.length; iRow++) {
            for (int iCol = 1; iCol < a[0].length; iCol++) {
                if (a[iRow][iCol] == 1) {
                    iTmpMatrix[iRow][iCol] = Math.min(iTmpMatrix[iRow - 1][iCol],
                                                      Math.min(iTmpMatrix[iRow - 1][iCol - 1], iTmpMatrix[iRow][iCol - 1])) + 1;

                    if (iTmpMatrix[iRow][iCol] > iMaxSubMatrixSize) {
                        iMaxSubMatrixSize = iTmpMatrix[iRow][iCol];
                        // iMaxRow = iRow;
                        // iMaxCol = iCol;
                    }
                } else {
                    iTmpMatrix[iRow][iCol] = 0;
                }
            }
        }

        // StdOut.println("iMaxRow: " + iMaxRow + ", iMaxCol: " + iMaxCol);
        return iMaxSubMatrixSize;
    }

    // Reads in an array from Standard Input 
    private static int[][] readMatrix() {
        int[][] iMatrix;
        int iMatrixDim = 0;

        iMatrixDim = StdIn.readInt();
        iMatrix = new int[iMatrixDim][iMatrixDim];

        for (int i = 0; i < iMatrix.length && !StdIn.isEmpty(); i++) {
            for (int j = 0; j < iMatrix[0].length && !StdIn.isEmpty(); j++) {
                iMatrix[i][j] = StdIn.readInt();
            }
        }

        return iMatrix;
    }

    // Reads an n-by-n matrix of 0s and 1s from standard input
    // and prints the size of the largest contiguous square submatrix
    // containing only 1s.
    public static void main(String[] args) {
        int[][] iMatrix = readMatrix();
        boolean bPrintDebug = false;

        StdOut.println(size(iMatrix));

        if (bPrintDebug) {
            for (int i = 0; i < iMatrix.length; i++) {
                for (int j = 0; j < iMatrix[0].length; j++) {
                    StdOut.print(iMatrix[i][j] + "  ");
                }

                StdOut.println();
            }
        }
    }
}