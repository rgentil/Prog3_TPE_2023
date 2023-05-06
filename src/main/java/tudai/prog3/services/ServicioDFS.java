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
			Iterator<Integer> it = this.grafo.obtenerVertices();
			if (it != null) {
				while (it.hasNext()) {
					this.vertices.put(it.next(), "WHITE");
				}
			}
		}
	}

	private void dfsForest_visit(List<Integer> result, Integer current) {
		this.vertices.put(current, "YELLOW");
		result.add(current);

		Iterator<Integer> it = this.grafo.obtenerAdyacentes(current);
		while (it.hasNext()) {
			Integer ady = it.next();
			if (this.vertices.get(ady).equals("WHITE")) {
				this.dfsForest_visit(result, ady);
			}
		}

		this.vertices.put(current, "BLACK");
	}

	public List<Integer> dfsForest() {
		Iterator<Integer> it = this.vertices.keySet().iterator();
		while (it.hasNext()) {
			vertices.put(it.next(), "WHITE");
		}

		List<Integer> result = new ArrayList<>();
		it = this.vertices.keySet().iterator();
		while (it.hasNext()) {
			Integer current = it.next();
			if (this.vertices.get(current).equals("WHITE")) {
				this.dfsForest_visit(result, current);
			}
		}

		return result;
	}

}
