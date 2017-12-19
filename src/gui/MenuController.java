package gui;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.LinkedList;

import characters.PlayerImageFactory;
import characters.players.Player;
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
    private RadioButton rbSurvival;

    @FXML
    private RadioButton rbRush;

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
    private Button continueBtn;

    @FXML
    private ImageView playerImageView;

    private Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private double windowWidth = screenSize.getWidth(), windowHeight = screenSize.getHeight();
    private MediaPlayer mediaPlayer;
    private ToggleGroup diffToggleGroup, modeToggleGroup;
    private LinkedList<String> images = new LinkedList<>();
    private int imageIndex;
    public static String playerImage = "person";
    public static Stage gameStage;
    private static Button ourContinueBtn;
    public static String mode, diff;

    @FXML
    void initialize() {
        mainHbox.getChildren().remove(settingsVbox);

        mainPane.setPrefSize(windowWidth, windowHeight);
        mainHbox.setPrefSize(windowWidth, windowHeight);
        menuVbox.setPrefSize(windowWidth, windowHeight);

        ourContinueBtn = continueBtn;

        diffToggleGroup = new ToggleGroup();
        rbEasy.setToggleGroup(diffToggleGroup);
        rbMedium.setToggleGroup(diffToggleGroup);
        rbHard.setToggleGroup(diffToggleGroup);

        rbEasy.setUserData("easy");
        rbMedium.setUserData("medium");
        rbHard.setUserData("hard");
        diff = "easy";
        
        rbEasy.setSelected(true);

        modeToggleGroup = new ToggleGroup();
        rbSurvival.setToggleGroup(modeToggleGroup);
        rbRush.setToggleGroup(modeToggleGroup);

        rbSurvival.setUserData("survival");
        rbRush.setUserData("rush");

        rbRush.setSelected(true);
        mode = "rush";
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
        gameStage = new Stage();
        GameEngine.getInstance(diff , mode ,10,10);
        Player.getInstance().addObserver(GameEngine.getInstance());
        Parent root = FXMLLoader.load(getClass().getResource("game_layout.fxml"));
        gameStage.setTitle("Maze Runner");
        String css = this.getClass().getResource("game_style.css").toExternalForm();
        root.getStylesheets().add(css);
        gameStage.setScene(new Scene(root));
        gameStage.setResizable(false);
        gameStage.setMaximized(true);
        gameStage.initStyle(StageStyle.UNDECORATED);
        /*mediaPlayer.stop();
        mediaPlayer = null;*/

        GameEngine.addKeyListeners(root.getScene());

        ourContinueBtn.setDisable(false);
        gameStage.show();
        Main.menu.hide();
    }

    @FXML
    void onHighScore() {

    }

    @FXML
    void onSettingsClick(){
        mainHbox.getChildren().remove(menuVbox);
        mainHbox.getChildren().add(settingsVbox);
    }


    @FXML
    void onLoadClick() {

    }

    @FXML
    void onSaveClick() {

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
    void onLoadImageClick() {

    }

    @FXML
    void onApplyClick() {
        mainHbox.getChildren().remove(settingsVbox);
        mainHbox.getChildren().add(menuVbox);
        //TODO set difficulty
        playerImage = images.get(imageIndex);
        mode = modeToggleGroup.getSelectedToggle().getUserData().toString();
        diff = diffToggleGroup.getSelectedToggle().getUserData().toString();
        System.out.println("mode " + mode + " diff " + diff);
    }

    public static void disableContinue(){
        ourContinueBtn.setDisable(true);
    }

    @FXML
    void onContinueGame (){
        Player.getInstance().setPlayerImage(playerImage);
        Main.menu.hide();
        gameStage.show();
    }

}
