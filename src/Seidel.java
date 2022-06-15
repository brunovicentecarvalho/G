import static java.lang.Math.*;

public class Seidel {


    public static void gaussSeidel(double[][] A, double[] results, double EPSILON){
        int p = 0;
        boolean parar = false;
        double[] novosValores = new double[results.length];
        double[] valoresAntigos = new double[results.length];

        do{
            for(int i = 0; i < A.length; i++){
                double abs = retornaErro(i, A, results, novosValores, valoresAntigos);
                imprimeErro(abs);
                p++;
                parar = defineParada(i,abs,EPSILON,novosValores,valoresAntigos);
                if (parar)
                    novosValores[i] = valoresAntigos[i];
            }
        }while(!parar);
    }

    public static double retornaErro(int i, double[][] matriz, double[]results, double[]novosValores, double[]valoresAntigos){
        double sum = 0.0;
        double sum1 = 0.0;
        for(int j = 0; j < matriz.length; j++){

            if( j != i)
                sum += matriz[i][j]*valoresAntigos[j];

            sum1 += (matriz[i][j]*novosValores[j]);
        }

        novosValores[i] = (results[i] - sum - sum1)/matriz[i][i];
        System.out.println("X_" + (i+1) + ": " + novosValores[i]);
        return abs((novosValores[i] - valoresAntigos[i]));
    }
    public static void imprimeErro(double abs){
        System.out.println("--------\n");
        System.out.println("Erro : " + abs);
        System.out.println("\n--------");
    }
    public static boolean defineParada(int i, double abs, double EPSILON, double[] novosValores, double[] valoresAntigos){
        if(abs > EPSILON){
            novosValores[i] = valoresAntigos[i];
            return false;
        }
        return true;
    }

}
