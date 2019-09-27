import java.awt.Graphics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;



class Model
{
    private CopCar copCar;
    private RobberCar robberCar;
    private Bank bank;
    private ArrayList<Sprite> sprites = new ArrayList<Sprite>();
    private int numCaptured = 0;
    private int numEscaped = 0;
    private int viewWidth;
    private int viewHeight;

    Model() throws IOException {
    	
    	bank = new Bank();
    	sprites.add(bank);
    }
    	
    
    public synchronized void update(Graphics g) {
		
    	for(int i = 0; i < sprites.size(); i++)
    	{
    		sprites.get(i).updateImage(g);
    	}
    
    }
    
    
    public synchronized void addSprite(int x, int y)
    {
 
    	
    	if(sprites.size() == 1)
    	{
    		robberCar = new RobberCar();
    		robberCar.setX(300);
    		robberCar.setY(300);
        	sprites.add(robberCar);
    	}
    	
    	else
    	{
    		if(sprites.get((sprites.size())-1).getClass() == robberCar.getClass())
        	{
            	copCar = new CopCar();
        		copCar.setX(x);
        		copCar.setY(y);
            	sprites.add(copCar);
        	}
        	
        	else 
        	{
        		robberCar = new RobberCar();
        		robberCar.setX(300);
        		robberCar.setY(300);
            	sprites.add(robberCar);
        	}
    	}
    	
    	
    	
    	
    	
    }
    
    public synchronized void updateScene(int width, int height)
    {
    	viewWidth = width;
    	viewHeight = height;
    	for(int i = 1; i < sprites.size(); i++)
    	{
    		
    		if(sprites.get(i).getClass() == robberCar.getClass())
    		{
    			sprites.get(i).updateState(width, height);
    			
    			if(((RobberCar) sprites.get(i)).hasEscaped() == true)
				{
    				numEscaped += 1;
    				
    				Iterator itr = sprites.iterator(); 
    				while (itr.hasNext()) 
    		        { 
    		            Sprite s = (Sprite) itr.next();
    		            if(s.getClass() == robberCar.getClass())
    		            {
    		            	if(((RobberCar) s).hasEscaped())
        		            {
        		            	System.out.println("I'm free!");
        		            	itr.remove();
        		            }
    		            }
    		            
    		        } 
    				    
				}
    			
    		}
    		
    		else if(sprites.get(i).getClass() == copCar.getClass())
    		{
    			sprites.get(i).updateState(width, height);
    			
    			for(int j = 0; j < sprites.size(); j++)
    			{
    				
    				if(sprites.get(j).getClass() == robberCar.getClass())
    				{
    					if(sprites.get(i).overlaps(sprites.get(j)))
        				{
        					
        					if(((RobberCar) sprites.get(j)).isCaptured() == false)
        					{
        						((RobberCar) sprites.get(j)).captured();
        						numCaptured += 1;
        					}
        					
        				}
    				}
    				
    			}
    			
    			if((sprites.get(i).getX() > width) || (sprites.get(i).getX() < 0))
    			{
    				((CopCar) sprites.get(i)).invertX();	
    			}
    			
    			if((sprites.get(i).getY() > height) || (sprites.get(i).getY() < 0))
    			{
    				((CopCar) sprites.get(i)).invertY();
    			}	
    		}
    		
    		
    		
    	}
    	
    }
    
    public int getCaptured()
	{
		return numCaptured;
	}
	
	public int getEscaped()
	{
		return numEscaped;
	}
	
	public synchronized void initialize()
	{
		sprites.clear();
		
		bank = new Bank();
    	sprites.add(bank);
    	
    	numEscaped = 0;
    	numCaptured = 0;
	}
	
	public int getViewWidth()
	{
		return viewWidth;
	}
	
	public int getViewHeight()
	{
		return viewHeight;
	}
}