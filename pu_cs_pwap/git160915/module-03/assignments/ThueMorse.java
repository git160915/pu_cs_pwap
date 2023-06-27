public class ThueMorse {
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);
        int[] iThueMorseSeq = new int[iN];

        // Variables to control the sequence build
        int iPrevSeqMultiplier = 0;
        int iSeqMultiplier = 1;

        // Need to check against iN to ensure I don't run beyond the array length
        // since the array iThueMorseSeq was initialised with lenght iN above
        while (iSeqMultiplier < iN) {
            // Sequence lenght is always incremented by power of 2
            // with the sequence lenght initialised to 1 above
            // Also first save the previous mutipler
            iPrevSeqMultiplier = iSeqMultiplier;
            iSeqMultiplier *= 2;

            for (int i = iPrevSeqMultiplier; i < iSeqMultiplier && i < iThueMorseSeq.length; i++) {
                // Add 1 and take the modulo to give us the same result as negation (switching 0s and 1s and vice versa)
                iThueMorseSeq[i] = (iThueMorseSeq[i - iPrevSeqMultiplier] + 1) % 2;
            }
        }

        for (int i = 0; i < iN; i++) {
            for (int j = 0; j < iN; j++) {
                if (iThueMorseSeq[i] == iThueMorseSeq[j]) {
                    System.out.print("+  ");
                } else {
                    System.out.print("-  ");
                }
            }

            System.out.println();
        }
    }
}