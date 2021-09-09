import java.lang.Exception;

public class EmptyDeckException extends Exception{
	public EmptyDeckException(){
		super("Il n'y a plus de carte dans le deck !");
	}
}