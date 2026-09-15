import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Random;

public class JuegoDeCraps {
   
    FastReader reader = new FastReader();

    static final int JUEGOS = 1_000_000;
    static final int LIMITE_TIRO = 20; 
  
    long[] ganaEnTiro = new long[LIMITE_TIRO + 1];   
    long[] pierdeEnTiro = new long[LIMITE_TIRO + 1]; 

    long totalGanados = 0;
    long totalPerdidos = 0;
    long sumaTirosTotal = 0; 

    Random random = new Random();

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

  
    private int lanzarDados() {
        int dado1 = 1 + random.nextInt(6);
        int dado2 = 1 + random.nextInt(6);
        return dado1 + dado2;
    }

    
    private void registrar(boolean gano, int numTiro) {
        int indice = Math.min(numTiro, LIMITE_TIRO);
        if (gano) {
            ganaEnTiro[indice]++;
            totalGanados++;
        } else {
            pierdeEnTiro[indice]++;
            totalPerdidos++;
        }
        sumaTirosTotal += numTiro;
    }

   
    private void jugarUnaPartida() {
        int numTiro = 1;
        int suma = lanzarDados();

        if (suma == 7 || suma == 11) {
            registrar(true, numTiro);
            return;
        }
        if (suma == 2 || suma == 3 || suma == 12) {
            registrar(false, numTiro);
            return;
        }

        
        int punto = suma;
        while (true) {
            numTiro++;
            suma = lanzarDados();
            if (suma == punto) {
                registrar(true, numTiro);
                return;
            }
            if (suma == 7) {
                registrar(false, numTiro);
                return;
            }
           
        }
    }

    public void resuelve() {
        for (int i = 0; i < JUEGOS; i++) {
            jugarUnaPartida();
        }

       
        System.out.println("Tiro\tGanados\tPerdidos");
        for (int t = 1; t <= LIMITE_TIRO; t++) {
            String etiqueta = (t == LIMITE_TIRO) ? (t + " y despues") : String.valueOf(t);
            System.out.println(etiqueta + "\t" + ganaEnTiro[t] + "\t" + pierdeEnTiro[t]);
        }

        
        double probabilidadGanar = (double) totalGanados / JUEGOS;
        System.out.println();
        System.out.println("Total ganados: " + totalGanados);
        System.out.println("Total perdidos: " + totalPerdidos);
        System.out.printf("Probabilidad de ganar: %.4f%n", probabilidadGanar);

        
        double duracionPromedio = (double) sumaTirosTotal / JUEGOS;
        System.out.printf("Duracion promedio del juego (tiros): %.4f%n", duracionPromedio);

        
        System.out.println();
        System.out.println("Tiro\tProbabilidad de ganar en ese tiro");
        for (int t = 1; t <= LIMITE_TIRO; t++) {
            long total = ganaEnTiro[t] + pierdeEnTiro[t];
            double prob = (total == 0) ? 0.0 : (double) ganaEnTiro[t] / total;
            String etiqueta = (t == LIMITE_TIRO) ? (t + " y despues") : String.valueOf(t);
            System.out.printf("%s\t%.4f%n", etiqueta, prob);
        }
    }

    public static void main(String[] args) {
        JuegoDeCraps id = new JuegoDeCraps();

        id.leerDatos();
        id.resuelve();
    }
}