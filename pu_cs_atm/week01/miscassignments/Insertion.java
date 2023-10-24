public class Insertion {

    public static void sort(String[] sList) {
        int iListLength = sList.length;

        for (int i = 1; i < sList.length; i++) {
            for (int j = i; j > 0; j--) {
                if (sList[j - 1].compareTo(sList[j]) > 0) {
                    exchange(sList, j - 1, j);
                } else {
                    break;
                }
            }
        }

        return;
    }

    public static void exchange(String[] sList, int prevElement, int currElement) {
        String sTmp = sList[prevElement];
        sList[prevElement] = sList[currElement];
        sList[currElement] = sTmp;

        return;
    }

    public static void main(String[] args) {
        String[] sWordsList = StdIn.readAllStrings();
        sort(sWordsList);

        for (int i = 0; i < sWordsList.length; i++) {
            StdOut.println(sWordsList[i]);
        }
    }
}