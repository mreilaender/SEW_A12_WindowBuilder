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

import javax.swing.JLabel;

import reilaender.com.udojava.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class Calculator {

	private JFrame frame;
	private JFormattedTextField input;
	
	private JButton one, two, three, four, five, six, seven, eight, nine, zero,
		plus, minus, div, multi,
		equals, dot, clear
		;
	private JLabel output;
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
		p_input.setBackground(Color.WHITE);
		p_input.setBorder(new EmptyBorder(10, 20, 10, 20));
		frame.getContentPane().add(p_input, BorderLayout.NORTH);
		GridBagLayout gbl_p_input = new GridBagLayout();
		gbl_p_input.columnWidths = new int[]{442, 0};
		gbl_p_input.rowHeights = new int[]{20, 0, 0};
		gbl_p_input.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_p_input.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		p_input.setLayout(gbl_p_input);
		
		final JFormattedTextField input = new JFormattedTextField();
		input.setBorder(BorderFactory.createEmptyBorder());
		input.addKeyListener(new KeyAdapter() {
			private String err = "Not a valid number";
			private boolean test;
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();
				int k = e.getKeyCode();
				System.out.println(k);
				if(!(k == KeyEvent.VK_ENTER || k == KeyEvent.VK_SPACE)) {
					output.setText(err);
					e.consume();
					test = false;
				}
			}
			@Override
			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				int k = e.getKeyCode();
				System.out.println(k);
				if( !( ((c >= '0') && (c <= '9')) || (c == '+') || (c == '-') || (c == '*') || (c == '/')) ) {
					System.out.println("hier");
					output.setText(err);
					
					e.consume();
				} else if (output.getText().equals(err)) {
					output.setText("");
				} else if (test) {
					
				}
				input.requestFocus();
			}
			@Override
			public void keyReleased(KeyEvent e) {
				char c = e.getKeyChar();
				int k = e.getKeyCode();
//				Expression expr = new Expression("1000000000000000000000000000000000000000000000000+1");
//				String[] a = input.getText().split("[+]");
//				for(int i = 0; i < a.length;++i) {
//					if(a[i].contains("-")) {
//						String[] tmp = a[i].split("[-]");
//						System.out.println("Minus:");
//						for(int j = 0;j < tmp.length;++j)
//							System.out.println(tmp[j]);
//					}
//					System.out.println(a[i]);
//				}
				if (k == KeyEvent.VK_ENTER || k == KeyEvent.VK_ENTER) {
					output.setText("" + new Expression(input.getText()).eval());
				} else if (k == KeyEvent.VK_SPACE) {
					System.err.println("SPACE");
				}
				input.requestFocus();
			}
		});
		GridBagConstraints gbc_input = new GridBagConstraints();
		gbc_input.insets = new Insets(0, 0, 5, 0);
		gbc_input.fill = GridBagConstraints.BOTH;
		gbc_input.gridx = 0;
		gbc_input.gridy = 0;
		p_input.add(input, gbc_input);
		
		output = new JLabel("");
		output.setForeground(Color.LIGHT_GRAY);
		GridBagConstraints gbc_output = new GridBagConstraints();
		gbc_output.anchor = GridBagConstraints.NORTH;
		gbc_output.fill = GridBagConstraints.HORIZONTAL;
		gbc_output.gridx = 0;
		gbc_output.gridy = 1;
		p_input.add(output, gbc_output);
		
		JPanel p_numbers = new JPanel();
		p_numbers.setBackground(Color.DARK_GRAY);
		p_numbers.setBorder(new EmptyBorder(10, 10, 10, 10));
		frame.getContentPane().add(p_numbers, BorderLayout.CENTER);
		p_numbers.setLayout(new GridLayout(0, 3, 0, 0));
		
		seven = new JButton("7");
		seven.setBorder(BorderFactory.createEmptyBorder());
		seven.setBackground(Color.DARK_GRAY);
		seven.setForeground(Color.WHITE);
		p_numbers.add(seven);
		
		eight = new JButton("8");
		eight.setBorder(BorderFactory.createEmptyBorder());
		eight.setBackground(Color.DARK_GRAY);
		eight.setForeground(Color.WHITE);
		p_numbers.add(eight);
		
		nine = new JButton("9");
		nine.setBorder(BorderFactory.createEmptyBorder());
		nine.setBackground(Color.DARK_GRAY);
		nine.setForeground(Color.WHITE);
		p_numbers.add(nine);
		
		four = new JButton("4");
		four.setBorder(BorderFactory.createEmptyBorder());
		four.setBackground(Color.DARK_GRAY);
		four.setForeground(Color.WHITE);
		p_numbers.add(four);
		
		five = new JButton("5");
		five.setBorder(BorderFactory.createEmptyBorder());
		five.setBackground(Color.DARK_GRAY);
		five.setForeground(Color.WHITE);
		p_numbers.add(five);
		
		six = new JButton("6");
		six.setBorder(BorderFactory.createEmptyBorder());
		six.setBackground(Color.DARK_GRAY);
		six.setForeground(Color.WHITE);
		p_numbers.add(six);
		
		one = new JButton("1");
		one.setBorder(BorderFactory.createEmptyBorder());
		one.setBackground(Color.DARK_GRAY);
		one.setForeground(Color.WHITE);
		p_numbers.add(one);
		
		two = new JButton("2");
		two.setBorder(BorderFactory.createEmptyBorder());
		two.setBackground(Color.DARK_GRAY);
		two.setForeground(Color.WHITE);
		p_numbers.add(two);
		
		three = new JButton("3");
		three.setBorder(BorderFactory.createEmptyBorder());
		three.setBackground(Color.DARK_GRAY);
		three.setForeground(Color.WHITE);
		p_numbers.add(three);
		
		dot = new JButton(".");
		dot.setBorder(BorderFactory.createEmptyBorder());
		dot.setBackground(Color.DARK_GRAY);
		dot.setForeground(Color.WHITE);
		p_numbers.add(dot);
		
		zero = new JButton("0");
		zero.setBorder(BorderFactory.createEmptyBorder());
		zero.setBackground(Color.DARK_GRAY);
		zero.setForeground(Color.WHITE);
		p_numbers.add(zero);
		
		equals = new JButton("=");
		equals.setBorder(BorderFactory.createEmptyBorder());
		equals.setBackground(Color.DARK_GRAY);
		equals.setForeground(Color.WHITE);
		p_numbers.add(equals);
		
		JPanel p_operations = new JPanel();
		p_operations.setBackground(Color.GRAY);
		p_operations.setBorder(new EmptyBorder(10, 10, 10, 10));
		frame.getContentPane().add(p_operations, BorderLayout.EAST);
		p_operations.setLayout(new GridLayout(5, 1, 0, 0));
		
		clear = new JButton("CLR");
		clear.setBorder(BorderFactory.createEmptyBorder());
		clear.setBackground(Color.GRAY);
		clear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output.setText("");
				input.setText("");
				input.requestFocus();
			}
		});
		p_operations.add(clear);
		
		div = new JButton("/");
		div.setBorder(BorderFactory.createEmptyBorder());
		div.setBackground(Color.GRAY);
		p_operations.add(div);
		
		multi = new JButton("x");
		multi.setBorder(BorderFactory.createEmptyBorder());
		multi.setBackground(Color.GRAY);
		p_operations.add(multi);
		
		minus = new JButton("-");
		minus.setBorder(BorderFactory.createEmptyBorder());
		minus.setBackground(Color.GRAY);
		p_operations.add(minus);
		
		plus = new JButton("+");
		plus.setBorder(BorderFactory.createEmptyBorder());
		plus.setBackground(Color.GRAY);
		plus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		p_operations.add(plus);
	}

}
