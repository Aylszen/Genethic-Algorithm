import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class Population {

	Converter conv = new Converter();

	public List<Chromosome> chooseFirstPopulation(final byte POPULATION_SIZE, final byte MAX_CHROMOSOME_VALUE) {
		Random random = new Random();
		List<Chromosome> chromosomeList = new ArrayList<Chromosome>();
		for (int i = 0; i < POPULATION_SIZE; i++) {
			Chromosome chromosome = new Chromosome();
			chromosome.setPhenotype(random.nextInt(MAX_CHROMOSOME_VALUE));
			chromosome.setGenotype(conv.decimalToBinary(chromosome.getPhenotype()));
			chromosomeList.add(chromosome);
		}
		return chromosomeList;
	}

	public void assessmentOfAdaptation(final byte POPULATION_SIZE, List<Chromosome> chromosomeList) {
		for (int i = 0; i < POPULATION_SIZE; i++) {
			chromosomeList.get(i).setAdaptationLevel(
					2 * (((int) Math.pow(conv.binaryToDecimal(chromosomeList.get(i).getGenotype()), 2)) + 1));
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
			nextGenChromosomeList.add(
					selectNewChromosomes(POPULATION_SIZE, chromosomeList, randomProbability));
		}
		return nextGenChromosomeList;
	}

	public Chromosome selectNewChromosomes(final byte POPULATION_SIZE, List<Chromosome> chromosomeList,
			float randomProbability) {
		float probabilityOfSelectionSum = 0;
		Chromosome newChromosome = new Chromosome();
		for (int j = 0; j < POPULATION_SIZE; j++) {
			probabilityOfSelectionSum += chromosomeList.get(j).getProbabilityOfSelection();
			if (randomProbability < probabilityOfSelectionSum) {
				newChromosome.setGenotype(chromosomeList.get(j).getGenotype());
				newChromosome.setPhenotype(conv.binaryToDecimal(newChromosome.getGenotype()));
				return newChromosome;
			}
		}
		return newChromosome;
	}

	public void crossChromosomes(final byte POPULATION_SIZE, final byte PROBABILITY_OF_CROSSING,
			List<Chromosome> chromosomeList) {
		Random random = new Random();

		final byte LOCUS_SIZE = 7;
		int ch1_at = 0, ch2_at = 0;
		int locus = 0;
		int temp = 0;
		for (int i = 0; i < (POPULATION_SIZE / 2); i++) {
			if (random.nextInt(101) <= PROBABILITY_OF_CROSSING) {
				locus = random.nextInt(LOCUS_SIZE);
				ch1_at = random.nextInt(POPULATION_SIZE);
				ch2_at = random.nextInt(POPULATION_SIZE);
				temp = chromosomeList.get(ch1_at).getGene(locus);
				chromosomeList.get(ch1_at).setGene(chromosomeList.get(ch2_at).getGene(locus), locus);
				chromosomeList.get(ch2_at).setGene(temp, locus);
			}
		}

	}

	public void mutateChromosomes(final byte POPULATION_SIZE, final byte PROBABILITY_OF_MUTATION,
			List<Chromosome> chromosomeList) {
		Random random = new Random();
		final byte LOCUS_SIZE = 7;
		int locus = 0;
		for (int i = 0; i < 1; i++) {
			if (random.nextInt(101) <= PROBABILITY_OF_MUTATION) {
				locus = random.nextInt(LOCUS_SIZE);
				System.out.print("Uda�o si�\n");
				if (chromosomeList.get(i).getGene(locus) == 0)
					chromosomeList.get(i).setGene(1, locus);
				else
					chromosomeList.get(i).setGene(0, locus);
			}
		}
	}

}
