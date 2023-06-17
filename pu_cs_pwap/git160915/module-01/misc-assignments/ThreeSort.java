public class ThreeSort {
    public static void main(String[] args) {
        int iNum1 = Integer.parseInt(args[0]);
        int iNum2 = Integer.parseInt(args[1]);
        int iNum3 = Integer.parseInt(args[2]);

        System.out.println(Math.min(Math.min(iNum1, iNum2), iNum3));
        System.out.println(
            Math.min(
                Math.max(Math.min(iNum1, iNum2), iNum3),
                Math.max(Math.min(iNum2, iNum3), iNum1)
            )
        );
        System.out.println(Math.max(Math.max(iNum1, iNum2), iNum3));
    }
}
