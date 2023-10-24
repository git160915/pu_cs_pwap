public class MergeSortV2 {

    private static String[] aux;

    public static void merge(String[] list, int low, int mid, int high) {
        int i = low;
        int j = mid;
        int iSubListSize = high - low;

        for (int k = 0; k < iSubListSize; k++) {
            if (i == mid) {
                aux[k] = list[j++];
            } else if (j == high) {
                aux[k] = list[i++];
            } else if (list[i].compareTo(list[j]) < 0) {
                aux[k] = list[i++];
            } else {
                aux[k] = list[j++];
            }
        }

        for (int k = 0; k < iSubListSize; k++) {
            list[low + k] = aux[k];
        }
    }

    public static void sort(String[] list, int low, int high) {
        int iListSize = high - low;

        if (iListSize <= 1) {
            return;
        }

        int mid = low + iListSize / 2;
        sort(list, low, mid);
        sort(list, mid, high);
        merge(list, low, mid, high);
    }

    public static void sort(String[] list) {
        aux = new String[list.length];
        sort(list, 0, list.length);
    }
    public static void main(String[] args) {
        In inFile = new In(args[0]);
        String[] sWordList = inFile.readAllStrings();

        MergeSortV2.sort(sWordList);
        for (int i = 0; i < sWordList.length; i++) {
            StdOut.println(sWordList[i]);
        }
    }
}