public class RevesPuzzle {

    // move n smallest discs from one pole to another, using the temp pole
    private static void hanoi3(int k, int n, String from, String temp, String to) {
        if (n == k) return;

        hanoi3(k, n-1, from, to, temp);
        printMoveDisk(n, from, to);
        hanoi3(k, n-1, temp, from, to);
    }
    
    // move n smallest discs from one pole to another, using the temp pole
    private static void hanoi4(int k, int n, String from, String temp1, String temp2, String to) {
        // StdOut.println("k: " + k + ", n: " + n);
        if (n == k) {
            return;
        } else if (n == k + 1) {
            printMoveDisk(n, from, to);
            return;
        }

        int iN = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));

        hanoi4(k, n - 2, from, temp1, to, temp2);
        // hanoi4(k, iN - 1, from, temp2, to, temp1);
        printMoveDisk(n - 1, from, temp1);
        printMoveDisk(n, from, to);
        printMoveDisk(n - 1, temp1, to);
        // hanoi4(k, iN - 1, temp1, from, temp2, to);
        hanoi4(k, n - 2, temp2, from, temp1, to);

        return;
    }

    private static void printMoveDisk(int iDiskToMove, String sFromPole, String sToPole) {
        StdOut.println("Move disc " + iDiskToMove + " from " + sFromPole+ " to " + sToPole);

        return;
    }
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        hanoi4(0, n, "A", "B", "C", "D");
    }
}