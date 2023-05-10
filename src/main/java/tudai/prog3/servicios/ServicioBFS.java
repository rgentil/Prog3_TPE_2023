package tudai.prog3.servicios;

import java.util.*;

import tudai.prog3.colecciones.Grafo;

public class ServicioBFS {

	private Grafo<?> grafo;
	private HashMap<Integer, Boolean> visitados;

	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.visitados = new HashMap<Integer, Boolean>();
	}

	private void iniciarEstructura() {
		if (this.grafo != null) {
			for (Iterator<Integer> iterator = grafo.obtenerVertices(); iterator.hasNext();) {
				Integer vertice = (Integer) iterator.next();
				visitados.put(vertice, false);
			}
		}
	}

	public List<Integer> bfsForest() {
		this.iniciarEstructura();
		List<Integer> resultado = new ArrayList<Integer>();
		for (Iterator<Integer> vertices = this.grafo.obtenerVertices(); vertices.hasNext();) {
			Integer vertice = (Integer) vertices.next();
			if (!visitados.get(vertice)) {
				resultado.addAll(bfsForest(vertice));
			}
		}
		return resultado;
	}

	private List<Integer> bfsForest(Integer origen) {
		ArrayList<Integer> fila = new ArrayList<>();
		ArrayList<Integer> salida = new ArrayList<>();
		visitados.put(origen, true);
		fila.add(origen);
		salida.add(origen);
		while (!fila.isEmpty()) {
			int vertice = fila.remove(0);
			for (Iterator<Integer> adyacentes = this.grafo.obtenerAdyacentes(vertice); adyacentes.hasNext();) {
				Integer adyacente = (Integer) adyacentes.next();
				if (!visitados.get(adyacente)) {
					visitados.put(adyacente, true);
					fila.add(adyacente);
					salida.add(adyacente);
				}
			}
		}
		return salida;
	}

}
