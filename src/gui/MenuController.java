package gui;


import java.awt.Dimension;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

import cells.Cell;
import cells.FlyweightFactory;
import characters.PlayerImageFactory;
import characters.players.Player;
import game_engine.GameEngine;
import game_engine.scoreBoard.ScoreBoard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
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
    private TextField assetType;

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
    public static Stage primaryStage;
    private String LoadableImage = null;

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
        /*mediaPlayer = new MediaPlayer(hit);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();*/

        initImages();
    }

    private void initImages() {
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
        GameEngine.getInstance(diff, mode, 10, 10);
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
        mainHbox.getChildren().remove(menuVbox);

        LinkedHashMap<String, Double> rushScore =
                (LinkedHashMap<String, Double>) ScoreBoard.getInstance().getRushScoreBoard();

        LinkedHashMap<String, Double> survivalScore =
                (LinkedHashMap<String, Double>) ScoreBoard.getInstance().getSurvivalScoreBoard();

        GridPane rushGridPane = new GridPane();
        GridPane survivalGridPane = new GridPane();


        Label rushLbl = new Label("RUSH MODE");
        Label survivalLbl = new Label("SURVIVAL MODE");

        rushLbl.getStyleClass().add("score-lbl");
        survivalLbl.getStyleClass().add("score-lbl");

        VBox.setMargin(rushLbl, new Insets(0, 0, 20, 0));
        VBox.setMargin(survivalLbl, new Insets(0, 0, 20, 0));

        rushGridPane.addColumn(0);
        rushGridPane.addColumn(1);

        survivalGridPane.addColumn(0);
        survivalGridPane.addColumn(1);

        fillGridPane(rushScore, rushGridPane);
        fillGridPane(survivalScore, survivalGridPane);

        VBox rushVBox = new VBox(rushLbl, rushGridPane);
        VBox survivalVBox = new VBox(survivalLbl, survivalGridPane);

        rushVBox.getStyleClass().add("score-vbox");
        survivalVBox.getStyleClass().add("score-vbox");

        rushVBox.setAlignment(Pos.TOP_CENTER);
        survivalVBox.setAlignment(Pos.TOP_CENTER);

        HBox hBox = new HBox(rushVBox, survivalVBox);
        hBox.setAlignment(Pos.TOP_CENTER);
        hBox.setSpacing(100);

        javafx.scene.control.Label title = new Label("HIGH SCORES");
        title.getStyleClass().add("score-title");
        VBox.setMargin(title, new Insets(0, 0, 20, 0));

        Button back = new Button("BACK");
        back.setMinWidth(200);
        VBox.setMargin(back, new Insets(20, 0, 0, 0));

        VBox mainScoreVBox = new VBox(title, hBox, back);
        mainScoreVBox.setAlignment(Pos.CENTER);

        back.getStyleClass().add("menu-button");
        back.setOnAction(event -> {
            mainHbox.getChildren().remove(mainScoreVBox);
            mainHbox.getChildren().add(menuVbox);
        });

        mainHbox.getChildren().add(mainScoreVBox);
    }

    private void fillGridPane(LinkedHashMap<String, Double> map, GridPane gridPane) {
        int index = 0;
        for (Map.Entry<String, Double> entry : map.entrySet()) {
            Label name = new Label(entry.getKey());
            Label score = new Label(String.format("%.2f", entry.getValue()));

            name.getStyleClass().add("score");
            score.getStyleClass().add("score");

            gridPane.addRow(index);
            gridPane.add(name, 0, index);
            gridPane.add(score, 1, index);
            index++;
        }
    }

    private

    @FXML
    void onSettingsClick() {
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
        if (imageIndex >= 1) {
            imageIndex--;
            playerImageView.setImage(PlayerImageFactory.setImage(images.get(imageIndex)));
            playerImageView.setViewport(new Rectangle2D(0, 140, 70, 70));
        }
    }

    @FXML
    void onNextClick() {
        //TODO if index > 3 so it's imported image

        if (imageIndex < images.size() - 1) {
            imageIndex++;
            playerImageView.setImage(PlayerImageFactory.setImage(images.get(imageIndex)));
            playerImageView.setViewport(new Rectangle2D(0, 140, 70, 70));
        }
    }

    @FXML
    void onAssetBrowse() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new ExtensionFilter("Images only ..", "*.jpg", "*.png"));
        fileChooser.setTitle("Open Resource File");
        File file = fileChooser.showOpenDialog(primaryStage);
        String path = file.getAbsolutePath(); // path you can take it in a String member to use it
        LoadableImage = path;
    }

    @FXML
    void onAssetApply() {
        String type = assetType.getText();
        if (!type.equals("")) { // this checks empty you may handle invalid type !!!
            Cell cell = FlyweightFactory.create(type);
            if (cell != null) {
                if (LoadableImage != null) {
                    cell.load(new Image(new File(LoadableImage).toURI().toString(), 70, 70, false, false));
                }
            }
            if (!continueBtn.isDisable()) {
                GameController.initMaze();
            }
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

    public static void disableContinue() {
        ourContinueBtn.setDisable(true);
    }

    @FXML
    void onContinueGame() {
        Player.getInstance().setPlayerImage(playerImage);
        Main.menu.hide();
        GameEngine.togglePaused();
        gameStage.show();
    }

}
