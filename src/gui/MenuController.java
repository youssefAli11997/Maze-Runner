package gui;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

import game_engine.Game;
import game_engine.GameEngine;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class MenuController {

    @FXML
    private Pane mainPane;

    @FXML
    private HBox mainHbox;

    @FXML
    private VBox menuVbox;
    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private double windowWidth = screenSize.getWidth(), windowHeight = screenSize.getHeight();
    private MediaPlayer mediaPlayer;

    @FXML
    void initialize() {
        mainPane.setPrefSize(windowWidth, windowHeight);
        mainHbox.setPrefSize(windowWidth, windowHeight);
        menuVbox.setPrefSize(windowWidth, windowHeight);

        String bip = "src/assets/sound/Forest of Forgetfulness.mp3";
     /*   Media hit = new Media(new File(bip).toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();*/
    }

    @FXML
    private void onButtonsHover(MouseEvent e) {
        Button button = (Button) e.getSource();
        double width = button.getPrefWidth();
        double height = button.getPrefHeight();

        button.setPrefWidth(width + 20);
        button.setPrefHeight(height + 7);
        //TODO set margin
    }

    @FXML
    void onButtonsLeave(MouseEvent e) {
        Button button = (Button) e.getSource();
        double width = button.getPrefWidth();
        double height = button.getPrefHeight();

        button.setPrefWidth(width - 20);
        button.setPrefHeight(height - 7);
    }

    @FXML
    void onStartNewGame() throws IOException {
        Stage stage = new Stage();
        GameEngine.getInstance(5,5);
        Parent root = FXMLLoader.load(getClass().getResource("game_layout.fxml"));
        stage.setTitle("Maze Runner");
        String css = this.getClass().getResource("game_style.css").toExternalForm();
        root.getStylesheets().add(css);
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setMaximized(true);
        //stage.initStyle(StageStyle.UNDECORATED);
        /*mediaPlayer.stop();
        mediaPlayer = null;*/

        GameEngine.addKeyListeners(root.getScene());

        stage.show();
        Main.menu.close();
    }

    @FXML
    void onExitClick() {
        Main.menu.close();
    }

}
