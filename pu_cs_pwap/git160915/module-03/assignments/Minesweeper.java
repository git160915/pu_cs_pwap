public class Minesweeper {
    public static void main (String[] args) {
        int iM = Integer.parseInt(args[0]);
        int iN = Integer.parseInt(args[1]);
        int iK = Integer.parseInt(args[2]);

        // Minesweeper grid
        int[][] cMineSweeperGrid = new int[iM][iN];

        // Flatten the m x n grid into a single list, 
        // then generate k random numbers uniformly 
        // from 0 to (m x n - 1)
        int[] iRandomMinesList = new int[iK];

        boolean bIsUniqueMine = false;

        for (int i = 0; i < iRandomMinesList.length; i++) {
            // Initliase to false and assume it starts off
            // as not unique at this point
            bIsUniqueMine = false;

            while (!bIsUniqueMine) {
                // Generate a random mine and then need to check if its unique 
                // out of all the random mines generated thus far
                iRandomMinesList[i] = (int) (Math.random() * iM * iN);

                // Assume its a unique until we find a duplicate
                bIsUniqueMine = true;
                for (int j = 0; j < i && bIsUniqueMine; j++) {
                    if (iRandomMinesList[i] == iRandomMinesList[j]) {
                        bIsUniqueMine = false;
                    }
                }
            }
        }

        for (int i = 0; i < iRandomMinesList.length; i++) {
            System.out.print(iRandomMinesList[i] + "  ");
        }
        System.out.println();

        for (int iRow = 0; iRow < cMineSweeperGrid.length; iRow++) {
            for (int iCol = 0; iCol < cMineSweeperGrid[iRow].length; iCol++) {
                cMineSweeperGrid[iRow][iCol] = 0;
            }
        }

        int iTmpRandomMine = 0;
        for (int i = 0; i < iRandomMinesList.length; i++) {
            iTmpRandomMine = iRandomMinesList[i]-1;
            cMineSweeperGrid[iTmpRandomMine/iM][iTmpRandomMine%iN] = -1;
        }

        for (int iRow = 0; iRow < cMineSweeperGrid.length; iRow++) {
            for (int iCol = 0; iCol < cMineSweeperGrid[iRow].length; iCol++) {
                if (cMineSweeperGrid[iRow][iCol] >= 0) {
                    // Check above
                    if (iRow > 0) {
                        // Check above
                        if (cMineSweeperGrid[iRow - 1][iCol] < 0) {
                            cMineSweeperGrid[iRow][iCol] += 1;
                        }

                        // Check diagnally above to the left if applicable
                        if (iCol > 0 && cMineSweeperGrid[iRow - 1][iCol - 1] < 0) {
                            cMineSweeperGrid[iRow][iCol] += 1;
                        }
                            
                        // Check diagnally above to the right if applicable
                        if (iCol < cMineSweeperGrid[iRow].length - 1 && cMineSweeperGrid[iRow - 1][iCol + 1] < 0) {
                            cMineSweeperGrid[iRow][iCol] += 1;
                        }
                    }

                    // Check below
                    if (iRow < cMineSweeperGrid.length - 1) {
                        // Check below 
                        if (cMineSweeperGrid[iRow + 1][iCol] < 0) {
                            cMineSweeperGrid[iRow][iCol] += 1;
                        }

                        // Check diagnally below to the left if applicable
                        if (iCol > 0 && cMineSweeperGrid[iRow + 1][iCol - 1] < 0) {
                            cMineSweeperGrid[iRow][iCol] += 1;
                        }
                            
                        // Check diagnally below to the right if applicable
                        if (iCol < cMineSweeperGrid[iRow].length - 1 && cMineSweeperGrid[iRow + 1][iCol + 1] < 0) {
                            cMineSweeperGrid[iRow][iCol] += 1;
                        }
                    }

                    // Check to the right 
                    // I don't need to check diagnally right up or down because
                    // I have already done the diagnal check up and down already
                    if (iCol < cMineSweeperGrid[iRow].length - 1) {
                        // Check to the right 
                        if (cMineSweeperGrid[iRow][iCol + 1] < 0) {
                            cMineSweeperGrid[iRow][iCol] += 1;
                        }
                    } 

                    // Check to the left
                    // I don't need to check diagnally left up or down because
                    // I have already done the diagnal check up and down already
                    if (iCol > 0) {
                        // check to the left 
                        if (cMineSweeperGrid[iRow][iCol - 1] < 0) {
                            cMineSweeperGrid[iRow][iCol] += 1;
                        }
                    } 

                    System.out.print(cMineSweeperGrid[iRow][iCol] + "  ");
                } else {
                    System.out.print("*  ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }
}
