import java.util.LinkedList;

// Graph class
class Graph {
    private int vertices; // Number of vertices
    private LinkedList<Integer>[] adjacencyList; // Adjacency list

    // Constructor
    public Graph(int vertices) {
        this.vertices = vertices;
        adjacencyList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjacencyList[i] = new LinkedList<>();
        }
    }

    // Add edge to the graph
    public void addEdge(int source, int destination, boolean isUndirected) {
        adjacencyList[source].add(destination);
        if (isUndirected) {
            adjacencyList[destination].add(source);
        }
    }

    // Display the graph as an adjacency list
    public void displayGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ":");
            for (int neighbor : adjacencyList[i]) {
                System.out.print(" -> " + neighbor);
            }
            System.out.println();
        }
    }
}

// Main class
public class GraphLinkedListExample {
    public static void main(String[] args) {
        int vertices = 5;

        // Create a graph with 5 vertices
        Graph graph = new Graph(vertices);

        // Add edges (undirected graph example)
        graph.addEdge(0, 1, true);
        graph.addEdge(0, 4, true);
        graph.addEdge(1, 2, true);
        graph.addEdge(1, 3, true);
        graph.addEdge(1, 4, true);
        graph.addEdge(2, 3, true);
        graph.addEdge(3, 4, true);

        // Display the adjacency list representation
        System.out.println("Graph adjacency list:");
        graph.displayGraph();
    }
}
