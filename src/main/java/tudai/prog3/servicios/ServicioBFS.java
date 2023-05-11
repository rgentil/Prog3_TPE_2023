package tudai.prog3.servicios;

import java.util.*;

import tudai.prog3.colecciones.Grafo;

/**
 * BFS Forest : dado un grafo, realiza un recorrido en anchura y retorna un
 * orden posible de descubrimiento para los vértices durante ese recorrido.
 * 
 * @author Lauge Guillermina, Gentil Ricardo
 *
 */
public class ServicioBFS {

	private Grafo<?> grafo;
	private HashMap<Integer, Boolean> visitados;

	public ServicioBFS(Grafo<?> grafo) {
		this.grafo = grafo;
		this.visitados = new HashMap<Integer, Boolean>();
	}

	/**
	 * Inicia todos los vertices como no visitados.
	 */
	private void iniciarEstructura() {
		if (this.grafo != null) {
			for (Iterator<Integer> iterator = grafo.obtenerVertices(); iterator.hasNext();) {
				Integer vertice = (Integer) iterator.next();
				visitados.put(vertice, false);
			}
		}
	}

	/**
	 *
	 * Inicio la estructura. Recorro todos los vertices que no fueron vistados.
	 * O(|V|+|A|). Va a pasar una vez por cada vertice y una vez por cada arco.
	 * 
	 * @return Lista con el camino recorrido
	 */
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

	/**
	 * Marcar el vértice origen como VISITADO y lo agrego a la fila. Tomo el primer
	 * vertice de la fila y recorro todos los adyacentes que no fueron visitados y
	 * los voy marcando agregando a la salida para visitarlos a todos y al final
	 * para mostrarlo como solución
	 * 
	 * @param origen Vertice origen
	 * @return
	 */
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
