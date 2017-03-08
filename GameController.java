import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.lang.Math;

/**
 * The class <b>GameController</b> is the controller of the game. It has a method
 * <b>selectColor</b> which is called by the view when the player selects the next
 * color. It then computesthe next step of the game, and  updates model and view.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */
public class GameController implements ActionListener 
{

    private GameModel model;
    private GameView game;
    private Stack<DotInfo> captured;


    /**
     * Constructor used for initializing the controller. It creates the game's view 
     * and the game's model instances
     * 
     * @param size
     *            the size of the board on which the game will be played
     */
    public GameController(int size) 
    {

        model = new GameModel(size);
        game = new GameView(model, this);
        model.capture(0, 0);
        selectColor(model.getColor(0, 0));
        captured = new Stack<DotInfo>(size*size);

    }

    /**
     * resets the game
     */
    public void reset(){

        model.reset();
        game.update();
    }

    /**
     * Callback used when the user clicks a button (reset or quit)
     *
     * @param e
     *            the ActionEvent
     */
    public void actionPerformed(ActionEvent e) 
    {
        //colors: grey-0, yellow-1, blue-2, green-3, purple-4, red-5
        if (e.getActionCommand().equals("Quit"))
        {
            System.exit(0);
        } else if (e.getActionCommand().equals("Reset"))
        {
            reset();

        } else if (e.getActionCommand().equals("grey"))
        {
            model.step();
            selectColor(0);
            game.update();

        } else if (e.getActionCommand().equals("yellow"))
        {
            model.step();
            selectColor(1);
            game.update();

        } else if (e.getActionCommand().equals("blue"))
        {
            model.step();
            selectColor(2);
            game.update();

        } else if (e.getActionCommand().equals("green"))
        {
            model.step();
            selectColor(3);
            game.update();

        } else if (e.getActionCommand().equals("purple"))
        {
            model.step();
            selectColor(4);
            game.update();

        } else if (e.getActionCommand().equals("red"))
        {
            model.step();
            selectColor(5);
            game.update();
        }
    }

    /**
     * <b>selectColor</b> is the method called when the user selects a new color.
     * If that color is not the currently selected one, then it applies the logic
     * of the game to capture possible locations. It then checks if the game
     * is finished, and if so, congratulates the player, showing the number of
     * moves, and gives two options: start a new game, or exit
     * @param color
     *            the newly selected color
     */
    public void selectColor(int color){

        model.setCurrentSelectedColor(color);
        int x = model.getSize();
        for (int i = 0; i < x*x; i++)
        {
               if (model.isCaptured(i/x, i%x))
               {
                    model.get(i/x, i%x).setColor(color);
                    captured.push(model.get(i/x, i%x));
               }
        }

        while (!captured.isEmpty() && !captured.isFull())
        {
            DotInfo dot = captured.pop();
            int row = dot.getX();
            int coln = dot.getY();

            if (row - 1 >= 0)
            {
                if (model.getColor(row - 1, coln) == color && !model.isCaptured(row - 1, coln))
                {
                    captured.push(model.get(row - 1, coln));
                    model.capture(row - 1, coln)
                }
            }
            if (row + 1 < model.getSize())
            {
                if (model.getColor(row + 1, coln) == color && !model.isCaptured(row + 1, coln))
                {
                    captured.push(model.get(row + 1, coln));
                    model.capture(row + 1, coln)
                }
            }
            if (coln + 1 < model.getSize())
            {
                if (model.getColor(row, coln + 1) == color && !model.isCaptured(row, coln + 1))
                {
                    captured.push(model.get(row, coln + 1));
                    model.capture(row, coln + 1)
                }
            }
            if (coln - 1 >= 0)
            {
                if (model.getColor(row, coln - 1) == color && !model.isCaptured(row, coln - 1))
                {
                    captured.push(model.get(row, coln - 1));
                    model.capture(row, coln - 1)
                }
            }
        } //end while;

        if (model.isFinished())
        {
            System.out.println("DIALOG BOX");
        }
    } // end selectColor();


// ADD YOUR PRIVATE METHODS HERE



}
