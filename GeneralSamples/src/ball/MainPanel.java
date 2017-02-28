package ball;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;

import javax.swing.JPanel;

/**
 * This panel displays the lotto balls
 */
public class MainPanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	private static final int PANEL_WIDTH = 500;
	private static final int PANEL_HEIGHT = 300;

	private ArrayList<Ellipse2D.Double> graphicBalls = new ArrayList<Ellipse2D.Double>();
	private ArrayList<LotteryBall> balls = new ArrayList<LotteryBall>();

	/**
	 * Constructs a rectangle panel with the rectangle at a default location.
	 */
	public MainPanel() {
		setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
	}

	public void setBalls(ArrayList<Ellipse2D.Double> gBalls, ArrayList<LotteryBall> nBalls) {
		graphicBalls = gBalls;
		balls = nBalls;
		repaint();
	}

	private void draw(Graphics2D g2) {

		Color b = new Color(0, 0, 255);
		g2.setColor(b);
		g2.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

		for (int j = 0; j < balls.size(); j++) {
			LotteryBall currentBall = (LotteryBall) balls.get(j);
			g2.setColor(currentBall.getBallColor());
			Ellipse2D.Double drawBall = (Ellipse2D.Double) graphicBalls.get(j);
			g2.fill(drawBall);
			int x = (int) (drawBall.getX()) + 10;
			int y = (int) (drawBall.getY()) + 25;
			Font f = new Font("ARIAL", Font.BOLD, 12);
			g2.setFont(f);
			g2.setColor(new Color(0, 0, 0));
			g2.drawString(" " + currentBall.value(), x, y);
		}

	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		draw(g2);

	}

}
