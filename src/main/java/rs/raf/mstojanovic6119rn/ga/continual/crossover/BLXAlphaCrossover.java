package rs.raf.mstojanovic6119rn.ga.continual.crossover;

import rs.raf.mstojanovic6119rn.ga.continual.ContinualChromosome;

import java.util.Random;

public class BLXAlphaCrossover implements ContinualChromosome.ContinualCrossover {

    private final Random rand = new Random();

    @Override public ContinualChromosome[] cross(ContinualChromosome chromosome1, ContinualChromosome chromosome2) {
        int length = chromosome1.getGenes().length;
        if (chromosome2.getGenes().length != length)
            return null;
        Double[] genes = new Double[length];
        Double alpha = this.rand.nextDouble();
        for (int i = 0; i < length; ++i) {
            /*Double d = Math.abs(chromosome1.getGenes()[i] - chromosome2.getGenes()[i]);
            Double min = Math.min(chromosome1.getGenes()[i], chromosome2.getGenes()[i]) - alpha * d;
            Double max = Math.max(chromosome1.getGenes()[i], chromosome2.getGenes()[i]) + alpha * d;
            Double scale = 100 / min;
            int minScaled = (int) (min * scale);
            int maxScaled = (int) (max * scale);
            int geneScaled = this.rand.nextInt(maxScaled - minScaled) + minScaled;
            genes[i] = geneScaled / scale;*/
            Double gene1 = chromosome1.getGenes()[i];
            Double gene2 = chromosome2.getGenes()[i];
            Double d = Math.abs(chromosome1.getGenes()[i] - chromosome2.getGenes()[i]);
            Double r = this.rand.nextDouble();
            genes[i] = r * (1 + 2 * alpha) * d - (Math.min(gene1, gene2) - alpha * d);
        }
        return new ContinualChromosome[] {new ContinualChromosome(genes)};
    }
}
