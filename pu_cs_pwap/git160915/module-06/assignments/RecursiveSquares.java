public class RecursiveSquares {

    // Draws a square centered on (x, y) of the given side length
    // with a light gray background and a black border.
    public static void drawSquare(double x, double y, double length) {
        // Draw black square outline
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.square(x, y, length / 2);
        
        // Fill square color
        StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
        StdDraw.filledSquare(x, y, length / 2);

        // StdOut.println("x: " + x + ", y: " + y + ", length: " + length);
    }

    // Draws a recursive square pattern of order n, centered on (x, y)
    // of the given side length.
    public static void draw(int n, double x, double y, double length) {
        if (n == 0) {
            return;
        }

        double dRadius = length / 2;

        draw(n - 1, x - dRadius, y + dRadius, dRadius);
        draw(n - 1, x + dRadius, y + dRadius, dRadius);
        drawSquare(x, y, length);
        draw(n - 1, x - dRadius, y - dRadius, dRadius);
        draw(n - 1, x + dRadius, y - dRadius, dRadius);

        return;
    }

    // Takes an integer command-line argument n and draws a recursive
    // square pattern of order n, centered on (0.5, 0.5) with side length 0.5.
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);

        draw(iN, 0.5, 0.5, 0.5);
    }
}