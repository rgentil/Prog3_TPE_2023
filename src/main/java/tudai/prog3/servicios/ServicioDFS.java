package tudai.prog3.servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import tudai.prog3.colecciones.Grafo;

/**
 * DFS Forest : dado un grafo, realiza un recorrido en profundidad y retorna un
 * orden posible de descubrimiento para los vértices durante ese recorrido.
 * 
 * @author Lauge Guillermina, Gentil Ricardo
 */
public class ServicioDFS {

	private final Grafo<?> grafo;
	private HashMap<Integer, String> vertices;

	public ServicioDFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.vertices = new HashMap<>();
	}

	private void iniciarEstructura() {
		if (this.grafo != null) {
			for (Iterator<Integer> it = this.grafo.obtenerVertices(); it.hasNext();) {
				Integer vertice = (Integer) it.next();
				this.vertices.put(vertice, "BLANCO");
			}
		}
	}

	public List<Integer> dfsForest() {
		this.iniciarEstructura();
		List<Integer> result = new ArrayList<Integer>();
		for (Iterator<Integer> iterator = grafo.obtenerVertices(); iterator.hasNext();) {
			Integer vertice = (Integer) iterator.next();
			if (vertices.get(vertice).equals("BLANCO")) {
				result.addAll(dfsForest(vertice));
			}
		}
		return result;
	}

	private List<Integer> dfsForest(Integer vertice) {
		List<Integer> resultado = new ArrayList<Integer>();
		vertices.put(vertice, "AMARILLO");
		resultado.add(vertice);
		for (Iterator<Integer> it = grafo.obtenerAdyacentes(vertice); it.hasNext();) {
			Integer adyacente = (Integer) it.next();
			if (vertices.get(adyacente).equals("BLANCO")) {
				resultado.addAll(dfsForest(adyacente));
			}
		}
		vertices.put(vertice, "NEGRO");
		return resultado;
	}

}
