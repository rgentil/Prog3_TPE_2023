package tudai.prog3.services;
/*
import java.util.*;

import tudai.prog3.collections.Arco;
import tudai.prog3.collections.Grafo;

public class ServicioCaminos {

	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private int lim;

	private List<Arco<T>> visitados;

	// Servicio caminos
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
		this.visitados = new ArrayList<Arco<T>>();
	}


	private List<Integer> listarNodos(List<Arco<T>> actual) {
		List<Integer> lista = new ArrayList<>();
		lista.add(actual.get(0).getVerticeOrigen());
		for(Arco<T> a: actual) {
			lista.add(a.getVerticeDestino());
		}
		return lista;
	}


	private List<Arco<T>> caminos(List<Arco<T>> actual, Arco<T> arco, int cont) {
		if (!this.visitados.contains(arco)) {
			this.visitados.add(arco);
			cont += 1;

			Integer destino = arco.getVerticeDestino();
			if (destino == this.destino && cont <= this.lim) {
				actual.add(arco);
			} else {
				if (cont < this.lim) {
					Iterator<Arco<T>> it = this.grafo.obtenerArcos(arco.getVerticeDestino());
					if (it != null) {
                        while (it.hasNext()) {
                            this.caminos(actual, it.next(), cont);
                            if (!actual.isEmpty()) {
                                actual.add(0, arco);
                                return actual;
                            }
                        }
                    }
				}
			}
		}
		return actual;
	}


	public List<List<Integer>> caminos() {
        List<List<Integer>> caminos = new ArrayList<>();
		if (this.lim > 0 && this.grafo != null) {

            this.visitados.clear();

            Iterator<Arco<T>> it = grafo.obtenerArcos(this.origen);
            if (it != null) {
                while (it.hasNext()) {
                    Arco<T> arco = it.next();
                    if (!this.visitados.contains(arco)) {
                        List<Arco<T>> actual = this.caminos(new ArrayList<>(), arco, 0);
                        if (!actual.isEmpty()) {
                            caminos.add(this.listarNodos(actual));
                        }
                    }
                }
            }

        }
		return caminos;
	}

}



 */
