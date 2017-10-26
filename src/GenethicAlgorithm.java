import java.util.ArrayList;
import java.util.List;

public class GenethicAlgorithm {

	public static void main(String[] args) {
		List<Chromosome> chromosomeList = new ArrayList<Chromosome>();
		List<Chromosome> nextGenChromosomeList = new ArrayList<Chromosome>();
		final byte POPULATION_SIZE = 10;
		final byte MAX_CHROMOSOME_VALUE = 127;
		final byte PROBABILITY_OF_CROSSING = 75;
		final byte PROBABILITY_OF_MUTATION = 2;

		Population population = new Population();
		population.chooseFirstPopulation(POPULATION_SIZE, MAX_CHROMOSOME_VALUE, chromosomeList);
		// #############################
		for (int i = 0; i < 2; i++) {
			population.assessmentOfAdaptation(POPULATION_SIZE, chromosomeList);
			population.setProbabilityOfSelectionForEachChromosome(POPULATION_SIZE, chromosomeList);
			nextGenChromosomeList = population.selectNextGeneration(POPULATION_SIZE, chromosomeList);
			for (int j = 0; j < POPULATION_SIZE; j++) {
				System.out.print(chromosomeList.get(j).getPhenotype() + " | "
						+ nextGenChromosomeList.get(j).getPhenotype() + "\n");
				}
			System.out.print("-----------------\n");
			chromosomeList = nextGenChromosomeList;
			
			
			population.crossChromosomes(POPULATION_SIZE, PROBABILITY_OF_CROSSING, chromosomeList);
			population.mutateChromosomes(POPULATION_SIZE, PROBABILITY_OF_MUTATION, chromosomeList);
			// #############################
		}
	}

}
