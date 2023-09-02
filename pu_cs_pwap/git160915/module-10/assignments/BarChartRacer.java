import java.util.Arrays;

/**
 *  The {@code BarChartRacer} class represents a library for drawing animated charts.
 *  It leverages @code Bar and @code BarChart.
 *
 *  @author Gia Truong
 *
 */
public class BarChartRacer {

    // sample client 
    public static void main(String[] args) {
        final int REFRESH_INTERVAL = 100;

        // Read in the input file
        In inputFileStream = new In(args[0]);

        // Number of bars to display on chart
        int iNumOfBarsToRender = Integer.parseInt(args[1]);

        // create the bar chart
        String title = inputFileStream.readLine();
        String xAxis = inputFileStream.readLine();
        String source = inputFileStream.readLine();
        BarChart chart = new BarChart(title, xAxis, source);
        int iNumOfInputRecords;
        String sCaption = "";
        String[] sInputValues;
        Bar[] bars;

        // StdOut.println("Title: " + title);
        // StdOut.println("X-Axis: " + xAxis);
        // StdOut.println("Source: " + source);

        // draw the bar chart
        StdDraw.setCanvasSize(1000, 700);
        
        // This will enable Double Buffering so that we can 
        // create smoother rendering of the charts to the screen
        StdDraw.enableDoubleBuffering();

        while (inputFileStream.hasNextLine()) {
            // StdOut.println("Reading in number of records");

            // Read empty line before the next group
            inputFileStream.readLine();

            // Number of records to read in
            iNumOfInputRecords = Integer.parseInt(inputFileStream.readLine());

            // Init array of Bar
            bars = new Bar[iNumOfInputRecords];
            
            // StdOut.println(iNumOfBarsToRender);
            // StdOut.println(iNumOfInputRecords);

            // Reset the chart ready for the next set of data
            chart.reset();

            for (int i = 0; i < iNumOfInputRecords; i++) {
                // StdOut.println("Looping through reading the data records");

                // Read in the input string and split into constituents "year, name, country, value, category"
                sInputValues = inputFileStream.readLine().split(",");

                // set the caption using the year
                sCaption = sInputValues[0];

                // add the bars to the bar chart
                bars[i] = new Bar(sInputValues[1], Integer.parseInt(sInputValues[3]), sInputValues[4]);
            }

            Arrays.sort(bars);

            for (int i = bars.length - 1; i >= bars.length - iNumOfBarsToRender; i--) {
                chart.add(bars[i].getName(), bars[i].getValue(), bars[i].getCategory());
            }

            // Set chart caption
            chart.setCaption(sCaption);
                
            // draw the bar chart
            // StdDraw.setCanvasSize(1000, 700);
            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(REFRESH_INTERVAL);
        }
    }
}
