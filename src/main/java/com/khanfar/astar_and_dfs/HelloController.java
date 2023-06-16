package com.khanfar.astar_and_dfs;

import com.khanfar.astar_and_dfs.Graph.Graph;
import com.khanfar.astar_and_dfs.Graph.Vertex;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HelloController {
    public static  String  FILE_NAME ;
    public static Graph graph = new Graph();


    @FXML
    void HuristicOnAction(ActionEvent event) {
        StringBuilder builder = new StringBuilder() ;
        for (Vertex vertex : graph.getGraph().keySet()) {
            for (Vertex vertex1 : graph.getGraph().keySet()) {
                int distance = Graph.distance(vertex.getLatitude() , vertex1.getLatitude() , vertex.getLongitude() , vertex1.getLongitude());
                builder.append(vertex.getLabel()+","+vertex1.getLabel()+","+distance+"\n");
            }
        }
        printHuristicValueToFile(builder);
    }

    public void printHuristicValueToFile(StringBuilder stringBuilder) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("airDistance.csv"))) ;
            bufferedWriter.write(stringBuilder.toString()  , 0 , stringBuilder.length());
            bufferedWriter.flush();
            bufferedWriter.close();
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("Data Saved Sucsessfully   ");
            // show the dialog
            a.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void readfileOnAction(ActionEvent event) {

        FileChooser fileChooser = new FileChooser()  ;
        File file = fileChooser.showOpenDialog(new Stage());
        if (file != null) {
            FILE_NAME =  file.getAbsolutePath();
            graph.loadDataFromFile(FILE_NAME);

            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("read file is ok    ");
            // show the dialog
            a.show();
        }
    }

    @FXML
    void startOnAction(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent parent = fxmlLoader.load();

        Scene scene = new Scene(parent);
       scene.getStylesheets().addAll(HelloApplication.class.getResource("home.css").toExternalForm());
        Stage stage = new Stage() ;
        stage.setTitle("shortest path !");
        stage.setScene(scene);
        stage.show();
    }

}
