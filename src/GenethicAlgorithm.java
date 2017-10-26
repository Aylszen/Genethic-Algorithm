import java.util.ArrayList;
import java.util.List;

public class GenethicAlgorithm {

	public static void main(String[] args) {
		List<Chromosome> chromosomeList = new ArrayList<Chromosome>();
		List<Chromosome> nextGenChromosomeList = new ArrayList<Chromosome>();
		final byte POPULATION_SIZE = 10;
		final byte MAX_CHROMOSOME_VALUE = 127;

		Population population = new Population();
		population.chooseFirstPopulation(POPULATION_SIZE, MAX_CHROMOSOME_VALUE, chromosomeList);
//#############################
		for (int i = 0; i < 20; i++) {
		population.assessmentOfAdaptation(POPULATION_SIZE, chromosomeList);
		population.setProbabilityOfSelectionForEachChromosome(POPULATION_SIZE, chromosomeList);
		nextGenChromosomeList = population.selectNextGeneration(POPULATION_SIZE, chromosomeList);

		for (int j = 0; j < POPULATION_SIZE; j++) {
			System.out.print(
					chromosomeList.get(j).getPhenotype() + " | " + nextGenChromosomeList.get(j).getPhenotype() + "\n");
			// System.out.print(firstPopulation.chromosomeList.get(i).getAdaptationLevel()
			// + "\n");
			// System.out.print(firstPopulation.chromosomeList.get(i).getProbabilityOfSelection()
			// + "\n");
		}
		chromosomeList = nextGenChromosomeList;
		if(chromosomeList == nextGenChromosomeList)
		{
			System.out.print("DUPA");
		}
		population.crossChromosomes(POPULATION_SIZE, chromosomeList);
//#############################
		}
	}

}
