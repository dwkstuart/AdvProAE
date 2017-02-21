import java.util.Random;
/**Method that makes a concrete instance of the Creature superclass for 
 * Species A
 * 
 * @author 0207805s David Stuart
 *
 */
public class SpeciesB extends Creature {
	//isntance variables
	
	SpeciesB speciesType;
	//protected final double speciesFitness = 0.4;
	//protected final int MAXLIFE = 5000;
	//protected  int actualLifespan;
	//protected final int lifespan;

	public SpeciesB(int x, int y, World grid) {
		super(x, y, grid);
		MAXLIFE = 5000;
		//random number generator to get actual life span
		Random rand = new Random();
		lifespan = rand.nextInt(MAXLIFE);
		speciesFitness = 0.4;
		
	}

	/**@return the string that will be printed
	 * when the 2D array is displayed 
	 */
	public String toString() {

		return "2";
	}

	/**Creates a concrete instance of the species
	 * @param x position of the world 2D array
	 * @param y position on the world 2D array
	 * @return SpeciesB creature
	 */
	public Creature produceChild(int x, int y) {

		Creature SpeciesB = new SpeciesB(x, y, world);
		world.setSpecBbirths();
		return SpeciesB;

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
