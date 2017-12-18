package gui;

import characters.players.Player;
import game_engine.GameEngine;
import game_engine.scoreBoard.ScoreBoard;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * Created by M.Sharaf on 18/12/2017.
 */
public class WinController {

    @FXML
    private Label score;

    @FXML
    private TextField playerName;

    @FXML
    void initialize() {
        score.setText("SCORE : " + Player.getInstance().getScore());
    }

    @FXML
    void onSubmitClick() throws IOException {
        if (!playerName.getText().equals("")) {
            ScoreBoard.getInstance().addScore(MenuController.mode , playerName.getText(), (double) Player.getInstance().getScore());

            MenuController.gameStage.close();
            GameEngine.getInstance().winStage.close();
            MenuController.disableContinue();
            Main.menu.show();
        }
    }
}
