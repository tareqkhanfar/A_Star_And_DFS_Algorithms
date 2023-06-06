package com.khanfar.astar_and_dfs;

import com.khanfar.astar_and_dfs.Graph.Graph;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class HelloController {
    public static  String  FILE_NAME ;
    public static Graph graph = new Graph();


    @FXML
    void generateEdgesOnAction(ActionEvent event) {

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
       //scene.getStylesheets().addAll(HelloApplication.class.getResource("style.css").toExternalForm());
        Stage stage = new Stage() ;
        stage.setTitle("shortest path !");
        stage.setScene(scene);
        stage.show();
    }

}
