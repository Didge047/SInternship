package part01;

public enum Meals {
Starters("Starters"), MainCourse("Main Course"), Dessert("Dessert");

private String genStr;

private Meals(String gen) {
	genStr = gen;
	}

public String toString() {
	return genStr;
}

public static Meals getRandom() {
    return values()[(int) (Math.random() * values().length)];
}
}