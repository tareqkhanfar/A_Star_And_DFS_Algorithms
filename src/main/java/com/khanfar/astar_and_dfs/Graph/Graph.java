package com.khanfar.astar_and_dfs.Graph;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;

public class Graph {
    private HashMap<Vertex , HashSet<VertexFromTo>> graph = new HashMap<>() ;

/*
    public void configureGraph (String fileName) throws FileNotFoundException {

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

 */
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

    public void loadDataFromFile(String fileName) {
        try {
            Scanner in = new Scanner(new File(fileName));
            in.nextLine();
            String []str ;
            while (in.hasNext()){
                str = in.nextLine().split(",");
                String cityName = str[0];
                double latitude = Double.parseDouble(str[1]);
                double longitude = Double.parseDouble(str[2]);
                Vertex vertex = new Vertex(cityName , longitude , latitude);
                graph.put(vertex , new HashSet<>());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
    public void loadDistanceRoads (String fileName) {
        try {
            Scanner in = new Scanner(new File(fileName));
            in.nextLine();
            String str[] ;
            while (in.hasNext()) {
                str = in.nextLine().split(",");
                String city1 = str[0];
                String city2 = str[1];
                double distance = Double.parseDouble(str[2]);
                graph.get(search(city1)).add(new VertexFromTo(search(city2 ) , distance));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }


    public void loadDistanceAir(String fileName , String dest) {
        /*
        try {
            Scanner in = new Scanner(new File(fileName));
            in.nextLine();
            String str[] ;
            while (in.hasNext()) {
                str = in.nextLine().split(",");

            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

         */
        Vertex vDest = search(dest);

        for (Vertex vertex : graph.keySet()){
            int airDistance = distance(vertex.getLatitude() , vDest.getLatitude() , vertex.getLongitude() , vDest.getLongitude());
            vertex.setH_Cost(airDistance);
        }



    }
    public static int distance(double lat1,
                               double lat2, double lon1,
                               double lon2)
    {

        // The math module contains a function
        // named toRadians which converts from
        // degrees to radians.
        lon1 = Math.toRadians(lon1);
        lon2 = Math.toRadians(lon2);
        lat1 = Math.toRadians(lat1);
        lat2 = Math.toRadians(lat2);

        // Haversine formula
        double dlon = lon2 - lon1;
        double dlat = lat2 - lat1;
        double a = Math.pow(Math.sin(dlat / 2), 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.pow(Math.sin(dlon / 2),2);

        double c = 2 * Math.asin(Math.sqrt(a));

        // Radius of earth in kilometers. Use 3956
        // for miles
        double r = 6371;

        // calculate the result
        return (int) (c * r);
    }


}
