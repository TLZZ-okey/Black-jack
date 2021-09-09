public class Card{
	Value val;
	Color col;

	public Card(Value val, Color col){
		this.val = val;
		this.col = col;
	}
	public String toString(){
        return val.getSymbole()+col.getSymbole();
    }
	public String getColorSymbole(){
		return col.getSymbole();
	}
	public String getColorName(){
		return col.name();
	}
	public String getValueSymbole(){
		return val.getSymbole();
	}
	public int getPoints(){
		return val.getPoints();
	}
}