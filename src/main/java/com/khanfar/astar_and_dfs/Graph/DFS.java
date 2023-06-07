package com.khanfar.astar_and_dfs.Graph;

import java.util.*;

import com.khanfar.astar_and_dfs.Graph.* ;


public class DFS {

    private Graph graph ;

    public DFS (Graph graph) {
        this.graph = graph;
    }



    public List<Vertex> findPath(String src, String dest) {
        Vertex startVertex = graph.search(src);
        Vertex endVertex = graph.search(dest);

        if (startVertex == null || endVertex == null) {
            return null; // Return null if start or end vertex doesn't exist
        }

        Stack<Vertex> stack = new Stack<>();
        HashMap<Vertex, Vertex> pathMap = new HashMap<>();
        startVertex.setVisited(true);
        stack.push(startVertex);

        while (!stack.isEmpty()) {
            Vertex currentVertex = stack.pop();

            if (currentVertex.getLabel().equals(dest)) {
                // Trace back the path from the destination to the source
                List<Vertex> path = new LinkedList<>();
                for (Vertex v = endVertex; v != null; v = pathMap.get(v)) {
                    path.add(0, v);
                }
                return path;
            }

            for (VertexFromTo entry : graph.getGraph().get(currentVertex)) {
                Vertex adjacentVertex = entry.getTo();
                if (!adjacentVertex.isVisited()){
                    adjacentVertex.setVisited(true);
                    pathMap.put(adjacentVertex, currentVertex); // Store the predecessor
                    stack.push(adjacentVertex);
                }
            }
        }

        return null; // Return null if no path found
    }

    public double  findCostByPath(List<Vertex> path) {
        double cost = 0 ;
        for (int i = 0 ;i < path.size()-1 ; i++) {
          cost+= costBetweenTwoCities(path.get(i) , path.get(i+1));
        }
        return cost;

    }
    private double costBetweenTwoCities (Vertex v1 , Vertex v2 ) {
        double cost = 0;
        HashSet<VertexFromTo> adjacent = graph.getGraph().get(v1);
        for (VertexFromTo vertex : adjacent){
            if (vertex.getTo().getLabel().equals(v2.getLabel())){
                cost = vertex.getCost();
                return cost;
            }
        }
        return cost;

    }





}
