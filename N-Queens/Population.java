import java.util.Arrays;
import java.util.Random;

/**
 * A <code>Population</code> is a collection of individuals (each one
 * representing a candidate solution for the n-queens problem). To facilitate
 * the implementation of the various methods, <b>the individuals will always be
 * kept in increasing value of fitness</b>.
 */

public class Population {

	private int size;
	private int dimension;
	private Individual[] population;
	private static final double MUTATION_RATE = 0.8;

    /**
     * A constructor of arity 2 to initialize the <b>Population</b>.
     * 
     * @param size is the number of individuals of this population
     * @param dimension is the size of the board and also the number of queens
     */
	
	public Population(int size, int dimension) {
		this.size = size;
		this.dimension = dimension;
		population = new Individual[size];

		for (int i = 0; i < population.length; i++) {
			Individual ind1 = new Individual(dimension);
			population[i] = ind1;
		}
		sort(population);

	}

    /**
     * The method <code>evolve</code> selects parent individuals. An offspring
     * is then created from the two parents, using the method
     * <code>crossover</code>. With probability <code>MUTATION_RATE</code>, the
     * offspring is <code>mutated</code>. Use 0.8 as the default
     * <code>MUTATION_RATE</code> The resulting child is inserted into the
     * population. As a result, the least fitted individual will be eliminated
     * from the population. Remember that the <code>population</code> is kept in
     * increasing order of fitness. For the selection of the parents, you can
     * experiment with different scenarios. A possible scenario is to randomly
     * select two parents. Another possible one would be to select the most fit,
     * and a randomly selected one. Or else, select the two most fitted
     * individuals.
     */

	
	public void evolve() {
		
		Random random = new Random();
		int randomInt = (int) (random.nextDouble() * (population.length - 1));
		int randomInt2 = (int) (random.nextDouble() * (population.length - 1));
		
		Individual temp = new Individual(size);
		temp = population[0].recombine(population[randomInt2]);

		double value = Math.random();
		if (value <= MUTATION_RATE) 
		{
			temp.mutate();
			population[population.length - 1] = temp;
		} 
		else {
			population[population.length - 1] = temp;
		}
		sort(population);


	}

    /**
     * The instance method <code>public Individual getFittest()</code> returns the
     * "best" individual of the population, i.e. the one that has the smallest
     * fitness value.
     * 
     * @return returns the currently best solution
     */
	
	public Individual getFittest() {
		return population[0];
	}

    /**
     * Returns a <code>String</code> representation of this <code>Population</code>.
     * 
     * @return the String representation of this Population
     */
	
	 public String toString() {
		 String str = "";
		 for(int i = 0;i<population.length;i++)
		 {
			str += "Individual: {fitness="+population[i].getFitness()+", attributes="+population[i]+"}, ";
		 }
		 return str;
	 }
	 
	/**
	 * Sorts the Individual array starting with the best fitness,
	 * all the way to the worst fitness. 
	 * Using Insertion sort method.
	 * @param input
	 * @return input - a reference of Individual object.
	 */
	private Individual[] sort(Individual[] input) {

		Individual temp;
		for (int i = 1; i < input.length; i++) {
			for (int j = i; j > 0; j--) {
				if (input[j].getFitness() < input[j - 1].getFitness()) {
					temp = input[j];
					input[j] = input[j - 1];
					input[j - 1] = temp;
				}
			}
		}
		return input;
	}

}
