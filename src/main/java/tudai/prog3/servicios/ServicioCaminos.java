package tudai.prog3.servicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tudai.prog3.colecciones.Arco;
import tudai.prog3.colecciones.Grafo;

/**
 * Caminos: dado un origen, un destino y un límite 'lim' retorna todos los
 * caminos que, partiendo del vértice origen, llega al vértice de destino sin
 * pasar por más de 'lim' arcos. Aclaración importante: en un camino no se puede
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
	private List<List<Integer>> caminos;

	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
		this.caminos = new ArrayList<List<Integer>>();
	}

	/**
	 * Método caminos El método es una adaptación del recorrido dfs, debido a que se
	 * trata de descubrir todos los caminos posibles y no, por ejemplo, el de menor
	 * longitud (para lo que habrá sido adecuado la adaptación de un recorrido bfs).
	 *
	 * Complejidad: O (V + A) donde V es la cantidad de vértices y A es la cantidad
	 * de arcos del grafo. En el peor de los casos, cuando el límite de arcos pasado
	 * por parámetro sea excesivo, deberán recorrerse todos los vértices y todos los
	 * arcos. En el caso contrario, cuando el límite sea igual a 0, no se realizará
	 * ningún recorrido. De modo tal que el factor decisivo en el cálculo de la
	 * complejidad de este método es el límite de arcos que restringe la cantidad de
	 * arcos por los que se podrá pasar.
	 *
	 * @return List<List<Integer>> Lista de listas de vértices -caminos- que cumplen
	 *         la restricción de límite de arcos recibida por parámetro.
	 */
	public List<List<Integer>> caminos() {
		if (this.lim > 0 && this.grafo != null) {
			this._caminos(new ArrayList<Arco<?>>(), new ArrayList<Integer>(), this.origen, 0);
		}
		return this.caminos;
	}

	private void _caminos(List<Arco<?>> visitados, List<Integer> camino, Integer verticeActual, int cont) {
		if (verticeActual == this.destino && cont > 0) {
			List<Integer> tmp = new ArrayList<Integer>();
			tmp.add(this.origen);
			tmp.addAll(camino);
			this.caminos.add(tmp);
		} else {
			for (Iterator<?> it = this.grafo.obtenerArcos(verticeActual); it.hasNext();) {
				Arco<?> arcoActual = (Arco<?>) it.next();
				if (!visitados.contains(arcoActual)) {
					visitados.add(arcoActual);
					cont += 1;
					if (cont <= this.lim) {
						Integer verticeAdyacente = arcoActual.getVerticeDestino();
						camino.add(verticeAdyacente);
						this._caminos(visitados, camino, verticeAdyacente, cont);
						camino.remove(verticeAdyacente);
					}
					visitados.remove(arcoActual);
					cont -= 1;
				}
			}
		}

	}

}
