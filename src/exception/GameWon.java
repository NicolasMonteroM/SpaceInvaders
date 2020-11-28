package exception;

public class GameWon extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7232952306590260886L;

	public GameWon() {
		super("You won :D");
	}

}
