

public class EdgeWorld extends World{	
	public EdgeWorld(int rows, int cols) {
		
		super(rows, cols);
	}


public int alterXPosition(int x) {
	if (x < 0) {
		x = -1;
	}else
	if (x > rows-1) {
		x = -1;
	}
	return x;
	
}
@Override
public int alterYPosition(int y) {
	if (y < 0) {
		y = -1;
	}else
	if (y > cols-1) {
		y = -1;
	}
	return y;
}




}
