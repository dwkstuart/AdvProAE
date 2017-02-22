/**
 * Abstract Superclass Used to create generic creature objects and handle the
 * logic species reproduction, run method.
 * 
 * @author 0207805s David Stuart
 *
 */
abstract class Creature extends Thread {

	// instance variables that will need to be initialized in the concrete classes
	private int lifespan;
	private int MAXLIFE;
	private double speciesFitness;
	
	// position in the grid on x axis
	private final int posX;
		// position on the grid on y axis
	private final int posY;
	// shared world object containing
	protected final World world;
	// Left and Right offset determine the range of cells 
	//	creature can reproduce in
	private final int LEFTOFFSET = -1;
	private final int RIGHTOFFSET = 1;

	/**
	 * Abstract Constructor
	 * 
	 * @param x
	 *            the x coordinate of the creature in the world grid
	 * @param y
	 *            the y coordinate of the creature in the world grid
	 * @param grid
	 *            shared object of World type, used to reference grid
	 */
	public Creature(int x, int y, World grid) {
		this.posX = x;
		this.posY = y;
		this.world = grid;

		// places creature in the world at the specified position
		synchronized (grid) {
			grid.insertCreature(x, y, this);
		}

	}

	/**
	 * Method that handles logic for species reproduction at end of life
	 * Creature attempts to place child in the cells around it and it's own cell
	 * 
	 */
	private void reproduce() {

		// synchronize world object whilst reproduce method is taking place to
		// avoid race conditions
		
		synchronized (this.world) {
			// make the position of the creature in the array null so it
			// treats its own square as if empty
			world.makeNull(posX, posY);

			// cycles through the 9 positions on the grid
			// that surround the creature
			for (int i = LEFTOFFSET; i <= RIGHTOFFSET; i++) {
				for (int k = LEFTOFFSET; k <= RIGHTOFFSET; k++) {

					int xNew = (this.posX + i);
					int yNew = (this.posY + k);

					// checks if the cell is a valid one and alters it dependent
					// on
					// rules of the type of world
					xNew = world.alterXPosition(xNew);
					yNew = world.alterYPosition(yNew);

					// in case of EdgeWorld, invalid coordinates are returned as
					// -1
					if (!(xNew == -1 || yNew == -1)) {

						// fetches the creature at position for testing
						Creature testCellContents = world.getCellContents(xNew, yNew);

						if (testCellContents == null) {

							if (this.fillEmptyCell()) {
								Creature child = this.produceChild(xNew, yNew);
								child.start();

							}
						}

						// if test has creature in it check if child is
						// successfully
						// placed
						if (testCellContents != null) {
							// runs probablity check to see if murder of
							// other creature is successful
							if (this.murderSuccessful(testCellContents)) {
								Creature child = this.produceChild(xNew, yNew);
								// if murder is successful, interrupt the
								// other creature and stop it reproducing
								testCellContents.interrupt();
								child.start();
							}
						}
					}
				}
			}
		}
	}

	/**
	 * Method that determines if a child appears in and empty cell or not
	 * 
	 * @return boolean if attempt to fill empty cell was successful
	 */
	private boolean fillEmptyCell() {
		boolean success = false;
		// checks random number against the fitness of the species
		if (Math.random() <= this.getFitness()) {
			success = true;
			return success;
		}

		return false;

	}

	/**
	 * Method that determines if an occupied Square is overwritten
	 * 
	 * @return boolean true if successful
	 */
	private boolean murderSuccessful(Creature enemy) {
		// generates random number to use as a test, gets the fitness of the
		// creature
		// gets the fitness of the creature in the cell
		if (Math.random() <= (this.getFitness() - enemy.getFitness())) {

			return true;
		}
		return false;
	}

	/**
	 * @return the string that will be printed when the 2D array is displayed
	 */
	public abstract String toString();

	/**Method to return the fitness of a specific creature
	 * 
	 * @return double fitness value of a creature
	 */
	abstract public double getFitness();

	/**
	 * Creates a concrete instance of the species
	 * 
	 * @param x
	 *            position of the world 2D array
	 * @param y
	 *            position on the world 2D array
	 * @return Creature object
	 * 
	 */
	abstract public Creature produceChild(int x, int y);

	/**Getter for lifespan instance variable
	 * 
	 * @return value of a creatures lifespan
	 */
	abstract public int getLifespan(); 

	/**
	 * The run method thread sleeps for it's life span and then reproduces
	 * unless interrupt is thrown
	 */
	public void run() {

		if (!Thread.interrupted()) {
			try {
				Creature.sleep(this.getLifespan());
				this.reproduce();

			} catch (InterruptedException e) {

				// e.printStackTrace();
			}

		}

	}

}
