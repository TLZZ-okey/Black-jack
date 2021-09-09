import java.util.LinkedList;
import java.lang.Exception;
import java.util.Collections;

public class Deck{
	private LinkedList<Card> cardList;

	public Deck(int nbBox){
		cardList = new LinkedList<Card>();
		//Value[] valueArray = Value.values();
		//Color[] colorArray = Color.values();

		for(int i = 0; i < nbBox; i++){
			for(Value val : Value.values()){
				for(Color col : Color.values()){
					Card c = new Card(val,col);
					cardList.add(c);
				}
			}
		}
		Collections.shuffle(cardList);
	}
	public String toString(){
		return cardList.toString();
	}
	public Card draw() throws EmptyDeckException{
		if(cardList.size() == 0)
			throw new EmptyDeckException();
		return cardList.pollFirst();
	}
}