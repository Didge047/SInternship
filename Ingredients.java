package part01;


public class Ingredients {
	private int id;
	private String name;
	private FoodGroup FoodGroup;
	private int Calories;

	public int getCalories() {
		return Calories;
	}

	public void setCalories(int calories) {
		Calories = calories;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FoodGroup getFoodGroup() {
		return FoodGroup;
	}

	public void setFoodGroup(int choice) {
		if (choice == 1)
			setFoodGroup(part01.FoodGroup.FruitAndVeg);
		else if (choice == 2)
			setFoodGroup(part01.FoodGroup.CompositeFoods);
		else if (choice == 3)
			setFoodGroup(part01.FoodGroup.Dairy);
		else if (choice == 4)
			setFoodGroup(part01.FoodGroup.Cereal);
		else if (choice == 5)
			setFoodGroup(part01.FoodGroup.Protein);
		else if (choice == 6)
			setFoodGroup(part01.FoodGroup.Sugar);
		else if (choice == 7)
			setFoodGroup(part01.FoodGroup.Fat);
		else if (choice == 8)
			setFoodGroup(part01.FoodGroup.SpiceAndHerbs);
		else if (choice == 9)
			setFoodGroup(part01.FoodGroup.EssentialNutrient);
		else
			System.out.println("Invalid input");
	}
	
	public void setFoodGroup(FoodGroup FoodGroup) {
		this.FoodGroup = FoodGroup;
	}
	
	public Ingredients(int id, String name, FoodGroup FoodGroup, int Calories) {
		setId(id);
		setName(name);
		setFoodGroup(FoodGroup);
		setCalories(Calories);
	}
	
	public Ingredients() {
		this(-1, null, null, -1);
	}
	
	public String getDetails() {
		String result = "Name: " + getName() + "Id: " + getId() + "\nFoodGroup: " + getFoodGroup() + "\nCalories per 100g: " + getCalories() + "\n";
		return result;
	}
	

}
