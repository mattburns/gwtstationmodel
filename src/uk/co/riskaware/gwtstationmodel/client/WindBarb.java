package uk.co.riskaware.gwtstationmodel.client;

public class WindBarb {

    private final double knots;
    private final double degrees;

    private static final double KNOTS_IN_METER_PER_SECOND = 1.9438444924406;

    public WindBarb(double knots, double degrees) {
        super();
        this.knots = knots;
        this.degrees = degrees;
    }

    public double getKnots() {
        return knots;
    }

    public double getDegrees() {
        return degrees;
    }

    public double getRadians() {
        return Math.toRadians(degrees);
    }

    public static double toKnots(double metersPerSecond) {
        return metersPerSecond * KNOTS_IN_METER_PER_SECOND;
    }
}
