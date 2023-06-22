package tudai.prog3.test;

import java.util.List;

import tudai.prog3.colecciones.GrafoDirigido;
import tudai.prog3.servicios.ServicioBFS;
import tudai.prog3.servicios.ServicioCaminos;
import tudai.prog3.servicios.ServicioDFS;

public class Test {

	public static void main(String[] args) {

		GrafoDirigido<Integer> g = new GrafoDirigido<>();

		g.agregarArco(1, 2, null);
		g.agregarArco(1, 3, null);
		g.agregarArco(1, 1, null);
		g.agregarArco(2, 5, null);
		g.agregarArco(3, 4, null);
		g.agregarArco(4, 1, null);
		g.agregarArco(4, 5, null);

		/*
		 * Arcos que no se deben generar para que no haya repetidos. Resuelve - El
		 * agregarArco no verifica que ya no exista el arco generando arcos duplicados."
		 */
		g.agregarArco(1, 2, null);
		g.agregarArco(1, 2, null);
		g.agregarArco(1, 3, null);
		g.agregarArco(4, 5, null);

		ServicioDFS dfs = new ServicioDFS(g);
		ServicioBFS bfs = new ServicioBFS(g);
		ServicioCaminos cam = new ServicioCaminos(g, 1, 5, 3);

		List<Integer> dfs_forest = dfs.dfsForest();
		System.out.println("\nDFS Forest: " + dfs_forest);

		List<Integer> bfs_forest = bfs.bfsForest();
		System.out.println("\nBFS Forest: " + bfs_forest);

		List<List<Integer>> caminos = cam.caminos();
		System.out.println("\nCaminos: ");
		for (List<Integer> list : caminos) {
			System.out.println(list.toString());
		}

		g.imprimir();
		System.out.println("#Arcos " + g.cantidadArcos());
		System.out.println("#Vertice " + g.cantidadVertices());

		/*
		 * Solución a - El borrarVertice no actualiza correctamente la cantidad de
		 * arcos. Tampoco borra correctamente los arcos entrantes del vértice a borrar.
		 */
		int v_eliminar = 1;
		System.out.println("\nSe elimina el vertice " + v_eliminar);
		g.borrarVertice(v_eliminar);
		g.imprimir();
		System.out.println("#Arcos " + g.cantidadArcos());
		System.out.println("#Vertice " + g.cantidadVertices());

	}

}
