/**
 * Actividad Sesión No. 2 - ¿Cuál algoritmo escala mejor?
 * Asignatura: Estructura de Datos I
 *
 * Compara experimentalmente dos algoritmos:
 *   - Algoritmo A: lineal      -> O(n)
 *   - Algoritmo B: cuadrático  -> O(n²)
 *
 * Para cada tamaño de entrada n mide el tiempo de ejecución en nanosegundos
 * usando System.nanoTime() y lo imprime en una tabla.
 *
 * Compilación y ejecución:
 *   javac ComparacionAlgoritmos.java
 *   java ComparacionAlgoritmos
 *
 * Nota: los tiempos dependen del procesador, la memoria, el sistema operativo
 * y las optimizaciones de la JVM. Por eso NO son idénticos entre ejecuciones
 * y no deben confundirse con la complejidad Big O.
 */
public class ComparacionAlgoritmos {

    public static void main(String[] args) {

        // Tamaños de entrada a probar
        int[] tamanos = {100, 1_000, 5_000, 10_000};

        // Calentamiento de la JVM (JIT): ejecuta los algoritmos una vez
        // antes de medir, para que la primera medición no salga distorsionada.
        algoritmoLineal(1_000);
        algoritmoCuadratico(1_000);

        // Encabezado de la tabla (\t = tabulador)
        System.out.println("n\tO(n) ns\tO(n²) ns");

        for (int n : tamanos) {

            // --- Medición del algoritmo lineal ---
            long inicioLineal = System.nanoTime();
            algoritmoLineal(n);
            long finLineal = System.nanoTime();
            long tiempoLineal = finLineal - inicioLineal;

            // --- Medición del algoritmo cuadrático ---
            long inicioCuadratico = System.nanoTime();
            algoritmoCuadratico(n);
            long finCuadratico = System.nanoTime();
            long tiempoCuadratico = finCuadratico - inicioCuadratico;

            // Resultado de la fila: n, tiempo lineal, tiempo cuadrático
            System.out.println(
                n + "\t" + tiempoLineal + "\t" + tiempoCuadratico
            );
        }
    }

    /**
     * Algoritmo A - Complejidad O(n).
     * Un solo ciclo: realiza n iteraciones.
     *
     * @param n tamaño de la entrada
     * @return número de operaciones realizadas (n)
     */
    public static long algoritmoLineal(int n) {
        long contador = 0;
        for (int i = 0; i < n; i++) {
            contador++;
        }
        return contador;
    }

    /**
     * Algoritmo B - Complejidad O(n²).
     * Dos ciclos anidados: realiza n × n iteraciones.
     *
     * @param n tamaño de la entrada
     * @return número de operaciones realizadas (n²)
     */
    public static long algoritmoCuadratico(int n) {
        long contador = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                contador++;
            }
        }
        return contador;
    }
}
