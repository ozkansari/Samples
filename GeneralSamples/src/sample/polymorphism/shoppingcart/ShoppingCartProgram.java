package sample.polymorphism.shoppingcart;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * Example shows:
 * - GUI
 * - Inner class
 * - Polymorphism, Interface, Inheritance
 * - List iteration
 */
public class ShoppingCartProgram extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private JLabel displayAreaLeft, displayAreaRight;
	
	private ExitButtonHandler exitHandler;
	private CoffeeProductBtnHandler coffeeProductBtnHandler;
	private BookProductBtnHandler bookProductBtnHandler;

	private static final int WIDTH = 400;
	private static final int HEIGHT = 300;

	/**
	 * Different product types are kept here
	 */
	private List<Product> shoppingCart = new ArrayList<Product>();
	
	private int totalPrize = 0;
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String args[]) {
		ShoppingCartProgram rectObject = new ShoppingCartProgram();
	}
	
	/**
	 * CONSTRUCTOR
	 */
	public ShoppingCartProgram() {
		
		// create CoffeeProduct Button
		JButton coffeeProductBtn = new JButton("Coffee");
		coffeeProductBtnHandler = new CoffeeProductBtnHandler();
		coffeeProductBtn.addActionListener(coffeeProductBtnHandler);

		// create CoffeeProduct Button
		JButton bookProductBtn = new JButton("Book");
		bookProductBtnHandler = new BookProductBtnHandler();
		bookProductBtn.addActionListener(bookProductBtnHandler);
		
		displayAreaLeft = new JLabel("No Product", SwingConstants.CENTER);
		displayAreaRight = new JLabel("0 TL", SwingConstants.CENTER);
		
		// Create Exit Button
		JButton exitB = new JButton("Exit");
		exitHandler = new ExitButtonHandler();
		exitB.addActionListener(exitHandler);

		// Set the title of the window
		setTitle("Birazý Burada . commm");

		// Get the container
		Container pane = getContentPane();

		// Set the layout
		pane.setLayout(new GridLayout(5, 2));
 
		
		// Place all items created
		pane.add(coffeeProductBtn);
		pane.add(bookProductBtn);
		pane.add(displayAreaLeft);
		pane.add(displayAreaRight);
		pane.add(exitB);
		
		// set the size of the window and display it
		setSize(WIDTH, HEIGHT);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	/**
	 * Refreshes label on the frame
	 */
	private void refreshDisplayAreas() {
		displayAreaLeft.setText(shoppingCart.size() + " products");
		displayAreaRight.setText(totalPrize + " TL");
		
	}
	
	/**
	 * Claculates total prize
	 * 
	 * @param productParam
	 */
	private void checkOut(Product productParam) {
		totalPrize += productParam.getPrize();
	}
	
	
	/**
	 * INNER CLASS
	 */
	private class CoffeeProductBtnHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Product product = new CoffeeProduct();
			shoppingCart.add(product);
			checkOut(product);
			refreshDisplayAreas();
		}
	}
	
	/**
	 * INNER CLASS
	 */
	private class BookProductBtnHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Product product = new BookProduct();
			shoppingCart.add(product);
			checkOut(product);
			refreshDisplayAreas();
		}
	}
	
	/**
	 * 
	 */
	private class ExitButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}

}
