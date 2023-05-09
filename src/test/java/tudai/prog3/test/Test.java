package tudai.prog3.test;

import tudai.prog3.collections.GrafoDirigido;
import tudai.prog3.services.ServicioBFS;
import tudai.prog3.services.ServicioDFS;

import java.util.List;

public class Test {

	public static void main(String[] args) {

		GrafoDirigido<Integer> grafo = new GrafoDirigido<>();

		grafo.agregarArco(3, 10, null);
		grafo.agregarArco(3, 8, null);
		grafo.agregarArco(5, 11, null);
		grafo.agregarArco(7, 8, null);
		grafo.agregarArco(7, 11, null);
		grafo.agregarArco(8, 9, null);
		grafo.agregarArco(11, 10, null);
		grafo.agregarArco(11, 2, null);

		ServicioDFS dfs = new ServicioDFS(grafo);
		ServicioBFS bfs = new ServicioBFS(grafo);
//		ServicioCaminos cam = new ServicioCaminos(grafo, 3, 9, 2);

		List<Integer> dfs_forest = dfs.dfsForest();
		System.out.println("\nDFS Forest: " + dfs_forest);

		List<Integer> bfs_forest = bfs.bfsForest();
		System.out.println("\nBFS Forest: " + bfs_forest);

//		List<List<Integer>> caminos = cam.caminos();
//		System.out.println("\nCaminos: ");
//		for(List<Integer> list:caminos) {
//			System.out.println(list.toString());
//		}



	}

}
