package rs.raf.mstojanovic6119rn.ga;

public interface Crossover<G> {
    <C extends Chromosome<G>> C[] cross(C chromosome1, C chromosome2);
}
