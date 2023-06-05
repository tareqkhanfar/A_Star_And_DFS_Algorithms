package com.khanfar.astar_and_dfs.Graph;

import java.util.*;

public class Astar {
private HashMap <Vertex , HashSet<VertexFromTo>> graph = new HashMap<>() ;


public Astar (HashMap<Vertex , HashSet<VertexFromTo>> graph) {
    this.graph = graph ;
}
public Astar() {

}

public void configureGraph () {
    Vertex A = new Vertex("A" , 6) ;
    Vertex S = new Vertex("S" , 7) ;
    Vertex B = new Vertex("B" , 4) ;
    Vertex C = new Vertex("C" , 2) ;
    Vertex G = new Vertex("G" , 0) ;

    HashSet<VertexFromTo> set1 = new HashSet<>() ;
    set1.add(new VertexFromTo(B , 2) ) ;
    set1.add(new VertexFromTo(G , 12) ) ;
    set1.add(new VertexFromTo(C , 5) ) ;



    graph.put(A , set1) ;


    HashSet<VertexFromTo> set2 = new HashSet<>() ;
    set2.add(new VertexFromTo(A , 1) ) ;
    set2.add(new VertexFromTo(B , 4) ) ;
    graph.put(S , set2) ;


    HashSet<VertexFromTo> set3 = new HashSet<>() ;

    set3.add(new VertexFromTo(C , 2) ) ;
    graph.put(B , set3) ;

    HashSet<VertexFromTo> set4 = new HashSet<>() ;

    set4.add(new VertexFromTo(G, 3) ) ;
    graph.put(C, set4) ;

    graph.put(G , new HashSet<>());




}
public void printGraph () {
    for (Map.Entry<Vertex , HashSet<VertexFromTo>> entry  :this.graph.entrySet()) {
        System.out.println(entry.getKey());
    }
}

public void printPath (Vertex dest) {
    dest = search("G");
    Stack<Vertex> stack = new Stack<>() ;

Vertex current = dest ;

while (current != null) {
stack.push(current) ;
current = current.getParent() ;
}
while (!stack.isEmpty()){
    System.out.println(stack.pop().getLabel());
}
}



public void findShortestPath (String src) {
    PriorityQueue<Vertex> heap = new PriorityQueue<>();

    Vertex s = search(src);
    s.setG_Cost(0);
    heap.add(s);

   // System.out.println(search(src).toString());



   while (!heap.isEmpty()) {
       Vertex vertex = heap.poll();
       if (vertex == null) {
           break;
       }
       vertex.setVisited(true);
       for ( VertexFromTo u : graph.get(vertex)) {
           Vertex w = u.getTo() ;

                  if (!w.isVisited()) {

                          if ( vertex.getG_Cost() + u.getCost() + w.getH_Cost() < w.getF_Cost()) {
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


    public void setGraph(HashMap<Vertex, HashSet<VertexFromTo>> graph) {
        this.graph = graph;
    }
    public HashMap<Vertex, HashSet<VertexFromTo>> getGraph() {
        return graph;
    }
}
