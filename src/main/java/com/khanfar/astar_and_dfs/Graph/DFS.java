package com.khanfar.astar_and_dfs.Graph;

import java.util.*;

import com.khanfar.astar_and_dfs.Graph.* ;


public class DFS {

    private Graph graph ;

    public DFS (Graph graph) {
        this.graph = graph;
    }



    public HashSet<Vertex> findPath(String src, String dest) {
        Vertex startVertex = graph.search(src);
        Vertex endVertex = graph.search(dest);

        if (startVertex == null || endVertex == null) {
            return null; // Return null if start or end vertex doesn't exist
        }

        Stack<Vertex> stack = new Stack<>();
        HashSet<Vertex> visited = new HashSet<>();

        stack.push(startVertex);
        startVertex.setVisited(true);

        while (!stack.isEmpty()) {
            Vertex currentVertex = stack.pop();
            visited.add(currentVertex);

            if (currentVertex.getLabel().equals(dest)) {

                return visited; // Return visited nodes if destination is found
            }

            for (VertexFromTo entry : graph.getGraph().get(currentVertex)) {
                Vertex adjacentVertex = entry.getTo();
                if (!adjacentVertex.isVisited()){
                    adjacentVertex.setVisited(true);
                    stack.push(adjacentVertex);
                }
            }
        }

        return null; // Return null if no path found
    }



}
