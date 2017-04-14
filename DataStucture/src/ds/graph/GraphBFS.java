package ds.graph;

import java.util.LinkedList;
import java.util.Queue;
//www.mathcs.emory.edu/~cheung/Courses/323/Syllabus/Graph/dfs.html
public class GraphBFS {
	/*
	 * ‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐ Data structure used to
	 * represent a graph ‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐
	 */
	int[][] adjMatrix;
	int rootNode = 0;
	int NNodes;
	boolean[] visited;

	/*
	 * ‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐ Construct a graph of N nodes
	 * ‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐‐
	 */
	GraphBFS(int N) {
		NNodes = N;
		adjMatrix = new int[N][N];
		visited = new boolean[N];
	}

	GraphBFS(int[][] mat) {
		int i, j;
		NNodes = mat.length;
		adjMatrix = new int[NNodes][NNodes];
		visited = new boolean[NNodes];
		for (i = 0; i < NNodes; i++)
			for (j = 0; j < NNodes; j++)
				adjMatrix[i][j] = mat[i][j];
	}

	public void bfs() {
		// BFS uses Queue data structure
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(rootNode);
		visited[rootNode] = true;
		printNode(rootNode);
		while (!q.isEmpty()) {
			int n, child;
			n = (q.peek()).intValue();
			child = getUnvisitedChildNode(n);
			if (child != -1) {
				visited[child] = true;
				printNode(child);
				q.add(child);
			} else {
				q.remove();
			}
		}
		clearVisited(); // Clear visited property of nodes
	}

	int getUnvisitedChildNode(int n) {
		int j;
		for (j = 0; j < NNodes; j++) {
			if (adjMatrix[n][j] > 0) {
				if (!visited[j])
					return (j);
			}
		}
		return (-1);
	}

	void clearVisited() {
		int i;
		for (i = 0; i < visited.length; i++)
			visited[i] = false;
	}

	void printNode(int n) {
		System.out.println(n);
	}

	public static void main(String[] args) {
		// 0 1 2 3 4 5 6 7 8
		// ===================================================
		int[][] conn = { { 0, 1, 0, 1, 0, 0, 0, 0, 1 }, // 0
				{ 1, 0, 0, 0, 0, 0, 0, 1, 0 }, // 1
				{ 0, 0, 0, 1, 0, 1, 0, 1, 0 }, // 2
				{ 1, 0, 1, 0, 1, 0, 0, 0, 0 }, // 3
				{ 0, 0, 0, 1, 0, 0, 0, 0, 1 }, // 4
				{ 0, 0, 1, 0, 0, 0, 1, 0, 0 }, // 5
				{ 0, 0, 0, 0, 0, 1, 0, 0, 0 }, // 6
				{ 0, 1, 1, 0, 0, 0, 0, 0, 0 }, // 7
				{ 1, 0, 0, 0, 1, 0, 0, 0, 0 } };// 8
		GraphBFS G = new GraphBFS(conn);
		G.bfs();
	}
}