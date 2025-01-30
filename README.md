# Java-Algorithm 🚀

## Description 📚

Welcome to the **Java Algorithms Project**! This repository contains a collection of algorithms implemented in Java, designed to help beginner programmers understand and practice fundamental programming concepts. Whether you're just starting out or looking to refine your skills, this project will serve as an invaluable resource.

---

## 📑 Table of Contents

- [Java-Algorithm 🚀](#java-algorithm-)
  - [Description 📚](#description-)
  - [📑 Table of Contents](#-table-of-contents)
  - [Installation 🛠️](#installation-️)
  - [Usage 🎯](#usage-)
  - [Included Algorithms 📂](#included-algorithms-)
    - [🔹 Graphs](#-graphs)
    - [🔹 Sorting](#-sorting)
    - [🔹 Trees](#-trees)
    - [🔹 Shortest Path](#-shortest-path)
    - [🔹 Minimum Spanning Tree (MST)](#-minimum-spanning-tree-mst)
    - [🔹 Maximum Flow](#-maximum-flow)
  - [Contributing 🤝](#contributing-)
  - [Directory Structure 📁](#directory-structure-)
  - [License 📜](#license-)

---

## Installation 🛠️

Follow these simple steps to get started:

1. **Clone this repository:**
   
   ```bash
   git clone https://github.com/dkk934/JAVA-Algorithm.git
   ```

2. **Navigate to the project directory:**
   
   ```bash
   cd JAVA-Algorithm
   ```

3. **Compile the Java files:**
   
   - Ensure that you have the Java Development Kit (JDK) installed. You can download it from the official [Oracle JDK](https://www.oracle.com/java/technologies/javase-downloads.html) page.
   
   - Compile all source files:
     
     ```bash
     javac -d bin Graphs/*.java Sorting/*.java Trees/*.java CPMathAlgorithms/*.java MaximumFlow/*.java MinimumSpanningTree/*.java Searching/*.java ShortestPath/*.java UserInterface/*.java
     ```
   
   - This command compiles all Java files in the project and places the compiled classes in the `bin` directory.

---

## Usage 🎯

Want to see the algorithms in action? Here's how:

1. **Navigate to the `bin` directory:**
   
   ```bash
   cd bin
   ```

2. **Run a program:**
   
   - To execute the **User Interface**, run:
     
     ```bash
     java Main
     ```
   
   - You can also run individual algorithms by specifying the respective class name.

---

## Included Algorithms 📂

This project includes implementations of various algorithms categorized as follows:

### 🔹 Graphs

Algorithms for traversing and searching graphs, crucial for modeling relationships in networks and connections.

### 🔹 Sorting

Techniques to arrange data in a specific order (ascending/descending), with different sorting methods optimized for various use cases.

### 🔹 Trees

Operations on tree data structures like binary search trees, including insertion, deletion, and traversal algorithms.

### 🔹 Shortest Path

Algorithms to find the optimal route between nodes in a graph with minimal cost, distance, or time.

### 🔹 Minimum Spanning Tree (MST)

Techniques for finding a subset of edges in a weighted graph that connects all vertices with the lowest total edge weight.

### 🔹 Maximum Flow

Methods to determine the greatest amount of flow possible from a source node to a sink node in a flow network.

---

## Contributing 🤝

We welcome contributions! To contribute:

1. **Fork** this repository.

2. **Create a new branch**:
   
   ```bash
   git checkout -b feature/new-feature
   ```

3. **Make changes and commit**:
   
   ```bash
   git commit -am 'Add new feature'
   ```

4. **Push changes**:
   
   ```bash
   git push origin feature/new-feature
   ```

5. **Submit a Pull Request** for review.

---

## Directory Structure 📁

<details>
    <summary><b>Java-Algorithm-List</b></summary> 
    <details>
        <summary>CPMathAlgorithms</summary>
    - BinaryIndexedTree.java</br>
    - EuclideanAlgorithm.java</br>
    - FermatsLittleTheorem.java</br>
    - KMP.java</br>
    - ModularExponentiation.java</br>
    - ModularInverse.java</br>
    - SieveOfEratosthenes.java</br>
    </details>
    <details>
        <summary>Graphs</summary>
    - BFS.java</br>
    - DFS.java</br>
    - DirectedGraphAdjList.java</br>
    - DirectedGraphAdjMatrix.java</br>
    - DirectedWeightedGraphAdjList.java</br>
    - DirectedWeightedGraphAdjMatrix.java</br>
    - UndirectedGraphAdjList.java</br>
    - UndirectedGraphAdjMatrix.java</br>
    - UndirectedGraphCycleDetection.java</br>
    </details>
    <details>
        <summary>MaximumFlow</summary>
    - EdmonsKarpAlgorithm.java</br>
    - FordFulkersonAlgorithm.java</br>
    </details>
    <details>
        <summary>MinimumSpanningTree</summary>
    - KruskalAlgorithm.java</br>
    - PrimAlgorithm.java</br>
        </details>
    <details>
        <summary>Searching</summary>
    - BinarySearch.java</br>
    - ExponentialSearch.java</br>
    - JumpSearch.java</br>
    - LinearSearch.java</br>
    - TernarySearch.java</br>
    </details>
    <details>
        <summary>ShortestPath</summary>
    - AStar.java</br>
    - BellmanFord.java</br>
    - DijkstraAlgorithm.java</br>
    - FloydWarshall.java</br>
    </details>
    <details>
        <summary>Sorting</summary>
    - BinomialHeapSort.java</br>
    - BubbleSort.java</br>
    - CocktailShakerSort.java</br>
    - CountingSort.java</br>
    - FlashSort.java</br>
    - InsertionSort.java</br>
    - MergeSort.java</br>
    - PigeonholeSort.java</br>
    - QuickSort.java</br>
    - RadixSort.java</br>
    - SelectionSort.java</br>
    - ShellSort.java</br>
    - SleepSort.java</br>
    - StrandSort.java</br>
    - TimSort.java</br>
    - TopologicalSort.java</br>
    </details>
    <details>   
        <summary>Trees</summary>
    - AVLTree.java</br>
    - BinarySearchTree.java</br>
    - BinaryTree.java</br>
    - DecisionTree.java</br>
    - TreeInArray.java</br>
    - TreeLinkedList.java</br>
      </details>
</details>

---

## License 📜

This project is licensed under the **MIT License**. See the [LICENSE](LICENSE) file for more details.

🌟 Happy Coding! 🌟
