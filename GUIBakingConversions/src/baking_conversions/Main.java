package baking_conversions;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	
	public static void main(String[]args)
	{
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Cooking Conversions application");
		ArrayList<Recipe> recipes = new ArrayList<Recipe>();
		String keepGoingIngredient="Y";
		String keepGoingRecipe="Y";
		int option = menu(scanner);
		scanner.nextLine();
		int j=1;
		while(j!=0)
		{
			
		
		switch(option)
		{
		case 1:
			System.out.println("Please enter recipe name: ");
			
			String recipeName = scanner.nextLine();
			Recipe recipe = new Recipe(recipeName);
				do {
					System.out.println("**Ingredient**");
					System.out.println();
					System.out.println("Ingredient Amount: ");
					double amount = scanner.nextDouble();
					scanner.nextLine();
					System.out.println("Measurement type (tsp, tbsp, cup, pound, quart, ounces): ");
					String measurementType = scanner.nextLine();
					while (!measurementType.equals("tsp")&&!measurementType.equals("tbsp")&&
							!measurementType.equals("cup")&&!measurementType.equals("pound")&&
							!measurementType.equals("quart")&& !measurementType.equals("cups")
							&& !measurementType.equals("quarts") && !measurementType.equals("oz")
							&& !measurementType.equals("ounce")&& !measurementType.equals("pounds")
							&& !measurementType.equals("ounces") && !measurementType.equals("lb"))
					
					{
						System.out.println("Please enter a valid measurement type");
						measurementType = scanner.nextLine();
					}
					MeasurementType m = MeasurementType.valueOf(measurementType);
				
					System.out.println("Ingredient name: ");
					String ingredientName=scanner.nextLine();
					
					Ingredient i = new Ingredient(amount, m, ingredientName);
					recipe.addIngredient(i);
					
					System.out.println("Do you want to enter another ingredient? enter y for yes");
					keepGoingIngredient=scanner.nextLine();
					
				}
				while(keepGoingIngredient.equalsIgnoreCase("Y"));
				recipes.add(recipe);
				
				break;
		case 2:
			int k= 1;
			System.out.println("Choose a recipe that you want to convert: ");
			for(Recipe r: recipes)
			{
				System.out.println(k+ ". "+r.getTitle());
				k++;
			}
			int choice2=scanner.nextInt();
			Recipe currentRecipe= recipes.get(choice2-1);
			double timesMultiplied;
			System.out.println("Enter the amount of times you want to make the recipe: ");
			timesMultiplied= scanner.nextDouble();
			Recipe recipeUpdated = conversionMethod(currentRecipe, timesMultiplied);
			for(Ingredient l: recipeUpdated.getIngredients())
			{
				System.out.println(l);
			}
			System.out.println();
			break;
			
		case 3:
			System.out.println("Substitute a measurement");
			//System.out.println("2. Substitute an ingredient");
			int choice1 = scanner.nextInt();
			if(choice1 == 1)
			{
				int l= 1;
				System.out.println("Choose a recipe: ");
				for(Recipe r: recipes)
				{
					System.out.println(l+ ". "+r.getTitle());
					l++;
				}
				int choice3=scanner.nextInt();
				Recipe currentRecipe1= recipes.get(choice3-1);
		
				scanner.nextLine();
				
				System.out.println("Please enter the measurement you want to substitute for: ");
				String measurementType = scanner.nextLine();
				while (!measurementType.equals("tsp")&&!measurementType.equals("tbsp")&&
						!measurementType.equals("cup")&&!measurementType.equals("pound")&&
						!measurementType.equals("quart")&& !measurementType.equals("cups"))
				{
					System.out.println("Please enter a valid measurement type");
					measurementType = scanner.nextLine();
				}
				MeasurementType m1 = MeasurementType.valueOf(measurementType);
				ArrayList<Ingredient>ingredientsConverted=new ArrayList<Ingredient>();
				
				for(Ingredient i: currentRecipe1.getIngredients())
				{
					if(i.getType().equals(m1))
					{
						ingredientsConverted.add(convertIngredient(i));
					}
					else 
					{
						ingredientsConverted.add(i);
					}
				}
				
				System.out.println("Recipe with measurement substitutions:");
				for(Ingredient ingredientConverted: ingredientsConverted)
				{
					System.out.println(ingredientConverted);
				}
			}
//			if (choice1==2)
//			{
//				System.out.println("Please enter the ingredient you want to substitute for: ");
//
//			}
			break;
			
		case 4:
			System.exit(0);
		}
		
		
		option=menu(scanner);
		scanner.nextLine();
		}	
	}
	
	public static int menu(Scanner scanner)
	{
		System.out.println("1. Add a recipe");
		System.out.println("2. Multiply/Divide a recipe");
		System.out.println("3. Substitutions");
		System.out.println("4. Exit the program");
		int choice = scanner.nextInt();
		return choice;
		
	}
	
	public static Recipe conversionMethod(Recipe currentRecipe, Double timesMultiplied)
	{
		ArrayList<Ingredient>currentIngredients = currentRecipe.getIngredients();
		Recipe updatedRecipe = new Recipe(currentRecipe.getTitle());
		for(Ingredient i: currentIngredients)
		{
			double updatedAmt = i.getAmount()*timesMultiplied;
			Ingredient currIng = new Ingredient( updatedAmt, i.getType(), i.getName());
			updatedRecipe.addIngredient(currIng);
		}
		return updatedRecipe;
	}
	
	public static Ingredient convertIngredient(Ingredient i)
	{
		StringBuilder sb = new StringBuilder();
		
		MeasurementType m = i.getType();
		//conversions
		switch(m)
		{
		case tsp:
			
			return new Ingredient(i.getAmount()/3,MeasurementType.tbsp,i.getName());
		case tbsp:
			return new Ingredient(i.getAmount()*3,MeasurementType.tsp,i.getName());
		case cup:
		case cups:
			return new Ingredient(i.getAmount()*16,MeasurementType.tbsp,i.getName());
		case ounces:
		case oz:
		case ounce:
			return new Ingredient(i.getAmount()/8,MeasurementType.cup,i.getName());
		case pound:
		case pounds:
		case lb:
			return new Ingredient(i.getAmount()*2, MeasurementType.cup,i.getName());
		case quart:
		case quarts:
			return new Ingredient(i.getAmount()/4, MeasurementType.cup,i.getName());
		default:
			return i;
			
			
			
		}
	
	}

	
}
