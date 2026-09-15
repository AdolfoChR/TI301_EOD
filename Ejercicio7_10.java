import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ejercicio7_10 {
    int numVendedores;
    double[] ventas;
    FastReader reader = new FastReader();

    static class FastReader {
        BufferedReader b;
        StringTokenizer s; 

        public FastReader() {
            b = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (s == null || !s.hasMoreElements()) {
                try {
                    s = new StringTokenizer(b.readLine());
                } catch (IOException e) {
                    e.printStackTrace(); 
                }
            }
            return s.nextToken();
        }

        int nextInt() { 
            return Integer.parseInt(next()); 
        }

        double nextDouble() { 
            return Double.parseDouble(next()); 
        }
    }

    public void leerDatos() {
        numVendedores = reader.nextInt();
        ventas = new double[numVendedores];
        for (int i = 0; i < numVendedores; i++) {
            ventas[i] = reader.nextDouble();
        }
    }

    public void resuelve() {
        int[] rangos = new int[9];

        for (int i = 0; i < numVendedores; i++) {
            int salario = (int) (200 + 0.09 * ventas[i]);
            int indice = (salario / 100) - 2;

            if (indice >= 8) {
                rangos[8]++;
            } else if (indice >= 0) {
                rangos[indice]++;
            }
        }

        System.out.println("Rango de Salario\tCantidad de Vendedores");
        System.out.println("$200 - $299\t\t" + rangos[0]);
        System.out.println("$300 - $399\t\t" + rangos[1]);
        System.out.println("$400 - $499\t\t" + rangos[2]);
        System.out.println("$500 - $599\t\t" + rangos[3]);
        System.out.println("$600 - $699\t\t" + rangos[4]);
        System.out.println("$700 - $799\t\t" + rangos[5]);
        System.out.println("$800 - $899\t\t" + rangos[6]);
        System.out.println("$900 - $999\t\t" + rangos[7]);
        System.out.println("$1,000 en adelante\t" + rangos[8]);
    }

    public static void main(String[] args) {
        Ejercicio7_10 id = new Ejercicio7_10();
        id.leerDatos();
        id.resuelve();
    }   
}