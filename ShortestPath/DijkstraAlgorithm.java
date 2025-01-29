import java.util.*;

public class DijkstraAlgorithm {

    public static Map<String, Integer> dijkstra(Map<String, List<Node>> graph, String start) {
        // Priority queue to store (distance, node) pairs. Initially contains the start node with distance 0.
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(n -> n.distance));
        priorityQueue.add(new Node(start, 0));

        // Map to store the shortest known distance to each node. Initialize with infinity for all nodes.
        Map<String, Integer> distances = new HashMap<>();
        for (String node : graph.keySet()) {
            distances.put(node, Integer.MAX_VALUE);
        }
        distances.put(start, 0); // Distance to the start node is 0.

        // Set to track visited nodes to avoid revisiting them.
        Set<String> visited = new HashSet<>();

        while (!priorityQueue.isEmpty()) {
            // Remove the node with the smallest distance from the priority queue.
            Node current = priorityQueue.poll();

            if (visited.contains(current.name)) {
                continue;
            }

            // Mark the node as visited.
            visited.add(current.name);

            // Update distances for each neighbor of the current node.
            for (Node neighbor : graph.get(current.name)) {
                int newDistance = current.distance + neighbor.distance;

                // If a shorter path to the neighbor is found, update it.
                if (newDistance < distances.get(neighbor.name)) {
                    distances.put(neighbor.name, newDistance);
                    priorityQueue.add(new Node(neighbor.name, newDistance));
                }
            }
        }

        return distances;
    }

    public static void execute() {
        // Graph represented as an adjacency list.
        Map<String, List<Node>> graph = new HashMap<>();
        graph.put("A", Arrays.asList(new Node("B", 1), new Node("C", 4)));
        graph.put("B", Arrays.asList(new Node("A", 1), new Node("C", 2), new Node("D", 6)));
        graph.put("C", Arrays.asList(new Node("A", 4), new Node("B", 2), new Node("D", 3)));
        graph.put("D", Arrays.asList(new Node("B", 6), new Node("C", 3)));

        // Find the shortest paths from node 'A'.
        String startNode = "A";
        Map<String, Integer> shortestDistances = dijkstra(graph, startNode);

        // Print the result.
        System.out.println("Shortest distances from node " + startNode + ": " + shortestDistances);
    }

    static class Node {
        String name;
        int distance;

        public Node(String name, int distance) {
            this.name = name;
            this.distance = distance;
        }
    }
}
