import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;


/**
 * The class <b>GameView</b> provides the current view of the entire Game. It extends
 * <b>JFrame</b> and lays out the actual game and 
 * two instances of JButton. The action listener for the buttons is the controller.
 *
 * @author Guy-Vincent Jourdan, University of Ottawa
 */

public class GameView extends JFrame 
{
    //instance variables

    //window panels
    private JPanel board;
    private JPanel gamePad;
    private JPanel options;
    //board variables
    private DotButton[] dots;
    //gamePad variables
    private DotButton grey, yellow, blue, green, purple, red;
    //options variables
    private JLabel steps;
    private JButton reset, quit;

    /**
     * Constructor used for initializing the Frame
     * 
     * @param model
     *            the model of the game (already initialized)
     * @param gameController
     *            the controller
     */

    public GameView(GameModel model, GameController gameController) 
    {
        //tmp board size
        int x = 3;

        //window panels
        setLayout(new GridLayout(3, 1));
        board = new JPanel(new GridLayout(x, x));
        add(board);

        gamePad = new JPanel(new GridLayout(1, 6));
        add(gamePad);

        options = new JPanel(new GridLayout(1, 3));
        add(options);

        //board variables
        dots = new DotButton[x*x];
        int iconSize; //to determine later
        Random gen = new Random generator;

        for (int i = 0; i< dots.length; i++)
        {
            //initialize dot
            dots[i] = new DotButton(i/x, i%x, generator.nextInt(6), iconSize);
            board.add(dots[i]);
        }


        //gamePad variables -- FIX PARAMETERS: color, iconSize, controller
        grey = new DotButton(color, iconSize);
        grey.addActionListener(controller)
        gamePad.add(grey);

        yellow = new DotButton(color, iconSize);
        yellow.addActionListener(controller);
        gamePad.add(yellow);

        blue = new DotButton(color, iconSize);
        blue.addActionListener(controller);
        gamePad.add(blue);

        green = new DotButton(color, iconSize);
        green.addActionListener(controller);
        gamePad.add(green);

        purple = new DotButton(color, iconSize);
        purple.addActionListener(controller);
        gamePad.add(purple);

        red = new DotButton(color, iconSize);
        red.addActionListener(controller);
        gamePad.add(red);


        //options variables -- FIX PARAMETERS: controller
        steps = new JLabel();
        options.add(steps);

        reset = new JButton("Reset");
        reset.addActionListener(controller);
        options.add(reset);

        quit = new JButton("Quit");
        quit.addActionListener(controller);
        options.add(quit);

        //setup and closing settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 100);
        setVisible(true);
    }

    /**
     * update the status of the board's DotButton instances based on the current game model
     */

    public void update()
    {

// ADD YOUR CODE HERE

    }

}
