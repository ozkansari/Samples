package ball;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * This frame contains a panel that displays a rectangle and a panel of text
 * fields to specify the rectangle position.
 */
public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private MainPanel rectPanel;
	private BallPicker ballPicker = new BallPicker(54);

	private ArrayList<LotteryBall> balls = new ArrayList<LotteryBall>();
	private ArrayList<Ellipse2D.Double> graphicBalls = new ArrayList<Ellipse2D.Double>();

	private int count = 0;
	private int x = 5;
	private int ballSelectionValue = 6;
	private int maxNumberSelectionValue = 54;

	/**
	 * Constructs the frame.
	 */
	public MainFrame() {

		setTitle("TURKEY_Lotto");

		createRectangularPanel();

		createControlPanel();

		pack();
	}

	/**
	 * 
	 */
	private void createRectangularPanel() {
		// the panel that draws the rectangle
		rectPanel = new MainPanel();
		getContentPane().add(rectPanel, BorderLayout.CENTER);
	}

	/**
	 * Creates the control panel with the text fields at the bottom of the
	 * frame.
	 */
	private void createControlPanel() {

		JComboBox<String> ballSelectionCombo = initBallSelectionCombo();
		JComboBox<String> maxNumberSelectionCombo = initMaxNumberSelectionCombo();
		JButton lottoButton = initLottoButton();
		JButton resetButton = initResetButton(lottoButton, ballSelectionCombo,
				maxNumberSelectionCombo);
		// the button to move the rectangle

		// the panel for holding the user interface components
		JPanel controlPanel = new JPanel();
		controlPanel.add(new JLabel("Number of balls:"));
		controlPanel.add(ballSelectionCombo);
		controlPanel.add(new JLabel("Max number:"));
		controlPanel.add(maxNumberSelectionCombo);
		controlPanel.add(lottoButton);
		controlPanel.add(resetButton);

		getContentPane().add(controlPanel, BorderLayout.SOUTH);
	}

	/**
	 * @return
	 */
	private JComboBox<String> initBallSelectionCombo() {
		String[] ballSelectionItems = { "6", "7" };
		JComboBox<String> ballSelectionCombo = new JComboBox<String>(ballSelectionItems);
		return ballSelectionCombo;
	}

	/**
	 * @return
	 */
	private JComboBox<String> initMaxNumberSelectionCombo() {
		String[] maxNumberSelectionItems = { "54", "90" };
		JComboBox<String> maxNumberSelectionCombo = new JComboBox<String>(
				maxNumberSelectionItems);
		return maxNumberSelectionCombo;
	}

	/**
	 * @return lotto button
	 */
	private JButton initLottoButton() {
		final JButton lottoButton = new JButton("Pick Ball");
		class LottoButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if (count < ballSelectionValue) {
					balls.add(ballPicker.chooseBall());
					graphicBalls.add(new Ellipse2D.Double(x + count * 50, 100,
							40, 40));
					count++;
					if (count == ballSelectionValue) {
						lottoButton.setText("Done!");
					}
				}
				rectPanel.setBalls(graphicBalls, balls);
			}
		}
		ActionListener listener = new LottoButtonListener();
		lottoButton.addActionListener(listener);
		return lottoButton;
	}

	/**
	 * @param lottoButton
	 * @param maxNumberSelectionCombo
	 * @param ballSelectionCombo
	 * @return reset button
	 */
	private JButton initResetButton(final JButton lottoButton,
			final JComboBox<String> ballSelectionCombo,
			final JComboBox<String> maxNumberSelectionCombo) {
		JButton resetButton = new JButton("Reset");
		class ResetButtonListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				ballSelectionValue = Integer.valueOf(String
						.valueOf(ballSelectionCombo.getSelectedItem()));
				maxNumberSelectionValue = Integer.valueOf(String
						.valueOf(maxNumberSelectionCombo.getSelectedItem()));
				ballPicker = new BallPicker(maxNumberSelectionValue);
				count = 0;
				lottoButton.setText("Pick Ball");
				balls.clear();
				graphicBalls.clear();
				rectPanel.setBalls(graphicBalls, balls);
			}
		}
		ActionListener listener = new ResetButtonListener();
		resetButton.addActionListener(listener);
		return resetButton;
	}

}
