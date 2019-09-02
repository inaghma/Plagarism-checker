package plag;
import java.awt.EventQueue;



import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.Color;


public class MAIN_GUI extends MAIN_CODE{

	private JFrame frame;
    public static String duplication;
	private JTextField txtfile1;
	private JTextField txtfile2;
    public static String path2;
    public static String path1;
    private JButton btngo;
    private JTextField txtdup;
    private JLabel lbldup;
    public static String temp;
    public static String fname1;
    public static String fname2;
    private JTextField txtfname1;
    private JTextField txtfname2;
    private static String f1size;
    private static String f2size;
    private static long ftemp;
    private  static  long startTime;
    private static String ngram="";
 public    static double dupper;
 private JLabel lblFileToFile;
 private JTextArea txtrSfgs;
    
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main() throws IOException
	{
		 startTime = System.currentTimeMillis();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MAIN_GUI window = new MAIN_GUI(" ");
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	/*
	 */
		

	}
	/**
	 * Create the application.
	 */
	
	public MAIN_GUI(String pat) {
		super(pat);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 153));
		frame.setBounds(100, 100, 796, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JButton btnfile1 = new JButton("Choose File");
		btnfile1.setFont(new Font("Raavi", Font.BOLD, 19));
		btnfile1.addActionListener(new ActionListener() 
		{
			public void actionPerformed(java.awt.event.ActionEvent e)
			{

				txtfile1.setText(getfilename());
				MAIN_GUI.path1=txtfile1.getText();
			   txtfname1.setText(temp);
			 fname1=getvar_value(temp);
			  
				
			}
		});
		btnfile1.setBounds(295, 301, 142, 42);
		frame.getContentPane().add(btnfile1);
		
		JButton btnfile2 = new JButton("Choose File");
		btnfile2.setFont(new Font("Raavi", Font.BOLD, 19));
		btnfile2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(java.awt.event.ActionEvent e) 
			{
				
			
				txtfile2.setText(getfilename());
				MAIN_GUI.path2=txtfile2.getText();
				txtfname2.setText(temp);
				 fname2=getvar_value(temp);
				
				
			}
		});
		btnfile2.setBounds(295, 408, 145, 39);
		frame.getContentPane().add(btnfile2);
		
		txtfile1 = new JTextField();
		txtfile1.setEditable(false);
		txtfile1.setBounds(168, 261, 412, 29);
		frame.getContentPane().add(txtfile1);
		txtfile1.setColumns(10);
		
		txtfile2 = new JTextField();
		txtfile2.setEditable(false);
		txtfile2.setColumns(10);
		txtfile2.setBounds(170, 369, 410, 25);
		frame.getContentPane().add(txtfile2);
		
		btngo = new JButton("GO!!!");
		btngo.setFont(new Font("Raavi", Font.BOLD, 19));
		btngo.addActionListener(new ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent e) 
			{
				try {
					MAIN_CODE.s=readFile(path1);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				try {
					MAIN_CODE.p=readFile(path2);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				MAIN_CODE ob=new MAIN_CODE(p);
				
				 
	              
				dupper=display();
                duplication=Double.toString(dupper);
                txtdup.setText(duplication);
                
               /* Chart ob1=new Chart("Pie Chart Demo 1");
                ob1.getvalues(dupper,fname1, fname2);
				ob1.pack();
			
				 RefineryUtilities.centerFrameOnScreen(ob1);
			        ob1.setVisible(true);*/
                
              //  HIGHTLIGHTING high1=new HIGHTLIGHTING();
                  HIGHLIGHT.main();
                long endTime = System.currentTimeMillis();
        		System.out.println("Took "+(endTime - startTime) + " ms");
				
				
			}
		});
		btngo.setBounds(601, 468, 105, 45);
		frame.getContentPane().add(btngo);
		
		txtdup = new JTextField();
		txtdup.setEditable(false);
		txtdup.setBounds(375, 496, 86, 23);
		frame.getContentPane().add(txtdup);
		txtdup.setColumns(10);
		txtdup.setVisible(false);

		
		lbldup = new JLabel("DUPLICATION %");
		lbldup.setBounds(248, 490, 114, 23);
		frame.getContentPane().add(lbldup);
		lbldup.setVisible(false);
		
		txtfname1 = new JTextField();
		txtfname1.setBounds(72, 261, 86, 20);
		frame.getContentPane().add(txtfname1);
		txtfname1.setColumns(10);
		txtfname1.setVisible(false);
		
		txtfname2 = new JTextField();
		txtfname2.setColumns(10);
		txtfname2.setBounds(83, 418, 86, 20);
		frame.getContentPane().add(txtfname2);
		
		lblFileToFile = new JLabel("File to File  Plagirism Detection");
		lblFileToFile.setBackground(new Color(204, 204, 153));
		lblFileToFile.setFont(new Font("Californian FB", Font.BOLD, 42));
		lblFileToFile.setBounds(86, 30, 620, 63);
		frame.getContentPane().add(lblFileToFile);
		
		txtrSfgs = new JTextArea();
		txtrSfgs.setEditable(false);
		txtrSfgs.setForeground(Color.BLACK);
		txtrSfgs.setFont(new Font("Monospaced", Font.BOLD, 16));
		txtrSfgs.setBackground(new Color(255, 255, 255));
		txtrSfgs.setText("Choose the two files from the system for which you want to check plagiarism.\r\nAnd hit the GO! button\r\n(NOTE: The files must be in \".txt\" format  only)\r\n");
		txtrSfgs.setBounds(14, 118, 748, 110);
		frame.getContentPane().add(txtrSfgs);
		txtfname2.setVisible(false);
	}
	private String getfilename()
	{
		JButton open=new JButton();
		JFileChooser fc = new  JFileChooser();
		 fc.setCurrentDirectory(new java.io.File("C:/Users/3bca2016/Documents"));//hoem directory to start with"."--> to start at the projects location//do hoem directory
		 //set the title fo rthe file chooser
		 fc.setDialogTitle("Choose form here");
		 
		  
		   // txtfname1.setText(selected.getName());
		 
		 //only show directory nothing else at all
		fc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
		if (fc.showOpenDialog(open)==JFileChooser.APPROVE_OPTION)
		{
			
		}
		String fname=fc.getSelectedFile().getPath();//to shoe the path on the thing
       fname=fname.replace('\\', '/');
      // fc.showOpenDialog(null);
       File selected = fc.getSelectedFile();
       temp=selected.getName();
       ftemp=selected.getTotalSpace();
		return fname;
	}
	
	
	//to get the fname fo rthe variables fname1 and fname2
	public static String getvar_value(String s)
	{
		return s;
		
	}
}
