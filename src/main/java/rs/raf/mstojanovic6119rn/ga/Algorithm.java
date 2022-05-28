package rs.raf.mstojanovic6119rn.ga;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

/**
 * The class which is used to run a genetic algorithm.
 *
 * @param <G> type of an element of a chromosome used in this algorithm.
 *
 */
public class Algorithm<G> {

    /**
     * Size of a population.
     */
    private final int population;

    /**
     * Chromosomes in a population.
     *
     * @see Chromosome
     */
    private List<Chromosome<G>> chromosomes;

    /**
     * A crossover technique used for this algorithm.
     *
     * @see Crossover
     */
    private Crossover<G> crossover;

    /**
     * A mutation technique used for this algorithm.
     *
     * @see Mutation
     */
    private Mutation<G> mutation;

    /**
     * Constructor for the algorithm. Has to take all of the fields except for field population, because the size
     * can be calculated as the length of the array of chromosomes.
     */
    public Algorithm(Crossover<G> crossover, Mutation<G> mutation, Chromosome<G>... chromosomes) {
        this.crossover = crossover;
        this.mutation = mutation;
        this.chromosomes = Arrays.asList(chromosomes);
        this.population = chromosomes.length;
    }

    /**
     * Method to be used for running the algorithm on a population using crossover and mutation techniques which are
     * all defined as fields of this class.
     *
     * @param fitness a function for calculating the fitness of the chromosomes
     * @param limit a real number which indicates that the algorithm is finished when it's reached by a fitness
     *              of the best chromosome.
     * @param iterations maximum number of iterations of the algorithm; when it reaches 0, the algorithm is over,
     *                   regardless of success
     * @param toCross number of chromosomes to cross in every iteration of the algorithm
     * @param toMutate number of chromosomes to mutate in every iteration of the algorithm
     * @return the best chromosome after the last iteration
     *
     * @see Function
     * @see Chromosome
     * @see Comparator
     */
    public Chromosome<G> run(Function<G[], Double> fitness, double limit, int iterations,
                             int toCross, int toMutate) {
        for (Chromosome<G> c: this.chromosomes)
            c.setLastFitnessFunction(fitness);
        while (true) {
            this.chromosomes.sort(Comparator.comparing(a -> fitness.apply(a.getGenes())));
            this.chromosomes = this.chromosomes.subList(0, this.population);
            if (fitness.apply(this.chromosomes.get(0).getGenes()) >= limit)
                return this.chromosomes.get(0);
            if (iterations-- <= 0)
                return this.chromosomes.get(0);
            List<Chromosome<G>> newChromosomes = new LinkedList<>();
            for (int i = 0; i < toCross; i += 2) {
                if (i >= this.chromosomes.size() - 1)
                    break;
                newChromosomes.addAll(Arrays.asList(this.crossover.cross(
                        this.chromosomes.get(i), this.chromosomes.get(i + 1))));
            }
            this.chromosomes.addAll(newChromosomes);
            this.chromosomes.sort(Comparator.comparing(a -> -fitness.apply(a.getGenes())));
            newChromosomes = new LinkedList<>();
            for (int i = 0; i < toMutate; ++i)
                newChromosomes.add(this.mutation.mutate(this.chromosomes.get(i)));
        }
    }

}
