package application;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AddRecipeController implements Initializable{
		
		protected static HashMap<String,Recipe> recipes = new HashMap<String,Recipe>();
		
		@FXML
	    private TextField txtAmt;

		@FXML
		private ChoiceBox<MeasurementType> choiceBoxType;

	    @FXML
	    private TextField txtIngredient;

	    @FXML
	    private Button btnBack;
	    
	    @FXML
	    private Button btnAddIngredient;

	    @FXML
	    private Button btnFinished;

	    @FXML
	    void BackButtonClicked(ActionEvent event) throws IOException {
	    	
	    	FXMLLoader loader = new FXMLLoader();
	    	loader.setLocation(getClass().getResource("AddRecipeName.fxml"));
	    	Stage mainStage = (Stage) btnBack.getScene().getWindow();
		     
	    	BorderPane root = (BorderPane) loader.load(getClass().getResource("AddRecipeName.fxml"));
	    	//modify the scene of the stage to display this file

	    	//instantiate scene based on the new layout of the fxml that we just loaded
	    	Scene nextScene = new Scene(root);
	    	
	    	mainStage.setScene(nextScene);
			mainStage.show();
	    }

	    @FXML
	    void addIngredientClicked(ActionEvent event) {
	    	double amt = Double.parseDouble(txtAmt.getText());
	    	MeasurementType measurementType = choiceBoxType.getValue();
	    	String ingredient = txtIngredient.getText();
	    	Ingredient ing = new Ingredient(amt, measurementType, ingredient);
	    	AddRecipeNameController.recipe.addIngredient(ing);
	    	txtAmt.setText("");
	    	txtIngredient.setText("");
	    	choiceBoxType.setValue(MeasurementType._________);
//	    	Alert alert = new Alert (AlertType.CONFIRMATION);
//	    	alert.setContentText("Successfully added ingredient");
//	    	alert.show();
	    }

	    @FXML
	    void finishedClicked(ActionEvent event) throws IOException {
	    	if(txtAmt.getText().equals(""))
	    	{
	    		recipes.put(AddRecipeNameController.recipe.getTitle(),AddRecipeNameController.recipe);
		    	Alert alert = new Alert (AlertType.CONFIRMATION);
		    	alert.setContentText("Successfully added Recipe");
		    	alert.show();
		    	FXMLLoader loader = new FXMLLoader();
		    	loader.setLocation(getClass().getResource("BakingConversions.fxml"));
		    	Stage mainStage = (Stage) btnFinished.getScene().getWindow();
			     
		    	BorderPane root = (BorderPane) loader.load(getClass().getResource("BakingConversions.fxml"));
		    	//modify the scene of the stage to display this file

		    	//instantiate scene based on the new layout of the fxml that we just loaded
		    	Scene nextScene = new Scene(root);
		    	
		    	mainStage.setScene(nextScene);
				mainStage.show();
	    	}
	    	else
	    	{
	    		double amt = Double.parseDouble(txtAmt.getText());
		    	MeasurementType measurementType = choiceBoxType.getValue();
		    	String ingredient = txtIngredient.getText();
		    	Ingredient ing = new Ingredient(amt, measurementType, ingredient);
		    	AddRecipeNameController.recipe.addIngredient(ing);
		    	recipes.put(AddRecipeNameController.recipe.getTitle(),AddRecipeNameController.recipe);
		    	Alert alert = new Alert (AlertType.CONFIRMATION);
		    	alert.setContentText("Successfully added Recipe");
		    	alert.show();
		    	FXMLLoader loader = new FXMLLoader();
		    	loader.setLocation(getClass().getResource("BakingConversions.fxml"));
		    	Stage mainStage = (Stage) btnFinished.getScene().getWindow();
			     
		    	BorderPane root = (BorderPane) loader.load(getClass().getResource("BakingConversions.fxml"));
		    	//modify the scene of the stage to display this file

		    	//instantiate scene based on the new layout of the fxml that we just loaded
		    	Scene nextScene = new Scene(root);
		    	
		    	mainStage.setScene(nextScene);
				mainStage.show();
	    	}
	    }

		@Override
		public void initialize(URL arg0, ResourceBundle arg1) {
			for(MeasurementType m: MeasurementType.values())
			{
				choiceBoxType.getItems().add(m);
			}
		}


}
