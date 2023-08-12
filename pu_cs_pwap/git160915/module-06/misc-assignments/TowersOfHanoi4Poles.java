public class TowersOfHanoi4Poles {

    public static void main(String[] args) {
        int numDiscs = Integer.parseInt(args[0]);
        char source = 'A';
        char target = 'D';
        char auxiliary1 = 'B';
        char auxiliary2 = 'C';

        solveHanoi(numDiscs, source, target, auxiliary1, auxiliary2);
    }

    public static void solveHanoi(int n, char source, char target, char auxiliary1, char auxiliary2) {
        if (n == 0) {
            return;
        } else if (n == 1) {
            moveDisk(source, target);
            return;
        }

        int k = (int) Math.ceil(n - Math.sqrt(2 * n + 1)) + 1;

        solveHanoi(k, source, auxiliary1, auxiliary2, target);
        solveHanoi(n - k, source, target, auxiliary2, auxiliary1);
        solveHanoi(k, auxiliary1, target, auxiliary2, source);
    }

    public static void moveDisk(char source, char target) {
        System.out.println("Move disk from " + source + " to " + target);
    }
}
