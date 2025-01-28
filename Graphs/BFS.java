import java.util.*;

// Graph class to represent the graph structure
class BFS {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list

    // Constructor
    public BFS(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add an edge to the graph
    public void addEdge(int source, int destination) {
        adjacencyList[source].add(destination); // Add edge from source to destination
        adjacencyList[destination].add(source); // Add edge from destination to source (for undirected graph)
    }

    // Perform BFS starting from a given vertex
    public void bfs(int startVertex) {
        boolean[] visited = new boolean[vertices]; // Track visited nodes
        Queue<Integer> queue = new LinkedList<>(); // Queue for BFS traversal

        visited[startVertex] = true; // Mark the starting vertex as visited
        queue.add(startVertex); // Enqueue the starting vertex

        System.out.println("BFS starting from vertex " + startVertex + ":");

        while (!queue.isEmpty()) {
            int currentVertex = queue.poll(); // Dequeue a vertex
            System.out.print(currentVertex + " "); // Print the current vertex

            // Get all adjacent vertices of the dequeued vertex
            for (int adjacent : adjacencyList[currentVertex]) {
                if (!visited[adjacent]) { // If the adjacent vertex is not visited
                    visited[adjacent] = true; // Mark it as visited
                    queue.add(adjacent); // Enqueue the adjacent vertex
                }
            }
        }
    }

    // Main method to test the BFS implementation
    public static void execute() {
        BFS graph = new BFS(6); // Create a graph with 6 vertices (0 to 5)

        // Add edges to the graph
        graph.addEdge(0, 1);
        graph.addEdge(0, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 5);

        // Perform BFS starting from vertex 0
        graph.bfs(0);
    }
}
