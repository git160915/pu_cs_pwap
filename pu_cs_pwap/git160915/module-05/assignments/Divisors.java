public class Divisors {

    // Returns the greatest common divisor of a and b.
    public static int gcd(int a, int b) {
        int iA = Math.abs(a);
        int iB = Math.abs(b);
        int iGCD = 0;

        while (iB != 0) {
            iGCD = iB;
            iB = iA % iB;
            iA = iGCD;
        }

        return iGCD;
    }

    // Returns the least common multiple of a and b.
    public static int lcm(int a, int b) {
        return (Math.abs(a) / gcd(a, b)) * Math.abs(b);
    }

    // Returns true if a and b are relatively prime; false otherwise.
    public static boolean areRelativelyPrime(int a, int b) {
        return (gcd(a, b) == 1);
    }

    // Returns the number of integers between 1 and n that are
    // relatively prime with n.
    public static int totient(int n) {
        int iEulerTotient = 0;

        for (int i = 0; i < n; i++) {
            if (areRelativelyPrime(i, n)) {
                iEulerTotient++;
            }
        }

        return iEulerTotient;
    }

    // Takes two integer command-line arguments a and b and prints
    // each function, evaluated in the format (and order) given below.
    public static void main(String[] args) {
        int iA = Integer.parseInt(args[0]);
        int iB = Integer.parseInt(args[1]);
    
        StdOut.printf("gcd(%1$d, %2$d) = %3$d\n", iA, iB, gcd(iA, iB));
        StdOut.printf("lcm(%1$d, %2$d) = %3$d\n", iA, iB, lcm(iA, iB));
        StdOut.printf("areRelativelyPrime(%1$d, %2$d) = %3$b\n", iA, iB, areRelativelyPrime(iA, iB));
        StdOut.printf("totient(%1$d) = %2$d\n", iA, totient(iA));
        StdOut.printf("totient(%1$d) = %2$d\n", iB, totient(iB));
    }
}