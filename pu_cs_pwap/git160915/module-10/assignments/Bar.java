import java.util.Arrays;

public class Bar implements Comparable<Bar> {

    private final int iValue;
    private final String sName;
    private final String sCategory;

    // Creates a new bar.
    public Bar(String name, int value, String category) {
        if (name == null) {
            throw new IllegalArgumentException("Parameter, name, cannot be \'null\'");
        }

        if (value < 0) {
            throw new IllegalArgumentException("Parameter, value, cannot be less than \'0\'");
        }

        if (category == null) {
            throw new IllegalArgumentException("Parameter, category, cannot be \'null\'");
        }

        this.sName = name;
        this.iValue = value;
        this.sCategory = category;
    }

    // Returns the name of this bar.
    public String getName() {
        return this.sName;
    }

    // Returns the value of this bar.
    public int getValue() {
        return this.iValue;
    }

    // Returns the category of this bar.
    public String getCategory() {
        return this.sCategory;
    }

    // Compare two bars by value.
    public int compareTo(Bar that) {
        if (that == null) {
            throw new NullPointerException("Object of type Bar being compared to is \'null\'");
        }

        if (this.iValue < that.iValue) {
            return -1;
        } else if (this.iValue > that.iValue) {
            return 1;
        }

        return 0;
    }

    // Provide a string repreentation of this object Bar
    public String toString() {
        return "(" + this.sName + ", " + this.iValue + ", " + this.sCategory + ")";
    }

    // Sample client (see below).
    public static void main(String[] args) {
        // create an array of 10 bars
        Bar[] bars = new Bar[10];

        bars[0] = new Bar("Beijing",     22674, "East Asia");
        bars[1] = new Bar("Cairo",       19850, "Middle East");
        bars[2] = new Bar("Delhi",       27890, "South Asia");
        bars[3] = new Bar("Dhaka",       19633, "South Asia");
        bars[4] = new Bar("Mexico City", 21520, "Latin America");
        bars[5] = new Bar("Mumbai",      22120, "South Asia");
        bars[6] = new Bar("Osaka",       20409, "East Asia");
        bars[7] = new Bar("Sao Paulo",   21698, "Latin America");
        bars[8] = new Bar("Shanghai",    25779, "East Asia");
        bars[9] = new Bar("Tokyo",       38194, "East Asia");

        // sort in ascending order by weight
        Arrays.sort(bars);

        for (int i = 0; i < bars.length; i++) {
            StdOut.println(bars[i]);
        }
    }
}