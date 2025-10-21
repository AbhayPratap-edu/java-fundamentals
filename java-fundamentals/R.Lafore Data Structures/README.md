# 📊 Java Data Structures & Algorithms

Data structures and algorithms implemented in Java — following Robert Lafore's approach with clear examples and interactive demonstrations.  
---
## Repo Structure
<pre>
📦 DataStructures
│
├── 📁 Arrays
│   ├── 📄 HighArray.java
│   ├── 📄 orderedArray.java
│
├── 📁 Linked_lists
│   ├── 📄 SimpleLinkList.java
│   ├── 📄 DoublyLinkList.java
│   ├── 📄 DoubleEndList.java
│   ├── 📄 SortedLinkList.java
│   ├── 📄 interIteratorForList.java
│
├── 📁 Stack & Queue
│   ├── 📄 PriorityQueOnArray.java
│   ├── 📄 QueueOnArray.java
│   ├── 📄 QueOnLinkList.java
│   ├── 📄 StackOnArray.java
│   ├── 📄 StackOnLinkList.java
│
├── 📁 Trees
│   ├── 📄 BinaryTree.java
│   ├── 📄 Tree234.java
│   ├── 📄 RedBlackTree.java
│   ├── 📄 MSTree.java
│

├── 📁 Hashing
│   ├── 📄 HashTable.java
│   ├── 📄 HashChain.java
│   ├── 📄 DoubleHash.java
│
├── 📁 heaps
│   ├── 📄 Heap.java
│   
├── 📁 Graphs
│   ├── 📄 GraphN_BFS.java
│   ├── 📄 GraphN_DFS.java
│   ├── 📄 GraphDW_SP.java
│   ├── 📄 GraphW_MSTW.java
│   ├── 📄 Graph_TopoSorting.java
│
├── 📁 sorting
│   ├── 📄 Sorting.java
│   ├── 📄 MergeSort.java
│   ├── 📄 QuickSort1.java
│   ├── 📄 HeapSort.java
│   ├── 📄 ShellSorting.java  
│
└── 📄 README.md
  </pre>


---

## 📚 Data Structures

### 🟦 Arrays & Basic Structures

- **High Array**  
  Unordered array with basic operations  
  [`HighArray.java`](HighArray.java)

- **Ordered Array**  
  Sorted array with binary search  
  [`orderedArray.java`](orderedArray.java)

---

### 🟩 Linked Lists

- **Simple Linked List**  
  Singly-linked list with basic operations  
    [`SimpleLinkList.java`](SimpleLinkList.java)

- **Sorted Linked List**  
  Maintains sorted order on insertion  
  [`SortedLinkList.java`](SortedLinkList.java)

- **Doubly Linked List**  
  Bidirectional traversal with prev/next pointers  
  [`DoublyLinkList.java`](DoublyLinkList.java)

- **Double-Ended List**  
  Efficient operations at both ends  
  [`DoubleEndList.java`](DoubleEndList.java)

- **Iterator for Lists**  
  Custom iterator implementation for linked lists  
  [`interIteratorForList.java`](interIteratorForList.java)

---

### 🟨 Stacks & Queues

#### Stacks (LIFO)

- **Stack on Array**  
  Array-based stack implementation  
  [`StackOnArray.java`](StackOnArray.java)

- **Stack on Linked List**  
  Dynamic stack with no size limit  
  [`StackOnLinkList.java`](StackOnLinkList.java)

#### Queues (FIFO)

- **Queue on Array**  
  Circular array-based queue  
  [`QueueOnArray.java`](QueueOnArray.java)

- **Queue on Linked List**  
  Dynamic queue implementation  
  [`QueOnLinkList.java`](QueOnLinkList.java)

- **Priority Queue**  
  Elements dequeued by priority, not order  
  [`PriorityQueOnArray.java`](PriorityQueOnArray.java)

---


### 🟩 Trees

- **Binary Search Tree**  
  Hierarchical data structure with left < parent < right property  
  [`BinaryTree.java`](BinaryTree.java)

- **Red-Black Tree**  
  Self-balancing BST with color properties  
  [`RedBlackTree.java`](RedBlackTree.java)

- **2-3-4 Tree**  
  Multiway tree (can have 2, 3, or 4 children)  
  [`Tree234.java`](Tree234.java)

---
### 🟧 Hash Tables

- **Hash Table (Linear Probing)**  
  Open addressing with linear probing collision resolution  
  [`HashTable.java`](HashTable.java)

- **Hash Chain (Separate Chaining)**  
  Collision resolution using linked lists  
  [`HashChain.java`](HashChain.java)

- **Double Hashing**  
  Advanced open addressing with secondary hash function  
  [`DoubleHash.java`](DoubleHash.java)

---


### 🟪 Heaps

- **⛰️ Heap (Max-Heap)**  
  Complete binary tree with heap property (parent ≥ children)  
  [`Heap.java`](Heap.java)

---

### 🟥 Graphs

- **Graph BFS (Breadth-First Search)**  
  Level-order traversal using queue  
  [`GraphN_BFS.java`](GraphN_BFS.java)

- **Graph DFS (Depth-First Search)**  
  Explore as far as possible before backtracking  
  [`GraphN_DFS.java`](GraphN_DFS.java)

- **Topological Sorting**  
  Linear ordering of vertices in a DAG (Directed Acyclic Graph)  
  [`Graph_TopoSorting.java`](Graph_TopoSorting.java)

- **Minimum Spanning Tree (MST)**  
  Connects all vertices with minimum total edge weight  
  [`GraphW_MSTW.java`](GraphW_MSTW.java) | [`MSTree.java`](MSTree.java)

- **Shortest Path (Dijkstra's Algorithm)**  
  Finds shortest path from source to all vertices in weighted graph  
  [`GraphDW_SP.java`](GraphDW_SP.java)

---

## Sorting Algorithms

- **Merge Sort**  
  Divide-and-conquer stable sort  
  [`MergeSort.java`](MergeSort.java)

- **Quick Sort**  
  Partition-based in-place sort  
  [`QuickSort1.java`](QuickSort1.java)

- **Heap Sort**  
  Uses max-heap to sort in-place  
  [`HeapSort.java`](HeapSort.java)

- **Shell Sort**  
  Improved insertion sort with gap sequences  
  [`ShellSorting.java`](ShellSorting.java)

- **Sorting Utilities**  
  Helper functions and comparison tools  
  [`Sorting.java`](Sorting.java)

---

## 🎯 Key Features

✅ **Clean, well-commented code** — Learn by reading  
✅ **Classic implementations** — Based on Lafore's "Data Structures & Algorithms in Java"  
✅ **Time & Space complexity notes** — Understand performance trade-offs  
✅ **Educational focus** — Perfect for CSE students and interview prep

---

  
