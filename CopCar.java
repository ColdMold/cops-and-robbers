import java.awt.Graphics;
import java.util.Random;

public class CopCar extends Car {

	
	private static int xRatio;
	private static int yRatio;
	private boolean xSign = true;
	private boolean ySign = true;
	
	private static Engine obj = new Engine("CopCar", 30, 100);
	
	public CopCar()
	{
		
		super("CopCar", 5000, obj, "cop-car.jpg");
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
		if(xSign && ySign)
		{
			super.drive(2, xRatio, yRatio);
		}
		
		else if(xSign && !ySign)
		{
			super.drive(2, xRatio, -yRatio);
		}
		
		else if(!xSign && ySign)
		{
			super.drive(2, -xRatio, yRatio);
		}
		
		else
		{
			super.drive(2, -xRatio, -yRatio);
		}
		
	}
	
	public void invertX()
	{
		if(xSign)
			xSign = false;
		else
			xSign = true;
	}
	
	public void invertY()
	{
		if(ySign)
			ySign = false;
		else
			ySign = true;
	}
}
