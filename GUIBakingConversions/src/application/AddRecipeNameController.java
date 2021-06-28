package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AddRecipeNameController {

	protected static Recipe recipe;
	
    @FXML
    private Label lblName;

    @FXML
    private TextField txtRecipeName;

    @FXML
    private Button btnEnter;
    
    @FXML
    private Button btnBack;

    @FXML
    void enterClicked(ActionEvent event) throws IOException {
    	recipe = new Recipe (txtRecipeName.getText());
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("AddRecipeFXML.fxml"));
    	Stage mainStage = (Stage) btnEnter.getScene().getWindow();
	     
    	AnchorPane root = (AnchorPane) loader.load(getClass().getResource("AddRecipeFXML.fxml"));
    	//modify the scene of the stage to display this file

    	//instantiate scene based on the new layout of the fxml that we just loaded
    	Scene nextScene = new Scene(root);
    	
    	mainStage.setScene(nextScene);
		mainStage.show();
    }
    
    @FXML
    void btnBackClicked(ActionEvent event) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("BakingConversions.fxml"));
    	Stage mainStage = (Stage) btnBack.getScene().getWindow();
	     
    	BorderPane root = (BorderPane) loader.load(getClass().getResource("BakingConversions.fxml"));
    	//modify the scene of the stage to display this file

    	//instantiate scene based on the new layout of the fxml that we just loaded
    	Scene nextScene = new Scene(root);
    	
    	mainStage.setScene(nextScene);
		mainStage.show();
    }
    
    public Recipe getRecipe()
    {
    	return recipe;
    }

}
