import java.util.Random;

/**
 * Method that makes a concrete instance of the Creature superclass for Species
 * A
 * 
 * @author 0207805s David Stuart
 *
 */
public class SpeciesB extends Creature {

	// instance variables
	private final double speciesFitness = 0.4;
	private final int MAXLIFE = 5000;
	private final int lifespan;
	private final String printRep = "2";

	public SpeciesB(int x, int y, World grid) {
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

		Creature SpeciesB = new SpeciesB(x, y, world);
		return SpeciesB;

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
