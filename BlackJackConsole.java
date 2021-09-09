import java.util.Scanner;

public class BlackJackConsole {
	public BlackJackConsole() {
		Scanner scan = new Scanner(System.in);
		String anotherCard;
		BlackJack bj = new BlackJack();
		System.out.println("Welcome to the BlackJack table. Let's play !");
		System.out.println();
		bj.readScore();
		System.out.println();
		System.out.println("The bank draws: "+bj.getBankHandString()+" : "+bj.getBankBest());
		System.out.println("You draw : "+ bj.getPlayerHandString()+" : "+bj.getPlayerBest());
		
		while(!bj.isGameFinished()){
			System.out.println("Do you want another card? [y/n]");
			anotherCard = scan.nextLine();
			try {
				if(anotherCard.contains("y")){
					bj.playerDrawAnotherCard();
					System.out.println("Your hand is : "+ bj.getPlayerHandString()+" : "+bj.getPlayerBest());
				}
				else if(anotherCard.contains("n")){
					bj.bankLastTurn();
					System.out.println("The bank draws: "+bj.getBankHandString()+" : "+bj.getBankBest());
				}
			} catch (EmptyDeckException ex) {
					System.err.println(ex.getMessage());
					System.exit(-1);
			}
		}
		
		System.out.println("Player best : "+bj.getPlayerBest());
		System.out.println("Bank best : "+bj.getBankBest());
		System.out.println();

		if(bj.isPlayerWinner() && bj.isBankWinner()){
			System.out.println("Draw !");
		}

		else if(bj.isPlayerWinner()){
			System.out.println("You won !");
		}
		else if(bj.isBankWinner()){
			System.out.println("You loose...");
		}
		System.out.println();
		bj.updateScores();
		bj.writeScore();
		bj.readScore();
	}
	public static void main(String[] args) {
		new BlackJackConsole();
	}
}