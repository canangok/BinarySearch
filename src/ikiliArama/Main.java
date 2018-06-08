import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Main {
private JFrame frame;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				    ikiliArama window = new ikiliArama();
					window.pencere.setVisible(true);
					window.pencere.revalidate();
					window.pencere.repaint();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
				
			}
		});
	}
		

	}




