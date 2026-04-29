package main.java.util.Points;

public class Point {

    private float x;
    private float y;

    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    // Distancia entre dos puntos (método estático)
    public static Double distance(Point a, Point b) {
        float dx = a.x - b.x;
        float dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }

    // Distancia desde este punto a otro
    public double distanceTo(Point other) {
        return distance(this, other);
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Point)) return false;
        Point other = (Point) obj;
        return Float.compare(x, other.x) == 0 && Float.compare(y, other.y) == 0;
    }

    @Override
    public int hashCode() {
        return Float.hashCode(x) * 31 + Float.hashCode(y);
    }
}
