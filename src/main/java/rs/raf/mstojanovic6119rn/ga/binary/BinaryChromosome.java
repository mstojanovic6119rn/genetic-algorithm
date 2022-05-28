package rs.raf.mstojanovic6119rn.ga.binary;

import rs.raf.mstojanovic6119rn.ga.Chromosome;
import rs.raf.mstojanovic6119rn.ga.Crossover;
import rs.raf.mstojanovic6119rn.ga.Mutation;

public class BinaryChromosome extends Chromosome<Boolean> {

    public BinaryChromosome(Boolean... genes) {
        super(genes);
    }

    public interface BinaryCrossover extends Crossover<Boolean> {
        BinaryChromosome[] cross(BinaryChromosome chromosome1, BinaryChromosome chromosome2);
        @Override default <C extends Chromosome<Boolean>> C[] cross(C chromosome1, C chromosome2) {
            return this.cross(chromosome1, chromosome2);
        }
    }

    public interface BinaryMutation extends Mutation<Boolean> {
        BinaryChromosome mutate(BinaryChromosome chromosome);
        @Override default <C extends Chromosome<Boolean>> C mutate(C chromosome) {
            return this.mutate(chromosome);
        }
    }

}
