import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;


class Sprite
{
	private int locationX;
	private int locationY;
	private Image image;

	public Sprite(String jpgName)
	{
		setImage(jpgName);
		locationX = 0;
		locationY = 0;
	}
	
	public int getX() {	return locationX; }
	public int getY() {	return locationY; }
	public void setX(int x) { locationX = x; }
	public void setY(int y) { locationY = y; }
	
	public void setImage(String imagePath) {
        try {
            image = ImageIO.read(new File(imagePath));
        } catch (IOException ioe) {
            System.out.println("Unable to load image file.");
        }
	}
	public Image getImage() { return image; }	
	
	public void updateImage(Graphics g) {
		g.drawImage(getImage(), getX(), getY(), 60, 60, null);
	}
	
	public void updateState(int width, int height)
	{
		
	}
	
	//Note that the image for each Sprite is 60 x 60 pixels and its x and y coordinates specify its top left corner.
	public boolean overlaps(Sprite s) 
	{
		//if top left of S overlaps this
		if(((s.getX() >= this.getX()) && (s.getX() <= this.getX() + 60)) && ((s.getY() >= this.getY()) && (s.getY() <= this.getY() + 60)))
		{
			return true;
		}
		
		//if top right of S overlaps this
		else if(((s.getX() + 60 >= this.getX()) && (s.getX() + 60 <= this.getX() + 60)) && ((s.getY() >= this.getY()) && (s.getY() <= this.getY() + 60)))
		{
			return true;
		}
		
		//if bottom left of S overlaps this
		else if(((s.getX() >= this.getX()) && (s.getX() <= this.getX() + 60)) && ((s.getY() + 60 >= this.getY()) && (s.getY() + 60 <= this.getY() + 60)))
		{
			return true;
		}
		
		//if bottom right of S overlaps this
		else if(((s.getX() + 60 >= this.getX()) && (s.getX() + 60 <= this.getX() + 60)) && ((s.getY() + 60 >= this.getY()) && (s.getY() + 60 <= this.getY() + 60)))
		{
			return true;
		}
		
		return false;
		
	}
}