package calculator;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class Calculator {

	double dNumber = 0;
	double dMemory;
	double dResult = 0;
	boolean operator = false;
	boolean onOff = false;
	boolean equalUse = false;
	boolean operatorUse = false;
	int operate = 0;
	String resultFormat;

	private JFrame frame;
	private JLabel lblDisplayResult;

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
	/*-----------------------------------------------CALCULATE_METHOD-------------------------------*/

	/**
	 * make the differents operations function of operator
	 * 
	 * @param operate
	 * @param d
	 */

	public void calculTwoOperande(int operate, double d) {
System.out.println("avant " + dNumber + " " + d);
		switch (operate) {
		case 0:
			dNumber = d;
			break;
		case 1:
			dNumber = dNumber + d;
			break;
		case 2:
			dNumber = dNumber - d;
			break;

		case 3:
			dNumber = dNumber * d;
			break;

		case 4:
			dNumber = dNumber / d;
			break;
		}
		resultFormat = formatNumber();
		lblDisplayResult.setText(String.valueOf(resultFormat));
		System.out.println("apres " + dNumber + " " + d);
	}

	/**
	 * used to be able to play operation after use equals
	 */

	public void reinitEqual() {
		if (equalUse) {
			equalUse = !equalUse;
		}
	}

	/**
	 * used to print result after operation and delete display with previous number
	 */
	public void ReinitDisplayNumber() {
		if (operator) {
			lblDisplayResult.setText("");
			operator = !operator;
		}
	}

	/**
	 * used to reinit sign if user click on several following sign
	 */
	public void ReinitOperatorUse() {
		if (operatorUse) {
			operatorUse = !operatorUse;
		}
	}

	/**
	 * allows to print int or double fonction of type's result
	 * 
	 * @return resultFormat
	 */
	public String formatNumber() {
		DecimalFormatSymbols otherSymbols = new DecimalFormatSymbols(Locale.US);
		DecimalFormat decimalNumber = new DecimalFormat("#.##################", otherSymbols);
		String resultFormat = decimalNumber.format(dNumber);
		return resultFormat;
	}

	/**
	 * allows to reinit d as zero instead of string error
	 * 
	 * @param d
	 */
	public void deleteErrorMessage() {
		if (lblDisplayResult.getText() == "error") {
			lblDisplayResult.setText("");
			dNumber = 0;
		}
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
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 549, 658);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		/*--------------------------------------------------------CONTAINEUR-----------------------------*/

		JPanel button_container = new JPanel();
		button_container.setBounds(10, 239, 514, 369);
		button_container.setBackground(Color.BLACK);
		frame.getContentPane().add(button_container);
		button_container.setLayout(null);

		JPanel display_container = new JPanel();
		display_container.setBackground(new Color(176, 196, 222));
		display_container.setBounds(22, 130, 482, 98);
		frame.getContentPane().add(display_container);
		display_container.setLayout(null);

		lblDisplayResult = new JLabel("");
		lblDisplayResult.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDisplayResult.setBounds(85, 11, 387, 76);
		display_container.add(lblDisplayResult);

		JLabel lbDisplaySign = new JLabel("");
		lbDisplaySign.setBounds(10, 11, 53, 76);
		display_container.add(lbDisplaySign);

		/*-------------------------------------------------BUTTON_NUMBER-----------------------------*/

		// Number 0
		JButton btnNumberZero = new JButton("0");
		btnNumberZero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (onOff) {
					deleteErrorMessage();
					reinitEqual();
					ReinitDisplayNumber();
					ReinitOperatorUse();
					lbDisplaySign.setText("");

					// to print only one 0
					if (lblDisplayResult.getText().equals("0")) {
						lblDisplayResult.setText("0");
					} else {
						lblDisplayResult.setText(lblDisplayResult.getText() + "0");
					}
					
				}
			}
		});
		
		// Number 1
		btnNumberZero.setBackground(Color.LIGHT_GRAY);
		btnNumberZero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNumberZero.setBounds(10, 299, 89, 60);
		button_container.add(btnNumberZero);

		JButton btnNumberOne = new JButton("1");
		btnNumberOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					if (equalUse) {
						dNumber = 0;
					}
					deleteErrorMessage();
					ReinitDisplayNumber();
					ReinitOperatorUse();
					lbDisplaySign.setText("");
					lblDisplayResult.setText(lblDisplayResult.getText() + "1");
				}
			}
		});
		btnNumberOne.setBackground(Color.LIGHT_GRAY);
		btnNumberOne.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNumberOne.setBounds(10, 228, 89, 60);
		button_container.add(btnNumberOne);

		// Number 2
		JButton btnNumberTwo = new JButton("2");
		btnNumberTwo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					if (equalUse) {
						dNumber = 0;
					}
					deleteErrorMessage();
					ReinitDisplayNumber();
					ReinitOperatorUse();
					lbDisplaySign.setText("");
					lblDisplayResult.setText(lblDisplayResult.getText() + "2");
				}
			}
		});
		btnNumberTwo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNumberTwo.setBackground(Color.LIGHT_GRAY);
		btnNumberTwo.setBounds(109, 228, 89, 60);
		button_container.add(btnNumberTwo);

		// Number 3
		JButton btnNumberThree = new JButton("3");
		btnNumberThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					if (equalUse) {
						dNumber = 0;
					}
					deleteErrorMessage();
					ReinitDisplayNumber();
					ReinitOperatorUse();
					lbDisplaySign.setText("");
					lblDisplayResult.setText(lblDisplayResult.getText() + "3");
				}
			}
		});
		btnNumberThree.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNumberThree.setBackground(Color.LIGHT_GRAY);
		btnNumberThree.setBounds(208, 228, 89, 60);
		button_container.add(btnNumberThree);

		// Number 4
		JButton btnNumberFour = new JButton("4");
		btnNumberFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					if (equalUse) {
						dNumber = 0;
					}
					deleteErrorMessage();
					ReinitDisplayNumber();
					ReinitOperatorUse();
					lbDisplaySign.setText("");
					lblDisplayResult.setText(lblDisplayResult.getText() + "4");
				}
			}
		});
		btnNumberFour.setBackground(Color.LIGHT_GRAY);
		btnNumberFour.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNumberFour.setBounds(10, 157, 89, 60);
		button_container.add(btnNumberFour);

		// Number 5
		JButton btnNumberFive = new JButton("5");
		btnNumberFive.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					if (equalUse) {
						dNumber = 0;
					}
					deleteErrorMessage();
					ReinitDisplayNumber();
					ReinitOperatorUse();
					lbDisplaySign.setText("");
					lblDisplayResult.setText(lblDisplayResult.getText() + "5");
				}
			}
		});
		btnNumberFive.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNumberFive.setBackground(Color.LIGHT_GRAY);
		btnNumberFive.setBounds(109, 157, 89, 60);
		button_container.add(btnNumberFive);

		// Number 6
		JButton btnNumberSix = new JButton("6");
		btnNumberSix.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					if (equalUse) {
						dNumber = 0;
					}
					deleteErrorMessage();
					ReinitDisplayNumber();
					ReinitOperatorUse();
					lbDisplaySign.setText("");
					lblDisplayResult.setText(lblDisplayResult.getText() + "6");
				}
			}
		});
		btnNumberSix.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNumberSix.setBackground(Color.LIGHT_GRAY);
		btnNumberSix.setBounds(208, 157, 89, 60);
		button_container.add(btnNumberSix);

		// Number 7
		JButton btnNumberSeven = new JButton("7");
		btnNumberSeven.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					if (equalUse) {
						dNumber = 0;
					}
					deleteErrorMessage();
					ReinitDisplayNumber();
					ReinitOperatorUse();
					lbDisplaySign.setText("");
					lblDisplayResult.setText(lblDisplayResult.getText() + "7");
				}
			}
		});
		btnNumberSeven.setBackground(Color.LIGHT_GRAY);
		btnNumberSeven.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNumberSeven.setBounds(10, 86, 89, 60);
		button_container.add(btnNumberSeven);

		// Number 8
		JButton btnNumberHeight = new JButton("8");
		btnNumberHeight.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					if (equalUse) {
						dNumber = 0;
					}
					deleteErrorMessage();
					ReinitDisplayNumber();
					ReinitOperatorUse();
					lbDisplaySign.setText("");
					lblDisplayResult.setText(lblDisplayResult.getText() + "8");
				}
			}
		});
		btnNumberHeight.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNumberHeight.setBackground(Color.LIGHT_GRAY);
		btnNumberHeight.setBounds(109, 86, 89, 60);
		button_container.add(btnNumberHeight);

		// Number 9
		JButton btnNumberNine = new JButton("9");
		btnNumberNine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					if (equalUse) {
						dNumber = 0;
					}
					deleteErrorMessage();
					ReinitDisplayNumber();
					ReinitOperatorUse();
					lbDisplaySign.setText("");
					lblDisplayResult.setText(lblDisplayResult.getText() + "9");
				}
			}
		});
		btnNumberNine.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNumberNine.setBackground(Color.LIGHT_GRAY);
		btnNumberNine.setBounds(208, 86, 89, 60);
		button_container.add(btnNumberNine);

		// Coma button
		JButton btnDecimal = new JButton(".");
		btnDecimal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					lbDisplaySign.setText("");

					if (lblDisplayResult.getText().contains(".")) {
						lblDisplayResult.getText();
					} else {
						lblDisplayResult.setText(lblDisplayResult.getText() + ".");
					}

				}
			}
		});
		btnDecimal.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDecimal.setBackground(Color.LIGHT_GRAY);
		btnDecimal.setBounds(109, 299, 89, 60);
		button_container.add(btnDecimal);

		// button change sign of number
		JButton btnSignNumber = new JButton("+/-");
		btnSignNumber.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					dNumber = -Double.parseDouble(lblDisplayResult.getText());
					lblDisplayResult.setText(String.valueOf(dNumber));
				}
			}
		});
		btnSignNumber.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSignNumber.setBackground(Color.LIGHT_GRAY);
		btnSignNumber.setBounds(208, 299, 89, 60);
		button_container.add(btnSignNumber);

		/*-----------------------------------OPERATIONS_BUTTONS------------------------------------*/

		//Plus button
		JButton BtnAdd = new JButton("+");
		BtnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					deleteErrorMessage();
					if (equalUse) {
						operate = 0;
					}
					reinitEqual();
					if (operatorUse == false) {
						calculTwoOperande(operate, Double.parseDouble(lblDisplayResult.getText()));
					}

					operate = 1;
					operator = true;
					operatorUse = true;
					lbDisplaySign.setText("+");
				}
			}
		});
		BtnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		BtnAdd.setBackground(Color.LIGHT_GRAY);
		BtnAdd.setBounds(307, 228, 89, 131);
		button_container.add(BtnAdd);

		//Minus button
		JButton btnSubstract = new JButton("-");
		btnSubstract.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					deleteErrorMessage();
					if (equalUse) {
						operate = 0;
					}
					reinitEqual();
	
					if (operatorUse == false) {
						calculTwoOperande(operate, Double.parseDouble(lblDisplayResult.getText()));
					}
					operate = 2;
					operator = true;
					operatorUse = true;
					lbDisplaySign.setText("-");

				}
			}
		});
		btnSubstract.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSubstract.setBackground(Color.LIGHT_GRAY);
		btnSubstract.setBounds(406, 228, 89, 60);
		button_container.add(btnSubstract);

		//Multiply button
		JButton BtnMultiply = new JButton("x");
		BtnMultiply.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					deleteErrorMessage();
					if (equalUse) {
						operate = 0;
					}
					reinitEqual();
					if (operatorUse == false) {
						calculTwoOperande(operate, Double.parseDouble(lblDisplayResult.getText()));
					}
					operate = 3;
					operator = true;
					operatorUse = true;
					lbDisplaySign.setText("x");

				}
			}
		});
		BtnMultiply.setFont(new Font("Tahoma", Font.PLAIN, 12));
		BtnMultiply.setBackground(Color.LIGHT_GRAY);
		BtnMultiply.setBounds(307, 157, 89, 60);
		button_container.add(BtnMultiply);

		//Divided button
		JButton btnDivided = new JButton("\u00F7");
		btnDivided.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					deleteErrorMessage();
					if (equalUse) {
						operate = 0;
					}
					reinitEqual();
					if (operatorUse == false) {
						calculTwoOperande(operate, Double.parseDouble(lblDisplayResult.getText()));
					}
					operate = 4;
					operator = true;
					operatorUse = true;
					lbDisplaySign.setText("\u00F7");

				}
			}
		});
		btnDivided.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnDivided.setBackground(Color.LIGHT_GRAY);
		btnDivided.setBounds(406, 157, 89, 60);
		button_container.add(btnDivided);

		//Percentage button
		JButton BtnPercentage = new JButton("%");
		BtnPercentage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					double dNumberPercent;
					dNumberPercent = Double.parseDouble(lblDisplayResult.getText()) / 100;
					lblDisplayResult.setText(String.valueOf(dNumberPercent));
					dResult = Double.parseDouble(lblDisplayResult.getText());
					operator = true;
				}
			}
		});
		BtnPercentage.setFont(new Font("Tahoma", Font.PLAIN, 12));
		BtnPercentage.setBackground(Color.LIGHT_GRAY);
		BtnPercentage.setBounds(307, 86, 89, 60);
		button_container.add(BtnPercentage);

		//Square root button
		JButton btnSquareRoot = new JButton("\u221A");
		btnSquareRoot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					double dNumbersqrt;
					if (Double.parseDouble(lblDisplayResult.getText()) > 0) {
						dNumbersqrt = Math.sqrt(Double.parseDouble(lblDisplayResult.getText()));
						lblDisplayResult.setText(String.valueOf(dNumbersqrt));
						dResult = Double.parseDouble(lblDisplayResult.getText());
						operator = true;
					} else {
						lblDisplayResult.setText("error");
					}
				}
			}
		});
		btnSquareRoot.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSquareRoot.setBackground(Color.LIGHT_GRAY);
		btnSquareRoot.setBounds(406, 86, 89, 60);
		button_container.add(btnSquareRoot);

		//Equal button
		JButton btnSum = new JButton("=");
		btnSum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					if (equalUse == false) {
						dResult = Double.parseDouble(lblDisplayResult.getText());
						calculTwoOperande(operate, Double.parseDouble(lblDisplayResult.getText()));
						operator = true;
						equalUse = true;
				//		dNumber=0;

					} else {
					
						dNumber = Double.parseDouble(lblDisplayResult.getText());
						calculTwoOperande(operate, dResult);
					}
				}
			}
		});
		btnSum.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSum.setBackground(Color.LIGHT_GRAY);
		btnSum.setBounds(406, 299, 89, 60);
		button_container.add(btnSum);

		/*--------------------------------------------------OTHERS_BUTTONS---------------------*/

		//Switch On - Off button
		JButton btnOn_Off = new JButton("ON-C");
		btnOn_Off.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				lbDisplaySign.setText("");
				lblDisplayResult.setText("");
				dNumber = 0;
				dResult = 0;
				operate = 0;
				operator = false;
				equalUse = false;
				operatorUse = false;
				onOff = !onOff;

				if (onOff) {
					display_container.setBackground(new Color(176, 224, 230));
				} else {
					display_container.setBackground(new Color(176, 196, 222));
				}
			}
		});
		btnOn_Off.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnOn_Off.setBackground(Color.RED);
		btnOn_Off.setBounds(406, 19, 89, 60);
		button_container.add(btnOn_Off);

		//MRC button		
		JButton btnMemory = new JButton("MRC");
		btnMemory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					lblDisplayResult.setText(String.valueOf(dMemory));
				}
			}
		});
		btnMemory.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMemory.setBackground(Color.LIGHT_GRAY);
		btnMemory.setBounds(10, 19, 89, 60);
		button_container.add(btnMemory);

		//M+ button
		JButton btnMemPlus = new JButton("M+");
		btnMemPlus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					if (equalUse) {
						dNumber = 0;
					}
					dMemory += Double.parseDouble(lblDisplayResult.getText());
				}
			}
		});
		btnMemPlus.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMemPlus.setBackground(Color.LIGHT_GRAY);
		btnMemPlus.setBounds(109, 19, 89, 60);
		button_container.add(btnMemPlus);

		//M- button
		JButton btnMemMoins = new JButton("M-");
		btnMemMoins.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					if (equalUse) {
						dNumber = 0;
					}
					dMemory -= Double.parseDouble(lblDisplayResult.getText());
				}
			}
		});
		btnMemMoins.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnMemMoins.setBackground(Color.LIGHT_GRAY);
		btnMemMoins.setBounds(208, 19, 89, 60);
		button_container.add(btnMemMoins);

		//CE button
		JButton btnReset = new JButton("CE");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (onOff) {
					lblDisplayResult.setText("");
					lbDisplaySign.setText("");
				}
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnReset.setBackground(Color.LIGHT_GRAY);
		btnReset.setBounds(307, 19, 89, 60);
		button_container.add(btnReset);

	}
}
