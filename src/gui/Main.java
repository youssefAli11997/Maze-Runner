package gui;

import game_engine.GameEngine;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.SyncFailedException;

/**
 * Created by M.Sharaf on 09/12/2017.
 */

public class Main extends Application {
    public static Stage menu;

    GameEngine gameEngine;

    @Override
    public void start(Stage primaryStage) throws Exception{
        menu = primaryStage;
        Parent root = FXMLLoader.load(getClass().getResource("menu_layout.fxml"));
        primaryStage.setMaximized(true);
        primaryStage.setTitle("Maze Runner");
        String css = this.getClass().getResource("menu_style.css").toExternalForm();
        root.getStylesheets().add(css);

        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {

            }
        });

        gameEngine = new GameEngine(30,30);

        root.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println(event.getCode());
                if(event.getCode().equals(KeyCode.SPACE)){
                    gameEngine.activateFireMode();
                    System.out.println("H: " + event.getCode());
                }
                else {
                    gameEngine.setCurrentCommand(event.getCode().toString());
                }
            }
        });

        root.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                System.out.println("sap: " + event.getCode());
                if(event.getCode().equals(KeyCode.SPACE)){
                    gameEngine.activateFireMode();
                    System.out.println("H: " + event.getCode());
                }
                gameEngine.setCurrentCommand("released");
            }
        });

        primaryStage.setScene(new Scene(root));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
