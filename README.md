# Java-Algorithm 🚀

## Description 📚
Welcome to the Java Algorithms Project! This repository contains a collection of algorithms implemented in Java, designed to help beginner programmers understand and practice fundamental programming concepts. Whether you're just starting out or looking to brush up on your skills, you'll find this project helpful and engaging.

## Table of Contents 📑
- Installation
- Usage
- Included Algorithms
- Contributing
- License

## Installation 🛠️
Getting started is easy! Just follow these steps:

1. **Clone this repository:**
    ```bash
    git clone https://github.com/dkk934/JAVA-Algorithm.git
    ```
2. **Navigate to the project directory:**
    ```bash
    cd JAVA-Algorithm
    ```
3. **Compile the Java files:**
  - Make sure you have the Java Development Kit (JDK) installed. You can download it from the official Oracle website.
  - Compile the source files in each directory:
    ```bash
    javac -d bin Graphs/*.java Sorting/*.java Trees/*.java
    ```
  - This command compiles all Java files in the Graphs, Sorting, and Trees directories and places the compiled classes in the bin directory.

## Usage 🎯
Ready to see the algorithms in action? Here's how:
 
1. **Navigate to the bin directory:**
    ```bash
    cd bin
    ```
2. **Run the desired algorithm:**
  - For example, to run a specific algorithm:
    ```bash
    java QuickSort
    ```
  - Similarly, you can run algorithms specifying the appropriate class name.
 
## Included Algorithms 📂
Here's a sneak peek at the categories of algorithms you'll find in this project:

 ### Graphs
  This category includes algorithms for traversing and searching through graph structures. These algorithms are fundamental for understanding how to navigate and manipulate graph data       structures, which are widely used in computer science for modeling relationships and connections.

 ### Sorting
  Sorting algorithms are essential for arranging data in a specific order, such as ascending or descending. This category covers various sorting techniques, each with its own advantages     and use cases, helping you understand the trade-offs between different sorting methods.

 ### Trees
  Tree algorithms focus on operations related to tree data structures, such as binary search trees. These algorithms are crucial for efficiently managing hierarchical data and performing    operations like insertion, deletion, and traversal.
 
 ### Shortest path
  Shortest path algorithms are used in graph theory to find the path between two nodes (vertices) in a graph that minimizes the total weight (cost, distance, or time).  
 
 ### MST
  Minimum spanning tree algorithms are used to find a subset of edges in a weighted graph that connects all vertices with the minimum total edge weight, without forming cycles.

 ### Maximum flow
  Maximum flow algorithms determine the greatest amount of flow that can pass from a source node to a sink node in a flow network, while respecting capacity constraints on the edges.

## Contributing 🤝
We love contributions! If you'd like to contribute, please follow these steps:

1. Fork the repository.
2. Create a new branch (git checkout -b feature/new-feature).
3. Make your changes and commit them (git commit -am 'Add new feature').
4. Push your changes (git push origin feature/new-feature).
5. Open a Pull Request.
   
## Directory structure:
```
└── dkk934-java-algorithm/
    ├── README.md
    ├── LICENSE
    ├── Graphs/
    │   ├── CycleDetection.java
    │   ├── Directed Graph/
    │   │   ├── AdjacencyList.java
    │   │   └── AdjacencyMatrix.java
    │   ├── Directed Weighted Graph/
    │   │   ├── AdjacencyList.java
    │   │   └── AdjacencyMatrix.java
    │   ├── GraphsTraversing/
    │   │   ├── BFS.java
    │   │   └── DFS.java
    │   └── Undirected Graph/
    │       ├── AdjacencyList.java
    │       └── AdjacencyMatrix.java
    ├── Maximum Flow/
    │   ├── Edmonds-Karp.java
    │   └── Ford-Fulkerson.java
    ├── Minimum Spanning Tree/
    │   ├── Kruskal.java
    │   └── Prim.java
    ├── Shortest Path/
    │   ├── A_Star.java
    │   ├── BellmanFord.java
    │   ├── DijkstraAlgorithm.java
    │   └── Floyd-Warshall.java
    ├── Sorting/
    │   ├── BubbleShot.java
    │   ├── CountingSort.java
    │   ├── InsertionSort.java
    │   ├── MergeSort.java
    │   ├── QuickSort.java
    │   ├── Radix.java
    │   └── SelectionSort.java
    └── Trees/
        ├── AVLtree.java
        ├── BinarySearchTree.java
        ├── BinaryTree.java
        ├── DecisionTree.java
        ├── TreeInArray.java
        └── TreeLinkedLest.java

```
## License 📜
This project is licensed under the MIT License. See the LICENSE file for more details.
