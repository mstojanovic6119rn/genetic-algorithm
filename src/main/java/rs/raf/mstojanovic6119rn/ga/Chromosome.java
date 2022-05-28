package rs.raf.mstojanovic6119rn.ga;

public abstract class Chromosome<G> {

    private final int length;

    private final G[] genes;

    public Chromosome(G... genes) {
        this.genes = genes;
        this.length = this.genes.length;
    }

    public G[] getGenes() {
        return genes;
    }
}
