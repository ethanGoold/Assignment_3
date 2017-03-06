import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;
import java.lang.Math;


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
    //passed variables
    private GameModel model;
    private GameController controller;

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
        int iconSize;
        if (x <= 25)
        {
            iconSize = 1;
        }
        else
        {
            iconSize = 2;
        }
        int width = Math.max((3-iconSize)*10*x, 180);
        int height = (3-iconSize)*10;

        //passed variablels
        this.model = model;
        controller = gameController;

        //window panels
        setLayout(new GridLayout(3, 1));
        board = new JPanel(new GridLayout(x, x));
        add(board); // BorderLayout.NORTH;
        board.setSize(width, height*x*10);

        gamePad = new JPanel(new GridLayout(1, 6));
        add(gamePad); // BorderLayout.CENTER);
        gamePad.setSize(width, 5);

        options = new JPanel(new GridLayout(1, 3));
        add(options); // BorderLayout.SOUTH);
        options.setSize(width, 5);

        //board variables
        dots = new DotButton[x*x];
        Random generator = new Random();
        //colors: grey-0, yellow-1, blue-2, green-3, purple-4, red-5
        for (int i = 0; i< dots.length; i++)
        {
            //initialize dot
            dots[i] = new DotButton(i/x, i%x, generator.nextInt(6), iconSize);
            dots[i].setSize((3-iconSize)*10, (3-iconSize)*10);
            board.add(dots[i]);
        }


        //gamePad variables -- FIX PARAMETERS: iconSize
        //colors: grey-0, yellow-1, blue-2, green-3, purple-4, red-5
        iconSize = 0;

        grey = new DotButton(0, iconSize);
        grey.setSize(30, 30);
        //grey.addActionListener(controller)
        gamePad.add(grey);

        yellow = new DotButton(1, iconSize);
        yellow.setSize(30, 30);
        //yellow.addActionListener(controller);
        gamePad.add(yellow);

        blue = new DotButton(2, iconSize);
        blue.setSize(30, 30);
        //blue.addActionListener(controller);
        gamePad.add(blue);

        green = new DotButton(3, iconSize);
        green.setSize(30, 30);
        //green.addActionListener(controller);
        gamePad.add(green);

        purple = new DotButton(4, iconSize);
        purple.setSize(30, 30);
        //purple.addActionListener(controller);
        gamePad.add(purple);

        red = new DotButton(5, iconSize);
        red.setSize(30, 30);
        //red.addActionListener(controller);
        gamePad.add(red);


        //options variables
        steps = new JLabel();
        options.add(steps);

        reset = new JButton("Reset");
        //reset.addActionListener(controller);
        options.add(reset);

        quit = new JButton("Quit");
        //quit.addActionListener(controller);
        options.add(quit);

        //setup and closing settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height*x + 60);
        setVisible(true);
    }

    /**
     * update the status of the board's DotButton instances based on the current game model
     */

    public void update()
    {
        //board variables

        //gamePad variables
        //  no variables to update

        //options variables
        //steps.setText("Number of Steps: " + model.getSteps());
        //options variables updated

    }

}
