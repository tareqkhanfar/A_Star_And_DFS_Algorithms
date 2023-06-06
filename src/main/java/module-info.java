module com.khanfar.astar_and_dfs {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.khanfar.astar_and_dfs to javafx.fxml;
    exports com.khanfar.astar_and_dfs;

    opens com.khanfar.astar_and_dfs.Controllers to javafx.fxml;
    exports com.khanfar.astar_and_dfs.Controllers;
}