package pu_cs_atm.week04.miscassignments;

public class DFA {
    private int start;
    private boolean[] action;
    private ST<Character, Integer>[] next;

    @SuppressWarnings("unchecked")
    public DFA(String filename) {
        In inConfigFile = new In(filename);
        int iNumOfStates = inConfigFile.readInt();
        String sAlphabet = inConfigFile.readString();
        this.start = inConfigFile.readInt();

        // StdOut.println("Number of States: " + iNumOfStates);
        // StdOut.println("Alphabet: " + sAlphabet);
        // StdOut.println("Starting State: " + this.start);

        action = new boolean[iNumOfStates];
        next = (ST<Character, Integer>[]) new ST[iNumOfStates];
        
        for (int state = 0; state < iNumOfStates; state++) {
            action[state] = inConfigFile.readBoolean();
            next[state] = new ST<Character, Integer>();
            for (int alpha = 0; alpha < sAlphabet.length(); alpha++) {
                next[state].put(sAlphabet.charAt(alpha), inConfigFile.readInt());
            }
        }

        /*
        for (int state = 0; state < iNumOfStates; state++) {
            StdOut.print(state + " " + action[state] + " ");
            for (int alpha = 0; alpha < sAlphabet.length(); alpha++) {
                StdOut.print(next[state].get(sAlphabet.charAt(alpha)) + " ");
            }
            StdOut.println();
        }
        */
    }

    public boolean recognizes(String input) {
        int state = start;

        for (int i = 0; i < input.length(); i++) {
            state = next[state].get(input.charAt(i));
        }

        return action[state];
    }

    public static void main(String[] args) {
        DFA dfa = new DFA(args[0]);

        while (!StdIn.isEmpty()) {
            String input = StdIn.readString();
            if (dfa.recognizes(input))
                StdOut.println("Yes");
            else
                StdOut.println("No");
        }
    }
}