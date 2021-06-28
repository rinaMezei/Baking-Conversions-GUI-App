package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Map.Entry;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class SubstituteController implements Initializable{

    @FXML
    private Label lblRecipe;

    @FXML
    private ChoiceBox<String> choiceBoxRecipes;

    @FXML
    private Label lblMeasurementType;
    
    @FXML
    private ChoiceBox<MeasurementType> choiceBoxMeasurementType;

    @FXML
    private ListView<Ingredient> listViewConvertedRecipe;

    @FXML
    private Button btnBack;

    @FXML
    private Button btnEnter;

    @FXML
    void backButtonClicked(ActionEvent event) throws IOException {
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
    void btnEnterClicked(ActionEvent event) {
    	listViewConvertedRecipe.getItems().clear();
    	String recipeTitle = choiceBoxRecipes.getSelectionModel().getSelectedItem();
    	Recipe recipeToChange = AddRecipeController.recipes.get(recipeTitle);
    	MeasurementType measurementType = choiceBoxMeasurementType.getSelectionModel().getSelectedItem();
    	Ingredient convertedIngredient;
    	for(Ingredient i: recipeToChange.getIngredients())
    	{
    		if(i.getType().equals(measurementType))
    		{
    			convertedIngredient = convertIngredient(i);
    			listViewConvertedRecipe.getItems().add(convertedIngredient);
    		}
    		else
    		{
    			listViewConvertedRecipe.getItems().add(i);
    		}
    	}
    	listViewConvertedRecipe.setVisible(true);
    }

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		for(Entry<String,Recipe> m: AddRecipeController.recipes.entrySet())
		{
			choiceBoxRecipes.getItems().add((String) m.getKey());
		}
		listViewConvertedRecipe.setVisible(false);
		for(MeasurementType m: MeasurementType.values())
		{
			choiceBoxMeasurementType.getItems().add(m);
		}
	}
	
	public static Ingredient convertIngredient(Ingredient i)
	{
		MeasurementType m = i.getType();
		//conversions
		switch(m)
		{
		case tsps:
			return new Ingredient(i.getAmount()/3,MeasurementType.tbsps,i.getName());
		case tbsps:
			return new Ingredient(i.getAmount()*3,MeasurementType.tsps,i.getName());
		case cups:
			return new Ingredient(i.getAmount()*16,MeasurementType.tbsps,i.getName());
		case ounces:
			return new Ingredient(i.getAmount()/8,MeasurementType.cups,i.getName());
		case pounds:
			return new Ingredient(i.getAmount()*2, MeasurementType.cups,i.getName());
		case quarts:
			return new Ingredient(i.getAmount()/4, MeasurementType.cups,i.getName());
		default:
			return i;
		}	
	}
}
