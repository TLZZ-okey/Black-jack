import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;

public class BlackJack{
	private Deck deck = new Deck(4);
	private Hand playerHand = new Hand();
	private Hand bankHand = new Hand();
	private Boolean gameFinished = false;
	private int playerScore;
	private int bankScore;
	private String SCORE_FILENAME = "score.txt";

	public BlackJack(){
		try {
			reset();
		} catch (EmptyDeckException ex) {
			System.err.println(ex.getMessage());
			System.exit(-1);
		}
	}

	public void reset() throws EmptyDeckException{
		playerHand.clear();
		bankHand.clear();
		bankHand.add(deck.draw());
		playerHand.add(deck.draw());
		playerHand.add(deck.draw());

	}

	public String getPlayerHandString(){
		return playerHand.toString();
	}

	public String getBankHandString(){
		return bankHand.toString();
	}

	public int getPlayerBest(){
		playerHand.count();
		return playerHand.best();
	}

	public int getBankBest(){
		bankHand.count();
		return bankHand.best();
	}

	public Boolean isPlayerWinner(){
		if(getBankBest() > 21 || (getPlayerBest() >= getBankBest() && getPlayerBest() <= 21)){
			return true;
		}
		return false;
	}

	public Boolean isBankWinner(){
		if(getPlayerBest() > 21 || (getPlayerBest() <= getBankBest() && getBankBest() <= 21)){
			return true;
		}
		return false;
	}

	public Boolean isGameFinished(){
		return gameFinished;
	}

	public void playerDrawAnotherCard() throws EmptyDeckException{
		playerHand.add(deck.draw());

		if(getPlayerBest() > 21){
			gameFinished = true;
		}
	}

	public void bankLastTurn() throws EmptyDeckException{
		if(!isGameFinished() && getBankBest() <= 21){
			while(getBankBest() < getPlayerBest()){
				bankHand.add(deck.draw());
			}
			gameFinished = true;
		}
	}

	public void updateScores(){
		if(isPlayerWinner()){
			playerScore++;
		}

		if(isBankWinner()){
			bankScore++;
		}
	}
	public void writeScore(){
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(SCORE_FILENAME));
			bw.write("player " + playerScore);
			bw.newLine();
			bw.write("bank " + bankScore);
			bw.close();
      		//System.out.println("Successfully wrote to the file.");
    	} catch (IOException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    	}
	}
	public void readScore(){
		String Score1;
		String Score2;
		try {
			BufferedReader br = new BufferedReader(new FileReader(SCORE_FILENAME));
			Score1 = br.readLine();
			Score2 = br.readLine();
			String[] line1 = Score1.split("\\s");
			playerScore = Integer.parseInt(line1[1]);
      		System.out.println("Score Player : "+playerScore);

			String[] line2 = Score2.split("\\s");
			bankScore = Integer.parseInt(line2[1]);
      		System.out.println("Score Bank : "+bankScore);
			br.close();
    	} catch (IOException e) {
      		System.out.println("An error occurred.");
      		e.printStackTrace();
    	}
    }
}