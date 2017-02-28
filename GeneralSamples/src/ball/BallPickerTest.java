package ball;

public class BallPickerTest {
	public static void main(String args[]) {
		BallPicker pete = new BallPicker(54);

		for (int j = 0; j < 6; j++) {
			System.out.print(pete.chooseBall() + "  ");
		}

		System.out.println();
	}
}