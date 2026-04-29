

public class BalanceadoMain {
    public static void main (String[] args){
        Balanceador ok = new Balanceador("([]{}()[())]");
        boolean aux = ok.isBalanceado();
        System.out.println(aux);
    }
}
