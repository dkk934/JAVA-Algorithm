// A* Search Algorithm
// This algorithm finds the shortest path from a start node to a goal node in a graph.
// It uses a heuristic to estimate the cost to reach the goal, optimizing the search.
import java.util.*;

class AStar {
    static class Node {
        int id;
        double cost;

        Node(int id, double cost) {
            this.id = id;
            this.cost = cost;
        }
    }

    public static List<Integer> aStarSearch(int[][] graph, int[] heuristic, int start, int goal) {
        int V = graph.length;
        PriorityQueue<Node> openSet = new PriorityQueue<>(Comparator.comparingDouble(n -> n.cost));
        boolean[] closedSet = new boolean[V];
        int[] parent = new int[V];
        Arrays.fill(parent, -1);

        double[] gScore = new double[V];
        Arrays.fill(gScore, Double.MAX_VALUE);
        gScore[start] = 0;

        openSet.add(new Node(start, heuristic[start]));

        while (!openSet.isEmpty()) {
            Node current = openSet.poll();

            if (current.id == goal) {
                return reconstructPath(parent, start, goal);
            }

            closedSet[current.id] = true;

            for (int neighbor = 0; neighbor < V; neighbor++) {
                if (graph[current.id][neighbor] == 0 || closedSet[neighbor]) {
                    continue;
                }

                double tentativeGScore = gScore[current.id] + graph[current.id][neighbor];

                if (tentativeGScore < gScore[neighbor]) {
                    parent[neighbor] = current.id;
                    gScore[neighbor] = tentativeGScore;
                    double fScore = gScore[neighbor] + heuristic[neighbor];

                    openSet.add(new Node(neighbor, fScore));
                }
            }
        }

        return Collections.emptyList(); // Return empty if no path exists
    }

    private static List<Integer> reconstructPath(int[] parent, int start, int goal) {
        List<Integer> path = new ArrayList<>();
        for (int at = goal; at != -1; at = parent[at]) {
            path.add(at);
        }
        Collections.reverse(path);
        return path;
    }

    public static void execute() {
        int[][] graph = {
                {0, 1, 4, 0, 0},
                {0, 0, 4, 2, 7},
                {0, 0, 0, 3, 0},
                {0, 0, 0, 0, 1},
                {0, 0, 0, 0, 0}
        };

        int[] heuristic = {7, 6, 2, 1, 0};
        int start = 0;
        int goal = 4;

        List<Integer> path = aStarSearch(graph, heuristic, start, goal);
        System.out.println("Shortest path from start to goal: " + path);
    }
}
