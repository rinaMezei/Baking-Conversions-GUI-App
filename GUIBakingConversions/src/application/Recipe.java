package application;

import java.util.ArrayList;

public class Recipe {
	
	private  ArrayList<Ingredient>ingredients;
	private String title;
	
	public Recipe(String title)
	{
		this.title=title;
		this.ingredients=new ArrayList<Ingredient>();
	}

	public String getTitle()
	{
		return title;
	}
	
	public void addIngredient(Ingredient ingredient)
	{
		this.ingredients.add(ingredient);
	}
	
	public ArrayList<Ingredient> getIngredients()
	{
		ArrayList<Ingredient>copyIngredients = new ArrayList<Ingredient>();
		for(Ingredient i:ingredients)
		{
			copyIngredients.add(i);
		}
		
		return copyIngredients;
	}

	@Override
	public String toString() {
		return "Recipe [ingredients=" + ingredients + ", title=" + title + "]";
	}

}
