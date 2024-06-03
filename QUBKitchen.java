package part01;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class QUBKitchen {

	static Scanner input = new Scanner(System.in);
	private static ArrayList<Ingredients> myIngredients = new ArrayList<Ingredients>();
	private static ArrayList<Recipes> myRecipes = new ArrayList<Recipes>();
	private static ArrayList<WeeklyMenu> myWeeklyMenu = new ArrayList<WeeklyMenu>();

	private static int id = 26;
	private static int week = 1;

	public static void main(String[] args) {
		InitialiseIngredients();
		InitialiseRecipes();
		String options[] = { "Manage Ingredients", "Manage Recipes", "Manage Weekly Menu", "Quit" };
		Menu myMenu = new Menu("\nQUB Kitchen", options);
		boolean finished = false;
		do {
			int option = myMenu.getUserChoice();
			switch (option) {
			case 1:
				manageIngredients();
				break;
			case 2:
				manageRecipes();
				break;
			case 3:
				manageWeeklyMenu();
				break;
			case 4:
				finished = true;
				break;
			default:
				System.out.println("Not a valid option.");
			}
		} while (!finished);
	}

	private static void manageIngredients() {
		String options[] = { "Add Ingredient", "View Ingredients", "Delete Ingredient", "Update Ingredient", "Back" };
		Menu myMenu = new Menu("\nIngredients Menu", options);
		boolean finished = false;
		do {
			int option = myMenu.getUserChoice();
			switch (option) {
			case 1:
				addIngredient();
				break;
			case 2:
				viewIngredients();
				break;
			case 3:
				deleteIngredients();
				break;
			case 4:
				updateIngredients();
				break;
			case 5:
				main(options);
				break;
			case 6:
				finished = true;
				break;
			default:
				System.out.println("Not a valid option.");
			}
		} while (!finished);
	}

	private static void manageRecipes() {
		String options[] = { "Add Recipe", "View Recipes", "Delete Recipe", "Update Recipe", "Back" };
		Menu myMenu = new Menu("\nRestaurant App Menu", options);
		boolean finished = false;
		do {
			int option = myMenu.getUserChoice();
			switch (option) {
			case 1:
				addRecipe();
				break;
			case 2:
				viewRecipes();
				break;
			case 3:
				deleteRecipe();
				break;
			case 4:
				updateRecipes();
				break;
			case 5:
				finished = true;
				break;
			default:
				System.out.println("Not a valid option.");
			}
		} while (!finished);
	}

	public static void manageWeeklyMenu() {
		String options[] = { "Add Weekly Menu", "View Menu", "Modify Menu", "Back" };
		Menu myMenu = new Menu("\nRestaurant App Menu", options);
		boolean finished = false;
		do {
			int option = myMenu.getUserChoice();
			switch (option) {
			case 1:
				addMenu();
				break;
			case 2:
				viewWeeklyMenu();
				break;
			case 3:
				modifyMenu();
				break;
			case 4:
				finished = true;
				break;
			default:
				System.out.println("Not a valid option.");
			}
		} while (!finished);

	}

	public static void addIngredient() {
		System.out.println("OK - Add a new Ingredient");
		Ingredients ig = new Ingredients();
		ig.setId(id);
		id++;
		System.out.print("Enter Name of ingredient: ");
		String name = input.nextLine();
		ig.setName(name);
		System.out.println("1. Fruit and Veg");
		System.out.println("2. Composite Foods");
		System.out.println("3. Dairy");
		System.out.println("4. Cereal");
		System.out.println("5. Protein");
		System.out.println("6. Sugar");
		System.out.println("7. Fat");
		System.out.println("8. Spices and Herbs");
		System.out.println("9. Essential Nutrient");
		System.out.print("What number is the FoodGroup: ");
		int choice = input.nextInt();
		ig.setFoodGroup(choice);
		System.out.println("Whats the calorific value(per 100g)");
		int Calories = input.nextInt();
		ig.setCalories(Calories);
		myIngredients.add(ig);
		System.out.println("New Ingredient successfully added ");
		sortIngredients();

	}

	private static void addRecipe() {

		System.out.println("OK - Add a new Recipe");
		Recipes rp = new Recipes();
		System.out.print("Enter dish name: ");
		String dishName = input.nextLine();
		rp.setDishName(dishName);
		System.out.print("Enter number of portions: ");
		int portions = input.nextInt();
		rp.setPortions(portions);
		System.out.print("How many Ingredients will you add: ");
		int noOfIngr = input.nextInt();
		for (int i = 1; i <= noOfIngr; i++) {
			System.out.println("We have the following Ingredients:");
			for (int index = 1; index < myIngredients.size(); index++) {
				System.out.println(index + ". " + myIngredients.get(index).getName());
			}
			System.out.println("Which Ingredient would you like to add");
			int choice = input.nextInt();
			rp.setIngredients(myIngredients.get(choice - 1));
			System.out.println();
			System.out.print("Enter the quantity of that Ingredient you want to add in grams: ");
			int IngredientNo = input.nextInt();
			rp.setNoOfIngredients(IngredientNo);
			input.nextLine();
		}

		System.out.println("How many steps does your method contain: ");
		int noOfSteps = input.nextInt();
		input.nextLine();
		int stepNo = 1;
		do {
			System.out.print("Enter Step" + stepNo);
			String step = input.nextLine();
			rp.setMethod(step);
			stepNo++;
		} while (stepNo <= noOfSteps);

		rp.prepareIngredients();
		rp.prepareMethod();
		rp.prepareNoOfIngredients();
		myRecipes.add(rp);
		System.out.println("New Recipe successfully added ");
		sortRecipes();
	}

	public static void addMenu() {
		WeeklyMenu wm = new WeeklyMenu(week);
		Random rand = new Random();
		week++;
		int row;
		int col;
		ArrayList<String> starters = new ArrayList<String>();
		ArrayList<String> mainCourse = new ArrayList<String>();
		ArrayList<String> desserts = new ArrayList<String>();
		for (int index = 0; index < myRecipes.size(); index++) {
			if (myRecipes.get(index).getMealType() == Meals.Dessert) {
				starters.add(myRecipes.get(index).getDishName());
			} else if (myRecipes.get(index).getMealType() == Meals.MainCourse) {
				mainCourse.add(myRecipes.get(index).getDishName());
			} else {
				desserts.add(myRecipes.get(index).getDishName());
			}
		}
		for (row = 0; row < 5; row++) {
			for (col = 0; col < 3; col++) {
				if (col == 0) {
					int randInt = rand.nextInt(3);
					wm.setRecipe(row, col, starters.get(randInt));
				} else if (col == 1) {
					int randInt = rand.nextInt(3);
					wm.setRecipe(row, col, mainCourse.get(randInt));
				} else {
					int randInt = rand.nextInt(3);
					wm.setRecipe(row, col, desserts.get(randInt));
				}
			}
		}
		myWeeklyMenu.add(wm);

	}

	public static void viewIngredients() {
		System.out.println("\nList of all Ingredients.");
		System.out.println("We have the following Ingredients:\n");
		for (int index = 0; index < myIngredients.size(); index++) {
			System.out.println("Name: " + myIngredients.get(index).getName());
			System.out.println("ID: " + myIngredients.get(index).getId());
			System.out.println("Food group: " + myIngredients.get(index).getFoodGroup().toString());
			System.out.println("Calories: " + myIngredients.get(index).getCalories() + "\n");
			

		}
		System.out.println();
	}

	public static void viewRecipes() {
		System.out.println("\nList of all Recipes.");
		System.out.println("We have the following Recipes:");
		for (int index = 0; index < myRecipes.size(); index++) {
			System.out.println("Name: " + myRecipes.get(index).getDishName());
			System.out.println("Portions: " + myRecipes.get(index).getPortions());
			System.out.println("Ingredients: " + myRecipes.get(index).getIngredients());
			ArrayList<Ingredients> list = new ArrayList<Ingredients>();
			ArrayList<Integer> list2 = new ArrayList<Integer>();
			int totalCalories = 0;
			list.addAll(myRecipes.get(index).getIngredients());
			list2 = (myRecipes.get(index).getNoOfIngredients());
		    for (int i = 0 ; i < list.size() ; i ++) {
		    	totalCalories += ((list.get(i).getCalories()*list2.get(i)) / 100);
		    }
			System.out.println("Method: " + myRecipes.get(index).getMethod());
			System.out.println("Total calorific value: " + totalCalories + "\n");

		}
		System.out.println();
	}

	public static void viewWeeklyMenu() {
		System.out.println("Weekly menus:");

		for (int i = 0; i < myWeeklyMenu.size(); i++) {
			System.out.println("Week: " + myWeeklyMenu.get(i).getWeek());
			System.out.println(myWeeklyMenu.get(i));
		}
	}

	public static void deleteIngredients() {
		if (myIngredients.size() == 0) {
			System.out.println("Sorry, there are no Ingredients.");
		} else {
			System.out.println("We have the following Ingredients:");
			for (int index = 0; index < myIngredients.size(); index++) {
				System.out.println((index + 1) + ". " + myIngredients.get(index).getName());
			}
			System.out.print("Which Ingredients would you like to delete: ");
			int choiceOfInt = input.nextInt();
			myIngredients.remove(choiceOfInt - 1);
		}
		System.out.println();
	}

	public static void deleteRecipe() {
		if (myRecipes.size() == 0) {
			System.out.println("Sorry, there are no recipes.");
		} else {
			System.out.println("We have the following Recipes:");
			for (int index = 1; index <= myRecipes.size(); index++) {
				System.out.println(index + ". " + myRecipes.get(index).getDishName());
			}
			System.out.print("Which number Ingredients would you like to delete: ");
			int choiceOfInt = input.nextInt();
			myRecipes.remove(choiceOfInt - 1);
		}
		System.out.println();
	}

	public static void updateIngredients() {
		if (myIngredients.size() == 0) {
			System.out.println("Sorry, there are no Ingredients.");
		} else {
			System.out.println("We have the following Ingredients:");
			for (int index = 0; index < myIngredients.size(); index++) {
				System.out.println((index + 1) + ". " + myIngredients.get(index).getName());
			}
			System.out.println("Which Ingredient would you like to update?");
			int choice = input.nextInt();
			System.out.println(myIngredients.get(choice - 1).getDetails());
			System.out.println("Which piece of information would you like to update");
			System.out.println("1. Name");
			System.out.println("2. Food group");
			System.out.println("3. Calories");
			int selection = input.nextInt();
			if (selection == 1) {
				System.out.println("What Would you like to change the name to: ");
				String newName = input.nextLine();
				myIngredients.get(choice - 1).setName(newName);
			} else if (selection == 2) {
				System.out.println("1. Fruit and Veg");
				System.out.println("2. Composite Foods");
				System.out.println("3. Dairy");
				System.out.println("4. Cereal");
				System.out.println("5. Protein");
				System.out.println("6. Sugar");
				System.out.println("7. Fat");
				System.out.println("8. Spices and Herbs");
				System.out.println("9. Essential Nutrient");
				System.out.println("What Number Would you like to change the Food group to: ");
				int newFoodGroup = input.nextInt();
				myIngredients.get(choice - 1).setFoodGroup(newFoodGroup);
			} else if (selection == 3) {
				System.out.println("What Would you like to change the calorific value to: ");
				int newCalories = input.nextInt();
				myIngredients.get(choice - 1).setCalories(newCalories);
			} else {
				System.out.println("Invalid Selection");
			}

		}
	}

	public static void updateRecipes() {
		if (myRecipes.size() == 0) {
			System.out.println("Sorry, there are no Recipes.");
		} else {
			System.out.println("We have the following Recipes:");
			for (int index = 0; index < myRecipes.size(); index++) {
				System.out.println((index + 1) + ". " + myRecipes.get(index).getDishName());
			}
			System.out.println("Which Recipe would you like to update?");
			int choice = input.nextInt();
			System.out.println(myRecipes.get(choice - 1).getDetails());
			System.out.println("Which piece of information would you like to update");
			System.out.println("1. Dish Name");
			System.out.println("2. Ingredients");
			System.out.println("3. Method");
			int selection = input.nextInt();
			if (selection == 1) {
				System.out.println("What Would you like to change the name to: ");
				String newName = input.nextLine();
				myRecipes.get(choice - 1).setDishName(newName);
			} else if (selection == 2) {

				System.out.println("What Number Would you like to change the Food group to: ");
				int newFoodGroup = input.nextInt();
				myIngredients.get(choice - 1).setFoodGroup(newFoodGroup);
			} else if (selection == 3) {
				System.out.println("What Would you like to change the calorific value to: ");
				int newCalories = input.nextInt();
				myIngredients.get(choice - 1).setCalories(newCalories);
			} else {
				System.out.println("Invalid Selection");
			}

		}
	}

	public static void modifyMenu() {
		System.out.println("Which week would you like to change: ");
		int choice = input.nextInt();
		ArrayList<Integer> weeks = new ArrayList<Integer>();
		for (int i = 0; i < myWeeklyMenu.size(); i++) {
			weeks.add(myWeeklyMenu.get(i).getWeek());
		}
		if (weeks.contains(choice)) {
			addMenu();
			for (int row = 0; row < 5; row++) {
				for (int col = 0; col < 3; col++) {
					myWeeklyMenu.get(choice - 1).setRecipe(row, col,
							(myWeeklyMenu.get(myWeeklyMenu.size() - 1).getRecipe(row, col)));
				}
			}
			myWeeklyMenu.remove(myWeeklyMenu.size() - 1);
		} else {
			System.out.println("Invalid input");
		}
		System.out.println("Weekly menu successfully changed");
	}

	public static void sortIngredients() {
		int swaps;
		do {
			swaps = 0;
			for (int i = 0; i < myIngredients.size() - 1; i++) {
				if (((myIngredients.get(i).getName()).compareTo((myIngredients.get(i + 1).getName())) > 1)) {
					String tempName = myIngredients.get(i).getName();
					int tempId = myIngredients.get(i).getId();
					FoodGroup tempFoodGroup = myIngredients.get(i).getFoodGroup();
					int tempCalories = myIngredients.get(i).getCalories();
					myIngredients.get(i).setName(myIngredients.get(i + 1).getName());
					myIngredients.get(i).setId(myIngredients.get(i + 1).getId());
					myIngredients.get(i).setFoodGroup(myIngredients.get(i + 1).getFoodGroup());
					myIngredients.get(i).setCalories(myIngredients.get(i + 1).getCalories());
					myIngredients.get(i + 1).setName(tempName);
					myIngredients.get(i + 1).setId(tempId);
					myIngredients.get(i + 1).setFoodGroup(tempFoodGroup);
					myIngredients.get(i + 1).setCalories(tempCalories);
					swaps++;
				}
			}
		} while (swaps > 0);
	}

	public static void sortRecipes() {
		int swaps;
		do {
			swaps = 0;
			for (int i = 0; i < myRecipes.size() - 1; i++) {
				if (((myRecipes.get(i).getDishName()).compareTo((myRecipes.get(i + 1).getDishName())) > 1)) {
					String tempName = myRecipes.get(i).getDishName();
					int tempPortions = myRecipes.get(i).getPortions();
					ArrayList<Ingredients> tempIngredients = myRecipes.get(i).getIngredients();
					ArrayList<String> tempMethod = myRecipes.get(i).getMethod();
					ArrayList<Integer> tempNoOfIngredients = myRecipes.get(i).getNoOfIngredients();

					myRecipes.get(i).setDishName(myRecipes.get(i + 1).getDishName());
					myRecipes.get(i).setPortions(myRecipes.get(i + 1).getPortions());
					for (int j = 0; j < myRecipes.get(i).getIngredients().size(); j++) {
						myRecipes.get(i).setIngredients((myRecipes.get(i + 1).getIngredients()).get(j));
					}
					for (int k = 0; k < myRecipes.get(i).getIngredients().size(); k++) {
						myRecipes.get(i).setMethod((myRecipes.get(i + 1).getMethod()).get(k));
					}
					for (int l = 0; l < myRecipes.get(i).getIngredients().size(); l++) {
						myRecipes.get(i).setNoOfIngredients((myRecipes.get(i + 1).getNoOfIngredients()).get(l));
					}

					myRecipes.get(i + 1).setDishName(tempName);
					myRecipes.get(i + 1).setPortions(tempPortions);
					for (int m = 0; m < myRecipes.get(i).getIngredients().size(); m++) {
						myRecipes.get(i + 1).setIngredients(tempIngredients.get(m));
					}
					for (int n = 0; n < myRecipes.get(i).getIngredients().size(); n++) {
						myRecipes.get(i + 1).setMethod(tempMethod.get(n));
					}
					for (int o = 0; o < myRecipes.get(i).getIngredients().size(); o++) {
						myRecipes.get(i + 1).setNoOfIngredients(tempNoOfIngredients.get(o));
					}
					swaps++;
				}
			}
		} while (swaps > 0);
	}

	public static void InitialiseIngredients() {
		Ingredients I1 = new Ingredients(1, "Apples", FoodGroup.FruitAndVeg, 52);
		Ingredients I2 = new Ingredients(2, "Baked beans", FoodGroup.CompositeFoods, 155);
		Ingredients I3 = new Ingredients(3, "Bell peppers", FoodGroup.FruitAndVeg, 20);
		Ingredients I4 = new Ingredients(4, "Butter", FoodGroup.Dairy, 717);
		Ingredients I5 = new Ingredients(5, "Celery", FoodGroup.FruitAndVeg, 8);
		Ingredients I6 = new Ingredients(6, "Cheese", FoodGroup.Dairy, 402);
		Ingredients I7 = new Ingredients(7, "Eggs", FoodGroup.Dairy, 155);
		Ingredients I8 = new Ingredients(8, "Flour", FoodGroup.Cereal, 364);
		Ingredients I9 = new Ingredients(9, "Garlic", FoodGroup.FruitAndVeg, 111);
		Ingredients I10 = new Ingredients(10, "Ground beef", FoodGroup.Protein, 332);
		Ingredients I11 = new Ingredients(11, "Jam", FoodGroup.Sugar, 278);
		Ingredients I12 = new Ingredients(12, "Leeks", FoodGroup.FruitAndVeg, 61);
		Ingredients I13 = new Ingredients(13, "Lettuce", FoodGroup.FruitAndVeg, 15);
		Ingredients I14 = new Ingredients(14, "Milk", FoodGroup.Dairy, 42);
		Ingredients I15 = new Ingredients(15, "Olive oil", FoodGroup.Fat, 884);
		Ingredients I16 = new Ingredients(16, "Onions", FoodGroup.FruitAndVeg, 40);
		Ingredients I17 = new Ingredients(17, "Penne pasta", FoodGroup.CompositeFoods, 118);
		Ingredients I18 = new Ingredients(18, "Pepper", FoodGroup.SpiceAndHerbs, 20);
		Ingredients I19 = new Ingredients(19, "Potatoes", FoodGroup.FruitAndVeg, 75);
		Ingredients I20 = new Ingredients(20, "Salt", FoodGroup.EssentialNutrient, 0);
		Ingredients I21 = new Ingredients(21, "Stock cubes", FoodGroup.CompositeFoods, 438);
		Ingredients I22 = new Ingredients(22, "Sugar", FoodGroup.Sugar, 387);
		Ingredients I23 = new Ingredients(23, "Tomatoes", FoodGroup.FruitAndVeg, 19);
		Ingredients I24 = new Ingredients(24, "Water", FoodGroup.EssentialNutrient, 0);
		Ingredients I25 = new Ingredients(25, "White bread", FoodGroup.CompositeFoods, 265);

		myIngredients.add(I1);
		myIngredients.add(I2);
		myIngredients.add(I3);
		myIngredients.add(I4);
		myIngredients.add(I5);
		myIngredients.add(I6);
		myIngredients.add(I7);
		myIngredients.add(I8);
		myIngredients.add(I9);
		myIngredients.add(I10);
		myIngredients.add(I11);
		myIngredients.add(I12);
		myIngredients.add(I13);
		myIngredients.add(I14);
		myIngredients.add(I15);
		myIngredients.add(I16);
		myIngredients.add(I17);
		myIngredients.add(I18);
		myIngredients.add(I19);
		myIngredients.add(I20);
		myIngredients.add(I21);
		myIngredients.add(I22);
		myIngredients.add(I23);
		myIngredients.add(I24);
		myIngredients.add(I25);
		sortIngredients();
	}

	public static void InitialiseRecipes() {
		Recipes R1 = new Recipes("Soup", 4, Meals.Starters, null, (""), -1);
		R1.prepareIngredients();
		R1.prepareMethod();
		R1.prepareNoOfIngredients();
		R1.setIngredients(myIngredients.get(19));
		R1.setIngredients(myIngredients.get(5));
		R1.setIngredients(myIngredients.get(21));
		R1.setIngredients(myIngredients.get(24));
		R1.setNoOfIngredients(2);
		R1.setNoOfIngredients(4);
		R1.setNoOfIngredients(1);
		R1.setNoOfIngredients(200);
		R1.setMethod("Peel vegetables");
		R1.setMethod("Chop vegetables");
		R1.setMethod("place vegetables in boiling water with stock cubes over medium heat");
		R1.setMethod("Stir occasionally");
		R1.setMethod("reduce heat and let simmer");

		Recipes R2 = new Recipes("Salad", 1, Meals.Starters, null, (""), -1);
		R2.prepareIngredients();
		R2.prepareMethod();
		R2.prepareNoOfIngredients();
		R2.setIngredients(myIngredients.get(22));
		R2.setIngredients(myIngredients.get(12));
		R2.setIngredients(myIngredients.get(2));
		R2.setNoOfIngredients(50);
		R2.setNoOfIngredients(100);
		R2.setNoOfIngredients(50);
		R2.setMethod("Dice tomatoes and bell peppers");
		R2.setMethod("Place in bowl with lettuce");
		R2.setMethod("Toss");

		Recipes R3 = new Recipes("Bruschetta", 1, Meals.Starters, null, (""), -1);
		R3.prepareIngredients();
		R3.prepareMethod();
		R3.prepareNoOfIngredients();
		R3.setIngredients(myIngredients.get(24));
		R3.setIngredients(myIngredients.get(22));
		R3.setIngredients(myIngredients.get(17));
		R3.setIngredients(myIngredients.get(5));
		R3.setNoOfIngredients(100);
		R3.setNoOfIngredients(200);
		R3.setNoOfIngredients(20);
		R3.setNoOfIngredients(50);
		R3.setMethod("Dice tomatoes");
		R3.setMethod("Toast bread with cheese");
		R3.setMethod("Place tomatoes over the toasted bread");
		R3.setMethod("Season with pepper");

		Recipes R4 = new Recipes("Tomato pasta", 3, Meals.MainCourse, null, (""), -1);
		R4.prepareIngredients();
		R4.prepareMethod();
		R4.prepareNoOfIngredients();
		R4.setIngredients(myIngredients.get(22));
		R4.setIngredients(myIngredients.get(16));
		R4.setIngredients(myIngredients.get(19));
		R4.setNoOfIngredients(50);
		R4.setNoOfIngredients(250);
		R4.setNoOfIngredients(15);
		R4.setMethod("Blend tomatoes");
		R4.setMethod("Boil pasta in salt water for 10-15 minutes");
		R4.setMethod("Stir tomato juice");

		Recipes R5 = new Recipes("Shepherds pie", 4, Meals.MainCourse, null, (""), -1);
		R5.prepareIngredients();
		R5.prepareMethod();
		R5.prepareNoOfIngredients();
		R5.setIngredients(myIngredients.get(9));
		R5.setIngredients(myIngredients.get(18));
		R5.setIngredients(myIngredients.get(15));
		R5.setNoOfIngredients(200);
		R5.setNoOfIngredients(250);
		R5.setNoOfIngredients(50);
		R5.setMethod("Fry ground beef with chopped onions for 10-15 minutes");
		R5.setMethod("Boil potatoes for 40 minutes");
		R5.setMethod("Mashpotatoes");
		R5.setMethod("Place mince at bottom of dish and plaace mash on top");
		R5.setMethod("Bake in oven for 10 minutes");

		Recipes R6 = new Recipes("BK foot lettuce", 3, Meals.MainCourse, null, (""), -1);
		R6.prepareIngredients();
		R6.prepareMethod();
		R6.prepareNoOfIngredients();
		R6.setIngredients(myIngredients.get(12));
		R6.setNoOfIngredients(500);
		R6.setMethod("Plce foot on lettuce from burger king");

		Recipes R7 = new Recipes("Caramel apple", 1, Meals.Dessert, null, (""), -1);
		R7.prepareIngredients();
		R7.setIngredients(myIngredients.get(23));
		R7.setIngredients(myIngredients.get(0));
		R7.setNoOfIngredients(75);
		R7.setNoOfIngredients(150);
		R7.setMethod("Melt sugar in pot until it caramelises");
		R7.setMethod("Spread on apples");
		R7.setMethod("Let cool in fridge for 30 minutes");

		Recipes R8 = new Recipes("French toast", 2, Meals.Dessert, null, (""), -1);
		R8.prepareIngredients();
		R8.prepareMethod();
		R8.prepareNoOfIngredients();
		R8.setIngredients(myIngredients.get(24));
		R8.setIngredients(myIngredients.get(6));
		R8.setNoOfIngredients(200);
		R8.setNoOfIngredients(100);
		R8.setMethod("Crack eggs into pan");
		R8.setMethod("Dip both sides of the bread into eggs");

		Recipes R9 = new Recipes("Apple ice-cream", 4, Meals.Dessert, null, (""), -1);
		R9.prepareIngredients();
		R9.prepareMethod();
		R9.prepareNoOfIngredients();
		R9.setIngredients(myIngredients.get(0));
		R9.setIngredients(myIngredients.get(13));
		R9.setNoOfIngredients(200);
		R9.setNoOfIngredients(300);
		R9.setMethod("Blend apples and milk");
		R9.setMethod("Place in container and keep in freezer overnight");

		myRecipes.add(R1);
		myRecipes.add(R2);
		myRecipes.add(R3);
		myRecipes.add(R4);
		myRecipes.add(R5);
		myRecipes.add(R6);
		myRecipes.add(R7);
		myRecipes.add(R8);
		myRecipes.add(R9);
	}

}