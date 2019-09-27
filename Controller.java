import java.awt.Graphics;
import java.io.IOException;
import java.awt.event.MouseListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import javax.swing.Timer;
import javax.swing.SwingUtilities;

class Controller implements MouseListener, KeyListener
{
    Model model;
    View view;
    SpriteMover mover;

    Controller() throws IOException, Exception {
        model = new Model();
        view = new View(this);
        //new Timer(50, view).start();
    }

    public void update(Graphics g) {
        model.update(g);
    }

    public void mousePressed(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)) {
			// Gets here is left mouse button was clicked
			view.repaint();
			int x = e.getX();
			int y = e.getY();
			model.addSprite(x, y);
			
		} else if (SwingUtilities.isRightMouseButton(e))  {
			// Gets here if right mouse button was clicked
			model.updateScene(view.getWidth(), view.getHeight());
			view.repaint();
		}
    }
    
  

    public void mouseReleased(MouseEvent e) {    }
    public void mouseEntered(MouseEvent e) {    }
    public void mouseExited(MouseEvent e) {    }
    public void mouseClicked(MouseEvent e) {    }
    
    public void keyTyped(KeyEvent e) 
    {
    	if(e.getKeyChar() == 'h')
    	{
    		System.out.println("hello world");
    	}
    	
    	else if(e.getKeyChar() == 'n')
    	{
    		System.out.println("Number of cars captured: " + model.getCaptured());
    		System.out.println("Number of cars escaped: " + model.getEscaped());
    	}
    	
    	else if(e.getKeyChar() == 'r')
    	{
    		model.initialize();
    		view.repaint();
    	}
    	
    	else if(e.getKeyChar() == 's')
    	{
    		mover = new SpriteMover(model, view);
    		Thread t = new Thread(mover);
    		t.start();
    		
    		
    	}
    	
    }
    
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
    

    public static void main(String[] args) throws Exception {
        new Controller();
    }

	
	

	
	
}

