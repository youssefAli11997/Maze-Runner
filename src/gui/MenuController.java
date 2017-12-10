package gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuController {

	public String choosenLevel;
	public String playerName;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private Canvas canvas;

	@FXML
	private VBox mainMenuView;

	@FXML
	private Button startButtonId;

	@FXML
	private Button highScoreButtonId;

	@FXML
	private Button uploadImagesId;

	@FXML
	private Button loadButtonId;

	@FXML
	private Button quitButtonId;

	@FXML
	private VBox startGameView;

	@FXML
	private Label nameLabelId;

	@FXML
	private TextField nameAreaId;

	@FXML
	private Label selectlevelLabelId;

	@FXML
	private ToggleGroup groupOfRadioButtons;

	@FXML
	private RadioButton easyId;

	@FXML
	private RadioButton mediumId;

	@FXML
	private RadioButton hardId;

	@FXML
	private Button goBackFromSelectLevelView;

	@FXML
	private Button continueToGameId;

	@FXML
	private VBox quitView;

	@FXML
	private Label areYouSureId;

	@FXML
	private Button yesId;

	@FXML
	private Button noId;

	@FXML
	private VBox uploadView;

	@FXML
	private Label treeId;

	@FXML
	private Button uploadTreeId;

	@FXML
	private Label bombId;

	@FXML
	private Button uploadBombId;

	@FXML
	private Button goBackFromUpload;

	@FXML
	void getGameLevelEasy(ActionEvent event) {
		choosenLevel = "Easy";
		mediumId.setSelected(false);
		hardId.setSelected(false);
	}

	@FXML
	void getGameLevelMedium(ActionEvent event) {
		choosenLevel = "Medium";
		easyId.setSelected(false);
		hardId.setSelected(false);
	}

	@FXML
	void getGameLevelHard(ActionEvent event) {
		choosenLevel = "Hard";
		easyId.setSelected(false);
		mediumId.setSelected(false);
	}

	@FXML
	void getPlayerName(ActionEvent event) {
		playerName = nameAreaId.getText();
	}

	@FXML
	void goBackToMainViewFromSelectLevelView(ActionEvent event) {
		startGameView.setVisible(false);
		mainMenuView.setVisible(true);
		nameAreaId.clear();
	}

	@FXML
	void goToDetermineLevelView(ActionEvent event) {
		mainMenuView.setVisible(false);
		startGameView.setVisible(true);
	}

	@FXML
	void goToGameView(ActionEvent event) {
		// TODO go to game page
	}

	@FXML
	void goToLoadGameView(ActionEvent event) {
		// TODO go to load game view
	}

	@FXML
	void goToQuitView(ActionEvent event) {
		mainMenuView.setVisible(false);
		quitView.setVisible(true);
	}

	@FXML
	void goToUploadImagesView(ActionEvent event) {
		mainMenuView.setVisible(false);
		uploadView.setVisible(true);
	}

	@FXML
	void gobackToMainViewFromUpload(ActionEvent event) {
		uploadView.setVisible(false);
		mainMenuView.setVisible(true);
	}

	@FXML
	void quitTheGame(ActionEvent event) {
		Stage stage = (Stage) quitButtonId.getScene().getWindow();
		stage.close();
	}

	@FXML
	void returnToTheGameFromQuitView(ActionEvent event) {
		quitView.setVisible(false);
		mainMenuView.setVisible(true);
	}

	@FXML
	void showHighScore(ActionEvent event) {
		// TODO go to high score view
	}

	@FXML
	void uploadBombImage(ActionEvent event) {
		// TODO upload image
	}

	@FXML
	void uploadTreeImage(ActionEvent event) {
		// TODO upload Image
	}

	@FXML
	void initialize() {
		assert canvas != null : "fx:id=\"canvas\" was not injected: check your FXML file 'layout.fxml'.";
		assert mainMenuView != null : "fx:id=\"startButtonEffect\" was not injected: check your FXML file 'layout.fxml'.";
		assert startButtonId != null : "fx:id=\"startButtonId\" was not injected: check your FXML file 'layout.fxml'.";
		assert highScoreButtonId != null : "fx:id=\"highScoreButtonId\" was not injected: check your FXML file 'layout.fxml'.";
		assert uploadImagesId != null : "fx:id=\"uploadImagesId\" was not injected: check your FXML file 'layout.fxml'.";
		assert loadButtonId != null : "fx:id=\"loadButtonId\" was not injected: check your FXML file 'layout.fxml'.";
		assert quitButtonId != null : "fx:id=\"quitButtonId\" was not injected: check your FXML file 'layout.fxml'.";
		assert startGameView != null : "fx:id=\"startGameView\" was not injected: check your FXML file 'layout.fxml'.";
		assert nameLabelId != null : "fx:id=\"nameLabelId\" was not injected: check your FXML file 'layout.fxml'.";
		assert nameAreaId != null : "fx:id=\"nameAreaId\" was not injected: check your FXML file 'layout.fxml'.";
		assert selectlevelLabelId != null : "fx:id=\"selectlevelLabelId\" was not injected: check your FXML file 'layout.fxml'.";
		assert groupOfRadioButtons != null : "fx:id=\"groupOfRadioButtons\" was not injected: check your FXML file 'layout.fxml'.";
		assert easyId != null : "fx:id=\"easyId\" was not injected: check your FXML file 'layout.fxml'.";
		assert mediumId != null : "fx:id=\"mediumId\" was not injected: check your FXML file 'layout.fxml'.";
		assert hardId != null : "fx:id=\"hardId\" was not injected: check your FXML file 'layout.fxml'.";
		assert goBackFromSelectLevelView != null : "fx:id=\"goBackFromSelectLevelView\" was not injected: check your FXML file 'layout.fxml'.";
		assert continueToGameId != null : "fx:id=\"continueToGameId\" was not injected: check your FXML file 'layout.fxml'.";
		assert quitView != null : "fx:id=\"quitView\" was not injected: check your FXML file 'layout.fxml'.";
		assert areYouSureId != null : "fx:id=\"areYouSureId\" was not injected: check your FXML file 'layout.fxml'.";
		assert yesId != null : "fx:id=\"yesId\" was not injected: check your FXML file 'layout.fxml'.";
		assert noId != null : "fx:id=\"noId\" was not injected: check your FXML file 'layout.fxml'.";
		assert uploadView != null : "fx:id=\"uploadView\" was not injected: check your FXML file 'layout.fxml'.";
		assert treeId != null : "fx:id=\"treeId\" was not injected: check your FXML file 'layout.fxml'.";
		assert uploadTreeId != null : "fx:id=\"uploadTreeId\" was not injected: check your FXML file 'layout.fxml'.";
		assert bombId != null : "fx:id=\"bombId\" was not injected: check your FXML file 'layout.fxml'.";
		assert uploadBombId != null : "fx:id=\"uploadBombId\" was not injected: check your FXML file 'layout.fxml'.";
		assert goBackFromUpload != null : "fx:id=\"goBackFromUpload\" was not injected: check your FXML file 'layout.fxml'.";

		// set radio buttons
		easyId.setToggleGroup(groupOfRadioButtons);
		mediumId.setToggleGroup(groupOfRadioButtons);
		hardId.setToggleGroup(groupOfRadioButtons);
		easyId.setSelected(true);

		playerName = "deafult";

	}
}
