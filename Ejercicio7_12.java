import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Ejercicio7_12 {
    int[] entradas = new int[5];
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
        for (int i = 0; i < 5; i++) {
            int num = reader.nextInt();
            // Validar que esté en el rango [10, 100]
            while (num < 10 || num > 100) {
                num = reader.nextInt();
            }
            entradas[i] = num;
        }
    }

    public void resuelve() {
        int[] unicos = new int[5];
        int cantidadUnicos = 0;

        for (int i = 0; i < 5; i++) {
            int numero = entradas[i];
            boolean esDuplicado = false;

            for (int j = 0; j < cantidadUnicos; j++) {
                if (unicos[j] == numero) {
                    esDuplicado = true;
                    break;
                }
            }

            if (!esDuplicado) {
                unicos[cantidadUnicos] = numero;
                cantidadUnicos++;
                System.out.println("Número único introducido: " + numero);
            } else {
                System.out.println("El número " + numero + " ya existe.");
            }

            System.out.print("Valores únicos actual: ");
            for (int k = 0; k < cantidadUnicos; k++) {
                System.out.print(unicos[k] + " ");
            }
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        Ejercicio7_12 id = new Ejercicio7_12();
        id.leerDatos();
        id.resuelve();
    }   
}