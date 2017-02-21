/**
 * Abstract Superclass that makes a 2D String array used to represent world
 * 
 * @author 0207805s
 *
 */

abstract class World {

	// instance variables
	protected Creature[][] grid;
	protected final int rows;
	protected final int cols;
	protected int specAbirths;

	public int getSpecAbirths() {
		return specAbirths;
	}

	public void setSpecAbirths() {
		this.specAbirths++;
	}

	public int getSpecBbirths() {
		return specBbirths;
	}

	public void setSpecBbirths() {
		this.specBbirths++;
	}

	protected int specBbirths;

	/**
	 * Constructor for abstract class World
	 * 
	 * @param rows
	 *            number of rows in the grid
	 * @param cols
	 *            number of columns in the grid
	 */
	public World(int rows, int cols) {
		this.rows = rows;
		this.cols = cols;
		this.makeGrid();
	}

	/**
	 * Method that creates 2D string array and populates it with a a given
	 * string
	 * 
	 */
	private void makeGrid() {
		grid = new Creature[rows][cols];

	}

	/**
	 * Method to print out the 2D array to the console
	 */
	public void printGrid() {
		System.out.println("");// new line
		for (int i = 0; i < rows; i++) {

			for (int k = 0; k < cols; k++) {
				if (grid[i][k] == null) {
					System.out.print("-");
				} else
					System.out.print(grid[i][k]);
			}
			System.out.println("");// new line

		}
		System.out.println("Number of creatures " + this.countCreatures());
		System.out.println("");// new line
	}

	/**Method to count the number of creatures in 
	 * the grid at a specific point
	 * 
	 * @return number of creatures
	 */
	public int countCreatures() {
		int numInhabitants = 0;
		for (int i = 0; i < rows; i++) {

			for (int k = 0; k < cols; k++) {
				if (grid[i][k] != null) {
					numInhabitants++;

				}

			}
		}
		return numInhabitants;
	}

	/**
	 * Abstract Method Returns the contents of a cell of index [x][y] Logic will
	 * vary with the type of world
	 * 
	 * @param x
	 * @param y
	 * @return String
	 */
	abstract public Creature getCellContents(int x, int y);

	abstract public int alterXPosition(int x);

	abstract public int alterYPosition(int y);

	/**
	 * Method to add a creature(string) to a position in the 2D array
	 * 
	 * @param x
	 *            coordinate
	 * @param y
	 *            coordinates
	 * @param speciesType
	 */
	public synchronized void insertCreature(int x, int y, Creature speciesType) {
		grid[x][y] = speciesType;
	}

	/**Makes a grid position null when a creature dies and does not 
	 * place a child in it's own square 
	 * @param x position
	 * @param y	position
	 */
	public void makeNull(int x, int y) {

		grid[x][y] = null;
	}

}
