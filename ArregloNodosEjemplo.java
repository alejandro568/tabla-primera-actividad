/**
 * Ejemplo: arreglo de nodos en Java.
 * Cada posición del arreglo guarda un objeto Nodo (no un número suelto).
 */

// ---------- Clase 3: programa principal ----------
public class ArregloNodosEjemplo {
    public static void main(String[] args) {
        ArregloNodos lista = new ArregloNodos(5);

        lista.insertarFinal(10);
        lista.insertarFinal(20);
        lista.insertarFinal(30);
        System.out.print("Después de insertar 10, 20, 30: ");
        lista.mostrar();

        lista.insertarEn(1, 15);
        System.out.print("Insertar 15 en la posición 1:   ");
        lista.mostrar();

        System.out.println("Posición del 30: " + lista.buscar(30));

        lista.eliminar(20);
        System.out.print("Después de eliminar 20:         ");
        lista.mostrar();

        lista.insertarFinal(40);
        lista.insertarFinal(50);
        lista.insertarFinal(60);   // ya no cabe
        System.out.print("Estado final:                   ");
        lista.mostrar();
    }
}

// ---------- Clase 1: el Nodo ----------
class Nodo {
    int dato;            // valor que guarda el nodo

    Nodo(int dato) {     // constructor: crea el nodo con su dato
        this.dato = dato;
    }
}

// ---------- Clase 2: la estructura que administra el arreglo ----------
class ArregloNodos {
    private Nodo[] nodos;   // arreglo donde se guardan los nodos
    private int tamano;     // cuántos nodos hay realmente (no la capacidad)

    ArregloNodos(int capacidad) {
        nodos = new Nodo[capacidad];  // todas las posiciones empiezan en null
        tamano = 0;
    }

    // Insertar al final -> O(1)
    public boolean insertarFinal(int dato) {
        if (tamano == nodos.length) {
            System.out.println("Arreglo lleno, no se puede insertar " + dato);
            return false;
        }
        nodos[tamano] = new Nodo(dato);  // se crea el nodo y se guarda
        tamano++;
        return true;
    }

    // Insertar en una posición: hay que correr los nodos a la derecha -> O(n)
    public boolean insertarEn(int pos, int dato) {
        if (tamano == nodos.length || pos < 0 || pos > tamano) {
            System.out.println("No se puede insertar " + dato + " en la posición " + pos);
            return false;
        }
        for (int i = tamano; i > pos; i--) {
            nodos[i] = nodos[i - 1];     // desplaza hacia la derecha
        }
        nodos[pos] = new Nodo(dato);
        tamano++;
        return true;
    }

    // Buscar un dato recorriendo el arreglo -> O(n)
    public int buscar(int dato) {
        for (int i = 0; i < tamano; i++) {
            if (nodos[i].dato == dato) {
                return i;                // devuelve la posición
            }
        }
        return -1;                       // no se encontró
    }

    // Eliminar: se corren los nodos a la izquierda -> O(n)
    public boolean eliminar(int dato) {
        int pos = buscar(dato);
        if (pos == -1) {
            System.out.println("El dato " + dato + " no existe");
            return false;
        }
        for (int i = pos; i < tamano - 1; i++) {
            nodos[i] = nodos[i + 1];     // desplaza hacia la izquierda
        }
        nodos[tamano - 1] = null;        // libera la última posición
        tamano--;
        return true;
    }

    // Recorrer y mostrar -> O(n)
    public void mostrar() {
        System.out.print("[ ");
        for (int i = 0; i < tamano; i++) {
            System.out.print(nodos[i].dato + " ");
        }
        System.out.println("]  tamaño = " + tamano + " / capacidad = " + nodos.length);
    }
}
