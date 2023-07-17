public class Checkerboard {
    public static void main(String[] args) {
        // This is the size of the checkerboard 
        // in terms of number of squares to render
        int iN = Integer.parseInt(args[0]);
        
        // Size of the cells in the checkerboard
        // This is simply length of the side of the square
        double dCellDimension = 1.0/iN;

        // This is the cell dimension radius
        // Which is really simply half the dimension
        double dCellDimensionRadius = dCellDimension/2.0;

        // These hold the x and y cooridates of the square
        // Representing the top left corder
        double dCellX = 0.0, dCellY = 0.0;
        
        // Our scale starts from (0, 0)
        // Think of the x and y axis as follows:
        // (x = 0, y = 0): Bottom left of checkerboard
        // (x = 1, y = 0): Bottom right of checkerboard
        // (x = 0, y = 1): Top left of checkerboard
        // (x = 1, y = 1): Top right of checkerboard
        StdDraw.setXscale(0.0, +1.0);
        StdDraw.setYscale(0.0, +1.0);

        //StdDraw.enableDoubleBuffering();

        // First loop through the cells in the rows/y-axis
        for (int y = iN; y > 0; y--) {

            // Then secondly loop through the cells in the columns/x-axis
            for (int x = 0; x < iN; x++) {

                // Use modulo to find remainder to work out even or odd
                // numbered cells which allow us to painted with alternating color
                // Need to also factor in that in the next row, the first cell will
                // have to be a different color than the cell in the same column
                // from the row above/below.
                // Hence why I have two sets of nested "if" statements
                if (y % 2 == 0) {
                    if (x % 2 == 0) {
                        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    } else {
                        StdDraw.setPenColor(StdDraw.BLUE);
                    }
                } else {
                    if (x % 2 == 0) {
                        StdDraw.setPenColor(StdDraw.BLUE);
                    } else {
                        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    }
                }

                // Compute the x coordinate
                dCellX = x * dCellDimension + dCellDimensionRadius;
                dCellY = y * dCellDimension - dCellDimensionRadius;
                StdDraw.filledSquare(dCellX, dCellY, dCellDimensionRadius);

                // Debug print statement
                // System.out.println(dCellX+ " " + dCellY + " " + dCellDimension);
            }
        }

        //StdDraw.show();
        //StdDraw.pause(20);
    }
}
