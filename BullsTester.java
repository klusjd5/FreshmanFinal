import java.util.Scanner;

public class BullsTester {
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		Schedule g1 = new Schedule();
		String Name = "";
		String w = "";
		Player p1= new Player(null);
		
		int points;
		int assist;
		int rebounds;
		
			
			System.out.println("Enter the last name of your favorite player on the Chicago Bulls.");
			Name = keyboard.nextLine();
			p1 = new Player(Name);
			if(p1.exists(Name) != null) {
				//if the player exists, then the user input of just a last name will become the full name
				p1.newName(p1.exists(Name));
			}
			else {
				//if the last name the user enters is not actually on the bulls, it asks them again.
			while(p1.exists(Name)==null) {
				System.out.println("Please enter the name of an actual player on the Bulls");
				Name = keyboard.nextLine();
				p1 = new Player(Name);
				p1.newName(p1.exists(Name));
				System.out.println('\n');
			}
			}
			System.out.println(p1.getName()+", Great choice");
			//reads in the text so the program can properly run
			g1.readText();
			
			System.out.println("Please enter your predictions on whether the Bulls will win or not."+'\n'+
					"Then I will calculate if they are projected to make the playoffs or not."+'\n');
			System.out.println("also enter your predicted statline for "+p1.getName()+'\n'+
					"And I will calculate "+p1.getName()+"'s averages"+'\n');
			
			//for loop so that there are 5 games
			for(int i=0;i<5;i++) {
				System.out.println(g1.getGame());
			System.out.println("Enter W if you think the bulls will win or L if you think they will lose");
			w = keyboard.nextLine();
			while(!(w.equalsIgnoreCase("w")||w.equalsIgnoreCase("L"))) {
				System.out.println("Please enter the correct values.");
				System.out.println("Enter W if you think the bulls will win or L if you think they will lose");
				w = keyboard.nextLine();	
			}
			if(w.equalsIgnoreCase("w")){
				g1.addWin();
				}
			else if(w.equalsIgnoreCase("l")) {	
			
			}
		
			System.out.println("Enter your predicted points for "+p1.getName()+".");
			points = keyboard.nextInt();
			//100 is the most points ever scored in a game so thats the realistic max
			//and a player cant score negative points
			while(!(points <= 100 && points>0 )) {
				System.out.println("That is Completely unrealistic");
				System.out.println("Enter your predicted points for "+p1.getName()+".");
				points = keyboard.nextInt();
			}
			p1.addPoints(points);
			System.out.println("enter your predicted assists for "+p1.getName()+".");
			assist = keyboard.nextInt();
			//30 is the most assists totaled in a game so that is the max possible
			//cant have a negative amount of assists
			while(!(assist>0 && assist<=30)) {
				System.out.println("c'mon is that really gonna happen?");
				System.out.println("enter your predicted assists for "+p1.getName());
				assist = keyboard.nextInt();
			}
			p1.addAssists(assist);
			System.out.println("Enter your predicted rebounds for "+p1.getName()+".");
			rebounds = keyboard.nextInt();
			keyboard.nextLine();
			//38 is the most rebounds recorded in a game so that is the max.
			//you also cant have a negative rebounding total
			while(!(rebounds>0 && rebounds<=38)) {
				System.out.println("please enter a realistic value of rebounds");
				System.out.println("Enter your predicted rebounds for "+p1.getName()+".");
				rebounds = keyboard.nextInt();
			}
			p1.addRebounds(rebounds);
		}
			//tests to see if the bulls should make the playoffs and then outputs the result.
			if(g1.status()==true) {
				System.out.println("Based on your current projectile, the Bulls should make the playoffs");
			}
			else {
				System.out.println("Based on your current projectile, the Bulls will miss the playoffs");
			}
				//different scenarios in which how a player's season goes
				if((p1.ppg()>=25&&p1.apg()>=7&&p1.rpg()>=4)||p1.ppg()>=32) {
					System.out.println(p1+""+'\n'+"These are MVP caliber numbers for "+p1.getName());
				}
				else if(p1.ppg()>=20&&p1.apg()<=5&&p1.rpg()<=5) {
					System.out.println(p1+""+'\n'+"6th man of the year level scoring for "+p1.getName());
					}
				else if(p1.ppg()<=10&&p1.apg()<=5&&p1.rpg()<=5) {
					System.out.println(p1+""+'\n'+"Tough individual year for "+p1.getName());
				}
				else if(p1.ppg()<=15&&p1.apg()<=5&&p1.rpg()>=12) {
					System.out.println(p1+""+'\n'+"monster rebounding season for "+p1.getName());
				}
				else if(p1.ppg()<=15&&p1.apg()>=9&&p1.rpg()<=5) {
					System.out.println(p1+""+'\n'+p1.getName()+" is a floor general");
				}
				//a lot of possible scenarios in which the player can be an all star
				else if((p1.ppg()>=25&&p1.apg()<=7 && p1.rpg()<7)||(p1.ppg()>15&&p1.apg()>=10&&p1.rpg()>=5)||(p1.ppg()>=15&&p1.apg()>=7||p1.rpg()>=10)) {
					System.out.println(p1+""+'\n'+"All-star caliber year for "+p1.getName());
					
				}
				else {
					System.out.println(p1+""+'\n'+"solid statistical year for "+p1.getName());
				}
	}
}
