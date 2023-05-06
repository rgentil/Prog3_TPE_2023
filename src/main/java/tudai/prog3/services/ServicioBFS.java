package tudai.prog3.services;

import java.util.*;
import tudai.prog3.collections.Grafo;

public class ServicioBFS {

	private final Grafo<?> grafo;
	private HashMap<Integer, Boolean> vertices;
	private Stack<Integer> stack;

	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.vertices = new HashMap<>();
		this.stack = new Stack<>();
		this.init();
	}

	private void init() {
		if (this.grafo != null) {
			Iterator<Integer> it = this.grafo.obtenerVertices();
			if (it != null) {
				while (it.hasNext()) {
					this.vertices.put(it.next(), false);
				}
			}
		}
	}

	private void bfsForest(List<Integer> result, Integer v) {
		this.vertices.put(v, true);
		this.stack.add(v);
		result.add(v);

		while (!this.stack.empty()) {
			this.stack.pop();
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(v);
			while (it.hasNext()) {
				Integer current = it.next();
				if (!this.vertices.get(current)) {
					this.vertices.put(current, true);
					this.stack.add(current);
					result.add(current);
				}
			}
		}

	}

	public List<Integer> bfsForest() {
		this.stack.clear();
		Iterator<Integer> it = this.vertices.keySet().iterator();
		while (it.hasNext()) {
			vertices.put(it.next(), false);
		}

		List<Integer> result = new ArrayList<>();
		it = this.vertices.keySet().iterator();
		while (it.hasNext()) {

			Integer v = it.next();
			if(!this.vertices.get(v)) {
				this.bfsForest(result, v);
			}

		}
		return result;
	}

}
