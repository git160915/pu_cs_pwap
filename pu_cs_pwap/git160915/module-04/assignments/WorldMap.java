public class WorldMap {
    public static void main(String[] args) {
        // Variables that store the Canvas Width and Height that we first read in from Standard Input
        int iCanvasWidth = 0;
        int iCanvasHeight = 0;
        
        // Stores the number of vertices for each region
        int iVertexCount = 0;

        // Read in the Canvas Width and Height
        iCanvasWidth = StdIn.readInt();
        iCanvasHeight = StdIn.readInt();

        // Set Canvas size
        StdDraw.setCanvasSize(iCanvasWidth, iCanvasHeight);

        // Set the coordinate canvas range
        StdDraw.setXscale(0.0, iCanvasWidth);
        StdDraw.setYscale(0.0, iCanvasHeight);

        // Enable doublebuffering
        StdDraw.enableDoubleBuffering();

        // Set background color
        // StdDraw.setPenColor(StdDraw.BOOK_LIGHT_BLUE);
        // StdDraw.filledRectanglke(0.0 + (iCanvasWidth/2.0), 0.0 + (iCanvasHeight/2.0), iCanvasWidth/2.0, iCanvasHeight/2.0);

        // Set pen color for drawing the polygons
        StdDraw.setPenColor(StdDraw.BLACK);

        while (!StdIn.isEmpty()) {
            // Read in region
            StdIn.readString();

            // Read in number of vertices
            iVertexCount = StdIn.readInt();

            // Crate array of X & Y coordinates to draw the polygon
            double[] dXVertices = new double[iVertexCount];
            double[] dYVertices = new double[iVertexCount];

            // Loop through reading all vertices X & Y coordinates
            for (int i = 0; i < iVertexCount; i++) {
                // Read in X coordinate of this vertex
                dXVertices[i] = StdIn.readDouble();

                // Read in Y coordinate of this vertex
                dYVertices[i] = StdIn.readDouble();
            }

            // Draw polygon
            StdDraw.polygon(dXVertices, dYVertices);
        }

        // Show the screen since we have enabled doublebuffering
        StdDraw.show();
    }
}