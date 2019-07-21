import java.util.ArrayList;
import java.util.Random;
public class Services {

	public static int diceNumber() {
		Random rand=new Random();
		int diceNumber=rand.nextInt(7);
		while(diceNumber==0) {
			diceNumber=rand.nextInt(7);
		}
		return diceNumber;
	}
	
	public static void locationUpdate(Player p) {
		int location=p.getLocation();
		location+=diceNumber();
		if(location>=11) {
			location-=11;
		}
		p.setLocation(location);

	}
	
	public static void rent(Player player,Player landOwner,Property landInformation,ArrayList<Integer> propertyList) {
		int location=player.getLocation();
		System.out.println(location);
		if(propertyList.get(location)!=player.getPlayerNumber()&&location!=6) {
			System.out.println("player:"+player+"pay"+landInformation.getRent()+"to"+landOwner);
			Transfer(player,landOwner,landInformation.getRent());
		}
	}
	
	public static void Transfer(Player a,Player landOwner, int moneyAmount) {
		a.setMoney(a.getMoney() + moneyAmount);
		landOwner.setMoney(landOwner.getMoney() - moneyAmount);
	}
	
	public static void payJail(Player player,Property landInformation,ArrayList<Integer> propertyList) {
		int location=player.getLocation();
		int moneyRemained=player.getMoney();
		if(location==6) {
			System.out.println("Get into the jail,pay 50 dollar.");
			moneyRemained-=50;
		}player.setMoney(moneyRemained);
	}
	
	public static void buyLand(Player player,ArrayList<Integer> propertyList,Property landInformation) {
		int location=player.getLocation();
		if(location!=6&&propertyList.get(location)==0&&location!=0) {
			propertyList.set(location,player.getPlayerNumber());
			player.setMoney(player.getMoney()-landInformation.getCost());
		}
	}
	
	public static void sellLand(Player player,ArrayList<Integer> propertyList,Property landInformation) {
		int location=player.getLocation();
		int moneyUpdate=player.getMoney();
		if(propertyList.get(location)==player.getPlayerNumber()) {
			System.out.println("Buy the land");
			moneyUpdate+=(int) (landInformation.getCost()*0.75);
			player.setMoney(moneyUpdate);
		}
	}
	public static void sellLandEnd() {
		
	}

	public static Player searchPlayer(int position, ArrayList<Property> propertieslist, ArrayList<Player> playerslist) {
		for (Property i :propertieslist) {
			for (Player j :playerslist) {
				if (j.getPlayerNumber() == i.getOwnner()) {
					return j;
				}
			}
		
		}
		return null;
	}
	
	public static Property searchProperty(int position, ArrayList<Property> propertieslist) { 

			for (Property j :propertieslist) {
				if (position == j.getPosition()) {
					return j;
				}
			}
		return null;
	}
}