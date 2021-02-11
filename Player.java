public class Player {
	//the player's last names on the bulls
final String[] names = new String[] {"Zach Lavine", "Justin Holiday", "Jabari Parker", "Lauri Markkanen", "Robin Lopez", "Ryan Arcidiacono", "Wendell Carter","Bobby Portis","Kris Dunn","Denzel Valentine","Cristiano Felicio","Cameron Payne","Chandler Hutchison","Shaquille Harrison"};
private static String name;
private double totalPoints = 0;
private double rebounds = 0;
private double assists = 0;
private int games = 0;
private Double ppg;
private double apg;
private double rpg;
private String output;
private int x = 0;
private String fullName=null;
	
	public Player(String name) {
	this.name = name;
	}
	public static String getName() {
	return name;
	}
	//changes the players last name to their full name
	public void newName(String a) {
		name = a;
	}
	public double addPoints(int points) {
		games++;
	totalPoints += points; 
	return totalPoints;
	}
	public double addRebounds(int rebounds) {
	this.rebounds += rebounds;
	return this.rebounds;
	}
	public double addAssists(int assists) {
	this.assists += assists;
	return this.assists;
	}
	public double ppg() {
	ppg = totalPoints/games;
	return ppg;
	}
	public double apg() {
	apg = assists/games;
	return apg;
}
	public double rpg() {
	rpg = rebounds/games;
	return rpg;
	}
	//making sure the last name entered is an actual player's name.
	public String exists(String a) {
		//tests to see if name is greater than 9 characters
		//only one player has a name with 9 characters and it was longer than some full names so it causing an error.
		if(a.length()>=10) {
		if(a.equalsIgnoreCase(names[5].substring(names[5].length()-a.length()))) {
		//changes the fullName variable to the full name of the player so it can be returned.
		fullName = names[5];
		x++;
		return fullName;
		}
		else {
			return null;
		}
		}
		for(int i=0; i<14; i++) {
			//just looks at players last names in names[] so it can check whether or not the last name entered is the same
				if(a.equalsIgnoreCase(names[i].substring(names[i].length()-a.length()))) {
					//changes the fullName variable to the full name of the player so it can be returned.
					fullName = names[i];
					x++;
					}
			}
			
		//makes sure the player actually exists then returns the full name.
		if(fullName!=null) {
			return fullName;
		}
		else {
		return null;
		}
	}

	public String toString() {
		output = name+"'s Predicted Stats"+":"+'\n'+"Points Per Game:"+ppg+'\n'+"Assists Per Game:"+apg+'\n'+"Rebounds Per Game:"+rpg;
		return output;
	}

}
