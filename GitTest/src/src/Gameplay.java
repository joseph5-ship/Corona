import java.util.ArrayList;
import java.util.Scanner;

public class Gameplay {

	
	public static void startGame(ArrayList<Player> playersList, ArrayList<Property> propertiesList) {
		while(Services.winingCondiction(playersList)) {
				//Start round
			
			for (Player currentPlayer:playersList) {
				if (!Services.winingCondiction(playersList)) {
					break;
				}
				System.out.println(currentPlayer.getPlayerName() + "'s turn");
				System.out.println("Money: " + currentPlayer.getMoney());
				System.out.println("Location: " + currentPlayer.getLocation());
				Services.locationUpdate(currentPlayer);
				System.out.println("Location: " + currentPlayer.getLocation());
				System.out.println("Property name: " + propertiesList.get(currentPlayer.getLocation()).getPropertyName());
				
				//special location checking
				
				if(currentPlayer.getLocation() == 10) {
					Services.payJail(currentPlayer);
					System.out.println("");
					continue;
				}else if (currentPlayer.getLocation() == 5||currentPlayer.getLocation() == 15) {
					if (currentPlayer.getPlayerNumber()==0) {
						UsingRandomCard.humanUseRandomCard(propertiesList, currentPlayer);
						System.out.println("");
					}else {
						computerUseRandomCard.computerUseRandom(propertiesList, currentPlayer);
						System.out.println("");
					}
					continue;
				}else if (currentPlayer.getLocation() == 0) {
					currentPlayer.setMoney(currentPlayer.getMoney()+200);
					System.out.println("");
					continue;
				}

				//if it is normal property, buying,renting ,building
				if (currentPlayer.getPlayerNumber()==0) {
					//Human player turn
		        	if (propertiesList.get(currentPlayer.getLocation()).getOwner() == currentPlayer.getPlayerNumber()) {
		        		System.out.println("Do you want to bulid house on this property? (Y/N)");
						Scanner input = new Scanner(System.in);
				        String choice = input.nextLine();
				        if (choice.equalsIgnoreCase("Y")) {
				        	Services.buildHouse(currentPlayer, propertiesList);
				        }
					
					}else if (propertiesList.get(currentPlayer.getLocation()).getOwner() == 5) {
						System.out.println("Do you want to buy this property? (Y/N)");
						Scanner input = new Scanner(System.in);
				        String choice = input.nextLine();
				        if (choice.equalsIgnoreCase("Y")) {
				        	Services.buyLand(currentPlayer, propertiesList);
				        }
					}else if (propertiesList.get(currentPlayer.getLocation()).getOwner() != currentPlayer.getPlayerNumber()) {
						Services.rent(currentPlayer, propertiesList, playersList);
					}
				}else {
					//AI turn
						if (propertiesList.get(currentPlayer.getLocation()).getOwner() == currentPlayer.getPlayerNumber()) {
							if (currentPlayer.getMoney()>=400) {
								Services.buildHouse(currentPlayer, propertiesList);
							}
						}else if (propertiesList.get(currentPlayer.getLocation()).getOwner() == 5) {
							if (currentPlayer.getMoney()>=300) {
								Services.buyLand(currentPlayer, propertiesList);
							}	
						}else if (propertiesList.get(currentPlayer.getLocation()).getOwner() != currentPlayer.getPlayerNumber()) {
							Services.rent(currentPlayer, propertiesList, playersList);
						}
				}
				System.out.println("");

				
			}
		}
		
		//Game ends
		
		Services.findWinner(playersList, propertiesList);
		System.out.println("End Game");
		
	}
	
	public static void findWinner(Player p0,Player p1,Player p2,Player p3) {
		ArrayList<Integer> finalScore = new ArrayList<>();
		finalScore.add(p0.getMoney());
		finalScore.add(p1.getMoney());
		finalScore.add(p2.getMoney());
		finalScore.add(p3.getMoney());
		finalScore.sort(null);
		if (p0.getMoney() == finalScore.get(finalScore.size()-1)) {
			System.out.println("Winner is "+p0.getPlayerName());
		}else if (p1.getMoney() == finalScore.get(finalScore.size()-1)) {
			System.out.println("Winner is "+p1.getPlayerName());
		}else if (p2.getMoney() == finalScore.get(finalScore.size()-1)) {
			System.out.println("Winner is "+p2.getPlayerName());
		}else if (p3.getMoney() == finalScore.get(finalScore.size()-1)) {
			System.out.println("Winner is "+p3.getPlayerName());
		}
	}
}
