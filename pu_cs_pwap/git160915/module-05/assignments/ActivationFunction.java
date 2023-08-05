public class ActivationFunction {

    // Returns the Heaviside function of x.
    public static double heaviside(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }

        if (x < 0.0) {
            return 0.0;
        } else if (x == 0.0) {
            return 1.0/2;
        } else {
            return 1.0;
        }
    }

    // Returns the sigmoid function of x.
    public static double sigmoid(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }

        return 1 / (1 + Math.exp(-x));
    }

    // Returns the hyperbolic tangent of x.
    public static double tanh(double x) {
        if (Double.isNaN(x) && !(Double.isInfinite(x))) {
            return Double.NaN;
        } else if (x >= 20) {
            return 1.0;
        } else if (x <= -20) {
            return -1.0;
        }


        return (Math.exp(x) - Math.exp(-x))/(Math.exp(x) + Math.exp(-x));
    }

    // Returns the softsign function of x.
    public static double softsign(double x) {
        if (Double.isNaN(x) && !(Double.isInfinite(x))) {
            return Double.NaN;
        } if (x == Double.NEGATIVE_INFINITY) {
            return -1.0;
        } if (x == Double.POSITIVE_INFINITY) {
            return 1.0;
        }

        return x / (1 + Math.abs(x));
    }

    // Returns the square nonlinearity function of x.
    public static double sqnl(double x) {
        if (Double.isNaN(x)) {
            return Double.NaN;
        }

        if (x <= -2) {
            return -1.0;
        } else if (x > -2 && x < 0) {
            return x + ((x * x) / 4);
        } else if (x >= 0 && x < 2) {
            return x - ((x * x) / 4);
        } else {
            return 1.0;
        }
    }

    // Takes a double command-line argument x and prints each activation
    // function, evaluated, in the format (and order) given below.
    public static void main(String[] args) {
        double dX = Double.parseDouble(args[0]);
    
        StdOut.printf("%1$17s %2$s\n", "heaviside(" + dX + ") =", heaviside(dX));
        StdOut.printf("%1$17s %2$s\n", "sigmoid(" + dX + ") =", sigmoid(dX));
        StdOut.printf("%1$17s %2$s\n", "tanh(" + dX + ") =", tanh(dX));
        StdOut.printf("%1$17s %2$s\n", "softsign(" + dX + ") =", softsign(dX));
        StdOut.printf("%1$17s %2$s\n", "sqnl(" + dX + ") =", sqnl(dX));
    }
}