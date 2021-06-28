package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class BakingConversionsController {

    @FXML
    private Button btnAddRecipe;

    @FXML
    private Button btnMultiplyDivide;

    @FXML
    private Button btnSubstitute;

    @FXML
    private Button btnExit;

    @FXML
    void AddRecipeClicked(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("AddRecipeName.fxml"));
    	Stage mainStage = (Stage) btnAddRecipe.getScene().getWindow();
	     
    	BorderPane root = (BorderPane) loader.load(getClass().getResource("AddRecipeName.fxml"));
    	//modify the scene of the stage to display this file

    	//instantiate scene based on the new layout of the fxml that we just loaded
    	Scene nextScene = new Scene(root);
    	
    	mainStage.setScene(nextScene);
		mainStage.show();
    }

    @FXML
    void ExitClicked(ActionEvent event) {

    	Alert alert = new Alert (AlertType.INFORMATION);
    	alert.setContentText("Thank you for using our app. Have a great day!");
    	alert.showAndWait();
    	System.exit(1);
    }

    @FXML
    void MultiplyDivideClicked(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("MultiplyDivideFXML.fxml"));
    	Stage mainStage = (Stage) btnMultiplyDivide.getScene().getWindow();
	     
    	BorderPane root = (BorderPane) loader.load(getClass().getResource("MultiplyDivideFXML.fxml"));
    	//modify the scene of the stage to display this file

    	//instantiate scene based on the new layout of the fxml that we just loaded
    	Scene nextScene = new Scene(root);
    	
    	mainStage.setScene(nextScene);
		mainStage.show();
    }

    @FXML
    void SubstituteClicked(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("MultiplyDivideFXML.fxml"));
    	Stage mainStage = (Stage) btnMultiplyDivide.getScene().getWindow();
	     
    	BorderPane root = (BorderPane) loader.load(getClass().getResource("SubstitutionsFXML.fxml"));
    	//modify the scene of the stage to display this file

    	//instantiate scene based on the new layout of the fxml that we just loaded
    	Scene nextScene = new Scene(root);
    	
    	mainStage.setScene(nextScene);
		mainStage.show();
    }

}


