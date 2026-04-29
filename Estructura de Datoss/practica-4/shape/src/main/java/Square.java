public class Square extends Shape{

    private double lado;
    
    public Square (double lado){
        super();
        this.lado = lado;
    }

    @Override
    public double getPerimeter() {
        return 2 * (lado + lado);
    }

    @Override
    public double getArea() {
        return (lado * lado);
    }
}
