package rs.raf.mstojanovic6119rn.ga;

public interface Mutation<G> {
    <C extends Chromosome<G>> C mutate(C chromosome);
}
