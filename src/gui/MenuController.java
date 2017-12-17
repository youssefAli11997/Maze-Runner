package gui;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import characters.PlayerImageFactory;
import characters.players.Player;
import game_engine.Game;
import game_engine.GameEngine;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.ImageView;
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

    @FXML
    private VBox settingsVbox;

    @FXML
    private RadioButton rbEasy;

    @FXML
    private RadioButton rbMedium;

    @FXML
    private RadioButton rbHard;

    @FXML
    private Button imgPrev;

    @FXML
    private Button imgNext;

    @FXML
    private ImageView playerImageView;

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private double windowWidth = screenSize.getWidth(), windowHeight = screenSize.getHeight();
    private MediaPlayer mediaPlayer;
    private ToggleGroup toggleGroup;
    private LinkedList<String> images = new LinkedList<>();
    private int imageIndex;
    public static String playerImage = "person";

    @FXML
    void initialize() {
        mainHbox.getChildren().remove(settingsVbox);

        mainPane.setPrefSize(windowWidth, windowHeight);
        mainHbox.setPrefSize(windowWidth, windowHeight);
        menuVbox.setPrefSize(windowWidth, windowHeight);

        toggleGroup = new ToggleGroup();
        rbEasy.setToggleGroup(toggleGroup);
        rbMedium.setToggleGroup(toggleGroup);
        rbHard.setToggleGroup(toggleGroup);

        rbEasy.setUserData("easy");
        rbMedium.setUserData("medium");
        rbHard.setUserData("hard");

        rbEasy.setSelected(true);

        String bip = "src/assets/sound/Forest of Forgetfulness.mp3";
        Media hit = new Media(new File(bip).toURI().toString());
        mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

        initImages();
    }

    private void initImages (){
        images.add("person");
        images.add("horse");
        images.add("dragon");
        images.add("chicken");

        playerImageView.setImage(PlayerImageFactory.setImage("person"));
        playerImageView.setViewport(new Rectangle2D(0, 140, 70, 70));
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
        GameEngine.getInstance(10,10);
        Parent root = FXMLLoader.load(getClass().getResource("game_layout.fxml"));
        stage.setTitle("Maze Runner");
        String css = this.getClass().getResource("game_style.css").toExternalForm();
        root.getStylesheets().add(css);
        stage.setScene(new Scene(root));
        stage.setResizable(false);
        stage.setMaximized(true);
        stage.initStyle(StageStyle.UNDECORATED);
        mediaPlayer.stop();
        mediaPlayer = null;

        GameEngine.addKeyListeners(root.getScene());

        stage.show();
        Main.menu.close();
    }

    @FXML
    void onSettingsClick(){
        mainHbox.getChildren().remove(menuVbox);
        mainHbox.getChildren().add(settingsVbox);
    }

    @FXML
    void onExitClick() {
        Main.menu.close();
    }

    @FXML
    void onPrevClick() {
        if (imageIndex >= 1){
            imageIndex--;
            playerImageView.setImage(PlayerImageFactory.setImage(images.get(imageIndex)));
            playerImageView.setViewport(new Rectangle2D(0, 140, 70, 70));
        }
    }

    @FXML
    void onNextClick() {
        //TODO if index > 3 so it's imported image

        if (imageIndex < images.size() - 1){
            imageIndex++;
            playerImageView.setImage(PlayerImageFactory.setImage(images.get(imageIndex)));
            playerImageView.setViewport(new Rectangle2D(0, 140, 70, 70));
        }
    }

    @FXML
    void onApplyClick() {
        mainHbox.getChildren().remove(settingsVbox);
        mainHbox.getChildren().add(menuVbox);
        //TODO set difficulty
        playerImage = images.get(imageIndex);
    }

}
