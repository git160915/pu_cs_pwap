public class BandMatrix {
    public static void main(String[] args) {
        int iN = Integer.parseInt(args[0]);
        int iWidth = Integer.parseInt(args[1]);
        
        for (int i = 0; i < iN; i++) {
            for (int j = 0; j < iN; j++) {
                if (j == i) {
                    System.out.print("*");
                } else {
                    // Distance between j & i < iWdith
                    if (j < i && (i - j <= iWidth) ||
                        j > i && (j - i <= iWidth)) {
                        System.out.print("*");
                    } else {
                        System.out.print("0");
                    }
                }

                // Print 2 x spaces unless its the last element in the matrix for each row
                if (j != iN-1) {
                    System.out.print("  ");
                }
            }
            
            // New line at end of row
            System.out.println();
        }
    
        System.out.println();
    }
}