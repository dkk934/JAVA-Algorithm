import java.util.*;

// Class to represent the graph
class TopologicalSort {
    private int V; // Number of vertices
    private LinkedList<Integer> adjList[]; // Adjacency list for storing graph

    // Constructor to initialize graph with V vertices
    public TopologicalSort(int V) {
        this.V = V;
        adjList = new LinkedList[V]; // Array of adjacency lists

        // Initialize all adjacency lists
        for (int i = 0; i < V; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    // Method to add an edge from u to v
    public void addEdge(int u, int v) {
        adjList[u].add(v); // Add v to u's list
    }

    // Helper method to perform DFS and mark the nodes visited
    private void dfs(int node, boolean[] visited, Stack<Integer> stack) {
        // Mark the current node as visited
        visited[node] = true;

        // Recur for all the vertices adjacent to this node
        for (Integer neighbor : adjList[node]) {
            if (!visited[neighbor]) {
                dfs(neighbor, visited, stack);
            }
        }

        // Push the current node to stack (it will be used in topological order)
        stack.push(node);
    }

    // Method to perform topological sort
    public void topologicalSort() {
        Stack<Integer> stack = new Stack<>();
        boolean[] visited = new boolean[V];

        // Traverse all nodes and apply DFS for each unvisited node
        for (int i = 0; i < V; i++) {
            if (!visited[i]) {
                dfs(i, visited, stack);
            }
        }

        // Print the contents of stack (topological order)
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    public static void execute() {
        // Create a graph with 6 vertices
        TopologicalSort graph = new TopologicalSort(6);

        // Add edges
        graph.addEdge(5, 2);
        graph.addEdge(5, 0);
        graph.addEdge(4, 0);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        // Perform topological sort
        System.out.println("Topological Sort of the graph:");
        graph.topologicalSort();
    }
}

/* 
 * Topological Sort is a linear ordering of vertices in a directed acyclic graph (DAG)
 * such that for every directed edge uv, vertex u comes before v in the ordering.
 *
 * Other names for Topological Sort:
 * - Topological Ordering
 * - Directed Acyclic Graph (DAG) Sort
 *
 * Time Complexity:
 * - The time complexity of the algorithm is O(V + E), where:
 *   - V is the number of vertices
 *   - E is the number of edges in the graph
 * - This is because we visit each vertex once (O(V)) and for each vertex, we check its adjacent vertices (O(E)).

 * Space Complexity:
 * - The space complexity is O(V) because we store the visited array and the stack.
 */

