import java.awt.Graphics;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public class Car extends Sprite {
	
	NumberFormat formatter = new DecimalFormat("#0.00");

	private String description;
	private GasTank tank;
	private Engine engine;
	
	public Car(String desc, int capacity, Engine obj, String jpg)
	{
		super(jpg);
		
		
		if(desc.length() == 0)
		{
			description = "Generic car";
		}
		
		else
		{
			description = desc;
		}
		
		if(obj == null)
		{
			engine = new Engine("", 0, 0);
		}
		
		else
		{
			engine = obj;
		}
		
		tank = new GasTank(capacity);
		
	}
	
	public String getDescription()
	{
		String desc = description + " (engine: " + engine.getDescription() + "), fuel: " + formatter.format(tank.getLevel()) + 
				"/" + tank.getCapacity() + ", location: (" + super.getX() + "," + super.getY() + ")";
		
		return desc;
	}
	
	public double getFuelLevel()
	{
		return tank.getLevel();
	}
	
	public int getMPG()
	{
		return engine.getMPG();
	}
	
	public void fillUp()
	{
		tank.setLevel(tank.getCapacity());
	}
	
	public int getMaxSpeed()
	{
		return engine.getSpeed();
	}
	
	public double drive(int distance, double xRatio, double yRatio)
	{
		
		double x = xRatio;
        double y = yRatio;
        double h;

        h = Math.sqrt((x * x) + (y * y));
        
        if((getFuelLevel() - (distance/getMPG())) <= 0)
        {
        	distance = (int)(getFuelLevel() * getMPG());
        	System.out.printf("Ran out of gas after driving %.2f miles.\n", (double)distance);        	
        }

        double tmpX = (x * distance) / h;
        double tmpY = (y * distance) / h;
        
        super.setX(super.getX() + (int)tmpX );
        super.setY(super.getY() + (int)tmpY );
		tank.setLevel(getFuelLevel() - ((double)distance/getMPG()));
		
		return distance;
		
	}
	
	public void updateImage(Graphics g) {
        
		super.updateImage(g);
		
	}
	
	
	
}