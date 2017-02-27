package co.uk.fuzhang.QuickFunctionGraphViewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class help {

	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					help window = new help();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public help() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 546, 489);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JTextArea txtrHelpFeatures = new JTextArea();
		txtrHelpFeatures.setEditable(false);
		txtrHelpFeatures.setFont(new Font("Courier New", Font.PLAIN, 15));
		txtrHelpFeatures.setText("Help:\r\n\r\nFeatures:     \r\n1. Quick - just type number\r\n2. Powerful - support drawing up to quartic equation\r\n3. Real-time change when you you change size \r\n4. Color Customisation\r\n  \r\n\r\nHow to use them\r\n \r\n1. Type the coefficient of the equation you want\r\n    You can type 0 as a coeffcient if you don't \r\n    need that term\r\n\r\n2. Press \"Draw Function Graph\" button to draw it\r\n\r\n3. You can change the color of coordinate system and graph \r\n    by going to preference page");
		txtrHelpFeatures.setBounds(0, 0, 528, 381);
		frame.getContentPane().add(txtrHelpFeatures);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frame.setVisible(false);
			}
		});
		btnClose.setBounds(205, 402, 113, 27);
		frame.getContentPane().add(btnClose);
	}
}
