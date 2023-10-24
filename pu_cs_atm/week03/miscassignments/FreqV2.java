public class FreqV2 {

    public static void main(String[] args) {
        ST<String, Integer> st = new ST<>();

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();

            if (st.contains(word)) {
                st.put(word, st.get(word) + 1);
            } else {
                st.put(word, 1);
            }
        }

        for (String s : st.keys()) {
            StdOut.printf("%8d %s\n", st.get(s), s);
        }
    }
}