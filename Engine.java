public class Engine {

	private String engineName;
	private int engineMPG;
	private int maxSpeed;
	
	public Engine(String name, int mpg, int speed)
	{
		if(name.length() == 0)
		{
			engineName = "Generic engine";
		}
		
		else
		{
			engineName = name;
		}
		
		if(mpg < 0)
		{
			engineMPG = 0;
		}
		
		else
		{
			engineMPG = mpg;
		}
		
		if(speed < 0)
		{
			maxSpeed = 0;
		}
		
		else
		{
			maxSpeed = speed;
		}
		
	}
	
	public String getDescription()
	{
		String description = engineName + " (MPG: " + getMPG() + ", Max speed: " + getSpeed() + ")";
		return description;
	}
	
	public int getMPG()
	{
		return engineMPG;
	}
	
	public int getSpeed()
	{
		return maxSpeed;
	}
	
}