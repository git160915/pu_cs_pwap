public class RevesHanoi {

    public static void revesHanoi(int n, String from, String temp1, String temp2, String to) {
        int k = n /2;

        hanoi(0, k, "A", "C", "B");
        hanoi(k, n, "A", "C", "D");
        hanoi(0, k, "B", "C", "D");
    }

    // move n smallest discs from one pole to another, using the temp pole
    private static void hanoi(int k, int n, String from, String temp, String to) {
        if (n == k) return;
        hanoi(k, n-1, from, to, temp);
        StdOut.println("Move disc " + n + " from " + from + " to " + to);
        hanoi(k, n-1, temp, from, to);
    }
    
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        revesHanoi(n, "A", "B", "C", "D");
    }
}