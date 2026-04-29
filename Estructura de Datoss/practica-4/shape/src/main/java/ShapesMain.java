public class ShapesMain {

    public static void main (String[] args){

        /**
         * En este caso se crea una variable de tipo shape, con un valor en memoria de tipo circle
         * para el compilador que solo ve tipos estaticos solo ve que hay una variable de tipo circle
         * sin en bargo en tiempo de ejecucion se ve un objeto de tipo circle
         * por lo que se puede acceder a los metodos de la clase circle
         */
        Shape circle = new Circle(5);
        circle.getArea();
    }
    
}
