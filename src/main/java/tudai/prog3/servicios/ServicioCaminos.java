package tudai.prog3.servicios;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import tudai.prog3.colecciones.Arco;
import tudai.prog3.colecciones.Grafo;

public class ServicioCaminos {

	private Grafo<?> grafo;
	private int origen;
	private int destino;
	private int lim;

	private List<Arco<?>> visitados;

	// Servicio caminos
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
		this.visitados = new ArrayList<Arco<?>>();
	}


	private List<Integer> listarNodos(List<Arco<?>> actual) {
		List<Integer> lista = new ArrayList<>();
		lista.add(actual.get(0).getVerticeOrigen());
		for(Arco<?> a: actual) {
			lista.add(a.getVerticeDestino());
		}
		return lista;
	}


	private List<Arco<?>> caminos(List<Arco<?>> actual, Arco<?> arco, int cont) {
		if (!this.visitados.contains(arco)) {
			this.visitados.add(arco);
			cont += 1;

			Integer destino = arco.getVerticeDestino();
			if (destino == this.destino && cont <= this.lim) {
				actual.add(arco);
			} else {
				if (cont < this.lim) {
					Iterator<?> it = this.grafo.obtenerArcos(arco.getVerticeDestino());
					if (it != null) {
                        while (it.hasNext()) {
                            this.caminos(actual, (Arco<?>) it.next(), cont);
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

            Iterator<?> it = grafo.obtenerArcos(this.origen);
            if (it != null) {
                while (it.hasNext()) {
                    Arco<?> arco = (Arco<?>) it.next();
                    if (!this.visitados.contains(arco)) {
                        List<Arco<?>> actual = this.caminos(new ArrayList<>(), arco, 0);
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
