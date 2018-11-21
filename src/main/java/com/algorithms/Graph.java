package com.algorithms;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Graph {
    private int numVertices; // no of vertices
    private List<List<Integer>> adjacencyLists;

    public Graph(int v) {
        this.numVertices = v;
        adjacencyLists = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            adjacencyLists.add(i, new ArrayList<>());
        }
    }

    public List<List<Integer>> getAdjacencyLists() {
        return adjacencyLists;
    }

    public void setAdjacencyLists(List<List<Integer>> adjacencyLists) {
        this.adjacencyLists = adjacencyLists;
    }

    // Function to add an edge into the graph
    private void addEdge(int v, int w) {
        adjacencyLists.get(v).add(w);
    }

    // A recursive function used by topologicalSort
    private void topologicalSortUtil(int v, boolean visited[],
                                     Deque<Integer> stack) {
        visited[v] = true;
        for (Integer neighbour : adjacencyLists.get(v)) {
            if (!visited[neighbour])
                topologicalSortUtil(neighbour, visited, stack);
        }

        stack.push(v);
    }

    void topologicalSort() {
        Deque<Integer> stack = new ArrayDeque<>();

        boolean visited[] = new boolean[numVertices];

        for (int i = 0; i < numVertices; i++)
            if (!visited[i])
                topologicalSortUtil(i, visited, stack);

        while (!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }

    void dfs(int s) {
        List<Boolean> visited = new ArrayList<>();
        for (int i = 0; i < numVertices; i++)
            visited.add(false);

        // Create a stack for DFS
        Deque<Integer> stack = new ArrayDeque<>();

        // Push the current source node
        stack.push(s);

        while (!stack.isEmpty()) {
            // Pop a vertex from stack and print it
            s = stack.peekLast();
            stack.pollLast();

            if (!visited.get(s)) {
                System.out.print(s + " ");
                visited.set(s, true);
            }


            for (Integer v : adjacencyLists.get(s)) {
                if (!visited.get(v))
                    stack.push(v);
            }

        }
    }


    // Driver method
    public static void main(String args[]) {
        // Create a graph given in the above diagram
        Graph g = new Graph(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);

        System.out.println("Following is a Topological " +
                "sort of the given graph");
        g.topologicalSort();
        System.out.println();
        g.dfs(5);
    }

}
