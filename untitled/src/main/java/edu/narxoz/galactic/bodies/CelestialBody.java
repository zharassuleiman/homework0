package edu.narxoz.galactic.bodies;

public abstract class CelestialBody {
    private String name;
    private double x;
    private double y;
    protected CelestialBody(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
    public String getName() { return name; }
    public double getX() { return x; }
    public double getY() { return y; }

    public double distanceTo(CelestialBody other) {
        if (other == null) throw new IllegalArgumentException("Other cannot be null");
        double dx = other.getX() - this.x;
        double dy = other.getY() - this.y;
        return Math.sqrt(dx*dx + dy*dy);
    }
}