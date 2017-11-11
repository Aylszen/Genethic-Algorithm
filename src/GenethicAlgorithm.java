import java.util.ArrayList;
import java.util.List;

public class GenethicAlgorithm {

	public static void main(String[] args) {
		List<Chromosome> chromosomeList = new ArrayList<Chromosome>();
		Converter conv = new Converter();

		final byte POPULATION_SIZE = 10;
		final byte MAX_CHROMOSOME_VALUE = 127;
		final byte PROBABILITY_OF_CROSSING = 75;
		final byte PROBABILITY_OF_MUTATION = 2;

		Population population = new Population();
		chromosomeList = population.chooseFirstPopulation(POPULATION_SIZE, MAX_CHROMOSOME_VALUE);
		for (int i = 0; i < 2200; i++) {
			population.assessmentOfAdaptation(POPULATION_SIZE, chromosomeList);
			population.setProbabilityOfSelectionForEachChromosome(POPULATION_SIZE, chromosomeList);
			System.out.println("########PRZED_WYBOREM_NOWEJ_GEN###########################");
			for (int j = 0; j < 10; j++) {
				System.out.println(conv.binaryToDecimal(chromosomeList.get(j).getGenotype()));

			}
			chromosomeList = population.selectNextGeneration(POPULATION_SIZE, chromosomeList);
			population.crossChromosomes(POPULATION_SIZE, PROBABILITY_OF_CROSSING, chromosomeList);
			System.out.println("########PRZED_MUTACJA###########################");
			for (int j = 0; j < 10; j++) {
				System.out.println(conv.binaryToDecimal(chromosomeList.get(j).getGenotype()));

			}
			System.out.println("########PO_MUTACJI###########################");
			population.mutateChromosomes(POPULATION_SIZE, PROBABILITY_OF_MUTATION, chromosomeList);
			for (int j = 0; j < 10; j++) {
				System.out.println(conv.binaryToDecimal(chromosomeList.get(j).getGenotype()));

			}
		}
	}

}