public class GreatCircle {
    public static void main(String[] args) {
        // Read in the 4 Lat, Long, Lat, Long arguements
        double dLat1 = Math.toRadians(Double.parseDouble(args[0]));
        double dLong1 = Math.toRadians(Double.parseDouble(args[1]));
        double dLat2 = Math.toRadians(Double.parseDouble(args[2]));
        double dLong2 = Math.toRadians(Double.parseDouble(args[3]));

        // Radius of Earth
        double dEarthRadius = 6371.0;

        // Stores the resulting "distance"
        double dDistance;
        dDistance = 
            2 * dEarthRadius * Math.asin(
                Math.sqrt(
                    Math.pow(
                        Math.sin(
                            (dLat2 - dLat1)/2
                        ), 2
                    ) +
                    (
                        Math.cos(dLat1) * 
                        Math.cos(dLat2) *
                        Math.pow(
                            Math.sin(
                                (dLong2 - dLong1)/2
                            ), 2
                        )
                    )
                )
            );

        System.out.println(dDistance + " kilometers");
    }
}
