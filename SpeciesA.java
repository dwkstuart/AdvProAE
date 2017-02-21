import java.util.Random;

/**
 * Method that makes a concrete instance of the Creature superclass
 * for Species A 
 * @author 0207805s David Stuart
 *
 */

public class SpeciesA extends Creature {
	//instance variables
	
	private SpeciesA speciesType;


	/**Constructor
	 * @param x position on the world grid
	 * @param y position on the world grid
	 * @param grid
	 */
	public SpeciesA(int x, int y, World grid) {
		super(x, y, grid);			
		//random number generator to get actual life span
		Random rand = new Random();
		
		speciesFitness = 0.8;
		MAXLIFE = 10000;
		lifespan = rand.nextInt(MAXLIFE);
		//this.setLifespan(actualLifespan);
	
	}

	/**@return the string that will be printed
	 * when the 2D array is displayed 
	 */
	public String toString() {

		return "1";
	}

	/**Creates a concrete instance of the species
	 * @param x position of the world 2D array
	 * @param y position on the world 2D array
	 * @return SpeciesA creature
	 */
	public Creature produceChild(int x, int y) {
		Creature SpeciesA = new SpeciesA(x, y, world);
		world.setSpecAbirths();
		return SpeciesA;

	}

	@Override
	public double getFitness() {
		
		return speciesFitness;
	}

//	@Override
//	public int getActualLifespan() {
//
//		return actualLifespan;
//	}

}