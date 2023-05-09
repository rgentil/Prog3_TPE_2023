package tudai.prog3.collections;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class GrafoDirigido<T> implements Grafo<T> {

	private HashMap<Integer, HashSet<Arco<T>>> vertices;

	public GrafoDirigido() {
		this.vertices = new HashMap<>();
	}

	@Override
	public void agregarVertice(int verticeId) {
		if (!this.vertices.containsKey(verticeId)) {
			this.vertices.put(verticeId, new HashSet<>());
		}
	}

	@Override
	public void borrarVertice(int verticeId) {
		this.vertices.remove(verticeId);
	}

	@Override
	public void agregarArco(int verticeId1, int verticeId2, T etiqueta) {
		this.agregarVertice(verticeId1);
		this.agregarVertice(verticeId2);
		Arco<T> aux = new Arco<>(verticeId1, verticeId2, etiqueta);
		this.vertices.get(verticeId1).add(aux);
	}

	@Override
	public void borrarArco(int verticeId1, int verticeId2) {
		Arco<T> delete = this.obtenerArco(verticeId1, verticeId2);
		if (delete != null)
			this.vertices.get(verticeId1).remove(delete);
	}

	@Override
	public boolean contieneVertice(int verticeId) {
		return this.vertices.containsKey(verticeId);
	}

	@Override
	public boolean existeArco(int verticeId1, int verticeId2) {
		return this.obtenerArco(verticeId1, verticeId2) != null;
	}

	@Override
	public Arco<T> obtenerArco(int verticeId1, int verticeId2) {
		if (this.vertices.containsKey(verticeId1)) {
			Iterator<Arco<T>> arcosIt = this.obtenerArcos(verticeId1);
			while (arcosIt.hasNext()) {
				Arco<T> current = arcosIt.next();
				if (current.getVerticeDestino() == verticeId2)
					return current;
			}
		}
		return null;
	}

	@Override
	public int cantidadVertices() {
		return this.vertices.size();
	}

	@Override
	public int cantidadArcos() {
		if (this.vertices.isEmpty())
			return 0;
		int count = 0;
		Iterator<Integer> verticesIt = this.obtenerVertices();
		while (verticesIt.hasNext()) {
			count += this.vertices.get(verticesIt.next()).size();
		}
		return count;
	}

	@Override
	public Iterator<Integer> obtenerVertices() {
		if (this.vertices.isEmpty())
			return null;
		return this.vertices.keySet().iterator();
	}

	@Override
	public Iterator<Integer> obtenerAdyacentes(int verticeId) {
		if (!this.vertices.containsKey(verticeId))
			return null;
		HashSet<Integer> adjs = new HashSet<>();
		Iterator<Arco<T>> arcosIt = this.obtenerArcos(verticeId);
		while (arcosIt.hasNext()) {
			adjs.add(arcosIt.next().getVerticeDestino());
		}
		return adjs.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos() {
		HashSet<Arco<T>> aux = new HashSet<>();
		Iterator<Integer> verticesIt = this.obtenerVertices();
		while (verticesIt.hasNext()) {
			aux.addAll(this.vertices.get(verticesIt.next()));
		}
		return aux.iterator();
	}

	@Override
	public Iterator<Arco<T>> obtenerArcos(int verticeId) {
		if (!this.vertices.containsKey(verticeId))
			return null;
		return this.vertices.get(verticeId).iterator();
	}

}
