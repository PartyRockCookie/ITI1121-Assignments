import javax.swing.JOptionPane;

/**
 * The class <b>Queens</b> implements the top-level of the genetic algorithm. It
 * has a main method that reads parameters from the command line or using input
 * dialogs. Here is a sample run.
 * 
 * <pre>
 * > java Queens 500 100 8
 * Generations=65, Individual: {fitness=0, attributes=[5,3,0,4,7,1,6,2]}
 * </pre>
 * 
 * Because of the ``probabilistic'' nature of the algorithm, each run is likely
 * to produce a new solution.
 *
 * @author Marcel Turcotte (turcotte@eecs.uottawa.ca)
 */

public class Queens {
    
    /** 
     * Implements the top-level loop of the genetic algorithm. You must
     * complete the implementation of the method.
     * <ol>
     * <li>Create a new population</li>
     * <li>Whilst the maximum allowed number of generations has not been reached and no optimal solution has been found  
     * <ol>
     *  <li>Call the method evolve of the population</li>
     * </ol>
     * <li>Display the number of generations and the best individual</li>
     * </ol>
     * 
     * @param generations the number of generations to simulate
     * @param size the number of individuals in the population
     * @param dimension the dimension of the chess board (also the number of queens)
     */

    public static void simulate(int generations, int size, int dimension) {
    	int counter = 0;
    	boolean flag = true;
    	Population p1 = new Population(size,dimension);

    	while(generations != counter && flag) {
    		p1.evolve();
    		Individual i1;
    		i1 = new Individual(dimension);
    		i1 = p1.getFittest();
    		if(i1.getFitness() == 0)
    		{
    			flag = false;
    			System.out.println("Generations="+counter+", Individual: {fitness="+i1.getFitness()+", attributes="+i1.toString());
    		}
    		counter++;
            System.out.println(counter);
    	}
    	if(counter == generations)
    	{
    		System.out.println("No solution found. Here is all of the population:");
        	System.out.println("Generations="+counter+", "+p1.toString());
    	}

	
    }

    /**
     * The main method of this program. Examples of the execution of the program
     * from the command line:
     * 
     * <pre>
     * > java Queens 500 100 8
     * Generations=65, Individual: {fitness=0, attributes=[5,3,0,4,7,1,6,2]}
     * </pre>
     * 
     * @param args the array of arguments that were passed to the main method, generally on the command line
     */

     public static void main(String[] args) {

	int generations, size, dimension;
	
	StudentInfo.display();

	if (args.length == 3) {
	    generations = Integer.parseInt(args[0]);
	    size = Integer.parseInt(args[1]);
	    dimension = Integer.parseInt(args[2]);
	} else {
	    generations = Integer.parseInt(JOptionPane.showInputDialog("Input the number of generations", "500"));
	    size = Integer.parseInt(JOptionPane.showInputDialog("Input the size of the population", "100"));
	    dimension = Integer.parseInt(JOptionPane.showInputDialog("Input the dimension of the board", "8"));
	}

	simulate(generations, size, dimension);
	//Meant for testing purposes.
	/*System.out.println(Math.random());
	p1.evolve();*/
    }

}
