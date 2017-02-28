package ball;

import java.util.ArrayList;

public class LotteryHopper {
	private ArrayList<LotteryBall> myBalls = new ArrayList<LotteryBall>();
	private static final int DEFAULT_NUM_BALLS = 10;

	public LotteryHopper() {
		for (int j = 0; j < DEFAULT_NUM_BALLS; j++)
			myBalls.add(new LotteryBall(j));
	}

	public LotteryHopper(int numBalls) {
		for (int j = 0; j < numBalls; j++)
			myBalls.add(new LotteryBall(j));
	}

	public int size() {
		return myBalls.size();
	}

	public LotteryBall chooseBall(int j) {
		return (LotteryBall) myBalls.remove(j);
	}
}