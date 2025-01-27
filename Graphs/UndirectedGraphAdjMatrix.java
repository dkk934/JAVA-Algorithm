class UndirectedGraphAdjMatrix {
    private int[][] adjMatrix; // 2D array to store the edges
    private int size;          // Number of vertices in the graph

    // Constructor to initialize the adjacency matrix
    public UndirectedGraphAdjMatrix(int size) {
        this.size = size; 
        adjMatrix = new int[size][size]; // Initialize the matrix with 0s (no edges)
    }

    // Method to add an undirected edge between two vertices
    public void addEdge(int vertex1, int vertex2) {
        adjMatrix[vertex1][vertex2] = 1; // Add an edge from vertex1 to vertex2
        adjMatrix[vertex2][vertex1] = 1; // Since it's undirected, add the reverse edge as well
    }

    // Method to remove an undirected edge between two vertices
    public void removeEdge(int vertex1, int vertex2) {
        adjMatrix[vertex1][vertex2] = 0; // Remove the edge from vertex1 to vertex2
        adjMatrix[vertex2][vertex1] = 0; // Remove the reverse edge as well
    }

    // Method to print the adjacency matrix
    public void printGraph() {
        System.out.println("Adjacency Matrix:");
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Print each cell of the adjacency matrix
                System.out.print(adjMatrix[i][j] + " ");
            }
            System.out.println(); // New line after each row
        }
    }
}
