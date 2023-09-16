public class TestSS {

    public static int search(String key, String[] words) {
        for (int i = 0; i < words.length; i++) {
            if (words[i].compareTo(key) == 0) {
                return i;
            }
        }

        return -1;
    }
    
    public static void main(String[] args) {
        String[] words = StdIn.readAllStrings();
        int iWordListLength = words.length;
        double start = System.currentTimeMillis() / 1000.0;

        for (int i = 0; i < 10 * iWordListLength; i++) {
            String key = words[StdRandom.uniformInt(iWordListLength)];
            if (search(key, words) == -1) {
                StdOut.println(key);
            }
        }

        double now = System.currentTimeMillis() / 1000.0;
        StdOut.println(Math.round(now - start) + " seconds");
    }
}
