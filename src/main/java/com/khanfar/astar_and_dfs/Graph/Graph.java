package com.khanfar.astar_and_dfs.Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Graph {
    private HashMap<Vertex , HashSet<VertexFromTo>> graph = new HashMap<>() ;


    public void configureGraph (String fileName) {
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

    public HashMap<Vertex, HashSet<VertexFromTo>> getGraph() {
        return graph;
    }

    public void setGraph(HashMap<Vertex, HashSet<VertexFromTo>> graph) {
        this.graph = graph;
    }
    public Vertex search(String src) {
        for (Map.Entry<Vertex , HashSet<VertexFromTo>> entry  :this.graph.entrySet()) {
            if (src.equals(entry.getKey().getLabel())){
                return entry.getKey();
            }
        }
        return null;
    }

}
