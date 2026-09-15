import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Random;

public class DADOS {

    int numero;
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

        char nextChar() {
            return next().charAt(0);
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                if (s.hasMoreTokens()) {
                    str = s.nextToken("\n");
                } else {
                    str = b.readLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    public void leerDatos() {
    }

    public void resuelve() {

        long[] frecuencias = new long[13];

        Random random = new Random();

        for (int i = 0; i < 36000000; i++) {

            int dado1 = random.nextInt(6) + 1;
            int dado2 = random.nextInt(6) + 1;

            int suma = dado1 + dado2;

            frecuencias[suma]++;
        }

        System.out.println("Suma\tFrecuencia");

        for (int i = 2; i <= 12; i++) {
            System.out.println(i + "\t" + frecuencias[i]);
        }
    }

    public static void main(String[] args) {

        DADOS id = new DADOS();

        id.leerDatos();
        id.resuelve();
    }
}
