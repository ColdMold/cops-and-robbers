public class GasTank {

	private int maxCapacity;
	private double level;
	
	public GasTank(int capacity)
	{
		level = 0;
		
		if(capacity < 0)
		{
			maxCapacity = 0;
		}
		
		else
		{
			maxCapacity = capacity;
		}
	}
	
	public int getCapacity()
	{
		return maxCapacity;
	}
	
	public double getLevel()
	{
		return level;
	}
	
	public void setLevel(double levelIn)
	{
		if(levelIn < 0)
		{
			level = 0;
		}
		
		else if(levelIn > maxCapacity)
		{
			level = maxCapacity;
		}
		
		else
		{
			level = levelIn;
		}
	}
	
}