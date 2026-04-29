public class Logs {
    public static void main(String[] args){
        String p1 = "aabc";
        String p2 = "cbdd";
        String g1 = "caabbddc"; //
        String g2 = "cdaabbdc"; //

        System.out.println(interleavingLogs(p1, p2, g1)); // true
        System.out.println(interleavingLogs(p1, p2, g2)); // false
    }

    public static boolean interleavingLogs(String p1, String p2, String log){
        int m = p1.length();
        int n = p2.length();

        //si las longitudes no suman el total ya sabemos que no anda
        if(log.length() != n + m) return false;

        //defino la matriz con uno mas por que la pocicion 0 la vamos a inicializar con true
        boolean[][] dp = new boolean[m+1][n+1];
        dp[0][0] = true;//inicializamos la primera pocicion con true 

        //cargamos la primera fila 
        for(int j = 1; j<=n;j++){
            dp[0][j] = dp[0][j-1] && p2.charAt(j-1) == log.charAt(j-1);
            //vamos viendo que acarremos un true y tambien que 
            //el caracter que vamos a comparar valla respetando el orden
            //con las filas vemos que el de la izquierda sea true
        }

        //cargamos la primera columna 
        for(int i = 1; i<=m;i++){
            dp[i][0] = dp[i-1][0] && p1.charAt(i-1) == log.charAt(i-1);
            //vamos viendo que acarremos un true y tambien que 
            //el caracter que vamos a comparar valla respetando el orden 
            //con las columnas vemos que el de arriba sea true 
        }

        // Rellenar el resto de la matriz
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char g = log.charAt(i + j - 1); // menos 1 por que a la matriz la hicimos uno mas grande para agregar el primer true
                //vemos que el caracter en la pos i coincida con la cadena m en la pos i coincida con el de arriba y que arriba aya un true
                boolean fromP1 = p1.charAt(i - 1) == g && dp[i - 1][j];
                //vemos que el caracter en la pos j conicida con n en pos j y que atras aya un true 
                boolean fromP2 = p2.charAt(j - 1) == g && dp[i][j - 1];
                dp[i][j] = fromP1 || fromP2;
            }
        }

        return dp[m][n];
    }


    }



