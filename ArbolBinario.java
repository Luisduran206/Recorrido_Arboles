import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class ArbolBinario {
	
	Nodo raiz;

    public ArbolBinario() {
        raiz = null;
    }

    public void recorridoPreorden() {
        //Verificamos que la raíz o el primer elemento del árbol exista
    	if (raiz == null) {
            return;
        }
        //Esta será la lista de elementos a la cuál le iremos añadiéndo los nodos para 
    	//asegurarnos de obtener los nodos en el orden deseado.
        Stack<Nodo> nodos = new Stack<>();
        nodos.push(raiz); //Se agrega la raíz, pues será nuestro primer elemento

        while (!nodos.isEmpty()) { //Ciclo que asegura trabajar con todos los nodos del árbol
            Nodo nodoActual = nodos.pop(); //Nodo temporal, último valor de nuestra stack
            System.out.print(nodoActual.valor + " ");
            //Importante hacer la verificación primero para la derecha y luego la izquiera, por el orden en stack
            if (nodoActual.right != null) { //Verifica que exista un nodo a la derecha del actual y lo agrega
            	nodos.push(nodoActual.right);
            }
            if (nodoActual.left != null) { //Verifica que exista un nodo a la derecha del actual y lo agrega
            	nodos.push(nodoActual.left);
            }
        }
    }
    
    public void recorridoInorden(Nodo nodo) {
    	//Verificamos que la raíz o el primer elemento del árbol exista
    	if (nodo == null) {
            return;
        }
    	//Esta será la lista de elementos a la cuál le iremos añadiéndo los nodos para 
    	//asegurarnos de obtener los nodos en el orden deseado.
        Stack<Nodo> pila = new Stack<>();
        Nodo nodoActual = raiz; //El nodo actual toma a raíz como iniciación
        //Ciclo que asegura trabajar con todos los nodos
        while (nodoActual != null || !pila.isEmpty()) {
            while (nodoActual != null) {
            	//Con esto se avanza hasta el nodo más a la izquierda posible
            	pila.push(nodoActual); 
                nodoActual = nodoActual.left;
            }
            //Como el nodo al salir del while es null, le damos nuevo valor
            nodoActual = pila.pop();
            //Se imprime
            System.out.print(nodoActual.valor + " ");
            //Ahora se avanza al nodo más a la izquiera
            nodoActual = nodoActual.right;
         }	
    }

    public void recorridoInorden() {
        recorridoInorden(raiz);
    }
    
    public void recorridoPostorden() {
    	//Verificamos que la raíz o el primer elemento del árbol exista
    	if (raiz == null) {
            return;
        }
        Stack<Nodo> pila = new Stack<>(); //Pila que realiza recorrido iterativo
        Stack<Nodo> resultado = new Stack<>(); //Pila que nos almacena los nodos en el orden
        pila.push(raiz); //El recorrido empieza desde la raíz por lo que se debe añadir
        //Ciclo que asegura trabajar con todos los nodos
        while (!pila.isEmpty()) {
            Nodo nodoActual = pila.pop(); //Nodo temporal que toma el valor del nodo al hacer pop
            resultado.push(nodoActual); //Almacen del orden deseado 
            //Primero se ingresa la parte izquierda del árbol, después la derecha
            if (nodoActual.left != null) {
                pila.push(nodoActual.left);
            }
            if (nodoActual.right != null) {
                pila.push(nodoActual.right);
            }
        }
        //Ciclo que desapila los nodos de la pila resultado y los imprime en el orden correcto
        while (!resultado.isEmpty()) {
            Nodo nodo = resultado.pop();
            System.out.print(nodo.valor + " ");
        }
    }
    
}

class Nodo {
    int valor;
    Nodo left;
    Nodo right;

    public Nodo(int valor) {
        this.valor = valor;
        this.left = null;
        this.right = null;
    }
}
