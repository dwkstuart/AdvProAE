

import java.util.Random;

public class SpeciesD extends Creature {
	protected SpeciesD speciesType;
	protected final double speciesFitness = 0.2;
	protected final int maxLife = 500;
	protected  int actualLifespan;

	public SpeciesD(int x, int y, World grid) {
		super(x, y, grid);
	
	}

	public String toString() {

		return "4";
	}

	public Creature produceChild(int x, int y) {
		Creature a = new SpeciesD(x, y, world);
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