public class Clock {

    private int iHour;
    private int iMinute;

    // Creates a clock whose initial time is h hours and m minutes.
    public Clock(int h, int m) {
        if (h < 0 || h > 23) {
            throw new IllegalArgumentException("Arguement, h (hours), is out of bounds.  Hours must be between 0 and 23.");
        } else if (m < 0 || m > 59) {
            throw new IllegalArgumentException("Arguement, m (minutes), is out of bounds.  Minutes must be between 0 and 23.");
        }

        iHour = h;
        iMinute = m;
    }

    // Creates a clock whose initial time is specified as a string, using the format HH:MM.
    public Clock(String s) {
        String[] sTmpTime = s.split(":");
        int iTmpHour;
        int iTmpMinute;

        if (s.length() != 5 || sTmpTime.length != 2) {
            throw new IllegalArgumentException("Arguement is an invalid format.  It should be a valid time that is HH:MM, i.e. 23:30.");
        }

        iTmpHour = Integer.parseInt(sTmpTime[0]);
        iTmpMinute = Integer.parseInt(sTmpTime[1]);

        if (iTmpHour < 0 || iTmpHour > 23) {
            throw new IllegalArgumentException("Arguement, h (hours), is out of bounds.  Hours must be between 0 and 23.");
        } else if (iTmpMinute < 0 || iTmpMinute > 59) {
            throw new IllegalArgumentException("Arguement, m (minutes), is out of bounds.  Minutes must be between 0 and 23.");
        }

        iHour = iTmpHour;
        iMinute = iTmpMinute;
    }

    // Returns a string representation of this clock, using the format HH:MM.
    public String toString() {
        String sTmpHour = "0" + this.iHour;
        String sTmpMinute = "0" + this.iMinute;

        return sTmpHour.substring(sTmpHour.length() - 2, sTmpHour.length()) + ":" +
               sTmpMinute.substring(sTmpMinute.length() - 2, sTmpMinute.length());
    }

    // Is the time on this clock earlier than the time on that one?
    public boolean isEarlierThan(Clock that) {
        return (this.iHour < that.iHour) ||
               ((this.iHour == that.iHour) && (this.iMinute < that.iMinute));
    }

    // Adds 1 minute to the time on this clock.
    public void tic() {
        this.iMinute++;

        int iTmpHour = this.iMinute / 60;
        int iTmpMinute = this.iMinute % 60;

        this.iHour = (this.iHour + iTmpHour) % 24;
        this.iMinute = iTmpMinute;
    }

    // Adds delta minutes to the time on this clock.
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("Arguement, delta, is invalid.  It must be a positive value.");
        }

        int iTmpHour = (delta + this.iMinute) / 60;
        int iTmpMinute = (delta + this.iMinute) % 60;

        this.iHour = (this.iHour + iTmpHour) % 24;
        this.iMinute = iTmpMinute;
    }

    // Test client (see below).
    public static void main(String[] args) {
        Clock clock1 = new Clock(22, 8);
        Clock clock2 = new Clock("22:09");
        Clock clock3 = new Clock("23:59");

        StdOut.println(clock1);
        StdOut.println(clock2);

        // Check if time in clock1 is earlier than clock2
        StdOut.println(clock1.isEarlierThan(clock2));

        clock1.tic();
        StdOut.println(clock1);

        clock3.tic();
        StdOut.println(clock3);

        clock1.toc(112);
        StdOut.println(clock1);
    }
}