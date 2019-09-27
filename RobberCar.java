import java.awt.Graphics;
import java.util.Random;

public class RobberCar extends Car {

	
	private int xRatio;
	private int yRatio;
	private boolean captured = false;
	private boolean escaped = false;
	private int numCaptured = 0;
	private int numEscaped = 0;
	
	private static Engine obj = new Engine("RobberCar", 20, 200);
	
	public RobberCar()
	{
		
		super("RobberCar", 5000, obj, "red-car.jpg");
		super.fillUp();
		
		Random rand = new Random(); 

		xRatio = rand.nextInt((5 - -5) + 1) + -5;
		yRatio = rand.nextInt((5 - -5) + 1) + -5;
	}
	
	
	public void updateImage(Graphics g) {

		super.updateImage(g);
		
	}
	
	public void updateState(int width, int height)
	{
		
		
		if(((getX() > width) || (getX() < 0)) || ((getY() > height) || (getY() < 0)))
		{
			numEscaped += 1;
			escaped = true;
		}
		
		else
		{
			super.drive(4, xRatio, yRatio);
		}
		
	}
	
	public void captured()
	{
		xRatio = 0;
		yRatio = 0;
		captured = true;
		super.setImage("jail.jpg");
		numCaptured += 1;
	}
	
	public boolean isCaptured()
	{
		if(captured) 
			return true;
		return false;
	}
	
	public boolean hasEscaped()
	{
		if(escaped)
			return true;
		return false;
	}
	
	
}
