//Recorrido Preorden: Es un recorrido que inicia en la raíz del árbol, recorre el nodo izquierdo y al final el derecho
//este puede ser utilizado para estructurar programas de decisión o clonar exactamente un nodo preexistente.

//Recorrido Inorden: Es un recorrido de árbol que inicia recorriendo el subárbol izquierdo, pasa por la raíz y finaliza en el subárbol derecho
//puede ser utilizado para visualizar los nodos de una manera jerárquica o para invertir los nodos binarios

//Recorrido Postorden: primero se visita el subárbol izquierdo, luego el derecho y culmina vistando la raíz
//puede ser utilizado para liberar la memoria ocupada por los nodos de un árbol en orden sin hacer referencias a nodos eliminados

public class APP {
	
	public static void main(String[] args){
		 
		ArbolBinario arbol = new ArbolBinario();
		
		arbol.raiz = new Nodo(1);
		arbol.raiz.left = new Nodo(2);
		arbol.raiz.right = new Nodo(3);
		arbol.raiz.left.left = new Nodo(4);
		arbol.raiz.left.right = new Nodo(5);
		arbol.raiz.right.left = new Nodo(6);
		arbol.raiz.right.right = new Nodo(7);
		arbol.raiz.left.left.left = new Nodo(8);
		arbol.raiz.left.left.right = new Nodo(9);
		arbol.raiz.left.right.left = new Nodo(10);
		
		System.out.println("Nuestro árbol en preorden: ");
		arbol.recorridoPreorden();
		
		System.out.println();
		
		System.out.println("Recorrido en inorden del árbol:");
        arbol.recorridoInorden();
        
        System.out.println();
        
        System.out.println("Recorrido postorden del árbol:");
        arbol.recorridoPostorden();
        
        //         1
        //       /   \
        //      2     3
        //     / \   /  \
        //    4   5  6   7    
		//   / \   \
		//  8   9  10
    }
}
