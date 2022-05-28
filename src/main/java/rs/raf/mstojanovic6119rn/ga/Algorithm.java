package rs.raf.mstojanovic6119rn.ga;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

public class Algorithm<G> {

    private final int population;

    private List<Chromosome<G>> chromosomes;

    private Crossover<G> crossover;

    private Mutation<G> mutation;

    public Algorithm(Crossover<G> crossover, Mutation<G> mutation, Chromosome<G>... chromosomes) {
        this.crossover = crossover;
        this.mutation = mutation;
        this.chromosomes = Arrays.asList(chromosomes);
        this.population = chromosomes.length;
    }

    public Chromosome<G> run(Function<G[], Double> fitness, double limit, int iterations,
                             int toCross, int toMutate) {
        while (true) {
            this.chromosomes.sort(Comparator.comparing(a -> fitness.apply(a.getGenes())));
            this.chromosomes = this.chromosomes.subList(0, this.population);
            if (fitness.apply(this.chromosomes.get(0).getGenes()) >= limit)
                return this.chromosomes.get(0);
            if (iterations-- <= 0)
                return this.chromosomes.get(0);
            List<Chromosome<G>> newChromosomes = new LinkedList<>();
            for (int i = 0; i < toCross; i += 2) {
                if (i >= this.chromosomes.size() - 1)
                    break;
                newChromosomes.addAll(Arrays.asList(this.crossover.cross(
                        this.chromosomes.get(i), this.chromosomes.get(i + 1))));
            }
            this.chromosomes.addAll(newChromosomes);
            this.chromosomes.sort(Comparator.comparing(a -> -fitness.apply(a.getGenes())));
            newChromosomes = new LinkedList<>();
            for (int i = 0; i < toMutate; ++i)
                newChromosomes.add(this.mutation.mutate(this.chromosomes.get(i)));
        }
    }

}
