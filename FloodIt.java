

/**
 * The class <b>FloodIt</b> launches the game
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class FloodIt 
{
   /**
     * <b>main</b> of the application. Creates the instance of  GameController 
     * and starts the game. If a game size greater than 10 is passed as parameter, it is 
     * used as the board size. Otherwise, a default value is passed.
     * 
     * @param args
     *            command line parameters
     */
    public static void main(String[] args) 
    {
    	//Obtaining board size
    	int size;
    	if (args.length != 0)
    	{
    		try
    		{
    			size = Integer.parseInt(args[0]);
    		}
    		catch (java.lang.NumberFormatException e)
    		{
    			size = 5;
    		}
    		if (size < 10)
    		{
    			System.out.println("Invalid input! Board size set to default (12).");
    			size = 12;
    		}
    	}
    	else
    	{
    		size = 12;
    	}
    	//

    	//Opening game
    	GameController controller = new GameController(size);
    	//

    }


}
