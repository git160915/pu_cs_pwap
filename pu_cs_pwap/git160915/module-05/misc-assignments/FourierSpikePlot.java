public class FourierSpikePlot {
    private static double[] linespace(double dStart, double dEnd, int iNumSamples) {
        double dStep = (dEnd - dStart) / (iNumSamples - 1);
        double[] dStepsList = new double[iNumSamples];

        for (int i = 0; i < dStepsList.length; i++) {
            dStepsList[i] = dStart + i * dStep;
        }

        return dStepsList;
    }

    private static double calculateFourierValue(double dT, int iN) {
        double dSum = 0.0;

        for (int i = 1; i < iN; i++) {
            dSum += Math.cos(i * dT);
        }

        return dSum / iN;
    }

    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);
        int iNumSamples = 500;
        double dStart = -10.0;
        double dEnd = 10.0;
        double[] dStepsList;
        double[] dFourierSpikeList = new double[iNumSamples];

        StdDraw.setXscale(-10.0, 10.0);
        StdDraw.setYscale(-1.00, 1.00);

        dStepsList = linespace(dStart, dEnd, iNumSamples);

        for (int i = 0; i < dStepsList.length; i++) {
            dFourierSpikeList[i] = calculateFourierValue(dStepsList[i], iN);
        }

        StdStats.plotLines(dFourierSpikeList);
    }
}
