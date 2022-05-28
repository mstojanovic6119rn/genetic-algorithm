package rs.raf.mstojanovic6119rn.ga.continual.crossover;

import rs.raf.mstojanovic6119rn.ga.continual.ContinualChromosome;

import java.util.Random;

public class SimpleMixingCrossover implements ContinualChromosome.ContinualCrossover {

    private final double beta = new Random().nextDouble();

    @Override public ContinualChromosome[] cross(ContinualChromosome chromosome1, ContinualChromosome chromosome2) {
        int length = chromosome1.getGenes().length;
        if (chromosome2.getGenes().length != length)
            return null;
        Double[] genes3 = new Double[length];
        Double[] genes4 = new Double[length];
        for (int i = 0; i < length; ++i) {
            genes3[i] = beta * chromosome1.getGenes()[i] + (1 - beta) * chromosome2.getGenes()[i];
            genes4[i] = beta * chromosome2.getGenes()[i] + (1 - beta) * chromosome1.getGenes()[i];
        }
        return new ContinualChromosome[] {new ContinualChromosome(genes3), new ContinualChromosome(genes4)};
    }
}
