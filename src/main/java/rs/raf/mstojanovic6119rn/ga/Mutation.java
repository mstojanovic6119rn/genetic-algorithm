package rs.raf.mstojanovic6119rn.ga;

/**
 * A technique used for mutating of a chromosome.
 *
 * @param <G> type of genes in a chromosome which mutates
 *
 * @see Chromosome
 */
public interface Mutation<G> {
    /**
     * Mutate the chromosome.
     *
     * @param chromosome chromosome to mutate
     * @return chromosome created using this mutation technique
     *
     * @param <C> type of a chromosome that mutates
     */
    <C extends Chromosome<G>> C mutate(C chromosome);
}
