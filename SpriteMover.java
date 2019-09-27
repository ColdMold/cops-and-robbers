
public class SpriteMover implements Runnable {

	private Model model;
	private View view;
	public SpriteMover(Model m, View v)
	{
		model = m;
		view = v;
	}

	public void run() 
	{
		while (true) {

			model.updateScene(model.getViewWidth(), model.getViewHeight());
			view.repaint();
			
	        try {
	            Thread.sleep(2);
	        } catch (InterruptedException e) {
	        	e.printStackTrace();
	        	Thread.currentThread().interrupt();
	        }
	    }
	}

}
