package plag;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;
import javax.swing.text.Highlighter.HighlightPainter;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

public class HIGHLIGHT {

	private JFrame frame;
	  private static String l_text =MAIN_CODE.s;//file1,large,s.
	  private static String r_text=MAIN_CODE.p;//file2,small,pat or p
	  /*public static int index;
	  public static int ngramsize;*/
	  static int in=0;
	  public static String l_len;
	  public static String r_len;
	
	  
	 
	  
	static List<Integer> l_index= new ArrayList<Integer>();   //list for index of source,left side,large file
	static List<Integer> l_length= new ArrayList<Integer>(); //list for length of source,left side,large file
	
	static List<Integer> r_index= new ArrayList<Integer>();    //list for index of pattern,right,small file
	static List<Integer> r_length= new ArrayList<Integer>();  //list for length of pattern,right,small file
	
	static List<String> l_list= new ArrayList<String>();//to work with the final list without changing the original list
	// An instance of the private subclass of the default highlight painter
	  Highlighter.HighlightPainter painter= new DefaultHighlighter.DefaultHighlightPainter(Color.cyan);
	  /* *
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HIGHLIGHT window = new HIGHLIGHT();
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
	public HIGHLIGHT() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 255, 204));
		frame.getContentPane().setFont(new Font("Arial", Font.PLAIN, 24));
		frame.setBounds(100, 100, 796, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JTextArea l_txtarea = new JTextArea();
		l_txtarea.setEditable(false);
		l_txtarea.setBounds(15, 217, 354, 298);
		frame.getContentPane().add(l_txtarea);
		l_txtarea.setLineWrap(true);
		l_txtarea.setText(l_text);
		Highlighter l_highlighter = l_txtarea.getHighlighter();
		l_txtarea.setVisible(false);
		
		JTextArea r_txtarea = new JTextArea();
		r_txtarea.setEditable(false);
		r_txtarea.setBounds(414, 215, 357, 298);
		frame.getContentPane().add(r_txtarea);
		r_txtarea.setLineWrap(true);
		r_txtarea.setText(r_text);
		Highlighter r_highlighter = r_txtarea.getHighlighter();
		r_txtarea.setVisible(false);

		
		JLabel l_fname = new JLabel("l_filename.txt");
		l_fname.setFont(new Font("Arial", Font.PLAIN, 19));
		l_fname.setBounds(125, 105, 117, 36);
		frame.getContentPane().add(l_fname);
		l_fname.setText(MAIN_GUI.fname1);
		
		JLabel r_fname = new JLabel("r_filename.txt");
		r_fname.setFont(new Font("Arial", Font.PLAIN, 19));
		r_fname.setBounds(644, 105, 139, 36);
		frame.getContentPane().add(r_fname);
		r_fname.setText(MAIN_GUI.fname2);
		
		JLabel lblpercent = new JLabel("0");
		lblpercent.setFont(new Font("Arial", Font.PLAIN, 19));
		lblpercent.setBounds(310, 99, 117, 49);
		frame.getContentPane().add(lblpercent);
		lblpercent.setText(MAIN_GUI.duplication+"%");
		
		
		
		JLabel lblResult = new JLabel("Result:");
		lblResult.setFont(new Font("Dialog", Font.BOLD, 28));
		lblResult.setBounds(18, 24, 117, 49);
		frame.getContentPane().add(lblResult);
		
		JLabel lblIs = new JLabel("is");
		lblIs.setFont(new Font("Arial", Font.PLAIN, 19));
		lblIs.setBounds(269, 105, 23, 36);
		frame.getContentPane().add(lblIs);
		
		JLabel lblPlagiarisedFrom = new JLabel("plagiarised from the file ");
		lblPlagiarisedFrom.setFont(new Font("Arial", Font.PLAIN, 19));
		lblPlagiarisedFrom.setBounds(401, 105, 233, 43);
		frame.getContentPane().add(lblPlagiarisedFrom);
		
		JLabel lblTheFile = new JLabel("The file ");
		lblTheFile.setFont(new Font("Arial", Font.PLAIN, 19));
		lblTheFile.setBounds(18, 110, 96, 26);
		frame.getContentPane().add(lblTheFile);
		
		JLabel lblyestheplag = new JLabel("");
		
		lblyestheplag.setFont(new Font("Arial", Font.PLAIN, 29));
		lblyestheplag.setBounds(128, 22, 621, 49);
		frame.getContentPane().add(lblyestheplag);
		
		final_set();//call the function o get the length and indexes list of both the left and right wala files for highlighting
		
		
		if(MAIN_GUI.dupper ==0.00)
		{
			lblyestheplag.setForeground(Color.BLUE);
			lblyestheplag.setText("NO PLAGIARISM DETECTED!!!");
		}
		else
		{
			lblyestheplag.setForeground(Color.RED);
			lblyestheplag.setText("PLAGIARISM DETECTED!!");
		}
		
		
/*	if(MAIN_GUI.dupper==0.0)
		{
			lblyestheplag.setForeground(Color.BLUE);
			lblyestheplag.setText("NO PLAGIARISM DETECTED!!!");
		}
		else 
		{
			lblyestheplag.setForeground(Color.RED);
			lblyestheplag.setText("PLAGIARISM DETECTED!!");

		}*/
		
