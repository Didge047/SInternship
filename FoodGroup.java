package part01;

public enum FoodGroup {
FruitAndVeg("Fruit and Veg"), CompositeFoods("Composite foods"), Dairy("Dairy"), Cereal("Cereal"), Protein("Protein"), Sugar("Sugar"), Fat("Fat"), SpiceAndHerbs("Spice and herbs"), EssentialNutrient("Essential nutrient");

private String genStr;

private FoodGroup(String gen) {
	genStr = gen;
	}

public String toString() {
	return genStr;
	}
}
