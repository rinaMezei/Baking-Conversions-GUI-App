package application;

import java.io.IOException;
import java.net.URL;
import java.util.Map.Entry;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MultiplyDivideController implements Initializable{

    @FXML
    private Label lblConvert;

    @FXML
    private ChoiceBox<String> choiceBoxConvert;

    @FXML
    private Label lblNumber;

    @FXML
    private TextField txtAmount;

    @FXML
    private ListView<Ingredient> listViewRecipe;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnOk;

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

    @FXML
    void btnOkayClicked(ActionEvent event) {
    	listViewRecipe.getItems().clear();
    	String recipeTitle = choiceBoxConvert.getSelectionModel().getSelectedItem();
    	Recipe recipeToChange = AddRecipeController.recipes.get(recipeTitle);
    	
    	for(Ingredient i: recipeToChange.getIngredients())
		{
			double updatedAmt = i.getAmount()* Double.parseDouble(txtAmount.getText());
			Ingredient currIng = new Ingredient( updatedAmt, i.getType(), i.getName());
			listViewRecipe.getItems().add(currIng);
		}
    	listViewRecipe.setVisible(true);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		for(Entry<String,Recipe> m: AddRecipeController.recipes.entrySet())
		{
			choiceBoxConvert.getItems().add((String) m.getKey());
		}
		listViewRecipe.setVisible(false);
		
	}

}
