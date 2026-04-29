public class Rectangle extends Shape {

    private double ancho;
    private double alto;

    public Rectangle (double ancho, double alto){
        super();
        this.alto = alto;
        this.ancho = ancho;
    }

    @Override
    public double getPerimeter() {
        return 2 * (alto + ancho);
    }

    @Override
    public double getArea() {
        return (alto * ancho);
    }
}
