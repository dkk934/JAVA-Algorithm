import java.util.*;

class DirectedWeightedGraphAdjMatrix {
    private int[][] adjMatrix; // 2D array to store weights of edges
    private int size;          // Number of vertices in the graph

    // Constructor to initialize the adjacency matrix
    public DirectedWeightedGraphAdjMatrix(int size) {
        this.size = size;
        adjMatrix = new int[size][size]; // Initialize matrix with 0s (no edges)
    }

    // Method to add a directed edge with a weight
    public void addEdge(int source, int destination, int weight) {
        adjMatrix[source][destination] = weight; // Assign weight to the edge
    }

    // Method to print the adjacency matrix
    public void printGraph() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Print each cell of the matrix
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println(); // New line after each row
        }
    }
}
