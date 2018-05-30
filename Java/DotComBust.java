import java.util.*;

public class DotComBust {

	private GameHelper helper = new GameHelper();
	private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
	private int numOfGuesses = 0;

	private void setUpGame() {

		DotCom one = new DotCom();
		one.setName("Pets.com");
		DotCom two = new DotCom();
		two.setName("eToys.com");
		DotCom three = new DotCom();
		three.setName("Go2.com");

		dotComsList.add(one);
		dotComsList.add(two);
		dotComsList.add(three);
		
		System.out.println("Your goal is to sink three dot coms.");
		System.out.println("Pets.com, eToys.com, Go2.com");
		System.out.println("Try to sink them all in the fewest guesses!");

		for (DotCom dotComToSet : dotComsList) {
			ArrayList<String> newLocation = helper.placeDotCom(3);
			dotComToSet.setLocationCells(newLocation);
		}
	}

	private void startPlaying() {
		
		while(!dotComsList.isEmpty()) {
			
			String userGuess = helper.getUserInput("Enter a guess");
			checkUserGuess(userGuess);
		}
		finishGame();
	}

	private void checkUserGuess(String userGuess) {

		numOfGuesses++;
		String result = "miss";

		for (DotCom dotComToTest : dotComsList) {
			result = dotComToTest.checkYourself(userGuess);
			if (result.equals("hit")) {
				break;
			}
			if (result.equals("kill")) {
				dotComsList.remove(dotComToTest);
				break;
			}
		}
		System.out.println("You got a " + result);
	}

	private void finishGame() {
		System.out.println("All Dot Coms are dead! Your equity is nothing!");
		if (numOfGuesses <= 18) {
			System.out.println("It only took you " + numOfGuesses + " guesses.");
			System.out.println("You get a golden parachute!");
		} else {
			System.out.println("You took " + numOfGuesses + " guesses?");
			System.out.println("Should have invested in AI.");
		}
	}

	public static void main (String[] args) {

		DotComBust game = new DotComBust();
		game.setUpGame();
		game.startPlaying();
	}

}

class DotCom {
	
	private ArrayList<String> locationCells;
	private String name;

	public void setLocationCells(ArrayList<String> loc) {
		locationCells = loc;
	}

	public void setName(String n) {
		name = n;
	}

	public String checkYourself(String userInput) {
		String result = "miss";
		int index = locationCells.indexOf(userInput);

		if (index >=0) {
			locationCells.remove(index);
		}
		if (locationCells.isEmpty()) {
			result = "kill";
			System.out.println("You sunk " + name + "!");
		} else { 
			result = "hit";
		}
		return result;
	}
}

