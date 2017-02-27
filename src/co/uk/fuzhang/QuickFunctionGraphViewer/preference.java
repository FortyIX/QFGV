package co.uk.fuzhang.QuickFunctionGraphViewer;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JToggleButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class preference {

	
	static public Color graph_color_v;
	
	JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					preference window = new preference();
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
	public preference() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 425, 266);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String[] colorlist={"Red","Black","Yello","Green","Pink"};
		
		
		JComboBox coordinateSystem_color = new JComboBox(colorlist);
		coordinateSystem_color.setBounds(186, 59, 129, 24);
		frame.getContentPane().add(coordinateSystem_color);
		
		JComboBox graph_color = new JComboBox(colorlist);
		graph_color.setBounds(186, 95, 129, 24);
		frame.getContentPane().add(graph_color);
		
		 
		coordinateSystem_color.setSelectedIndex(main.cs_color.getColorSelectedIndex());
		graph_color.setSelectedIndex(main.g_color.getColorSelectedIndex());
		
		
		System.out.println("setting "+graph_color.getSelectedIndex());
		
		
		JLabel lblNewLabel = new JLabel("Coorinate System");
		lblNewLabel.setBounds(43, 61, 129, 21);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblGraphs = new JLabel("Graphs");
		lblGraphs.setBounds(120, 96, 72, 18);
		frame.getContentPane().add(lblGraphs);
		
		
		
		
		
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		     main.cs_color.SetColorWithIndex(coordinateSystem_color.getSelectedIndex());
			 main.g_color.SetColorWithIndex(graph_color.getSelectedIndex());
			 
			 System.out.println("current settint:"+graph_color.getSelectedIndex());
			 System.out.println("change to"+main.g_color.getColorSelectedIndex());
			 
			 
			
			 
		     //System.out.println(main.g_color.getColorSelectedIndex());
		     
			 frame.setVisible(false);
		     
			 //System.out.println("change to"+main.g_color.getColorSelectedIndex());
			 
			}
			
			
		});
		btnNewButton.setBounds(267, 182, 113, 27);
		frame.getContentPane().add(btnNewButton);
		
		
	}
	
	
}




//////////////////////////////////////////////////////////////////////////////////////////
//CLASS DECLARE & IMPLEMENTATION 
//////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////


// Color for Graph

class ColorOption {
	
   private int color_index;
	private Color Color;
  
    
	// init with color option index
	ColorOption(int index){

		this.color_index=index;
    	
    	switch(index){
    	
    	
    	case 0:
			
			this.Color=Color.RED;
			
			break;
        case 1:
			
        	this.Color=Color.BLACK;
			
			break;
        case 2:
 
        	this.Color=Color.YELLOW;

            break;
        case 3:

        	this.Color=Color.GREEN;

            break;
        case 4:

        	
        	this.Color=Color.PINK;

           break;
    	}
    	
    	
    }
    
	
	// init with color
	ColorOption(Color color){
    	
       if(color== Color.BLACK){
    	   
    	   this.Color=color;
    	   this.color_index=1;
    	   
       }
       else if(color== Color.RED){
    	   
    	   this.Color=color;
    	   this.color_index=0;
    	   
       }
       else if(color== Color.PINK){
	   
    	   this.Color=color;
    	   this.color_index=4;
	   
	   
 }
       else if(color== Color.YELLOW){
	      
    	   this.Color=color;
    	   this.color_index=2;
	   
	   
   }
       else if(color== Color.GREEN){
	   
    	   this.Color=color;
    	   this.color_index=3;
	   
	   
 }
       
       
    	
    	
    }
    
  
    
    // get color option in index number
    int getColorSelectedIndex(){
    	
       return this.color_index;
    	
    		
    }
    
    // get color option  in color
    Color getColorSelected(){
    	
      return this.Color;	
    	
    }
    
    
    // set color with index
    void SetColorWithIndex(int index){
    	
     this.color_index=index;
    	
    	switch(index){
    	
    	
    	case 0:
			
			this.Color=Color.RED;
			
			break;
        case 1:
			
        	this.Color=Color.BLACK;
			
			break;
        case 2:
 
        	this.Color=Color.YELLOW;

            break;
        case 3:

        	this.Color=Color.GREEN;

            break;
        case 4:

        	
        	this.Color=Color.PINK;

           break;
    	}
    }
    	
	
	

}

