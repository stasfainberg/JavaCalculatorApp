package calculators;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

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
		frame.setBounds(100, 100, 268, 424);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(10, 11, 230, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		
		/**************************************** Row 1 *******************************************/
		JButton btnBack = new JButton("");
		btnBack.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnBack.setBounds(10, 57, 50, 50);
		frame.getContentPane().add(btnBack);
		
		JButton btnClear = new JButton("C");
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClear.setBounds(70, 57, 50, 50);
		frame.getContentPane().add(btnClear);
		
		JButton btnPrecent = new JButton("%");
		btnPrecent.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPrecent.setBounds(130, 57, 50, 50);
		frame.getContentPane().add(btnPrecent);
		
		JButton btnPlus = new JButton("+");
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPlus.setBounds(190, 57, 50, 50);
		frame.getContentPane().add(btnPlus);
		
		
		
		/**************************************** Row 2 *******************************************/
		JButton btn7 = new JButton("7");
		btn7.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn7.setBounds(10, 114, 50, 50);
		frame.getContentPane().add(btn7);
		
		JButton btn8 = new JButton("8");
		btn8.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn8.setBounds(70, 114, 50, 50);
		frame.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn9.setBounds(130, 114, 50, 50);
		frame.getContentPane().add(btn9);
		
		JButton btnMinus = new JButton("-");
		btnMinus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMinus.setBounds(190, 114, 50, 50);
		frame.getContentPane().add(btnMinus);
		
		
		/**************************************** Row 3 *******************************************/
		JButton btn4 = new JButton("4");
		btn4.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn4.setBounds(10, 171, 50, 50);
		frame.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn5.setBounds(70, 171, 50, 50);
		frame.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn6.setBounds(130, 171, 50, 50);
		frame.getContentPane().add(btn6);
		
		JButton btnMul = new JButton("*");
		btnMul.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMul.setBounds(190, 171, 50, 50);
		frame.getContentPane().add(btnMul);
		
		
		
		
		/**************************************** Row 4 *******************************************/
		JButton btn1 = new JButton("1");
		btn1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn1.setBounds(10, 228, 50, 50);
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn2.setBounds(70, 228, 50, 50);
		frame.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn3.setBounds(130, 228, 50, 50);
		frame.getContentPane().add(btn3);
		
		JButton btnDiv = new JButton("/");
		btnDiv.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDiv.setBounds(190, 228, 50, 50);
		frame.getContentPane().add(btnDiv);
		
		
		/**************************************** Row 5 *******************************************/
		JButton btn0 = new JButton("0");
		btn0.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn0.setBounds(10, 285, 50, 50);
		frame.getContentPane().add(btn0);
		
		JButton btnDot = new JButton(".");
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDot.setBounds(70, 285, 50, 50);
		frame.getContentPane().add(btnDot);
		
		JButton btnPM = new JButton("+/-");
		btnPM.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPM.setBounds(130, 285, 50, 50);
		frame.getContentPane().add(btnPM);
		
		JButton btnEqual = new JButton("=");
		btnEqual.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEqual.setBounds(190, 285, 50, 50);
		frame.getContentPane().add(btnEqual);
		
		
		
		
		
	}
}
