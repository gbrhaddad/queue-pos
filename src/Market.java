import javax.swing.JFrame;
public class Market extends JFrame{
		
	Market(String titel){
	super(titel);
	this.setSize(1200,200);
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.setVisible(true);
	
			
	ControlPanel panel = new ControlPanel(new Store());
		 this.add(panel);
		 this.setVisible(true);
		}
	
	public static void main(String[] args) {
		new Market("Market");

	}
}
