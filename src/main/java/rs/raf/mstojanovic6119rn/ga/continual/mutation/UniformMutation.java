package rs.raf.mstojanovic6119rn.ga.continual.mutation;

import rs.raf.mstojanovic6119rn.ga.continual.ContinualChromosome;

import java.util.Arrays;
import java.util.Random;

public class UniformMutation implements ContinualChromosome.ContinualMutation {

    private final Random rand = new Random();

    @Override public ContinualChromosome mutate(ContinualChromosome chromosome) {
        Double[] genes = Arrays.copyOf(chromosome.getGenes(), chromosome.getGenes().length);
        int geneIndexToChange = this.rand.nextInt(chromosome.getGenes().length);
        genes[geneIndexToChange] = this.rand.nextDouble();
        return new ContinualChromosome(genes);
    }
}
