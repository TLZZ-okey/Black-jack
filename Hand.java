import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class Hand{
	private LinkedList<Card> cardList;
	private List<Integer> result;
	
	public Hand(){
		cardList = new LinkedList<Card>();
	}

	public String toString(){
		return cardList.toString();
	}

	public void add(Card card){
		cardList.add(card);
	}

	public void clear(){
		cardList.clear();
	}

	public List<Integer> count(){
		result = new ArrayList<Integer>();
		result.add(0);
		int val;
		int lenght;
		for(Card c : cardList){
			lenght = result.size();
			for(int i = 0; i < lenght; i++){
				val = result.get(i);
				result.set(i, val+c.getPoints());
				if(c.getPoints() == 1){
					result.add(val+11);
				}
			}
		}
		return result;
	}

	public int best(){
		int max = result.get(0);
		for(int i : result){
			if(i > max && i <= 21){
				max = i;
			}
		}
		return max;
	}
}