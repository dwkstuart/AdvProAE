

import java.util.Random;

public class SpeciesE extends Creature {
	protected SpeciesE speciesType;
	protected final double speciesFitness = 0.35;
	protected final int maxLife = 1500;
	protected  int actualLifespan;

	public SpeciesE(int x, int y, World grid) {
		super(x, y, grid);
	
	}

	public String toString() {

		return "5";
	}

	public Creature produceChild(int x, int y) {
		Creature a = new SpeciesE(x, y, world);
		return a;

	}

	@Override
	public double getFitness() {
		
		return speciesFitness;
	}

	@Override
	public int getLifespan() {
		//random number generator to get actual life span
		Random rand = new Random();
		actualLifespan = rand.nextInt(maxLife);
		return actualLifespan;
	}
}