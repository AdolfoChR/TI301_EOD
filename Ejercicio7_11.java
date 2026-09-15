import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ejercicio7_11 {
    int[] cuentas = new int[10];
    int[] bono = new int[15];
    int[] mejoresPuntuaciones = new int[5];
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
    }

    public void leerDatos() {
        // Leemos valores iniciales para bono y mejoresPuntuaciones
        for (int i = 0; i < bono.length; i++) {
            bono[i] = reader.nextInt();
        }
        for (int i = 0; i < mejoresPuntuaciones.length; i++) {
            mejoresPuntuaciones[i] = reader.nextInt();
        }
    }

    public void resuelve() {
        // a) Asignar cero a los 10 elementos del arreglo cuentas
        for (int i = 0; i < cuentas.length; i++) {
            cuentas[i] = 0;
        }

        // b) Sumar uno a cada uno de los 15 elementos del arreglo bono
        for (int i = 0; i < bono.length; i++) {
            bono[i] += 1;
        }

        // c) Imprimir los cinco valores del arreglo mejoresPuntuaciones en formato de columnas
        for (int i = 0; i < mejoresPuntuaciones.length; i++) {
            System.out.printf("%d\t", mejoresPuntuaciones[i]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ejercicio7_11 id = new Ejercicio7_11();
        id.leerDatos();
        id.resuelve();
    }   
}
