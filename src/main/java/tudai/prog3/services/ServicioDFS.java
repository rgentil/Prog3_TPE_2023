package tudai.prog3.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import tudai.prog3.collections.Grafo;

public class ServicioDFS {

	private final Grafo<?> grafo;
	private HashMap<Integer, String> vertices;

	public ServicioDFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.vertices = new HashMap<>();
		this.init();
	}

	private void init() {
		if (this.grafo != null) {
			for (Iterator<Integer> it = this.grafo.obtenerVertices(); it.hasNext();) {
				Integer vertice = (Integer) it.next();
				this.vertices.put(vertice, "WHITE");
			}
		}
	}

	public List<Integer> dfsForest() {
		this.init();
		List<Integer> result = new ArrayList<Integer>();
		for (Iterator<Integer> iterator = grafo.obtenerVertices(); iterator.hasNext();) {
			Integer vertice = (Integer) iterator.next();
			if (vertices.get(vertice).equals("WHITE")) {
				result.addAll(dfsForest_visit(vertice));
			}
		}
		return result;
	}

	private List<Integer> dfsForest_visit(Integer vertice) {
		List<Integer> resultado = new ArrayList<Integer>();
		vertices.put(vertice, "YELLOW");
		resultado.add(vertice);
		for (Iterator<Integer> it = grafo.obtenerAdyacentes(vertice); it.hasNext();) {
			Integer adyacente = (Integer) it.next();
			if (vertices.get(adyacente).equals("WHITE")) {
				resultado.addAll(dfsForest_visit(adyacente));
			}
		}
		vertices.put(vertice, "BLACK");
		return resultado;
	}

}
