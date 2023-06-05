package com.khanfar.astar_and_dfs;

import com.khanfar.astar_and_dfs.Graph.Astar;
import com.khanfar.astar_and_dfs.Graph.Vertex;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Astar astar = new Astar() ;
        astar.configureGraph();
        astar.findShortestPath("S");
     //   astar.printGraph();
        astar.printPath(new Vertex());

        // launch();
    }
}