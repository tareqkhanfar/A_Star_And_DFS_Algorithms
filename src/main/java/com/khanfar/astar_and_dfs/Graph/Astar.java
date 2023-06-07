package com.khanfar.astar_and_dfs.Graph;

import java.util.*;

public class Astar {
private HashMap <Vertex , HashSet<VertexFromTo>> graph ;

    public Astar(Graph graph) {
        this.graph = graph.getGraph();
    }




public String printPath (String dest) {
    Vertex Vertexdest = search(dest);
    Stack<Vertex> stack = new Stack<>() ;

Vertex current = Vertexdest ;
    StringBuilder builder = new StringBuilder();
    builder.append(dest+"-->");

while (current != null) {
stack.push(current) ;
current = current.getParent() ;
}
while (!stack.isEmpty()){
    builder.append(stack.pop().getLabel()+"-->");
    System.out.println("A * "+stack.pop().getLabel());
}
return builder.toString();

}



public void findShortestPath (String src) {
    PriorityQueue<Vertex> heap = new PriorityQueue<>();

    Vertex s = search(src);
    s.setG_Cost(0);
    heap.add(s);




   while (!heap.isEmpty()) {
       Vertex vertex = heap.poll();
       if (vertex == null) {
           break;
       }
       vertex.setVisited(true);
       for ( VertexFromTo u : graph.get(vertex)) {
           Vertex w = u.getTo() ;

                  if (!w.isVisited()) {

                          if (vertex.getG_Cost() + u.getCost() + w.getH_Cost() < w.getF_Cost()) {
                              w.setF_Cost(vertex.getG_Cost() + u.getCost() + w.getH_Cost());
                              w.setG_Cost(vertex.getG_Cost() + u.getCost());
                              w.setParent(vertex);
                              heap.add(w);
                          }

           }
       }
   }

}

    private Vertex search(String src) {
        for (Map.Entry<Vertex , HashSet<VertexFromTo>> entry  :this.graph.entrySet()) {
            if (src.equals(entry.getKey().getLabel())){
                return entry.getKey();
            }
        }
        return null;
    }



}
