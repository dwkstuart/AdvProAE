

public class TorusWorld extends World {
	public TorusWorld(int rows, int cols) {

		super(rows, cols);
	}

	
	// Method to handle out of bounds coordinates on X axis
	public int alterXPosition(int x) {
		if (x < 0) {
			x = rows - 1;
		}else
		if (x > rows-1) {
			x = 0;
		}
		return x;
	}

	public int alterYPosition(int y) {
		if (y < 0) {
			y = cols - 1;
		}
		else
		if (y > cols-1) {
			y = 0;
		}
		return y;

	}


}
