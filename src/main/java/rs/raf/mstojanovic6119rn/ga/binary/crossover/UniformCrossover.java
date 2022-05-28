package rs.raf.mstojanovic6119rn.ga.binary.crossover;

import rs.raf.mstojanovic6119rn.ga.binary.BinaryChromosome;

import java.util.Random;

public class UniformCrossover implements BinaryChromosome.BinaryCrossover {

    private final Random rand = new Random();

    @Override public BinaryChromosome[] cross(BinaryChromosome chromosome1, BinaryChromosome chromosome2) {
        int length = chromosome1.getGenes().length;
        if (chromosome2.getGenes().length != length)
            return null;
        Boolean[] genes3 = new Boolean[length];
        Boolean[] genes4 = new Boolean[length];
        for (int i = 0; i < length; ++i) {
            if (this.rand.nextBoolean()) {
                genes4[i] = chromosome1.getGenes()[i];
                genes3[i] = chromosome2.getGenes()[i];
            } else {
                genes3[i] = chromosome1.getGenes()[i];
                genes4[i] = chromosome2.getGenes()[i];
            }
        }
        BinaryChromosome chromosome3 = new BinaryChromosome(genes3);
        BinaryChromosome chromosome4 = new BinaryChromosome(genes4);
        return new BinaryChromosome[] {chromosome3, chromosome4};
    }
}
