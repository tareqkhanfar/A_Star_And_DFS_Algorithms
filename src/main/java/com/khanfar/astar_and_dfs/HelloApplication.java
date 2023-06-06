package com.khanfar.astar_and_dfs;

import com.khanfar.astar_and_dfs.Graph.Astar;
import com.khanfar.astar_and_dfs.Graph.DFS;
import com.khanfar.astar_and_dfs.Graph.Graph;
import com.khanfar.astar_and_dfs.Graph.Vertex;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("start.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws FileNotFoundException {

        /*
        Graph graph = new Graph();
        graph.loadDataFromFile("D:\\Artificial Intelligence\\AStar_And_DFS\\cities.csv");
        graph.loadDistanceRoads("D:\\Artificial Intelligence\\AStar_And_DFS\\roads.csv");
        graph.loadDistanceAir("D:\\Artificial Intelligence\\AStar_And_DFS\\airDistance.csv" , "Nablus");
        Astar astar = new Astar(graph) ;
        astar.findShortestPath("Ramallah");
     //   astar.printGraph();
        astar.printPath("Nablus");


        Graph graph1 = new Graph() ;
        graph1.loadDataFromFile("D:\\Artificial Intelligence\\AStar_And_DFS\\cities.csv");
        graph1.loadDistanceRoads("D:\\Artificial Intelligence\\AStar_And_DFS\\roads.csv");
        graph1.loadDistanceAir("D:\\Artificial Intelligence\\AStar_And_DFS\\airDistance.csv" , "Nablus");

        DFS dfs = new DFS(graph1);
        System.out.println(dfs.findPath("Ramallah" , "Nablus"));


         */
         launch();
    }
}