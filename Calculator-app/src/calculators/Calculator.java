package calculators;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Calculator {

	private JFrame frame;
	private JTextField textField;
	JLabel status = new JLabel("");
	
	//Holds the first entered number
	double firstNum;
	
	//Holds the second entered number
	double secondNum;
	
	//Holds the operation which should be performed between the first and the second number
	String operations;
	
	//Holds the numerical result after performing operations between the first and the second numbers
	double result;
	
	//Stores the result in String format 
	String answer = new String();
	
	//Stores temporary data 
	String tempText;
	
	//
	int countTextFieldCharacters = 0;
	int secondNumCountTextField = 0;
	
	
	boolean plus = false;
	boolean minus = false;
	boolean mul = false;
	boolean div = false;
	boolean equal = false;
	boolean resultDispalied = false;
	boolean firstNumStatus = false;
	boolean secondNumStatus = false;
	boolean PMStatus = false;
	boolean operationStatus = false;
	boolean dot = false;
	
	final static Color  RESULT_COLOR = Color.RED;

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
		frame.setBounds(100, 100, 286, 439);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 18));
		textField.setBounds(10, 11, 262, 35);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		status.setFont(new Font("Tahoma", Font.PLAIN, 18));
		
		status.setHorizontalAlignment(SwingConstants.RIGHT);
		status.setBounds(10, 57, 262, 24);
		frame.getContentPane().add(status);
		
		status.setForeground(RESULT_COLOR);
		frame.setResizable(false);
		
		
		
		/**************************************** Row 1 *******************************************/
		JButton btnBack = new JButton("\u20D6");
		btnBack.setVerticalAlignment(SwingConstants.BOTTOM);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String backSpace = null;
				if(textField.getText().length() > 0)
				{
					if(secondNumStatus) {
						StringBuilder strB = new StringBuilder(textField.getText());
						strB.deleteCharAt(textField.getText().length() -1);
						backSpace = strB.toString();
						textField.setText(backSpace);
						secondNumCountTextField--;
						secondNum = Double.parseDouble(textField.getText().substring(textField.getText().length()-secondNumCountTextField, textField.getText().length()));
						
						
						if(secondNumCountTextField == 0) {
							secondNumStatus = false;
							secondNum = 0;
						}
						
					}else if(firstNumStatus && operationStatus) {
						StringBuilder strB = new StringBuilder(textField.getText());
						strB.deleteCharAt(textField.getText().length() -1);
						strB.deleteCharAt(textField.getText().length() -2);
						strB.deleteCharAt(textField.getText().length() -3);
						backSpace = strB.toString();
						textField.setText(backSpace);
						operationStatus = false;
						firstNumStatus = false;
						
					}
				}else {
					
				}
			}
		});
		btnBack.setFont(new Font("Arial Unicode MS", Font.BOLD, 26));
		btnBack.setBounds(10, 92, 58, 50);
		frame.getContentPane().add(btnBack);
		

		
		/***************/
		JButton btnClear = new JButton("C");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				status.setText(null);
				
				firstNum = 0;
				secondNum = 0;
				result = 0;
				
				operations = null;
				answer = null;
				tempText = null;
				
				plus = false;
				minus = false;
				mul = false;
				div = false;
				equal = false;
				resultDispalied = false;
				firstNumStatus = false;
				secondNumStatus = false;
				PMStatus = false;
				operationStatus = false;	
				dot = false;
				
				countTextFieldCharacters = 0;
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnClear.setBounds(76, 92, 58, 50);
		frame.getContentPane().add(btnClear);
		
		
		
		/***************/
		JButton btnPrecent = new JButton("\u0025");
		btnPrecent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(secondNumStatus)
				{
					//calculate the percentage of the first number according to the second number 
					secondNum = (firstNum * secondNum) / 100;
					//change the text field
					textField.setText("");
					textField.setText(firstNum + " " + operations + " " +secondNum);
				}
			}
		});
		btnPrecent.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPrecent.setBounds(144, 92, 58, 50);
		frame.getContentPane().add(btnPrecent);
		
		
		
		/***************/
		JButton btnPlus = new JButton("+");
		btnPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(secondNumStatus)
				{
					status.setText("One operation at a time");
					return;
				}
				if(operationStatus)
				{
					tempText = textField.getText();
					String tempText01 = tempText.substring(0, tempText.length()-1);
					String tempText02 = tempText01.substring(0, tempText01.length()-1);
					textField.setText(tempText02.substring(0, tempText02.length()-1));
					tempText = "";
				}
				if(resultDispalied)
				{
					firstNum = Double.parseDouble(textField.getText());
					resultDispalied = false;
					operationStatus = true;
				}
				if(!textField.getText().equals(""))
				{
					operations = "+";
					tempText = textField.getText() + " " + operations + " ";
					textField.setText(tempText);
					tempText = "";
					plus = true;
					equal = true;
					firstNumStatus = true;
					operationStatus = true;
					dot = false;
					countTextFieldCharacters += 3;
				}else {
					
				}
			}
		});
		btnPlus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPlus.setBounds(212, 92, 58, 50);
		frame.getContentPane().add(btnPlus);
		
		
		
		/**************************************** Row 2 *******************************************/
		JButton btn7 = new JButton("7");
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				status.setText("");
				if(resultDispalied)
				{
					textField.setText("");
					resultDispalied = false;
				}
				
				if(!firstNumStatus)
				{
					String enteredNumber = textField.getText() + btn7.getText();
					textField.setText(enteredNumber);
					firstNum = Double.parseDouble(textField.getText());
				}else {
					String enteredNumber = textField.getText() + btn7.getText();
					textField.setText(enteredNumber);
					tempText = tempText + btn7.getText();
					secondNum = Double.parseDouble(tempText.toString());
					secondNumStatus = true;
					secondNumCountTextField++;
				}
			}
		});
		btn7.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn7.setBounds(10, 149, 58, 50);
		frame.getContentPane().add(btn7);
		
		
		
		/***************/
		JButton btn8 = new JButton("8");
		btn8.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				status.setText("");
				if(resultDispalied)
				{
					textField.setText("");
					resultDispalied = false;
				}
				
				if(!firstNumStatus)
				{
					String enteredNumber = textField.getText() + btn8.getText();
					textField.setText(enteredNumber);
					firstNum = Double.parseDouble(textField.getText());
				}else {
					String enteredNumber = textField.getText() + btn8.getText();
					textField.setText(enteredNumber);
					tempText = tempText + btn8.getText();
					secondNum = Double.parseDouble(tempText.toString());
					secondNumStatus = true;
					secondNumCountTextField++;
				}
			}
			
		});
		btn8.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn8.setBounds(76, 149, 58, 50);
		frame.getContentPane().add(btn8);
		
		
		/***************/
		JButton btn9 = new JButton("9");
		btn9.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				status.setText("");
				if(resultDispalied)
				{
					textField.setText("");
					resultDispalied = false;
				}
				
				if(!firstNumStatus)
				{
					String enteredNumber = textField.getText() + btn9.getText();
					textField.setText(enteredNumber);
					firstNum = Double.parseDouble(textField.getText());
				}else {
					String enteredNumber = textField.getText() + btn9.getText();
					textField.setText(enteredNumber);
					tempText = tempText + btn9.getText();
					secondNum = Double.parseDouble(tempText.toString());
					secondNumStatus = true;
					secondNumCountTextField++;
				}
			}
			
		});
		btn9.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn9.setBounds(144, 149, 58, 50);
		frame.getContentPane().add(btn9);
		
		
		/***************/
		JButton btnMinus = new JButton("-");
		btnMinus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(secondNumStatus)
				{
					status.setText("One operation at a time");
					return;
				}
				if(operationStatus)
				{
					tempText = textField.getText();
					String tempText01 = tempText.substring(0, tempText.length()-1);
					String tempText02 = tempText01.substring(0, tempText01.length()-1);
					textField.setText(tempText02.substring(0, tempText02.length()-1));
					tempText = "";
				}
				if(resultDispalied)
				{
					firstNum = Double.parseDouble(textField.getText());
					resultDispalied = false;
					operationStatus = true;
				}
				
				if(!textField.getText().equals(""))
				{
					operations = "-";
					tempText = textField.getText() + " " + operations + " ";
					textField.setText(tempText);
					tempText = "";
					minus = true;
					equal = true;
					firstNumStatus = true;
					operationStatus = true;
					dot = false;
					countTextFieldCharacters += 3;
				}else {
					
				}
			}
		});
		btnMinus.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMinus.setBounds(212, 149, 58, 50);
		frame.getContentPane().add(btnMinus);
		
		
		/**************************************** Row 3 *******************************************/
		JButton btn4 = new JButton("4");
		btn4.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				status.setText("");
				if(resultDispalied)
				{
					textField.setText("");
					resultDispalied = false;
				}
				
				if(!firstNumStatus)
				{
					String enteredNumber = textField.getText() + btn4.getText();
					textField.setText(enteredNumber);
					firstNum = Double.parseDouble(textField.getText());
				}else {
					String enteredNumber = textField.getText() + btn4.getText();
					textField.setText(enteredNumber);
					tempText = tempText + btn4.getText();
					secondNum = Double.parseDouble(tempText.toString());
					secondNumStatus = true;
					secondNumCountTextField++;
				}
			}
			
		});
		btn4.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn4.setBounds(10, 206, 58, 50);
		frame.getContentPane().add(btn4);
		
		
		
		/***************/
		JButton btn5 = new JButton("5");
		btn5.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				status.setText("");
				if(resultDispalied)
				{
					textField.setText("");
					resultDispalied = false;
				}
				
				if(!firstNumStatus)
				{
					String enteredNumber = textField.getText() + btn5.getText();
					textField.setText(enteredNumber);
					firstNum = Double.parseDouble(textField.getText());
				}else {
					String enteredNumber = textField.getText() + btn5.getText();
					textField.setText(enteredNumber);
					tempText = tempText + btn5.getText();
					secondNum = Double.parseDouble(tempText.toString());
					secondNumStatus = true;
					secondNumCountTextField++;
				}
			}
			
		});
		btn5.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn5.setBounds(76, 206, 58, 50);
		frame.getContentPane().add(btn5);
		
		
		
		/***************/
		JButton btn6 = new JButton("6");
		btn6.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				status.setText("");
				if(resultDispalied)
				{
					textField.setText("");
					resultDispalied = false;
				}
				
				if(!firstNumStatus)
				{
					String enteredNumber = textField.getText() + btn6.getText();
					textField.setText(enteredNumber);
					firstNum = Double.parseDouble(textField.getText());
				}else {
					String enteredNumber = textField.getText() + btn6.getText();
					textField.setText(enteredNumber);
					tempText = tempText + btn6.getText();
					secondNum = Double.parseDouble(tempText.toString());
					secondNumStatus = true;
					secondNumCountTextField++;
				}
			}
			
		});
		btn6.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn6.setBounds(144, 206, 58, 50);
		frame.getContentPane().add(btn6);
		
		
		
		
		/***************/
		JButton btnMul = new JButton("*");
		btnMul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(secondNumStatus)
				{
					status.setText("One operation at a time");
					return;
				}
				if(operationStatus)
				{
					tempText = textField.getText();
					String tempText01 = tempText.substring(0, tempText.length()-1);
					String tempText02 = tempText01.substring(0, tempText01.length()-1);
					textField.setText(tempText02.substring(0, tempText02.length()-1));
					tempText = "";
				}
				if(resultDispalied)
				{
					firstNum = Double.parseDouble(textField.getText());
					resultDispalied = false;
					operationStatus = true;
				}
				
				if(!textField.getText().equals(""))
				{
					operations = "*";
					tempText = textField.getText() + " " + operations + " ";
					textField.setText(tempText);
					tempText = "";
					mul = true;
					equal = true;
					firstNumStatus = true;
					operationStatus = true;
					dot = false;
					countTextFieldCharacters += 3;
				}else {
					
				}
			}
		});
		btnMul.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnMul.setBounds(212, 206, 58, 50);
		frame.getContentPane().add(btnMul);
		
		
		
		
		/**************************************** Row 4 *******************************************/
		JButton btn1 = new JButton("1");
		btn1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				status.setText("");
				if(resultDispalied)
				{
					textField.setText("");
					resultDispalied = false;
				}
				
				if(!firstNumStatus)
				{
					String enteredNumber = textField.getText() + btn1.getText();
					textField.setText(enteredNumber);
					firstNum = Double.parseDouble(textField.getText());
				}else {
					String enteredNumber = textField.getText() + btn1.getText();
					textField.setText(enteredNumber);
					tempText = tempText + btn1.getText();
					secondNum = Double.parseDouble(tempText.toString());
					secondNumStatus = true;
					secondNumCountTextField++;
				}
			}
			
		});
		btn1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn1.setBounds(10, 263, 58, 50);
		frame.getContentPane().add(btn1);
		
		
		
		/***************/
		JButton btn2 = new JButton("2");
		btn2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				status.setText("");
				if(resultDispalied)
				{
					textField.setText("");
					resultDispalied = false;
				}
				
				if(!firstNumStatus)
				{
					String enteredNumber = textField.getText() + btn2.getText();
					textField.setText(enteredNumber);
					firstNum = Double.parseDouble(textField.getText());
				}else {
					String enteredNumber = textField.getText() + btn2.getText();
					textField.setText(enteredNumber);
					tempText = tempText + btn2.getText();
					secondNum = Double.parseDouble(tempText.toString());
					secondNumStatus = true;
					secondNumCountTextField++;
				}
			}
		});
		btn2.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn2.setBounds(76, 263, 58, 50);
		frame.getContentPane().add(btn2);
		
		
		
		
		/***************/
		JButton btn3 = new JButton("3");
		btn3.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				status.setText("");
				if(resultDispalied)
				{
					textField.setText("");
					resultDispalied = false;
				}
				
				if(!firstNumStatus)
				{
					String enteredNumber = textField.getText() + btn3.getText();
					textField.setText(enteredNumber);
					firstNum = Double.parseDouble(textField.getText());
				}else {
					String enteredNumber = textField.getText() + btn3.getText();
					textField.setText(enteredNumber);
					tempText = tempText + btn3.getText();
					secondNum = Double.parseDouble(tempText.toString());
					secondNumStatus = true;
					secondNumCountTextField++;
				}
			}
		});
		btn3.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn3.setBounds(144, 263, 58, 50);
		frame.getContentPane().add(btn3);
		
		
		
		
		/***************/
		JButton btnDiv = new JButton("/");
		btnDiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(secondNumStatus)
				{
					status.setText("One operation at a time");
					return;
				}
				if(operationStatus)
				{
					tempText = textField.getText();
					String tempText01 = tempText.substring(0, tempText.length()-1);
					String tempText02 = tempText01.substring(0, tempText01.length()-1);
					textField.setText(tempText02.substring(0, tempText02.length()-1));
					tempText = "";
				}
				if(resultDispalied)
				{
					firstNum = Double.parseDouble(textField.getText());
					resultDispalied = false;
					operationStatus = true;
				}
				
				if(!textField.getText().equals(""))
				{
					operations = "/";
					tempText = textField.getText() + " " + operations + " ";
					textField.setText(tempText);
					tempText = "";
					div = true;
					equal = true;
					firstNumStatus = true;
					operationStatus = true;
					dot = false;
					countTextFieldCharacters += 3;
				}else {
					
				}
			}
		});
		btnDiv.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDiv.setBounds(212, 263, 58, 50);
		frame.getContentPane().add(btnDiv);
		
		
		/**************************************** Row 5 *******************************************/
		JButton btn0 = new JButton("0");
		btn0.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				status.setText("");
				if(resultDispalied)
				{
					textField.setText("");
					resultDispalied = false;
				}

				if(!firstNumStatus)
				{
					String enteredNumber = textField.getText() + btn0.getText();
					textField.setText(enteredNumber);
					firstNum = Double.parseDouble(textField.getText());
				}else {
					String enteredNumber = textField.getText() + btn0.getText();
					textField.setText(enteredNumber);
					tempText = tempText + btn0.getText();
					secondNum = Double.parseDouble(tempText.toString());
					secondNumStatus = true;
					secondNumCountTextField++;
				}
			}
		});
		btn0.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn0.setBounds(10, 320, 58, 50);
		frame.getContentPane().add(btn0);
		
		
		
		
		/***************/
		JButton btnDot = new JButton(".");
		btnDot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(textField.getText().equals("")) {
					return;
				}else {
					if(resultDispalied)
					{
						return;
					}else {
						if(!firstNumStatus)
						{
							if(!dot) {
								dot = true;
								String enteredNumber = textField.getText() + btnDot.getText();
								textField.setText(enteredNumber);
							}else {
								
							}
						}else if(secondNumStatus && operationStatus){
							if(!dot) {
								dot = true;
								String enteredNumber = textField.getText() + btnDot.getText();
								textField.setText(enteredNumber);
								tempText = tempText + btnDot.getText();
								secondNumCountTextField++;
							}else {
								
							}
						}else {
							
						}
					}
				}
			}
		});
		btnDot.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnDot.setBounds(76, 320, 58, 50);
		frame.getContentPane().add(btnDot);
		
		
		
		
		/***************/
		JButton btnPM = new JButton("+-");
		btnPM.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(resultDispalied) {
					firstNum = Double.parseDouble(textField.getText());
					resultDispalied = false;
					
					firstNum = firstNum * (-1);
					textField.setText("");
					textField.setText(String.valueOf(firstNum));
				}else {
					if(secondNumStatus) {
						String enteredNumber = textField.getText();
						secondNum = secondNum * (-1);
						int indexOfOperator = enteredNumber.indexOf(operations);
						tempText = enteredNumber.substring(0, indexOfOperator+2);
						tempText = tempText.concat("(" + String.valueOf(secondNum) + ")");
						textField.setText(tempText);
					}else if(operationStatus) {
						return;
					}else
					//if first number entered switch sign
					{
						firstNum = firstNum * (-1);
						textField.setText("");
						textField.setText(String.valueOf(firstNum));
					}
				}
			}
		});
		btnPM.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnPM.setBounds(144, 320, 58, 50);
		frame.getContentPane().add(btnPM);
		
		
		
		/***************/
		JButton btnEqual = new JButton("=");
		btnEqual.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
								
				if(!textField.getText().equals(""))
				{
					if(operations == "+")
					{
						result = firstNum + secondNum;
						answer = String.format("%.2f", result);
						status.setText("");
						textField.setText(answer);
						resultDispalied = true;
						firstNumStatus = false;
						secondNumStatus = false;
						PMStatus = false;
						equal = false;
						plus = false;
						operationStatus = false;
						tempText = "";
						secondNumCountTextField = 0;
					}
					else if(operations == "-")
					{
						result = firstNum - secondNum;
						answer = String.format("%.2f", result);
						status.setText("");
						textField.setText(answer);
						resultDispalied = true;
						firstNumStatus = false;
						secondNumStatus = false;
						PMStatus = false;
						equal = false;
						minus = false;
						operationStatus = false;
						tempText = "";
						secondNumCountTextField = 0;
					}
					else if(operations == "*")
					{
						result = firstNum * secondNum;
						answer = String.format("%.2f", result);
						status.setText("");
						textField.setText(answer);
						resultDispalied = true;
						firstNumStatus = false;
						secondNumStatus = false;
						PMStatus = false;
						equal = false;
						mul = false;
						operationStatus = false;
						tempText = "";
						secondNumCountTextField = 0;
					}
					else if(operations == "/")
					{
						result = firstNum / secondNum;
						answer = String.format("%.2f", result);
						status.setText("");
						textField.setText(answer);
						resultDispalied = true;
						firstNumStatus = false;
						secondNumStatus = false;
						PMStatus = false;
						equal = false;
						div = false;
						operationStatus = false;
						tempText = "";
						secondNumCountTextField = 0;
					}
					else {

					}
				}else {
					
					
				}
				
				
				
				
			}
		});
		btnEqual.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnEqual.setBounds(212, 320, 58, 50);
		frame.getContentPane().add(btnEqual);
		


		
		
		
		
		
	}
}
