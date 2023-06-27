public class DiscreteDistribution {
    public static void main(String[] args) {
        int iM = Integer.parseInt(args[0]);
        int iR;
        int[] iA = new int[args.length - 1];
        int[] iS = new int[iA.length + 1];

        for (int i = 0; i < iA.length; i++) {
            iA[i] = Integer.parseInt(args[i+1]);
        }

        iS[0] = 0;
        for (int i = 1; i < iS.length; i++) {
            iS[i] = iS[i-1] + iA[i-1];
        }

        for (int i = 0; i < iM; i++) {
            iR = (int) (Math.random() * iS[iS.length - 1]);

            for (int j = 1; j < iS.length; j++) {
                if (iR >= iS[j-1] && iR < iS[j]) {
                    System.out.print(j + " ");
                }
            }
        }

        System.out.println();
    }
}