public class PrimMST {

    public static void main(String[] args) {
        int V = 5; // Total number of vertices

        // Adjacency matrix: graph[i][j] stores edge weight. 0 means no edge.
        int[][] graph = {
            { 0, 2, 0, 6, 0 },
            { 2, 0, 3, 8, 5 },
            { 0, 3, 0, 0, 7 },
            { 6, 8, 0, 0, 9 },
            { 0, 5, 7, 9, 0 }
        };

        boolean[] visited = new boolean[V];
        visited[0] = true; // Start from vertex 0

        int totalWeight = 0;

        System.out.println("Edge : Weight");

        // An MST for V vertices always has (V - 1) edges
        for (int edgeCount = 0; edgeCount < V - 1; edgeCount++) {
            int minWeight = Integer.MAX_VALUE;
            int u = -1, v = -1;

            // Pick the smallest edge connecting a visited node to an unvisited node
            for (int i = 0; i < V; i++) {
                if (visited[i]) {
                    for (int j = 0; j < V; j++) {
                        if (!visited[j] && graph[i][j] != 0) {
                            if (graph[i][j] < minWeight) {
                                minWeight = graph[i][j];
                                u = i;
                                v = j;
                            }
                        }
                    }
                }
            }

            // Add the chosen edge to MST
            visited[v] = true;
            totalWeight += minWeight;
            System.out.println(u + " - " + v + " : " + minWeight);
        }

        System.out.println("Total MST Weight: " + totalWeight);
    }
}
