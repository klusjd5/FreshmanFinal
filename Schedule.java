import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;

public class Schedule {
	//the array has a length of 82 because there are 82 games in a season
	static String [] game = new String[82];
	static String fun = "";
	Random rand = new Random();
	private double wins = 0;
	private int i = 0;
	private double played = 0;
	
	//reads in the text file with the bulls schedule
	public void readText() {
		
		 File inputFile;
		 Scanner input;
		 inputFile = null;
		 input = null;
		
		 
		 try {
			 inputFile = new File("/Users/Klusjd5/Desktop/Schedule.txt");
			 input = new Scanner(inputFile);
		 }
		 catch (FileNotFoundException e) {
			 System.out.println("no");
			 System.exit(1);
			 }
		
		 //while the file has another line, the program reads it and puts it in position [i] of the array
		 while(input.hasNextLine()){
			 game[i] = input.nextLine();
			 i++;
		 }
		 input.close();
	}
	public Schedule() {
	}
	//gets a random bulls game. there are 82 games in a season so positions 0-81 are filled in the array
	//so find random integers between 0-81 to pick out random games in the array
	public String getGame() {
		fun = game[rand.nextInt(81)];
		played++;
		return fun;
	}
	public void addWin() {
	wins++;
	}
	public int getWins() {
		return (int) wins;
	}
	//calculates the team's winning percentage so if the team is over .500, they will make be likely to make the playoffs
	//.500 is about the average record of the 8th seed in the conference, the last team to make the playoffs
	public boolean status() {
		if((wins/played) >= .5) {
			return true;
		}
		else {
			return false;
		}
	}

}
