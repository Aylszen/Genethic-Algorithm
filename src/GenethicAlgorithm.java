import java.util.ArrayList;
import java.util.List;

public class GenethicAlgorithm {

	public static void main(String[] args) {
		List<Chromosome> chromosomeList = new ArrayList<Chromosome>();
		List<Chromosome> nextGenChromosomeList = new ArrayList<Chromosome>();
		final byte POPULATION_SIZE = 10;
		final byte MAX_CHROMOSOME_VALUE = 127;
		
		Population firstPopulation = new Population();
		firstPopulation.chooseFirstPopulation(POPULATION_SIZE,MAX_CHROMOSOME_VALUE,chromosomeList);
		
		firstPopulation.assessmentOfAdaptation(POPULATION_SIZE,chromosomeList);
		firstPopulation.setProbabilityOfSelectionForEachChromosome(POPULATION_SIZE,chromosomeList);
		nextGenChromosomeList = firstPopulation.selectNextGeneration(POPULATION_SIZE,chromosomeList);

		
		for (int i = 0; i < 10; i++) {
			System.out.print(chromosomeList.get(i).getPhenotype() + " | " +nextGenChromosomeList.get(i).getPhenotype()+"\n");
			//System.out.print(firstPopulation.chromosomeList.get(i).getAdaptationLevel() + "\n");
			//System.out.print(firstPopulation.chromosomeList.get(i).getProbabilityOfSelection() + "\n");
		}

	}

}
