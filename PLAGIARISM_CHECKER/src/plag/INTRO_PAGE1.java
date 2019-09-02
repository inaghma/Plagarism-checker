package plag;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.MediaTracker;
import java.awt.Toolkit;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class INTRO_PAGE1 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					INTRO_PAGE1 window = new INTRO_PAGE1();
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
	public INTRO_PAGE1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(102, 204, 153));
		frame.setBounds(100, 100, 796, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		
		JLabel lblApplicationToCheck = new JLabel("Application to check plagiarism of two documents.");
		lblApplicationToCheck.setFont(new Font("Kokila", Font.BOLD, 27));
		lblApplicationToCheck.setBackground(new Color(240, 240, 240));
		lblApplicationToCheck.setHorizontalAlignment(SwingConstants.CENTER);
		lblApplicationToCheck.setForeground(new Color(255, 255, 255));
		lblApplicationToCheck.setLabelFor(frame);
		lblApplicationToCheck.setBounds(94, 361, 578, 38);
		frame.getContentPane().add(lblApplicationToCheck);
		
		JLabel lblNewLabel = new JLabel("THE CHECKER");
		lblNewLabel.setFont(new Font("Gisha", Font.BOLD, 37));
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(226, 24, 297, 58);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblPlagiarismDetectionIs = new JLabel("Plagiarism detection is the way of finding and locating instances of plagiarism within ");
		lblPlagiarismDetectionIs.setHorizontalAlignment(SwingConstants.CENTER);
		lblPlagiarismDetectionIs.setForeground(new Color(255, 255, 255));
		lblPlagiarismDetectionIs.setFont(new Font("Kokila", Font.BOLD, 27));
		lblPlagiarismDetectionIs.setBounds(10, 397, 770, 38);
		frame.getContentPane().add(lblPlagiarismDetectionIs);
		
		JLabel lblNewLabel_1 = new JLabel("a work or document.");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Kokila", Font.BOLD, 27));
		lblNewLabel_1.setBounds(226, 433, 214, 32);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("Z:\\Naghma\\002_plagiarism.jpg"));
	//	lblNewLabel_2.setIcon(new ImageIcon(INTRO_PAGE1.class.getResource("/plag/002_plagiarism.jpg")));
		lblNewLabel_2.setBounds(121, 93, 513, 244);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnNext = new JButton("NEXT");
		btnNext.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				INTRO_PAGE2.main();
			}
		});
		btnNext.setFont(new Font("KodchiangUPC", Font.PLAIN, 26));
		btnNext.setBounds(592, 464, 123, 38);
		frame.getContentPane().add(btnNext);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(1, 0, 791, 547);
		frame.getContentPane().add(lblNewLabel_3);
	}
}
