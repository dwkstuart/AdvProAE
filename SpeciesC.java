

import java.util.Random;

public class SpeciesC extends Creature {
	protected SpeciesC speciesType;
	protected final double speciesFitness = 0.9;
	protected final int maxLife = 15000;
	protected  int actualLifespan;

	public SpeciesC(int x, int y, World grid) {
		super(x, y, grid);
	
	}

	public String toString() {

		return "3";
	}

	public Creature produceChild(int x, int y) {
		Creature a = new SpeciesC(x, y, world);
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