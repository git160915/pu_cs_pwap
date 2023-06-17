public class CMYKtoRGB {
    public static void main(String[] args) {
        double dCyan = Double.parseDouble(args[0]);
        double dMagenta = Double.parseDouble(args[1]);
        double dYellow = Double.parseDouble(args[2]);
        double dBlack = Double.parseDouble(args[3]);

        double dWhite = 1 - dBlack;
        double dRed = 255 * dWhite * (1 - dCyan);
        double dGreen = 255 * dWhite * (1 - dMagenta);
        double dBlue = 255 * dWhite * (1 - dYellow);

        System.out.println("red   = " + Math.round(dRed));
        System.out.println("green = " + Math.round(dGreen));
        System.out.println("blue  = " + Math.round(dBlue));
    }
}
