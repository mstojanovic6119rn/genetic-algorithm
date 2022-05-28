package rs.raf.mstojanovic6119rn.ga.continual.crossover;

import rs.raf.mstojanovic6119rn.ga.continual.ContinualChromosome;

import java.util.Random;

public class HeuristicalCrossover implements ContinualChromosome.ContinualCrossover {

    private final Random rand = new Random();

    @Override public ContinualChromosome[] cross(ContinualChromosome chromosome1, ContinualChromosome chromosome2) {
        int length = chromosome1.getGenes().length;
        if (chromosome2.getGenes().length != length)
            return null;
        ContinualChromosome better = chromosome1;
        ContinualChromosome worse = chromosome2;
        if (better.fitness() < worse.fitness()) {
            ContinualChromosome p = better;
            better = worse;
            worse = p;
        }
        Double[] genes = new Double[length];
        double r = this.rand.nextDouble();
        for (int i = 0; i < length; ++i)
            genes[i] = r * (better.getGenes()[i] - worse.getGenes()[i]) + better.getGenes()[i];
        return new ContinualChromosome[] {new ContinualChromosome(genes)};
    }
}
