import java.io.*;
import java.util.ArrayList;

public class SimpleDotCom {

	private ArrayList<String> locationCells;

	public void setLocationCells(ArrayList<String> locs) {
		locationCells = locs;
	}

	public String checkYourself(String userInput) {

		String result = "miss";
		int index = locationCells.indexOf(userInput);

		if (index >= 0) {
		
			locationCells.remove(index);

			if (locationCells.isEmpty()) {
				result = "kill";
			} else {
				result = "hit;
			}
		}
		
		return result;
	}

}

class SimpleDotComTestDrive {

	public static void main (String[] args) {
	
		SimpleDotCom dot = new SimpleDotCom();

		int[] locations = {2,3,4};

		dot.setLocationCells(locations);

		String userGuess = "2";

		String result = dot.checkYourself(userGuess);

		//String testResult = "failed";

		//if (result.equals("hit")) {

		//	testResult = "passed";

		//}

		//System.out.println(testResult);

	}

}


class SimpleDotComGame {

	public static void main(String[] args) {

		int numOfGuesses = 0;
		GameHelper helper = new GameHelper();
		SimpleDotCom theDotCom = new SimpleDotCom();
		int randomNum = (int) (Math.random() * 5);
		int[] locations = {randomNum, randomNum+1, randomNum+2};

		theDotCom.setLocationCells(locations);
		boolean isAlive = true;

		while(isAlive == true) {

			String guess = helper.getUserInput("enter a number");
			String result = theDotCom.checkYourself(guess);
			numOfGuesses++;
			if (result.equals("kill")) {
				isAlive = false;
				System.out.println("You took " + numOfGuesses + " guesses");
			}
		}
	}

}



class GameHelper {
	
	public String getUserInput(String prompt) {
	
		String inputLine = null;
		System.out.print(prompt + "  ");
		try {
		
		BufferedReader is = new BufferedReader(
			new InputStreamReader(System.in));
		inputLine = is.readLine();
		if (inputLine.length() == 0) return null;
		} catch (IOException e) {
		System.out.println("IOException: " + e);
		}
		return inputLine;

	}

}






