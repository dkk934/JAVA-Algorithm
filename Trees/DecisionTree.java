import java.util.*;

// DecisionTree class to build and use a decision tree for classification
public class DecisionTree {
    // Node class to represent a single node in the decision tree
    private static class Node {
        boolean isLeaf; // Whether this node is a leaf (no further splits)
        int featureIndex; // The index of the feature used for splitting
        double threshold; // The threshold value used for splitting
        int label; // The predicted class label for a leaf node
        Node left; // Left child node (values <= threshold)
        Node right; // Right child node (values > threshold)

        // Constructor for a leaf node
        public Node(boolean isLeaf, int label) {
            this.isLeaf = isLeaf;
            this.label = label;
        }

        // Constructor for an internal (non-leaf) node
        public Node(int featureIndex, double threshold) {
            this.isLeaf = false;
            this.featureIndex = featureIndex;
            this.threshold = threshold;
        }
    }

    private Node root; // Root node of the tree
    private int maxDepth; // Maximum depth of the tree

    // Constructor to initialize the tree with a maximum depth
    public DecisionTree(int maxDepth) {
        this.maxDepth = maxDepth;
    }

    // Method to train the decision tree
    public void fit(double[][] X, int[] y) {
        root = buildTree(X, y, 0); // Start building the tree from the root
    }

    // Method to predict labels for a set of inputs
    public int[] predict(double[][] X) {
        int[] predictions = new int[X.length]; // Array to store predictions
        for (int i = 0; i < X.length; i++) {
            predictions[i] = predictSample(X[i], root); // Predict each sample
        }
        return predictions;
    }

    // Recursive method to build the tree
    private Node buildTree(double[][] X, int[] y, int depth) {
        // Stopping criteria: if all labels are the same or max depth is reached
        if (allSameLabel(y) || (maxDepth != 0 && depth >= maxDepth)) {
            return new Node(true, majorityClass(y)); // Create a leaf node
        }

        // Variables to track the best split
        int bestFeature = -1;
        double bestThreshold = 0;
        double bestGini = Double.MAX_VALUE;
        int[] leftIndices = null, rightIndices = null;

        // Iterate over each feature to find the best split
        for (int featureIndex = 0; featureIndex < X[0].length; featureIndex++) {
            double[] thresholds = unique(X, featureIndex); // Get unique values of the feature
            for (double threshold : thresholds) {
                // Split data into left and right based on the threshold
                int[][] leftRight = splitData(X, featureIndex, threshold);
                int[] left = leftRight[0];
                int[] right = leftRight[1];

                // Calculate Gini impurity for this split
                double gini = calculateGini(y, left, right);
                if (gini < bestGini) {
                    // Update the best split if this one is better
                    bestGini = gini;
                    bestFeature = featureIndex;
                    bestThreshold = threshold;
                    leftIndices = left;
                    rightIndices = right;
                }
            }
        }

        // If no valid split is found, create a leaf node
        if (bestFeature == -1 || leftIndices == null || rightIndices == null) {
            return new Node(true, majorityClass(y));
        }

        // Split data into left and right subsets
        double[][] leftX = filterRows(X, leftIndices);
        int[] leftY = filterLabels(y, leftIndices);
        double[][] rightX = filterRows(X, rightIndices);
        int[] rightY = filterLabels(y, rightIndices);

        // Create an internal node with the best split
        Node node = new Node(bestFeature, bestThreshold);
        node.left = buildTree(leftX, leftY, depth + 1); // Recursively build left subtree
        node.right = buildTree(rightX, rightY, depth + 1); // Recursively build right subtree

        return node;
    }

    // Predict the label for a single sample
    private int predictSample(double[] sample, Node node) {
        if (node.isLeaf) {
            return node.label; // Return the label if it's a leaf node
        }
        // Decide to go left or right based on the feature value
        if (sample[node.featureIndex] <= node.threshold) {
            return predictSample(sample, node.left);
        } else {
            return predictSample(sample, node.right);
        }
    }

    // Check if all labels in the dataset are the same
    private boolean allSameLabel(int[] y) {
        for (int i = 1; i < y.length; i++) {
            if (y[i] != y[0]) {
                return false;
            }
        }
        return true;
    }

    // Find the majority class (most frequent label) in the dataset
    private int majorityClass(int[] y) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int label : y) {
            countMap.put(label, countMap.getOrDefault(label, 0) + 1);
        }
        return Collections.max(countMap.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

    // Get unique values of a feature (used for thresholds)
    private double[] unique(double[][] X, int featureIndex) {
        return Arrays.stream(X).mapToDouble(row -> row[featureIndex]).distinct().toArray();
    }

    // Split data into two subsets based on a threshold
    private int[][] splitData(double[][] X, int featureIndex, double threshold) {
        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        for (int i = 0; i < X.length; i++) {
            if (X[i][featureIndex] <= threshold) {
                left.add(i);
            } else {
                right.add(i);
            }
        }
        return new int[][]{
            left.stream().mapToInt(i -> i).toArray(),
            right.stream().mapToInt(i -> i).toArray()
        };
    }

    // Calculate the Gini impurity for a split
    private double calculateGini(int[] y, int[] leftIndices, int[] rightIndices) {
        int[] leftY = filterLabels(y, leftIndices);
        int[] rightY = filterLabels(y, rightIndices);

        double leftWeight = (double) leftY.length / y.length;
        double rightWeight = (double) rightY.length / y.length;

        return leftWeight * giniImpurity(leftY) + rightWeight * giniImpurity(rightY);
    }

    // Calculate Gini impurity for a subset of labels
    private double giniImpurity(int[] y) {
        if (y.length == 0) return 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int label : y) {
            countMap.put(label, countMap.getOrDefault(label, 0) + 1);
        }
        double impurity = 1.0;
        for (int count : countMap.values()) {
            double prob = (double) count / y.length;
            impurity -= prob * prob;
        }
        return impurity;
    }

    // Filter rows of X based on indices
    private double[][] filterRows(double[][] X, int[] indices) {
        double[][] filtered = new double[indices.length][X[0].length];
        for (int i = 0; i < indices.length; i++) {
            filtered[i] = X[indices[i]];
        }
        return filtered;
    }

    // Filter labels based on indices
    private int[] filterLabels(int[] y, int[] indices) {
        int[] filtered = new int[indices.length];
        for (int i = 0; i < indices.length; i++) {
            filtered[i] = y[indices[i]];
        }
        return filtered;
    }

    // Main method for testing
    public static void main(String[] args) {
        // XOR problem: simple binary classification
        double[][] X = {
            {0, 0},
            {0, 1},
            {1, 0},
            {1, 1}
        };
        int[] y = {0, 1, 1, 0}; // Labels

        // Create a decision tree with a max depth of 2
        DecisionTree tree = new DecisionTree(2);
        tree.fit(X, y); // Train the tree

        int[] predictions = tree.predict(X); // Make predictions
        System.out.println("Predictions: " + Arrays.toString(predictions)); // Print predictions
    }
}
