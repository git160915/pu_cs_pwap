public class RandomWalker {
    public static void main(String[] args) {
        // Read in the Manhatten distance arguement
        int iR = Integer.parseInt(args[0]);

        int iNumberOfSteps = 0;
        int iXCoord = 0;
        int iYCoord = 0;

        // >= 0.00 && < 0.25 == NORTH
        // >= 0.25 && < 0.50 == EAST
        // >= 0.50 && < 0.75 == SOUTH
        // >= 0.75 && < 1.00 == WEST
        double dNORTH = 0.25;
        double dEAST = 0.5;
        double dSOUTH = 0.75;
        double dWEST = 1.0;

        double dDirection;

        // Print out starting position
        System.out.println("(" + iXCoord + ", " + iYCoord + ")");

        // Take the absoluate value in order to compute the 
        // Manhatten distance and loop until the distnace is achieved
        while (Math.abs(iXCoord) + Math.abs(iYCoord) != iR) {
            dDirection = Math.random();

            if (dDirection < dNORTH) {
                iYCoord += 1;
            } else if (dDirection < dEAST) {
                iXCoord += 1;
            } else if (dDirection < dSOUTH) {
                iYCoord -= 1;
            } else if (dDirection < dWEST) {
                iXCoord -= 1;
            }

            System.out.println("(" + iXCoord + ", " + iYCoord + ")");

            // Count the number of steps
            iNumberOfSteps++;
        }

        System.out.println("steps = " + iNumberOfSteps);
    }
}