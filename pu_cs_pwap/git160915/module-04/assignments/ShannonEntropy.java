public class ShannonEntropy {
    public static void main (String[] args) {
        int iM = Integer.parseInt(args[0]);
        
        // This variable tracks the frequency of integers from StdIn for which 
        // we will use to compute the ShannonEntropy.
        // The integer will be the index into this array which we will increment
        // with each occurance of the integer
        int[] iIntegerFrequency = new int[iM];

        // This variable tracks the total number of integers read in from StdIn
        int iInputCount = 0;

        // This is the ShannonEntropy
        double dH = 0.0;

        while (!StdIn.isEmpty()) {
            // Increment the integer frequency
            // where the integer is the index into the array
            // which is between 1 and iM
            // Remember because this is an index will have to -1 from the integer
            // otherwise if the input contains a value equal to iM (which is m in the specification)
            // then we will exceed the array bounds
            iIntegerFrequency[StdIn.readInt()-1]++;

            // Increment the count of number of values read in from StdIn
            iInputCount++;
        }

        double dProportion = 0.0;
        for (int i = 0; i < iIntegerFrequency.length; i++) {
            if (iIntegerFrequency[i] > 0) {
                dProportion = ((double) iIntegerFrequency[i]/iInputCount);
                dH += dProportion * (Math.log10(dProportion)/Math.log10(2));
            } 
        }

        StdOut.printf("%1$.4f\n", -1 * dH);
    }
}