package reilaender.calculator;

import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;

import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.JPanel;

import java.awt.FlowLayout;

import javax.swing.JTextField;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;
import javax.swing.JButton;

import java.awt.Window.Type;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;

import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Calculator {

	private JFrame frame;
	private JTextField output;

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
		frame.setResizable(false);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel p_input = new JPanel();
		p_input.setBorder(new EmptyBorder(10, 20, 10, 20));
		frame.getContentPane().add(p_input, BorderLayout.NORTH);
		GridBagLayout gbl_p_input = new GridBagLayout();
		gbl_p_input.columnWidths = new int[]{442, 0};
		gbl_p_input.rowHeights = new int[]{20, 0, 0};
		gbl_p_input.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_p_input.rowWeights = new double[]{1.0, 0.0, Double.MIN_VALUE};
		p_input.setLayout(gbl_p_input);
		
		JFormattedTextField input = new JFormattedTextField();
		input.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				String err = "Not a valid number";
				if( !(((c >= '0') && (c <= '9')) || (c == '+') || (c == '-') || (c == '*') || (c == '/'))) {
					output.setText("");
					output.setText(err);
					
					arg0.consume();
				} else if (output.getText().equals(err)){
					output.setText("");
				}
			}
		});
		GridBagConstraints gbc_input = new GridBagConstraints();
		gbc_input.insets = new Insets(0, 0, 5, 0);
		gbc_input.fill = GridBagConstraints.BOTH;
		gbc_input.gridx = 0;
		gbc_input.gridy = 0;
		p_input.add(input, gbc_input);
		
		output = new JTextField();
		output.setBorder(BorderFactory.createEmptyBorder());
		output.setHorizontalAlignment(JTextField.RIGHT);
		output.setForeground(Color.WHITE);
		output.setEditable(false);
		output.setEnabled(false);
		GridBagConstraints gbc_output = new GridBagConstraints();
		gbc_output.fill = GridBagConstraints.HORIZONTAL;
		gbc_output.gridx = 0;
		gbc_output.gridy = 1;
		p_input.add(output, gbc_output);
		output.setColumns(1);
		
		JPanel p_numbers = new JPanel();
		p_numbers.setBorder(new EmptyBorder(10, 10, 10, 10));
		frame.getContentPane().add(p_numbers, BorderLayout.CENTER);
		p_numbers.setLayout(new GridLayout(0, 3, 0, 0));
		
		JButton seven = new JButton("7");
		p_numbers.add(seven);
		
		JButton eight = new JButton("8");
		p_numbers.add(eight);
		
		JButton nine = new JButton("9");
		p_numbers.add(nine);
		
		JButton four = new JButton("4");
		p_numbers.add(four);
		
		JButton five = new JButton("5");
		p_numbers.add(five);
		
		JButton six = new JButton("6");
		p_numbers.add(six);
		
		JButton one = new JButton("1");
		p_numbers.add(one);
		
		JButton two = new JButton("2");
		p_numbers.add(two);
		
		JButton three = new JButton("3");
		p_numbers.add(three);
		
		JButton dot = new JButton(".");
		p_numbers.add(dot);
		
		JButton zero = new JButton("0");
		p_numbers.add(zero);
		
		JButton equals = new JButton("=");
		p_numbers.add(equals);
		
		JPanel p_operations = new JPanel();
		p_operations.setBorder(new EmptyBorder(10, 1, 10, 10));
		frame.getContentPane().add(p_operations, BorderLayout.EAST);
		p_operations.setLayout(new GridLayout(5, 1, 0, 0));
		
		JButton clear = new JButton("CLR");
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output.setText("");
				input.setText("");
				output.setText("Test");
			}
		});
		p_operations.add(clear);
		
		JButton div = new JButton("/");
		p_operations.add(div);
		
		JButton multi = new JButton("x");
		p_operations.add(multi);
		
		JButton minus = new JButton("-");
		p_operations.add(minus);
		
		JButton plus = new JButton("+");
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		p_operations.add(plus);
	}

}