		JButton btnhigh = new JButton("More Details-->");
		btnhigh.setFont(new Font("Raavi", Font.PLAIN, 16));
		btnhigh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				/*pattern=txtarea2.getText();
				text=txtarea1.getText();*/
				l_txtarea.setVisible(true);
				r_txtarea.setVisible(true);
                
				

				System.out.println("the left side");
				System.out.println(l_index.size());
				System.out.println(l_length.size());
				System.out.println("the right side");
				System.out.println(r_index.size());
				System.out.println(r_length.size());
              
                	while(in<l_index.size())
    				{
    					 
    					  go_highlight(l_index.get(in),l_index.get(in)+l_length.get(in),l_highlighter,painter);
    				
    					  in++; 
    					
    				}
                	in=0;
                	while( in<r_index.size())
                	{
                		  go_highlight(r_index.get(in),r_index.get(in)+r_length.get(in),r_highlighter,painter);
    					 
    					 in++;
                	}
                				
				
				
				  
			}
		});
		btnhigh.setBounds(34, 163, 183, 43);
		frame.getContentPane().add(btnhigh, BorderLayout.SOUTH);
		
		
	/*	int l=MAIN_CODE.word_count(MAIN_CODE.s);
        l_len=Integer.toString(l);
		int r=MAIN_CODE.word_count(MAIN_CODE.p);
        r_len=Integer.toString(r);*/
	
	}
	
      
	//getting the index and length list for highlighting
		public static void get(int i,int m,boolean b)
		{
			if(b==true)
			{
				l_index.add(i);//left side wala file ,source, large,file1 ka index and length value
				l_length.add(m);
			}
			else
			{
				r_index.add(i);//right side wala file ,pattern,small, file2 ka index and length value
				r_length.add(m);
			}
		
			
		}
		
	//method to get the length and indexes list of both the left and right wala files for highlighting
		public static void final_set()
		{
			l_list=MAIN_CODE.flist;
		   l_list=MAIN_CODE.check_dup(l_list);
			 for(int m=0;m<l_list.size();m++)
		  {
			 System.out.println(l_list.get(m));
			  MAIN_CODE.search((l_list.get(m).toLowerCase()).toCharArray(), (l_text.toLowerCase()).toCharArray(),m,true);
			  MAIN_CODE.search((l_list.get(m).toLowerCase()).toCharArray(), (r_text.toLowerCase()).toCharArray(),m,false);
			  
			  
		  }
		} 
	
	
	public static void go_highlight(int p0,int p1,Highlighter h1,HighlightPainter painter)
	{
		   try{
			   System.out.println("yess highlight");
			  // h1.removeAllHighlights();
			  h1.addHighlight(p0, p1, painter);
			   
		    	 
		      }
		      catch(Exception e)
		      {
		    	  JOptionPane.showMessageDialog(null, "no pattern");
		      }
	}
}
