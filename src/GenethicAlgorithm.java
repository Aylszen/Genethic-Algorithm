import java.util.ArrayList;
import java.util.List;

public class GenethicAlgorithm {

	public static void main(String[] args) {
		List<Chromosome> chromosomeList = new ArrayList<Chromosome>();
		final byte POPULATION_SIZE = 10;
		final byte MAX_CHROMOSOME_VALUE = 127;
		final byte PROBABILITY_OF_CROSSING = 75;
		final byte PROBABILITY_OF_MUTATION = 2;
		final int ALL_CHROMOSOMES_WITH_MAX_VALUE = 322600;

		Population population = new Population();
		chromosomeList = population.chooseFirstPopulation(POPULATION_SIZE, MAX_CHROMOSOME_VALUE);
		for (int i = 0; i < 20000; i++) {
			population.assessmentOfAdaptation(POPULATION_SIZE, chromosomeList);
			population.setProbabilityOfSelectionForEachChromosome(POPULATION_SIZE, chromosomeList);
			population.checkAdapatationLevelOfWholePopulation(i, ALL_CHROMOSOMES_WITH_MAX_VALUE);
			chromosomeList = population.selectNextGeneration(POPULATION_SIZE, chromosomeList);
			population.crossChromosomes(POPULATION_SIZE, PROBABILITY_OF_CROSSING, chromosomeList);
			population.mutateChromosomes(POPULATION_SIZE, PROBABILITY_OF_MUTATION, chromosomeList);
		}
	}

}