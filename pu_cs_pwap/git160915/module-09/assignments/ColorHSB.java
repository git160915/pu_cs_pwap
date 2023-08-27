public class ColorHSB {
    private final int iHue;
    private final int iSaturation;
    private final int iBrightness;

    // Creates a color with hue h, saturation s, and brightness b.
    public ColorHSB(int h, int s, int b) {
        if (h < 0 || h > 359) {
            throw new IllegalArgumentException("Hue is out of bounds.  Must be between 0 and 359.");
        } else if (s < 0 || s > 100) {
            throw new IllegalArgumentException("Saturation is out of bounds.  Must be between 0 and 100.");
        } else if (b < 0 || b > 100) {
            throw new IllegalArgumentException("Brightness is out of bounds.  Must be between 0 and 100.");
        }

        iHue = h;
        iSaturation = s;
        iBrightness = b;
    }

    // Returns a string representation of this color, using the format (h, s, b).
    public String toString() {
        return "(" + iHue + ", " + iSaturation + ", " + iBrightness + ")";
    }

    // Is this color a shade of gray?
    public boolean isGrayscale() {
        return (iSaturation == 0) || (iBrightness == 0);
    }

    // Returns the squared distance between the two colors.
    public int distanceSquaredTo(ColorHSB that) {
        if (that == null) {
            throw new IllegalArgumentException("Argument to method cannot be null.");
        }

        int iHueDistance = (this.iHue - that.iHue);
        int iMinHueDistance = Math.min(iHueDistance * iHueDistance,
                                       ((360 - Math.abs(iHueDistance)) * (360 - Math.abs(iHueDistance))));

        int iSaturationDistance = this.iSaturation - that.iSaturation;
        iSaturationDistance *= iSaturationDistance;

        int iBrightnessDistance = this.iBrightness - that.iBrightness;
        iBrightnessDistance *= iBrightnessDistance;

        return iMinHueDistance + iSaturationDistance + iBrightnessDistance;
    }

    // Sample client (see below).
    public static void main(String[] args) {
        int iHue = Integer.parseInt(args[0]);
        int iSaturation = Integer.parseInt(args[1]);
        int iBrightness = Integer.parseInt(args[2]);

        ColorHSB colorHSB = new ColorHSB(iHue, iSaturation, iBrightness);

        ColorHSB colorHSBRef;
        ColorHSB colorHSBCurr;

        String sRefColor = "";
        String sCurrColor = "";
        int iMinDistance = 0;
        int iCurrDistance = 0;

        sRefColor = StdIn.readString();
        colorHSBRef = new ColorHSB(StdIn.readInt(), StdIn.readInt(), StdIn.readInt());
        iMinDistance = colorHSB.distanceSquaredTo(colorHSBRef);

        while (!StdIn.isEmpty()) {
            sCurrColor = StdIn.readString();
            colorHSBCurr = new ColorHSB(StdIn.readInt(), StdIn.readInt(), StdIn.readInt());
            iCurrDistance = colorHSB.distanceSquaredTo(colorHSBCurr);

            if (iCurrDistance < iMinDistance) {
                sRefColor = sCurrColor;
                colorHSBRef = colorHSBCurr;
                iMinDistance = iCurrDistance;
            }
        }

        StdOut.println(sRefColor + " " + colorHSBRef);
    }
}