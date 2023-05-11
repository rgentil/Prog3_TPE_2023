package tudai.prog3.servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import tudai.prog3.colecciones.Grafo;

/**
 * Caminos : dado un origen, un destino y un límite “lim” retorna todos los
 * caminos que, partiendo del vértice origen, llega al vértice de destino sin
 * pasar por más de “lim” arcos. Aclaración importante: en un camino no se puede
 * pasar 2 veces por el mismo arco.
 * 
 * @author Lauge Guillermina, Gentil Ricardo
 *
 */
public class ServicioCaminos {

	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private int lim;
	private HashMap<Integer, String> vertices;

	// Servicio caminos
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
	}

	private void iniciarEstructura() {
		if (this.grafo != null) {
			for (Iterator<Integer> it = this.grafo.obtenerVertices(); it.hasNext();) {
				Integer vertice = (Integer) it.next();
				this.vertices.put(vertice, "BLANCO");
			}
		}
	}

	public List<List<Integer>> caminos() {
		this.iniciarEstructura();
		List<List<Integer>> caminosFinal = new ArrayList<List<Integer>>();
		List<Integer> caminoAux = new ArrayList<Integer>();
		caminos(origen, 0, caminosFinal, caminoAux);
		return caminosFinal;
	}

	private void caminos(Integer i, int cantArcosPasados, List<List<Integer>> caminosFinal, List<Integer> caminoAux) {
		vertices.put(i, "AMARILLO");
		caminoAux.add(i);
		cantArcosPasados++;
		if (i == this.destino && cantArcosPasados <= this.lim) {
			caminosFinal.add(new ArrayList<Integer>(caminoAux));
		} else {
			for (Iterator<Integer> it = grafo.obtenerAdyacentes(i); it.hasNext();) {
				Integer adyacente = (Integer) it.next();
				if (vertices.get(adyacente).equals("BLANCO")) {
					caminos(adyacente, cantArcosPasados, caminosFinal, caminoAux);
				}
			}
		}
		vertices.put(i, "BLANCO");
		caminoAux.remove(caminoAux.size() - 1);
		cantArcosPasados--;
	}

}
