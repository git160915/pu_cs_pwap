public class SortV2 {
    public static void main(String[] args) {
        ST<String, Integer> st = new ST<>();

        while (!StdIn.isEmpty()) {
            String word = StdIn.readLine();
            st.put(word, 0);
        }

        for (String s : st.keys()) {
            StdOut.println(s);
        }
    }
}