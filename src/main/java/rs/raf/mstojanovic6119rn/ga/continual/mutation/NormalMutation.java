package rs.raf.mstojanovic6119rn.ga.continual.mutation;

import rs.raf.mstojanovic6119rn.ga.continual.ContinualChromosome;

import java.util.Random;

public class NormalMutation implements ContinualChromosome.ContinualMutation {

    private final Random rand = new Random();

    @Override public ContinualChromosome mutate(ContinualChromosome chromosome) {
        Double[] genes = new Double[chromosome.getGenes().length];
        for (int i = 0; i < genes.length; ++i) {
            Double gene = chromosome.getGenes()[i] + this.rand.nextGaussian();
            while (gene > 1)
                gene -= 1;
            genes[i] = gene;
        }
        return new ContinualChromosome(genes);
    }
}
