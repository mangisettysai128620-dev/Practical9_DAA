import java.util.Arrays;

public class PrimAlgorithm {
    private static final int INF = 9999999;

    public static void primMST(int[][] graph, int V) {
        boolean[] selected = new boolean[V];
        Arrays.fill(selected, false);

        // Start from vertex 0
        selected[0] = true;
        int numEdges = 0;
        int totalWeight = 0;

        System.out.println("Edge : Weight");

        while (numEdges < V - 1) {
            int min = INF;
            int x = 0; // Row index
            int y = 0; // Column index

            // Find the minimum weight edge connecting a selected vertex to an unselected one
            for (int i = 0; i < V; i++) {
                if (selected[i]) {
                    for (int j = 0; j < V; j++) {
                        if (!selected[j] && graph[i][j] != 0) {
                            if (min > graph[i][j]) {
                                min = graph[i][j];
                                x = i;
                                y = j;
                            }
                        }
                    }
                }
            }

            System.out.println(x + " - " + y + " : " + graph[x][y]);
            totalWeight += graph[x][y];
            selected[y] = true;
            numEdges++;
        }

        System.out.println("Total Weight of MST: " + totalWeight);
    }

    public static void main(String[] args) {
        int V = 5;

        // Graph represented as an adjacency matrix (0 means no edge)
        int[][] graph = {
            { 0, 2, 0, 6, 0 },
            { 2, 0, 3, 8, 5 },
            { 0, 3, 0, 0, 7 },
            { 6, 8, 0, 0, 9 },
            { 0, 5, 7, 9, 0 }
        };

        primMST(graph, V);
    }
}
