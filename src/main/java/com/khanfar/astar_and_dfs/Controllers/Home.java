package com.khanfar.astar_and_dfs.Controllers;

import com.khanfar.astar_and_dfs.Graph.*;
import com.khanfar.astar_and_dfs.HelloController;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.effect.Light;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

import java.net.URL;
import java.util.*;

import static com.khanfar.astar_and_dfs.HelloController.graph;

public class Home implements Initializable {

    @FXML
    private RadioButton a_Star;

    @FXML
    private ComboBox<String> dest;

    @FXML
    private RadioButton dfs;

    @FXML
    private ScrollPane displayImage;

    @FXML
    private TextField distance;

    @FXML
    private AnchorPane home;

    @FXML
    private TextArea path;

    @FXML
    private ComboBox<String> src;

    @FXML
    void destOnAction(ActionEvent event) {

    }

    @FXML
    void runOnAction(ActionEvent event) {
        path.clear();
        if (a_Star.isSelected()){
            graph.loadDistanceRoads("D:\\Artificial Intelligence\\AStar_And_DFS\\roads.csv");
            graph.loadDistanceAir("D:\\Artificial Intelligence\\AStar_And_DFS\\airDistance.csv" , dest.getValue());
            Astar astar = new Astar(graph) ;
            astar.findShortestPath(src.getValue());

        } else if (dfs.isSelected()) {
            Graph graph1 = new Graph() ;
            graph1.loadDataFromFile("D:\\Artificial Intelligence\\AStar_And_DFS\\cities.csv");
            graph1.loadDistanceRoads("D:\\Artificial Intelligence\\AStar_And_DFS\\roads.csv");
            graph1.loadDistanceAir("D:\\Artificial Intelligence\\AStar_And_DFS\\airDistance.csv" , dest.getValue());

            graph1.resetVisited();

            DFS dfs = new DFS(graph1);
            path.setText(dfs.findPath(src.getValue() , dest.getValue()).toString());

        }

        Vertex srcV = graph.search(src.getValue()) ;
        Vertex DestV = graph.search(dest.getValue()) ;

        String s =  printPath(srcV , DestV);
        if (DestV.getParent().getG_Cost() == Integer.MAX_VALUE) {
            path.setText("no path");
            distance.setText("N/A");

        }
        else {
            path.setText(s);
            distance.setText(DestV.getG_Cost() + "");
        }

        src.setValue(null);
        dest.setValue(null);


    }

    @FXML
    void srcOnAction(ActionEvent event) {

    }
    static Pane pane ;
    static ScrollPane scrollPane ;

    static final int mapWidth = 614, mapHeight = 1141;
    // offsets
    static final double mapLongitudeStart = 33.5, mapLatitudeStart = 33.5;
    // length of map in long/lat
    static final double mapLongitude = 36.5-mapLongitudeStart,
    // invert because it decreases as you go down
    mapLatitude = mapLatitudeStart-29.5;


    private static Point2D getPositionOnScreen(double longitude, double latitude){
        // use offsets
        longitude -= mapLongitudeStart;
        // do inverse because the latitude increases as we go up but the y decreases as we go up.
        // if we didn't do the inverse then all the y values would be negative.
        latitude = mapLatitudeStart-latitude;

        // set x & y using conversion
        int x = (int) (mapWidth*(longitude/mapLongitude));
        int y = (int) (mapHeight*(latitude/mapLatitude));

        return new Point2D(x, y);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        scrollPane = displayImage;

        Image img = null;
        Label label = new Label();
        label.setFont(new Font(40));
        label.setStyle("-fx-text-fill: #b0223b");

        img = new Image("D:\\Artificial Intelligence\\AStar_And_DFS\\palestine2.jpg");



        Canvas canvas = new Canvas(mapWidth, mapHeight);
        pane = new Pane();
        pane.setMaxHeight(mapHeight);
        pane.setMaxWidth(mapWidth);
        pane.getChildren().add(canvas);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        gc.drawImage(img, 0, 0, mapWidth, mapHeight);
        gc.setFill(Color.RED);
        pane.getChildren().add(label);

        for (Vertex vertex : graph.getGraph().keySet()) {

            src.getItems().addAll(vertex.getLabel());
            dest.getItems().addAll(vertex.getLabel());


            Button button = new Button(vertex.getLabel());
            button.setOnAction(e -> {
                if (src.getValue() == null) {
                    src.setValue(button.getText());
                } else if (dest.getValue() == null) {
                    dest.setValue(button.getText());
                }


                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        label.setText(button.getText());
                    }
                });
                System.out.println(button.getText());


            });

            Point2D point2D = getPositionOnScreen(vertex.getLongitude() , vertex.getLatitude());
            // gc.fillOval(x, y, 15, 15);


            button.setLayoutX(point2D.getX());
            button.setLayoutY(point2D.getY());
            button.setStyle(
                    "-fx-background-radius: 5em; " +
                            "-fx-min-width: 7px; " +
                            "-fx-min-height: 7px; " +
                            "-fx-max-width: 7px; " +
                            "-fx-max-height: 7px;" +
                            "-fx-background-color: green"
            );
            pane.getChildren().addAll(button);

        }

        displayImage.setContent(pane);









        ToggleGroup toggleGroup = new ToggleGroup();
        toggleGroup.getToggles().addAll(a_Star , dfs);

    }

    static Vertex  current  ;
    public static  LinkedList<Line> list = new LinkedList<>();
    public static String printPath(Vertex start, Vertex end) {
        current = null ;
        StringBuilder str= new StringBuilder();
        Stack<String> stack = new Stack<>() ;

        try {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    for (Line n : list) {
                        pane.getChildren().removeAll(n);
                        n.setVisible(false);

                    }
                }
            });
            current = end ;
            Vertex prev = current.getParent() ;
            while (prev != null) {
                // str.append("   " + current.getName()  + "  And cost : " + current.getDV() + "----->" + prev.getName()  + "  And cost : " + prev.getDV() +"\n ##################################################\n");
                stack.push("Move from " + prev.getLabel() +" to " + current.getLabel() +"-- " +current.getG_Cost() +"km");

                Point2D point2D = getPositionOnScreen(current.getLongitude() , current.getLatitude());
                current = current.getParent();
                Point2D  point2D1 = getPositionOnScreen(prev.getLongitude() , prev.getLatitude());

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Line line =new Line(point2D.getX() , point2D.getY(), point2D1.getX() , point2D1.getY());
                        line.setFill(Color.RED);
                        line.setStroke(Color.RED);
                        line.setStrokeWidth(5);

                        list.add(line);
                        pane.getChildren().addAll(line );
                        scrollPane.setContent(pane);
                    }
                });
                current = prev;
                prev = current.getParent();

            }



        }
        catch (NullPointerException e ) {
            e.printStackTrace();
        }
        while (!stack.isEmpty()) {
            str.append(stack.pop()+"\n");
        }
        return str.toString() ;

    }
}
