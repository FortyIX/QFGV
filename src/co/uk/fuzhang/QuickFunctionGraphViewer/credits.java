package co.uk.fuzhang.QuickFunctionGraphViewer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class credits {

	JFrame frmCredits;
	protected Object frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					credits window = new credits();
					window.frmCredits.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public credits() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		
		
		frmCredits = new JFrame();
		frmCredits.setTitle("Credits");
		frmCredits.setBounds(100, 100, 405, 319);
		frmCredits.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCredits.getContentPane().setLayout(null);
		
		JLabel lblQuickFunction = new JLabel("Quick Function Graph Viewer");
		lblQuickFunction.setFont(new Font("Yu Gothic", Font.PLAIN, 21));
		lblQuickFunction.setBounds(59, 13, 296, 43);
		frmCredits.getContentPane().add(lblQuickFunction);
		
		JLabel lblVersion = new JLabel("Version:");
		lblVersion.setBounds(132, 69, 72, 18);
		frmCredits.getContentPane().add(lblVersion);
		
		JLabel label = new JLabel("1.1");
		label.setBounds(207, 69, 72, 18);
		frmCredits.getContentPane().add(label);
		
		JLabel lblCode = new JLabel("Code:");
		lblCode.setBounds(142, 100, 72, 18);
		frmCredits.getContentPane().add(lblCode);
		
		JLabel lblFortyix = new JLabel("FortyIX");
		lblFortyix.setBounds(192, 100, 72, 18);
		frmCredits.getContentPane().add(lblFortyix);
		
		JLabel lblNewLabel = new JLabel("Any enquiry. Please email");
		lblNewLabel.setBounds(101, 158, 222, 18);
		frmCredits.getContentPane().add(lblNewLabel);
		
		JLabel lblContactfuzhangcouk = new JLabel("fortyix.contact@gmail.com\r\n");
		lblContactfuzhangcouk.setForeground(Color.RED);
		lblContactfuzhangcouk.setBounds(101, 177, 223, 18);
		frmCredits.getContentPane().add(lblContactfuzhangcouk);
		
		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				frmCredits.setVisible(false);
			}
		});
		btnClose.setBounds(151, 232, 113, 27);
		frmCredits.getContentPane().add(btnClose);
	}

}
