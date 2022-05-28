package rs.raf.mstojanovic6119rn.ga.binary.mutation;

import rs.raf.mstojanovic6119rn.ga.binary.BinaryChromosome;

import java.util.Random;

public class UniformBitChangeMutation implements BinaryChromosome.BinaryMutation {

    private final Random rand = new Random();

    @Override public BinaryChromosome mutate(BinaryChromosome chromosome) {
        int length = chromosome.getGenes().length;
        Boolean[] genes = new Boolean[length];
        for (int i = 0; i < length; ++i) {
            if (this.rand.nextBoolean())
                genes[i] = !chromosome.getGenes()[i];
            else
                genes[i] = chromosome.getGenes()[i];
        }
        return new BinaryChromosome(genes);
    }
}
