package co.uk.fuzhang.QuickFunctionGraphViewer;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.geom.Line2D;
import java.util.ServiceLoader;
import java.awt.event.ActionEvent;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;

import javax.swing.*;
import java.awt.Font;

import co.uk.fuzhang.QuickFunctionGraphViewer.preference;


public class main {

    static public  ColorOption cs_color;
    static public  ColorOption g_color;
   
    
	private JFrame frmQuickFunctionGraph;
	private JTextField coff_a;
	private JTextField coff_c;
	private JTextField coff_b;
	private JTextField coff_d;
	private JTextField coff_e;

	private int a,b,c,d,e; 
	public float Size=50;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					main window = new main();
					window.frmQuickFunctionGraph.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		
		cs_color = new ColorOption(1);
		g_color = new ColorOption(Color.PINK);
		
		System.out.println("CS color:"+cs_color.getColorSelectedIndex());
		System.out.println("G color:"+g_color.getColorSelectedIndex());
		
		frmQuickFunctionGraph = new JFrame();
		frmQuickFunctionGraph.setTitle("Quick Function Graph Viewer");
		frmQuickFunctionGraph.setBounds(100, 100, 445, 670);
		frmQuickFunctionGraph.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQuickFunctionGraph.getContentPane().setLayout(null);
		
		coff_a = new JTextField();
		coff_a.setToolTipText("a");
		coff_a.setBounds(58, 33, 43, 24);
		frmQuickFunctionGraph.getContentPane().add(coff_a);
		coff_a.setColumns(10);
		
		coff_c = new JTextField();
		coff_c.setToolTipText("c");
		coff_c.setBounds(219, 33, 43, 24);
		frmQuickFunctionGraph.getContentPane().add(coff_c);
		coff_c.setColumns(10);
		
		coff_b = new JTextField();
		coff_b.setToolTipText("b");
		coff_b.setBounds(135, 33, 43, 24);
		frmQuickFunctionGraph.getContentPane().add(coff_b);
		coff_b.setColumns(10);
		
		coff_d = new JTextField();
		coff_d.setToolTipText("d");
		coff_d.setBounds(304, 33, 36, 24);
		frmQuickFunctionGraph.getContentPane().add(coff_d);
		coff_d.setColumns(10);
		
		coff_e = new JTextField();
		coff_e.setToolTipText("e");
		coff_e.setBounds(376, 33, 43, 24);
		frmQuickFunctionGraph.getContentPane().add(coff_e);
		coff_e.setColumns(10);
		
		
		
		JPanel panel = new JPanel();
		panel.setBounds(14, 128, 400, 400);
		frmQuickFunctionGraph.getContentPane().add(panel);
		
         JSlider slider = new JSlider();
         slider.setToolTipText("available after a function is drawn");
         slider.setEnabled(false);
         //disable the slider at beginning 
         // until user graph is generated
         
