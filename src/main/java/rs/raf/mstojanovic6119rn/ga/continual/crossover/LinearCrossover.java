package rs.raf.mstojanovic6119rn.ga.continual.crossover;

import rs.raf.mstojanovic6119rn.ga.continual.ContinualChromosome;

import java.util.Random;

public class LinearCrossover implements ContinualChromosome.ContinualCrossover {

    private final double beta = new Random().nextDouble();

    private final boolean pass(double gene) {
        return gene >= 0 && gene <= 1;
    }

    @Override public ContinualChromosome[] cross(ContinualChromosome chromosome1, ContinualChromosome chromosome2) {
        int length = chromosome1.getGenes().length;
        if (chromosome2.getGenes().length != length)
            return null;
        Double[] genes3 = new Double[length];
        Double[] genes4 = new Double[length];
        Double[] genes5 = new Double[length];
        boolean[] passed = new boolean[] {true, true, true};
        for (int i = 0; i < length; ++i) {
            if (passed[0]) {
                genes3[i] = beta * chromosome1.getGenes()[i] + (1 - beta) * chromosome2.getGenes()[i];
                if (!this.pass(genes3[i]))
                    passed[0] = false;
            }
            if (passed[1]) {
                genes4[i] = (1 + beta) * chromosome1.getGenes()[i] - beta * chromosome2.getGenes()[i];
                if (!this.pass(genes4[i]))
                    passed[1] = false;
            }
            if (passed[2]) {
                genes5[i] = -beta * chromosome1.getGenes()[i] + (1 + beta) * chromosome2.getGenes()[i];
                if (!this.pass(genes5[i]))
                    passed[2] = false;
            }
        }
        if (passed[0] && passed[1] && passed[2])
            return new ContinualChromosome[] {new ContinualChromosome(genes3), new ContinualChromosome(genes4),
                    new ContinualChromosome(genes5)};
        if (passed[0] && passed[1])
            return new ContinualChromosome[] {new ContinualChromosome(genes3), new ContinualChromosome(genes4)};
        if (passed[0] && passed[2])
            return new ContinualChromosome[] {new ContinualChromosome(genes3), new ContinualChromosome(genes5)};
        if (passed[1] && passed[2])
            return new ContinualChromosome[] {new ContinualChromosome(genes4), new ContinualChromosome(genes5)};
        if (passed[0])
            return new ContinualChromosome[] {new ContinualChromosome(genes3)};
        if (passed[1])
            return new ContinualChromosome[] {new ContinualChromosome(genes4)};
        if (passed[2])
            return new ContinualChromosome[] {new ContinualChromosome(genes5)};
        return new ContinualChromosome[0];
    }
}
