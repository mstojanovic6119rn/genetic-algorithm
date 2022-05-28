package rs.raf.mstojanovic6119rn.ga.binary.mutation;

import rs.raf.mstojanovic6119rn.ga.binary.BinaryChromosome;

import java.util.Arrays;
import java.util.Random;

public class BitChangeMutation implements BinaryChromosome.BinaryMutation {

    private final Random rand = new Random();

    private int limit;

    public BitChangeMutation(int limit) {
        this.limit = limit;
    }

    private int[] generatePoints(int chromosomeLength) {
        int[] points = new int[this.limit];
        for (int i = 0; i < this.limit; ++i) {
            int newPoint = this.rand.nextInt(chromosomeLength);
            boolean exists = false;
            for (int j = 0; j < i; ++j) {
                if (points[j] == newPoint) {
                    --i;
                    exists = true;
                    break;
                }
            }
            if (!exists)
                points[i] = newPoint;
        }
        Arrays.sort(points);
        return points;
    }

    @Override public BinaryChromosome mutate(BinaryChromosome chromosome) {
        if (chromosome.getGenes().length > limit)
            return null;
        int length = chromosome.getGenes().length;
        Boolean[] genes = new Boolean[length];
        int[] points = this.generatePoints(length);
        int point = 0;
        for (int i = 0; i < length; ++i) {
            if (points[point] == i) {
                genes[i] = !chromosome.getGenes()[i];
                ++point;
            } else {
                genes[i] = chromosome.getGenes()[i];
            }
        }
        return new BinaryChromosome(genes);
    }
}
