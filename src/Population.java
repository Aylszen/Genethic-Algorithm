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

	public void setProbabilityOfSelectionForEachChromosome(final byte POPULATION_SIZE,
			List<Chromosome> chromosomeList) {
		int sumOfAdaptationValues = 0;
		for (int i = 0; i < POPULATION_SIZE; i++) {
			sumOfAdaptationValues += chromosomeList.get(i).getAdaptationLevel();
		}

		for (int i = 0; i < POPULATION_SIZE; i++) {
			chromosomeList.get(i).setProbabilityOfSelection(
					((float) chromosomeList.get(i).getAdaptationLevel() / (float) sumOfAdaptationValues) * 100);
		}
	}

	public List<Chromosome> selectNextGeneration(final byte POPULATION_SIZE, List<Chromosome> chromosomeList) {
		Random random = new Random();
		float randomProbability = 0;
		List<Chromosome> nextGenChromosomeList = new ArrayList<Chromosome>();
		for (int i = 0; i < POPULATION_SIZE; i++) {
			randomProbability = (random.nextFloat() * 100);
			selectNewChromosomes(POPULATION_SIZE, chromosomeList, nextGenChromosomeList, randomProbability);
		}
		return nextGenChromosomeList;

	}

	public void selectNewChromosomes(final byte POPULATION_SIZE, List<Chromosome> chromosomeList,
			List<Chromosome> nextGenChromosomeList, float randomProbability) {
		float probabilityOfSelectionSum = 0;
		for (int j = 0; j < POPULATION_SIZE; j++) {
			probabilityOfSelectionSum += chromosomeList.get(j).getProbabilityOfSelection();
			//System.out.printf("Random probab: %f probab of sel: %f\n", randomProbability, probabilityOfSelectionSum);
			if (randomProbability < probabilityOfSelectionSum) {
				nextGenChromosomeList.add(chromosomeList.get(j));
				probabilityOfSelectionSum = 0;
				return;
			}
		}
	}

	public void crossChromosomes(final byte POPULATION_SIZE, final byte PROBABILITY_OF_CROSSING,
			List<Chromosome> chromosomeList) {
		Random random = new Random();
		if (random.nextInt(101) < PROBABILITY_OF_CROSSING) {
			final byte LOCUS_SIZE = 7;
			int locus = 0, ch1_locus = 0, ch2_locus = 0, ch1_at = 0, ch2_at = 0;
			for (int i = 0; i < (POPULATION_SIZE / 2); i++) {
				locus = random.nextInt(LOCUS_SIZE);
				ch1_locus = chromosomeList.get(ch1_at = random.nextInt(POPULATION_SIZE)).getGenotype()[locus];
				ch2_locus = chromosomeList.get(ch2_at = random.nextInt(POPULATION_SIZE)).getGenotype()[locus];
				chromosomeList.get(ch1_at).getGenotype()[locus] = ch2_locus;
				chromosomeList.get(ch2_at).getGenotype()[locus] = ch1_locus;
			}
		}

	}

	public void mutateChromosomes(final byte POPULATION_SIZE, final byte PROBABILITY_OF_MUTATION,
			List<Chromosome> chromosomeList) {
		Random random = new Random();
		final byte LOCUS_SIZE = 7;
		int locus = 0;
		for (int i = 0; i < POPULATION_SIZE; i++) {
			if (random.nextInt(101) < PROBABILITY_OF_MUTATION) {
				locus = random.nextInt(LOCUS_SIZE);
				System.out.print("Uda³o siê");
				if (chromosomeList.get(i).getGenotype()[locus] == 0) {
					chromosomeList.get(i).getGenotype()[locus] = 1;
				} else {
					chromosomeList.get(i).getGenotype()[locus] = 0;
				}
			}
		}
	}

}
