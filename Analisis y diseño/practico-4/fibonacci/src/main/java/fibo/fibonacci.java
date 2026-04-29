
/**
 * forma de compilar:
 * mvn clean compile exec:java -Dexec.mainClass="main.java.fibofivonacci.main" 
 */
public class fibonacci {
    public static void main(String[] args){
        System.out.println(fibonacciS(1000));
    }   
    public static int fibonacciS(int n){
        int fibo0 = 0;
        int fibo1 = 1;
        int fibo = 0;
        if(n <= 1) return n==0 ? 0 : 1;
        for (int i=2; i<=n;i++){
            fibo = fibo0 + fibo1;

            fibo0 = fibo1;
            fibo1 = fibo;
        }

        return fibo1;
    } 
}
