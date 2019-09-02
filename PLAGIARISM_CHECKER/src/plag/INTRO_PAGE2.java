package plag;
import java.awt.EventQueue;

import javax.swing.JFrame;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

public class INTRO_PAGE2 {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					INTRO_PAGE2 window = new INTRO_PAGE2();
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
	public INTRO_PAGE2() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setFont(new Font("Arial", Font.PLAIN, 21));
		frame.getContentPane().setBackground(new Color(102, 204, 153));
		frame.setBounds(100, 100, 796, 570);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setResizable(false);
		
		JButton btnNewButton = new JButton("Compare File to File\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
					try {
						MAIN_GUI.main();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				
				
			}
		});
		btnNewButton.setFont(new Font("Raavi", Font.BOLD, 19));
		btnNewButton.setBounds(67, 141, 274, 57);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCompareMulitleFiles = new JButton("Compare Multiple Files");
		btnCompareMulitleFiles.setFont(new Font("Raavi", Font.BOLD, 19));
		btnCompareMulitleFiles.setBounds(67, 333, 274, 57);
		frame.getContentPane().add(btnCompareMulitleFiles);
		
		JLabel lblNewLabel = new JLabel("Allow the user to compare from\r\n");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 21));
		lblNewLabel.setToolTipText("");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBounds(409, 130, 326, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("one file to another file and to check \r\n");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 21));
		lblNewLabel_1.setBounds(409, 155, 354, 35);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("the similarty between them");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 21));
		lblNewLabel_2.setBounds(409, 180, 308, 40);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel label = new JLabel("Allow the user to compare from\r\n");
		label.setToolTipText("");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Arial", Font.PLAIN, 21));
		label.setBounds(409, 318, 328, 33);
		frame.getContentPane().add(label);
		
		JLabel lblOneFileTo = new JLabel("one file to multiple file and to check \r\n");
		lblOneFileTo.setForeground(Color.WHITE);
		lblOneFileTo.setFont(new Font("Arial", Font.PLAIN, 21));
		lblOneFileTo.setBounds(409, 342, 345, 33);
		frame.getContentPane().add(lblOneFileTo);
		
		JLabel label_1 = new JLabel("the similarty between them");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Arial", Font.PLAIN, 21));
		label_1.setBounds(409, 365, 280, 33);
		frame.getContentPane().add(label_1);
	}
}