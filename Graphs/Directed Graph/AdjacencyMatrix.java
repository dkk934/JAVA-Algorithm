import java.util.*;

class DirectedGraphAdjMatrix {
    private int[][] adjMatrix; // 2D array to store the adjacency matrix
    private int size;          // Number of vertices in the graph

    // Constructor to initialize the adjacency matrix with a given size
    public DirectedGraphAdjMatrix(int size) {
        this.size = size; 
        adjMatrix = new int[size][size]; // Initialize matrix with zeros (no edges)
    }

    // Method to add a directed edge from source to destination
    public void addEdge(int source, int destination) {
        adjMatrix[source][destination] = 1; // Mark edge from source to destination
    }

    // Method to print the adjacency matrix
    public void printGraph() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Print each cell in the adjacency matrix
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println(); // New line after each row
        }
    }
}
