package part01;

public class WeeklyMenu {
	private int week;
	private String menu[][];

	public WeeklyMenu(int week) {
		this.week = week;
		this.menu = initialise();
	}

	public void setWeek(int week) {
		this.week = week;
	}
	
	public int getWeek() {
		return week;
	}


	public void setRecipe(int row, int col, String recipe) {
		menu[row][col] = recipe;
	}

	public String getRecipe(int row, int col) {
		return menu[row][col];

	}

	public String[][] getWeeklyMenu() {
		return menu;
	}

	public String toString() {
		String result = "";
		result += "Monday:\t\t\t";
		for (int col = 0; col < 3; col++) {
			result += menu[0][col] + "\t\t";
		}
		result += "\n";
		result += "Tuesday:\t\t";
		for (int col = 0; col < 3; col++) {
			result += menu[1][col] + "\t\t";
		}
		result += "\n";
		result += "Wednesday:\t\t";
		for (int col = 0; col < 3; col++) {
			result += menu[2][col] + "\t\t";
		}
		result += "\n";
		result += "Thursdy:\t\t";
		for (int col = 0; col < 3; col++) {
			result += menu[3][col] + "\t\t";
		}
		result += "\n";
		result += "Friday:\t\t\t";
		for (int col = 0; col < 3; col++) {
			result += menu[4][col] + "\t\t";
		}
		result += "\n";

		return result;
	}
	
	public String[][] initialise() {
		String menu[][] = new String[5][3];
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 3; col++) {
				menu[row][col] = "empty";
			}
		}
		return menu;
	}
}