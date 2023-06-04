package com.khanfar.astar_and_dfs.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

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
    set1.add(new VertexFromTo(B , 10) ) ;
    set1.add(new VertexFromTo(G , 12) ) ;


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

    graph.put(G , null);




}
public void printGraph () {
    for (Map.Entry<Vertex , HashSet<VertexFromTo>> entry  :this.graph.entrySet()) {
           Vertex vertex = entry.getKey() ;
        System.out.print(vertex.getLabel() + ":  ");
        HashSet<VertexFromTo> vertexFromToSetEntry = entry.getValue();

        if (vertexFromToSetEntry != null) {


            for (VertexFromTo vertexFromTo : vertexFromToSetEntry) {
                System.out.print(vertexFromTo.getTo().getLabel() + "  ");
            }
        }
        System.out.println();
    }
}

    public void setGraph(HashMap<Vertex, HashSet<VertexFromTo>> graph) {
        this.graph = graph;
    }
    public HashMap<Vertex, HashSet<VertexFromTo>> getGraph() {
        return graph;
    }
}
