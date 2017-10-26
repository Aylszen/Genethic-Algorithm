import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class Population {

	public void chooseFirstPopulation(final byte POPULATION_SIZE, final byte MAX_CHROMOSOME_VALUE,
			List<Chromosome> chromosomeList) {
		Random random = new Random();
		Converter conv = new Converter();

		for (int i = 0; i < POPULATION_SIZE; i++) {
			Chromosome chromosome = new Chromosome(MAX_CHROMOSOME_VALUE);
			chromosome.setPhenotype(random.nextInt(MAX_CHROMOSOME_VALUE));
			chromosome.setGenotype(conv.decimalToBinary(chromosome.getPhenotype()));
			chromosomeList.add(chromosome);
		}
	}

	public void assessmentOfAdaptation(final byte POPULATION_SIZE, List<Chromosome> chromosomeList) {
		for (int i = 0; i < POPULATION_SIZE; i++) {
			chromosomeList.get(i)
					.setAdaptationLevel(2 * (((int) Math.pow(chromosomeList.get(i).getPhenotype(), 2)) + 1));
		}
	}

	public void setProbabilityOfSelectionForEachChromosome(final byte POPULATION_SIZE,List<Chromosome> chromosomeList) {
		int sumOfAdaptationValues = 0;
		for (int i = 0; i < POPULATION_SIZE; i++) {
			sumOfAdaptationValues += chromosomeList.get(i).getAdaptationLevel();
			chromosomeList.get(i).setAdaptationLevelSum(sumOfAdaptationValues);
		}

		for (int i = 0; i < POPULATION_SIZE; i++) {
			chromosomeList.get(i).setProbabilityOfSelection(
					((float) chromosomeList.get(i).getAdaptationLevel() / (float) sumOfAdaptationValues) * 100);
		}
	}

	public List<Chromosome> selectNextGeneration(final byte POPULATION_SIZE,List<Chromosome> chromosomeList) {
		Random random = new Random();
		float randomProbability = 0;
		List<Chromosome> nextGenChromosomeList = new ArrayList<Chromosome>();
		for (int i = 0; i < POPULATION_SIZE; i++) {
			randomProbability = (random.nextFloat() * 100);
			selectNewChromosome(POPULATION_SIZE,chromosomeList,nextGenChromosomeList, randomProbability);
		}
		return nextGenChromosomeList;

	}

	public void selectNewChromosome(final byte POPULATION_SIZE,List<Chromosome> chromosomeList,List<Chromosome> nextGenChromosomeList, float randomProbability) {
		float probabilityOfSelectionSum = 0;
		for (int j = 0; j < POPULATION_SIZE; j++) {
			probabilityOfSelectionSum += chromosomeList.get(j).getProbabilityOfSelection();
			System.out.printf("Random probab: %f probab of sel: %f\n", randomProbability, probabilityOfSelectionSum);
			if (randomProbability < probabilityOfSelectionSum) {
				nextGenChromosomeList.add(chromosomeList.get(j));
				probabilityOfSelectionSum = 0;
				return;
			}
		}
	}

}
