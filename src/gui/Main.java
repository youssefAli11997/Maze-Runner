package gui;

import org.apache.log4j.BasicConfigurator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * Created by M.Sharaf on 09/12/2017.
 */

public class Main extends Application {
    public static Stage menu;

    @Override
    public void start(Stage primaryStage) throws Exception{
        menu = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("menu_layout.fxml"));
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Maze Runner");
        String css = this.getClass().getResource("menu_style.css").toExternalForm();
        root.getStylesheets().add(css);

        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
        MenuController.primaryStage = primaryStage;
    }

    public static void main(String[] args) {
    	BasicConfigurator.configure();
        launch(args);
    }
}
