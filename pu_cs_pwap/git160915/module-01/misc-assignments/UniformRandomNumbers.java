public class UniformRandomNumbers {
    public static void main(String[] args) {
        double dRandomNum1 = Math.random();
        double dRandomNum2 = Math.random();
        double dRandomNum3 = Math.random();
        double dRandomNum4 = Math.random();
        double dRandomNum5 = Math.random();

        System.out.println(dRandomNum1);
        System.out.println(dRandomNum2);
        System.out.println(dRandomNum3);
        System.out.println(dRandomNum4);
        System.out.println(dRandomNum5);

        System.out.println();

        System.out.println("average: " + 
            (dRandomNum1 + dRandomNum2 + dRandomNum3 + dRandomNum4 + dRandomNum5)/5
        );

        System.out.println("min: " + 
            Math.min(
                Math.min(
                    Math.min(
                        Math.min(dRandomNum1, dRandomNum2),
                        dRandomNum3
                    ),
                    dRandomNum4
                ),
                dRandomNum5
            )
        );

        System.out.println("max: " + 
            Math.max(
                Math.max(
                    Math.max(
                        Math.max(dRandomNum1, dRandomNum2),
                        dRandomNum3
                    ),
                    dRandomNum4
                ),
                dRandomNum5
            )
        );
    }
}
