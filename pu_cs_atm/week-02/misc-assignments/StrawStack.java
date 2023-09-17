public class StrawStack {

    private String[] sStack;
    private int iCurrStackSize = 0;

    public StrawStack(int iMax) {
        sStack = new String[iMax];
    }

    public boolean isEmpty() {
        return (iCurrStackSize == 0);
    }

    public void push(String sItem) {
        sStack[iCurrStackSize++] = sItem;
    }

    public String pop() {
        return (sStack[--iCurrStackSize]);
    }

    public int size() {
        return iCurrStackSize;
    }

    public static void main(String[] args) {
        int iMaxStackSize = Integer.parseInt(args[0]);
        StrawStack ss = new StrawStack(iMaxStackSize);

        while (!StdIn.isEmpty()) {
            String word = StdIn.readString();
            if (word.equals("-")) {
                StdOut.print(ss.pop() + " ");
            } else {
                ss.push(word);
            }
        }
        StdOut.println();
    }
}