		  slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent arg0) {
				
				// giving input to variable
				Size=slider.getValue();
				
				if(Size==0){
					JOptionPane.showMessageDialog(null, "Scale cannot be zero");
					slider.setValue(50);
				}
				
				// clear original stuff
				panel.removeAll();
				
				// new instance
               Functiongraph graph=new Functiongraph(a,b,c,d,e,Size,cs_color.getColorSelected(),g_color.getColorSelected());
				
               // update panel
				panel.add(graph);
				panel.revalidate();
				graph.repaint();
				
			}
		});
		
		
		
		JButton btnNewButton = new JButton("Draw the Graph");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			 
				if(coff_a.getText()==" "||coff_b.getText()==" "||coff_c.getText()==" "||coff_d.getText()==" "||coff_e.getText()==" ")
				{
					
					JOptionPane.showMessageDialog(null, "Type in a function question to start and you need to fill all fields ");
					
				}
				else{
					 slider.setEnabled(true);
	               
				   // clear original stuff
				    panel.removeAll(); 
					
	               // giving input to variables 
					a=Integer.parseInt(coff_a.getText());
					b=Integer.parseInt(coff_b.getText());
					c=Integer.parseInt(coff_c.getText());
					d=Integer.parseInt(coff_d.getText());
					e=Integer.parseInt(coff_e.getText());
					
					//debug
					//System.out.println("first a"+a);
					
					// new instance
					Functiongraph graph=new Functiongraph(a,b,c,d,e,Size,cs_color.getColorSelected(),g_color.getColorSelected());
					
					System.out.println("sending to render"+cs_color.getColorSelected());
					
					// update panel
					panel.add(graph);
					panel.revalidate();
					graph.repaint();
					
					//debug
					//System.out.println(a);
					//System.out.println("clickded");
				}
			}
		});
		btnNewButton.setBounds(14, 73, 400, 27);
		frmQuickFunctionGraph.getContentPane().add(btnNewButton);
		
	
		
		
		
		JButton btnNewButton_1 = new JButton("Help");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				help window = new help();
				window.frame.setVisible(true);
				
				
			}
		});
		btnNewButton_1.setBounds(183, 583, 113, 27);
		frmQuickFunctionGraph.getContentPane().add(btnNewButton_1);
		
		JButton btnCredits = new JButton("Credits");
		btnCredits.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				credits window = new credits();
				window.frmCredits.setVisible(true);
			}
		});
		btnCredits.setBounds(304, 583, 113, 27);
		frmQuickFunctionGraph.getContentPane().add(btnCredits);
		
		
		slider.setBounds(14, 546, 399, 24);
		frmQuickFunctionGraph.getContentPane().add(slider);
		
		JLabel lblNewLabel = new JLabel("f(x)=   ");
		lblNewLabel.setBounds(14, 36, 64, 18);
		frmQuickFunctionGraph.getContentPane().add(lblNewLabel);
		
		JLabel lblX = new JLabel("X");
		lblX.setFont(new Font("SimSun", Font.PLAIN, 16));
		lblX.setBounds(102, 35, 72, 18);
		frmQuickFunctionGraph.getContentPane().add(lblX);
		
		JLabel label = new JLabel("4");
		label.setFont(new Font("SimSun", Font.PLAIN, 10));
		label.setBounds(115, 23, 72, 18);
		frmQuickFunctionGraph.getContentPane().add(label);
		
		JLabel label_1 = new JLabel("+");
		label_1.setBounds(125, 36, 72, 18);
		frmQuickFunctionGraph.getContentPane().add(label_1);
		
		JLabel lblX_1 = new JLabel("X");
		lblX_1.setFont(new Font("SimSun", Font.PLAIN, 16));
		lblX_1.setBounds(183, 35, 72, 18);
		frmQuickFunctionGraph.getContentPane().add(lblX_1);
		
		JLabel label_2 = new JLabel("3");
		label_2.setFont(new Font("SimSun", Font.PLAIN, 9));
		label_2.setBounds(192, 23, 72, 18);
		frmQuickFunctionGraph.getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("+");
		label_3.setFont(new Font("SimSun", Font.PLAIN, 16));
		label_3.setBounds(209, 35, 72, 18);
		frmQuickFunctionGraph.getContentPane().add(label_3);
		
		JLabel lblX_2 = new JLabel("X");
		lblX_2.setFont(new Font("SimSun", Font.PLAIN, 16));
		lblX_2.setBounds(269, 35, 72, 18);
		frmQuickFunctionGraph.getContentPane().add(lblX_2);
		
		JLabel label_4 = new JLabel("2");
		label_4.setFont(new Font("SimSun", Font.PLAIN, 9));
		label_4.setBounds(276, 23, 72, 18);
		frmQuickFunctionGraph.getContentPane().add(label_4);
		
		JLabel label_5 = new JLabel("+");
		label_5.setBounds(290, 36, 72, 18);
		frmQuickFunctionGraph.getContentPane().add(label_5);
		
		JLabel lblX_3 = new JLabel("X");
		lblX_3.setFont(new Font("SimSun", Font.PLAIN, 16));
		lblX_3.setBounds(341, 35, 72, 18);
		frmQuickFunctionGraph.getContentPane().add(lblX_3);
		
		JLabel label_6 = new JLabel("+");
		label_6.setBounds(355, 36, 72, 18);
		frmQuickFunctionGraph.getContentPane().add(label_6);
		
		JButton btnPreference = new JButton("Preference");
		btnPreference.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				preference window = new preference();
				window.frame.setVisible(true);
				
			}
		});
		btnPreference.setBounds(14, 583, 113, 27);
		frmQuickFunctionGraph.getContentPane().add(btnPreference);
		
		JLabel lblZoomIn = new JLabel("Zoom in");
		lblZoomIn.setBounds(355, 532, 72, 18);
		frmQuickFunctionGraph.getContentPane().add(lblZoomIn);
		
		JLabel lblNewLabel_1 = new JLabel("Zoom out");
		lblNewLabel_1.setBounds(14, 532, 72, 18);
		frmQuickFunctionGraph.getContentPane().add(lblNewLabel_1);
	}
  
}

