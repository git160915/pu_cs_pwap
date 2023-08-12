public class RevesPuzzle {

    // move n smallest discs from one pole to another, using the temp pole
    private static void hanoi3(int k, int n, String from, String temp, String to) {
        if (n == 0) return;

        hanoi3(k, n-1, from, to, temp);
        printMoveDisk(n + k, from, to);
        hanoi3(k, n-1, temp, from, to);
    }
    
    // move n smallest discs from one pole to another, using the temp pole
    private static void hanoi4(int n, String from, String temp1, String temp2, String to) {
        int k = (int) Math.round(n + 1 - Math.sqrt(2 * n + 1));

        if (n == 0) {
            return;
        } else if (n == 1) {
            printMoveDisk(n, from, to);
            return;
        }

        hanoi4(k, from, temp1, to, temp2);
        hanoi3(k, n - k, from, temp1, to);
        hanoi4(k, temp2, from, temp1, to);

        return;
    }

    private static void printMoveDisk(int iDiskToMove, String sFromPole, String sToPole) {
        StdOut.println("Move disc " + iDiskToMove + " from " + sFromPole+ " to " + sToPole);

        return;
    }
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);

        hanoi4(n, "A", "B", "C", "D");
    }
}