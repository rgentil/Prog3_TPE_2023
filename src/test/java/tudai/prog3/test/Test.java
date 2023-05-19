package tudai.prog3.test;

import java.util.List;

import tudai.prog3.colecciones.GrafoDirigido;
import tudai.prog3.servicios.ServicioBFS;
import tudai.prog3.servicios.ServicioCaminos;
import tudai.prog3.servicios.ServicioDFS;

public class Test {

	public static void main(String[] args) {

		GrafoDirigido<Integer> g = new GrafoDirigido<>();

//		g.agregarArco(3, 8, null);
//		g.agregarArco(3, 10, null);
//		g.agregarArco(5, 11, null);
//		g.agregarArco(7, 11, null);
//		g.agregarArco(7, 8, null);
//		g.agregarArco(8, 9, null);
//		g.agregarArco(11, 2, null);
//		g.agregarArco(11, 9, null);
//		g.agregarArco(11, 10, null);
//		g.agregarArco(11, 8, null);

		g.agregarArco(1, 2, null);
		g.agregarArco(1, 3, null);
		g.agregarArco(2, 5, null);
		g.agregarArco(3, 4, null);
		g.agregarArco(4, 5, null);

		// Ciclo
		g.agregarArco(4, 1, null);

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

	}

}
