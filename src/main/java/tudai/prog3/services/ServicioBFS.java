package tudai.prog3.services;

import java.util.*;
import tudai.prog3.collections.Grafo;

public class ServicioBFS {

	private final Grafo<?> grafo;
	private Stack<Integer> stack;

	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.stack = new Stack<>();
	}

	private void bfsForest(List<Integer> forest, Integer v) {
		this.stack.add(v);
		forest.add(v);

		while (!this.stack.empty()) {
			Integer actual = this.stack.pop();
			Iterator<Integer> it = this.grafo.obtenerAdyacentes(actual);
			if (it != null) {
				while (it.hasNext()) {
					Integer current = it.next();
					if (!forest.contains(current)) {
						this.stack.add(current);
						forest.add(current);
					}
				}
			}
		}

	}

	public List<Integer> bfsForest() {
		List<Integer> forest = new ArrayList<>();
		if (this.grafo != null) {

			this.stack.clear();

			Iterator<Integer> it = this.grafo.obtenerVertices();
			if (it != null) {
				while (it.hasNext()) {
					Integer v = it.next();
					if(!forest.contains(v)) {
						this.bfsForest(forest, v);
					}
				}
			}

		}
		return forest;
	}

}


