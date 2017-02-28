package ball;

import java.util.Random;

public class BallPicker {
	private static Random rg = new Random();
	private LotteryHopper myHopper;

	public BallPicker() {
		myHopper = new LotteryHopper();
	}

	public BallPicker(int numBalls) {
		myHopper = new LotteryHopper(numBalls);
	}

	public LotteryBall chooseBall() {
		int aBall = rg.nextInt(myHopper.size());

		return myHopper.chooseBall(aBall);

	}

}