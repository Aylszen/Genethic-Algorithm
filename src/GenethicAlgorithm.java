import java.util.ArrayList;
import java.util.List;

public class GenethicAlgorithm {

	public static void main(String[] args) {
		List<Chromosome> chromosomeList = new ArrayList<Chromosome>();
		Converter conv = new Converter();

		final byte POPULATION_SIZE = 10;
		final byte MAX_CHROMOSOME_VALUE = 127;
		final byte PROBABILITY_OF_CROSSING = 75;
		final byte PROBABILITY_OF_MUTATION = 100;

		Population population = new Population();
		chromosomeList = population.chooseFirstPopulation(POPULATION_SIZE, MAX_CHROMOSOME_VALUE);
		for (int i = 0; i < 3; i++) {
			population.assessmentOfAdaptation(POPULATION_SIZE, chromosomeList);
			population.setProbabilityOfSelectionForEachChromosome(POPULATION_SIZE, chromosomeList);
			chromosomeList = population.selectNextGeneration(POPULATION_SIZE, chromosomeList, MAX_CHROMOSOME_VALUE);
			population.crossChromosomes(POPULATION_SIZE, PROBABILITY_OF_CROSSING, chromosomeList);
			population.mutateChromosomes(POPULATION_SIZE, PROBABILITY_OF_MUTATION, chromosomeList);
		}
		chromosomeList.get(9).setGenotype(conv.decimalToBinary(1));
		for (int i = 0; i < 10; i++) {
			System.out.println(conv.binaryToDecimal(chromosomeList.get(i).getGenotype()));

		}
	}

}