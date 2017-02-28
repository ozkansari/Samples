package ball;

import java.awt.Color;

public class LotteryBall {
	private int myValue;

	private Color ballColor = new Color(255, 0, 0);

	public LotteryBall() {
		myValue = 0;
	}

	public LotteryBall(int val) {
		myValue = val + 1;
	}

	public LotteryBall(int val, int r, int g, int b) {
		myValue = val + 1;
		ballColor = new Color(r, g, b);
	}

	public int value() {
		return myValue;
	}

	public Color getBallColor() {
		return ballColor;
	}

	public String toString() {
		return " " + value();
	}
}