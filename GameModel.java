import java.util.Random;


public class GameModel { 

	public static final int COLOR_0           = 0;
    public static final int COLOR_1           = 1;
    public static final int COLOR_2           = 2;
    public static final int COLOR_3           = 3;
    public static final int COLOR_4           = 4;
    public static final int COLOR_5           = 5;
    public static final int NUMBER_OF_COLORS  = 6;
    private DotInfo[] model;
    private int size;
    private int steps = 0; 
    private int currentSelectedColor; 
    private Stacks<DotInfo> captured;

    public GameModel (int size){
        captured = new Stacks<DotInfo>(size);
    	Random generator = new Random();
    	this.size = size;
    	model = new DotInfo[size*size];
    	for (int i = 0; i< model.length; i++){
    		model[i] = new DotInfo(i/size, i%size, generator.nextInt(6));

    	}

    }

    public void reset(){
    	model = new DotInfo[size*size];
        Random generator = new Random();
    	for (int i = 0; i< model.length; i++){
    		model[i] = new DotInfo(i/size, i%size, generator.nextInt(6));
    	}
    	steps = 0;
    }

    public int getSize(){
    	return size;

    }

    public int getColor(int i, int j){
    	return model[(size*i) + j].getColor();

    }

    public boolean isCaptured(int i, int j){
    	return model[(size*i) + j].isCaptured();

    }

    public void capture(int i, int j){
    	model[(size*i) + j].setCaptured(true);


    }

    public int getNumberOfSteps(){
    	return steps; 


    }

    public void setCurrentSelectedColor(int val){
    	currentSelectedColor = val;


    }

    public int getCurrentSelectedColor(){
    	return currentSelectedColor;


    }

    public DotInfo get(int i, int j){
    	return model[size*i + j];

    }

    public void step(){
    	steps++;


    }

    public boolean isFinished(){
    	boolean result = true;
    	return captured.isFull();


    }

    public String toString(){
    	StringBuilder string = new StringBuilder();
    	for (int i = 0; i<model.length; i++){
    		string.append("The dot at row " + i/size + " and column "
             + i%size + " is color " + model[i].getColor());
    	}
        return string.toString();

    }
}
