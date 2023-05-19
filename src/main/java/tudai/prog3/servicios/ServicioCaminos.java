package tudai.prog3.servicios;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import tudai.prog3.colecciones.Grafo;

/**
 * Caminos : dado un origen, un destino y un l�mite �lim� retorna todos los
 * caminos que, partiendo del v�rtice origen, llega al v�rtice de destino sin
 * pasar por m�s de �lim� arcos. Aclaraci�n importante: en un camino no se puede
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

    public List<List<Integer>> caminos() {
        if (this.lim > 0 && this.grafo != null) {
            this._caminos(new ArrayList<Arco<?>>(), new ArrayList<Integer>(), this.origen, 0);
        }
        return this.caminos;
    }


    private void _caminos(List<Arco<?>> visitados, List<Integer> camino, Integer v, int cont) {

        if (v == this.destino) {
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(this.origen);
            tmp.addAll(camino);
            this.caminos.add(tmp);

        } else {
            for (Iterator<?> it = this.grafo.obtenerArcos(v); it.hasNext();) {
                Arco<?> actual = (Arco<?>) it.next();
                if (!visitados.contains(actual)) {
                    visitados.add(actual);
                    cont += 1;
                    if (cont <= this.lim) {
                        Integer dest = actual.getVerticeDestino();
                        camino.add(dest);
                        this.caminos(visitados, camino, dest, cont);
                        camino.remove(dest);
                    }
                    visitados.remove(actual);
                    cont -= 1;
                }
            }
        }

    }

}
