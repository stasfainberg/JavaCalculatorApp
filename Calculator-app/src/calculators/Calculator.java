package calculators;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Calculator {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculator window = new Calculator();
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
	public Calculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 297, 397);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(10, 11, 262, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		/**************************************** Row 1 *******************************************/
		JButton btnBack = new JButton("\u20D6");
		btnBack.setFont(new Font("Arial", Font.BOLD, 16));
		btnBack.setBounds(10, 62, 58, 50);
		frame.getContentPane().add(btnBack);
		
		JButton btnClear = new JButton("C");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClear.setBounds(76, 62, 58, 50);
		frame.getContentPane().add(btnClear);
		
		JButton btnPrecent = new JButton("\u0025");
		btnPrecent.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPrecent.setBounds(144, 62, 58, 50);
		frame.getContentPane().add(btnPrecent);
		
		JButton btnPlus = new JButton("+");
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPlus.setBounds(212, 62, 58, 50);
		frame.getContentPane().add(btnPlus);
		
		
		
		/**************************************** Row 2 *******************************************/
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String enteredNumber = textField.getText() + btn7.getText();
				textField.setText(enteredNumber);
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn7.setBounds(10, 119, 58, 50);
		frame.getContentPane().add(btn7);
		
		
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String enteredNumber = textField.getText() + btn8.getText();
				textField.setText(enteredNumber);
			}
			
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn8.setBounds(76, 119, 58, 50);
		frame.getContentPane().add(btn8);
		
		
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String enteredNumber = textField.getText() + btn9.getText();
				textField.setText(enteredNumber);
			}
			
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn9.setBounds(144, 119, 58, 50);
		frame.getContentPane().add(btn9);
		
		
		JButton btnMinus = new JButton("-");
		btnMinus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMinus.setBounds(212, 119, 58, 50);
		frame.getContentPane().add(btnMinus);
		
		
		/**************************************** Row 3 *******************************************/
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String enteredNumber = textField.getText() + btn4.getText();
				textField.setText(enteredNumber);
			}
			
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn4.setBounds(10, 176, 58, 50);
		frame.getContentPane().add(btn4);
		
		
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String enteredNumber = textField.getText() + btn5.getText();
				textField.setText(enteredNumber);
			}
			
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn5.setBounds(76, 176, 58, 50);
		frame.getContentPane().add(btn5);
		
		
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String enteredNumber = textField.getText() + btn6.getText();
				textField.setText(enteredNumber);
			}
			
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn6.setBounds(144, 176, 58, 50);
		frame.getContentPane().add(btn6);
		
		
		JButton btnMul = new JButton("*");
		btnMul.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMul.setBounds(212, 176, 58, 50);
		frame.getContentPane().add(btnMul);
		
		
		
		
		/**************************************** Row 4 *******************************************/
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String enteredNumber = textField.getText() + btn1.getText();
				textField.setText(enteredNumber);
			}
			
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn1.setBounds(10, 233, 58, 50);
		frame.getContentPane().add(btn1);
		
		
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String enteredNumber = textField.getText() + btn2.getText();
				textField.setText(enteredNumber);
			}
			
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn2.setBounds(76, 233, 58, 50);
		frame.getContentPane().add(btn2);
		
		
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String enteredNumber = textField.getText() + btn3.getText();
				textField.setText(enteredNumber);
			}
			
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn3.setBounds(144, 233, 58, 50);
		frame.getContentPane().add(btn3);
		
		
		JButton btnDiv = new JButton("/");
		btnDiv.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDiv.setBounds(212, 233, 58, 50);
		frame.getContentPane().add(btnDiv);
		
		
		/**************************************** Row 5 *******************************************/
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String enteredNumber = textField.getText() + btn0.getText();
				textField.setText(enteredNumber);
			}
			
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn0.setBounds(10, 290, 58, 50);
		frame.getContentPane().add(btn0);
		
		JButton btnDot = new JButton(".");
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDot.setBounds(76, 290, 58, 50);
		frame.getContentPane().add(btnDot);
		
		JButton btnPM = new JButton("+-");
		btnPM.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPM.setBounds(144, 290, 58, 50);
		frame.getContentPane().add(btnPM);
		
		JButton btnEqual = new JButton("=");
		btnEqual.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEqual.setBounds(212, 290, 58, 50);
		frame.getContentPane().add(btnEqual);
		
		
		
		
		
	}
}
