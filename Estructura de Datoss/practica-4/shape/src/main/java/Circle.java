public class Circle extends Shape {
    private double radio;

    public Circle (double ratio) {
        super();
        this.radio = ratio;
    }

    @Override
    public double getPerimeter() {
        return (Math.PI)*2*radio;
    }

    @Override
    public double getArea() {
        return (Math.PI)*(radio*radio);
    }
    
}
