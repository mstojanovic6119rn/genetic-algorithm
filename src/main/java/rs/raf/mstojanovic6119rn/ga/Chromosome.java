package rs.raf.mstojanovic6119rn.ga;

/**
 * Class which represents a chromosome. A superclass for binary and continual chromosome classes.
 *
 * @param <G> type of genes in a
 */
public abstract class Chromosome<G> {

    /**
     * Size of a chromosome
     */
    private final int length;

    /**
     * Array of genes of a chromosome
     */
    private final G[] genes;

    /**
     * Constructor which takes an array of genes. The field length is calculated as a length of an array of genes.
     *
     * @param genes array of genes
     */
    public Chromosome(G... genes) {
        this.genes = genes;
        this.length = this.genes.length;
    }

    public G[] getGenes() {
        return genes;
    }
}
