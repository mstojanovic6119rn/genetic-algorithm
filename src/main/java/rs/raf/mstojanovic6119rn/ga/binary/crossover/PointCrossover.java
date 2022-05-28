package rs.raf.mstojanovic6119rn.ga.binary.crossover;

import rs.raf.mstojanovic6119rn.ga.binary.BinaryChromosome;

import java.util.Random;

public class PointCrossover implements BinaryChromosome.BinaryCrossover {

    private final Random rand = new Random();

    private final int numberOfPoints;

    public PointCrossover(int numberOfPoints) {
        this.numberOfPoints = numberOfPoints;
    }

    private int[] generatePoints(int limit) {
        if (limit < this.numberOfPoints)
            return null;
        int[] points = new int[this.numberOfPoints];
        for (int i = 0; i < this.numberOfPoints; ++i) {
            int newPoint = this.rand.nextInt(limit);
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
        return points;
    }

    @Override public BinaryChromosome[] cross(BinaryChromosome chromosome1, BinaryChromosome chromosome2) {
        int length = chromosome1.getGenes().length;
        if (chromosome2.getGenes().length != length)
            return null;
        int[] points = this.generatePoints(length);
        if (points == null)
            return null;
        Boolean[] genes3 = new Boolean[length];
        Boolean[] genes4 = new Boolean[length];
        boolean exchange = false;
        for (int i = 0; i < length; ++i) {
            if (exchange) {
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
