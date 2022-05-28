package rs.raf.mstojanovic6119rn.ga.continual;

import rs.raf.mstojanovic6119rn.ga.Chromosome;
import rs.raf.mstojanovic6119rn.ga.Crossover;
import rs.raf.mstojanovic6119rn.ga.Mutation;

public class ContinualChromosome extends Chromosome<Double> {

    public ContinualChromosome(Double... genes) {
        super(genes);
    }

    public interface ContinualCrossover extends Crossover<Double> {
        ContinualChromosome[] cross(ContinualChromosome chromosome1, ContinualChromosome chromosome2);
        @Override default <C extends Chromosome<Double>> C[] cross(C chromosome1, C chromosome2) {
            return this.cross(chromosome1, chromosome2);
        }
    }

    public interface ContinualMutation extends Mutation<Double> {
        ContinualChromosome mutate(ContinualChromosome chromosome);
        @Override default <C extends Chromosome<Double>> C mutate(C chromosome) {
            return this.mutate(chromosome);
        }
    }

}
