package main.java.util.Points;

import java.rmi.StubNotFoundException;

/**
 * forma de compilar:
 * mvn clean compile exec:java -Dexec.mainClass="main.java.util.Points.NeartDistPoints.main" 
 */

import java.util.*;

public class NeartDistPoints {

    public static void main(String[] args) {
        // Crear algunos puntos de prueba
        Point[] points = {
            new Point(0, 0),
            new Point(3, 4),
            new Point(7, 1),
            new Point(2, 2),
            new Point(-1, -3)
        };

        Arrays.sort(points, Comparator.comparingDouble(Point::getX));

        // Imprimir los puntos
        System.out.println("Puntos:");
        for (Point p : points) {
            System.out.println(p);
        }

        // Usamos el método naive por ahora
        double minDist = Double.MAX_VALUE;
        Point p1 = null, p2 = null;

        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                double dist = Point.distance(points[i], points[j]);
                if (dist < minDist) {
                    minDist = dist;
                    p1 = points[i];
                    p2 = points[j];
                }
            }
        }

        System.out.println("\nPar más cercano:");
        System.out.println(p1 + " y " + p2 + " con distancia = " + minDist);

        System.out.println("ahora calculado con mi algoritmo");
        Pair x = minDistance(points);
        System.out.println("\nPar más cercano:");
        System.out.println(x.first + " y " + x.second + " con distancia = ");
        
    }

    public static Pair<Point, Point> minDistance (Point[] a){
        int n = a.length;


        return minDistance(a, 0, n-1);
    }

    public static Pair<Point, Point> minDistance (Point[] a, int left, int right){
        if (left == right) return null;

        if(left+1 == right) {
            return new Pair<Point,Point>(a[left], a[right]);
        }

        int mid = left + (right - left)/2;

        Pair<Point, Point> b = minDistance(a, left, mid);
        Pair<Point, Point> c = minDistance(a, mid + 1, right);
        Pair<Point, Point> min = minPair(b, c);


        Double distanceMin = Point.distance(min.first, min.second);

        Pair intermedie = intermediePair(a, mid, distanceMin);

        return (minPair(min, intermedie));
    }

    public static Pair<Point, Point> intermediePair(Point[] a, int mid, double delta) {
    List<Point> strip = new ArrayList<>();
    double midX = a[mid].getX();

    for (Point p : a) {
        if (Math.abs(p.getX() - midX) < delta) {
            strip.add(p);
        }
    }

    // ordenar la franja por Y
    strip.sort(Comparator.comparingDouble(Point::getY));

    Pair<Point, Point> minPair = null;
    double minDist = delta;

    for (int i = 0; i < strip.size(); i++) {
        for (int j = i+1; j < strip.size() && (strip.get(j).getY() - strip.get(i).getY()) < minDist; j++) {
            double dist = Point.distance(strip.get(i), strip.get(j));
            if (dist < minDist) {
                minDist = dist;
                minPair = new Pair<>(strip.get(i), strip.get(j));
            }
        }
    }

    return minPair;
}

public static Pair<Point, Point> minPair(Pair<Point, Point> p1, Pair<Point, Point> p2) {
    if (p1 == null) return p2;
    if (p2 == null) return p1;

    double d1 = Point.distance(p1.first, p1.second);
    double d2 = Point.distance(p2.first, p2.second);

    return d1 < d2 ? p1 : p2;
}


    
}
