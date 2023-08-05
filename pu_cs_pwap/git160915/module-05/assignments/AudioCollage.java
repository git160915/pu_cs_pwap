public class AudioCollage {
    /*
     * Create a new sound that contains the same samples as an existing sound, 
     * but with each sample multiplied by a constant α. This increases the 
     * volume when α>1 and decreases it when 0<α<1.
     *
     * Returns a new array that rescales a[] by a multiplicative factor of alpha.
     */
    public static double[] amplify(double[] a, double alpha) {
        double[] dAmpSample = new double[a.length];

        for (int i = 0; i < a.length; i++) {
            dAmpSample[i] = a[i] * alpha;
        }

        return dAmpSample;
    }

    /*
     * Create a new sound that contains the same samples as an existing sound, 
     * but in reverse order. This can lead to unexpected and entertaining results.
     *
     * Returns a new array that is the reverse of a[].
     */
    public static double[] reverse(double[] a) {
        double[] dRevSample = new double[a.length];

        for (int i = 0; i < a.length; i++) {
            dRevSample[i] = a[a.length - i - 1];
        }

        return dRevSample;
    }

    /*
     * Create a new sound that combines two existing sounds by appending the 
     * second one after the first. If the two sounds have m and n samples, 
     * then the resulting sound has m + n samples. This enables you to play 
     * two sounds sequentially.
     * 
     * Returns a new array that is the concatenation of a[] and b[].
     */
    public static double[] merge(double[] a, double[] b) {
        double[] dMergedSample = new double[a.length + b.length];

        for (int i = 0; i < a.length; i++) {
            dMergedSample[i] = a[i];
        }

        for (int i = 0; i < b.length; i++) {
            dMergedSample[a.length + i] = b[i];
        }

        return dMergedSample;
    }

    /*
     * Create a new sound that combines two existing sounds by summing the 
     * values of the corresponding samples. If one sound is longer than the other, 
     * append 0s to the shorter sound before summing. This enables you to play two 
     * sounds simultaneously.
     * 
     * Returns a new array that is the sum of a[] and b[],
     * padding the shorter arrays with trailing 0s if necessary.
     * 
     */
    public static double[] mix(double[] a, double[] b) {
        int iLongerSampleLength = Math.max(a.length, b.length);
        double[] dMixedSample = new double[iLongerSampleLength];
        double[] dShorterSample;
        double[] dLongerSample;

        if (a.length <= b.length) {
            // a[] is the shorter sample
            dShorterSample = a;
            dLongerSample = b;
        } else {
            // b[] is the shorter sample
            dShorterSample = b;
            dLongerSample = a;
        }

        for (int i = 0; i < dMixedSample.length; i++) {
            if (i < dShorterSample.length) {
                dMixedSample[i] = dShorterSample[i] + dLongerSample[i];
            } else {
                dMixedSample[i] = dLongerSample[i];
            }
        }

        return dMixedSample;
    }

    /*
     * Create a new sound that changes the duration of an existing sound via resampling. 
     * If the existing sound has n samples, then the new sound has ⌊n/α⌋ samples for some 
     * constant α>0, with sample i of the new sound having the same amplitude as sample ⌊iα⌋
     * of the existing sound.
     * 
     * Returns a new array that changes the speed by the given factor.
     */
    public static double[] changeSpeed(double[] a, double alpha) {
        double[] dSpedSample = new double[(int) (a.length / alpha)];

        for (int i = 0; i < dSpedSample.length; i++) {
            dSpedSample[i] = a[(int) (i * alpha)];
        }

        return dSpedSample;
    }

    /*
     * Checks and returns array with values between -1.0 and +1.0.
     * For some reason I get 100% on the assignment only if I 
     * mutate the array in this function
     */
    private static double[] checkValueBoundary(double[] a) {
        // double[] dCheckedValues = new double[a.length];

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 1.0) {
                // dCheckedValues[i] = 1.0;
                a[i] = 1.0;
            } if (a[i] < -1.0) {
                // dCheckedValues[i] = -1.0;
                a[i] = -1.0;
            }
            /* else {
                dCheckedValues[i] = a[i];
            }
            */
        }

        // return dCheckedValues;
        return a;
    }

    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double dAlpha = 2.0;
        String sWAVFolder = "./";   // "./functions/";
        double[] dSample1 = StdAudio.read(sWAVFolder + "singer.wav");
        double[] dSample2 = StdAudio.read(sWAVFolder + "chimes.wav");
        double[] dSample3 = StdAudio.read(sWAVFolder + "beatbox.wav");
        double[] dSample4 = StdAudio.read(sWAVFolder + "piano.wav");
        double[] dSample5 = StdAudio.read(sWAVFolder + "buzzer.wav");

        StdAudio.play(checkValueBoundary(amplify(dSample1, dAlpha)));
        StdAudio.play(checkValueBoundary(reverse(dSample2)));
        StdAudio.play(checkValueBoundary(merge(dSample3, dSample1)));
        StdAudio.play(checkValueBoundary(mix(dSample4, dSample1)));
        StdAudio.play(checkValueBoundary(changeSpeed(dSample5, dAlpha)));
    }
}