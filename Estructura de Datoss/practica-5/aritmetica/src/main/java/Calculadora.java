import MyArrayList.*;

public class Calculadora {


    public Calculadora() {

    }

    public double calcular (ArrayStack<String> operacion){

        try {
            int num1 = Integer.parseInt(operacion.pop());
            String operador = operacion.pop();
            int num2 = Integer.parseInt(operacion.pop());

            System.out.println("se va a calcular :" + num1 + " "+ operador + " " + num2);
            if (operador.equals("+")){
                return num1 + num2;
            }
            if (operador.equals("-")){
                return num1 - num2;
            }
            if (operador.equals("*")){
                return num1 * num2;
            }
            if (operador.equals("/")){
                return (num1 / num2);
            }
        } catch (NumberFormatException e){
            System.out.println("ingresa numeros validos.");
        }



        return -1;
        
    }

    

}
