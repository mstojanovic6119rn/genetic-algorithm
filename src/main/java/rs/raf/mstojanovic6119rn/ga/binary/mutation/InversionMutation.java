package rs.raf.mstojanovic6119rn.ga.binary.mutation;

import rs.raf.mstojanovic6119rn.ga.binary.BinaryChromosome;

import java.util.Random;

public class InversionMutation implements BinaryChromosome.BinaryMutation {

    private final Random rand = new Random();

    private Boolean[] copyGenes(Boolean[] oldGenes) {
        Boolean[] newGenes = new Boolean[oldGenes.length];
        for (int i = 0; i < newGenes.length; ++i)
            newGenes[i] = oldGenes[i];
        return newGenes;
    }

    private int[] generateTwoPointsOfInversion(int limit) {
        int lowPoint = this.rand.nextInt(limit), highPoint = this.rand.nextInt(limit);
        while (lowPoint == highPoint)
            highPoint = this.rand.nextInt(limit);
        if (lowPoint > highPoint) {
            int p = lowPoint;
            lowPoint = highPoint;
            highPoint = p;
        }
        return new int[] {lowPoint, highPoint};
    }

    @Override public BinaryChromosome mutate(BinaryChromosome chromosome) {
        int length = chromosome.getGenes().length;
        Boolean[] genes = this.copyGenes(chromosome.getGenes());
        int[] pointsOfInversion = this.generateTwoPointsOfInversion(length);
        for (int i = pointsOfInversion[0], j = pointsOfInversion[1]; i < j; ++i, --j) {
            Boolean p = genes[i];
            genes[i] = genes[j];
            genes[j] = p;
        }
        return new BinaryChromosome(genes);
    }
}
