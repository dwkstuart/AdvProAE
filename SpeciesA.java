import java.util.Random;

/**
 * Method that makes a concrete instance of the Creature superclass for Species
 * A
 * 
 * @author 0207805s David Stuart
 *
 */
public class SpeciesA extends Creature {
	// instance variables

	private final double speciesFitness = 0.8;
	private final int MAXLIFE = 10000;
	private final int lifespan;
	private final String printRep = "1";

	/**
	 * Constructor
	 * 
	 * @param x
	 *            position on the world grid
	 * @param y
	 *            position on the world grid
	 * @param grid
	 */
	public SpeciesA(int x, int y, World grid) {
		super(x, y, grid);
		// random number generator to get actual life span
		Random rand = new Random();
		lifespan = rand.nextInt(MAXLIFE);

	}


	@Override
	public String toString() {
		
		return printRep;
	}

	@Override
	public Creature produceChild(int x, int y) {
		Creature SpeciesA = new SpeciesA(x, y, world);
		return SpeciesA;

	}

	@Override
	public double getFitness() {

		return speciesFitness;
	}

	@Override
	public int getLifespan() {
		return lifespan;

	}

}