class Functiongraph extends JPanel{
	
	Color cs,gc;
	public int a,b,c,d,e;
	float size;
	
	Functiongraph(int coefficient1,int coefficient2,int coefficient3,int coefficient4,int Constant, float SizeOfFun,Color cs,Color gc){
		
		this.a=coefficient1;
		this.b=coefficient2;
		this.c=coefficient3;
		this.d=coefficient4;
		this.e=Constant;
		this.cs=cs;
		this.gc=gc;
		// pass the coefficients to this class to draw
		
		size=100-SizeOfFun;
		// pass the size of the function to this class to draw
		
		
	}
	
	 @Override
     public Dimension getPreferredSize() {
         return new Dimension(400, 400);
     }
	
	
	 protected void paintComponent(Graphics g){
	 
		 super.paintComponent(g);
		 
		 System.out.println("cs actuall print"+main.cs_color.getColorSelected());
		 System.out.println("g actuall print"+main.g_color.getColorSelected());
		 
		 System.out.println(size);
		 int panel_size=400;
		 Graphics2D g2d = (Graphics2D) g.create();
		
         g2d.setColor(cs);
        
         //draw the coordinate system
         g2d.drawLine(0, 200, 400, 200);
         g2d.drawLine(200, 0, 200, 400);
         
		 
         
         
         //draw functions
         int minimumX=(int)Math.floor(-size);
         // set the minimumm X
         int maximumX=(int)Math.ceil(size);
         // set the maximum X
         
         int ratio=panel_size/(2*maximumX);
         // the ratio between screen size and function size 
         // to make function graph more suitale for current panel
         
         double x1=minimumX;
         // first point X
         double x2=minimumX;
         //second point x
         
         double y1=a*(x1*x1*x1*x1)+b*(x1*x1*x1)+c*(x1*x1)+d*(x1)+e;
         // first point y
         double y2=a*(x2*x2*x2*x2)+b*(x2*x2*x2)+c*(x2*x2)+d*(x2)+e;
         // second point y
         
         for(;x2<=maximumX;x2+=0.1){
        	 // move second point x to left by 1
        	 // until the right edge
        	 
        	  y2=a*(x2*x2*x2*x2)+b*(x2*x2*x2)+c*(x2*x2)+d*(x2)+e;
        	  // move second point y ahead by x2
        	  g2d.setColor(gc);
        	 g2d.draw(new Line2D.Double(panel_size/2+(x1*ratio), panel_size/2-(y1*ratio),panel_size/2+(x2*ratio), panel_size/2-(y2*ratio)));
             // because the origin is at the centre of the panel. so we set panel centre as origin + the increasement of x1 will get the x1 position
        	 // with panel centre as origin point 
        	 
              //it is same for y but because the y value is going positive by going down so we need opposite way yo do it 
            
        	 
        	 x1=x2;
        	 y1=y2;
        	 // when finish this line. set the x2 to x1, y1=y2
        	 // means set the original point as the starting point for the next line
        	 // until whole graph is drawns
         
         }
         
         
         
         
         g2d.dispose();
	 }
	 
}
