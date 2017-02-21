/**Main class that runs the program 
 * @author 0207805s David Stuart
 *
 */
public class TestMain {

	public static void main(String[] args) {
		//create an instance of the Edgeworld
		// EdgeWorld test = new EdgeWorld(11,42);
		//create and instance of the TorusWorld
		TorusWorld test = new TorusWorld(30, 100);

		//print empty grid
		test.printGrid();

		
		//create and instance of each species
		SpeciesA a = new SpeciesA(6, 5, test);
		SpeciesB b = new SpeciesB(5, 23, test);
	
	
		a.start();
		b.start();
		//d.start();
	
		for (;;) {
			try {
			//0.5 second delay between printing grid	
				Thread.sleep(500);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

			test.printGrid();
			System.out.println("Number of SpeciesA births " + test.getSpecAbirths());
			System.out.println("Number of SpeciesB births " + test.getSpecBbirths());

		}

	}

}
