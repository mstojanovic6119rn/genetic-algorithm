package rs.raf.mstojanovic6119rn.ga;

/**
 * A crossover technique to be used in a genetic algorithm.
 *
 * @param <G> type of genes in a chromosomes which cross using this technique
 *
 * @see Chromosome
 */
public interface Crossover<G> {
    /**
     * Cross the chromosomes.
     *
     * @param chromosome1 first chromosome to cross
     * @param chromosome2 second chromosome to cross
     * @return array of new chromosomes that were created using the crossover technique
     *
     * @param <C> type of chromosomes used in a crossover
     */
    <C extends Chromosome<G>> C[] cross(C chromosome1, C chromosome2);
}
