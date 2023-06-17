public class GeneralizedHarmonic {
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);
        int iR = Integer.parseInt(args[1]);

        double dGeneralizedHarmonicNumber;

        dGeneralizedHarmonicNumber = 1/Math.pow(1, iR);
        for (int i = 2; i <= iN; i++) {
            dGeneralizedHarmonicNumber += 1/Math.pow(i, iR);
        }

        System.out.println(dGeneralizedHarmonicNumber);
    }
}
