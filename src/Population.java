import java.util.Random;
import java.lang.Math;
import java.util.ArrayList;
import java.util.List;

public class Population {
	List<Chromosome> chromosomeList = new ArrayList<Chromosome>();
	final byte POPULATION_SIZE = 10;
	final byte MAX_CHROMOSOME_VALUE = 127;

	public void chooseFirstPopulation() {
		Random random = new Random();
		Converter conv = new Converter();

		for (int i = 0; i < POPULATION_SIZE; i++) {
			Chromosome chromosome = new Chromosome(MAX_CHROMOSOME_VALUE);
			chromosome.setPhenotype(random.nextInt(MAX_CHROMOSOME_VALUE));
			chromosome.setGenotype(conv.decimalToBinary(chromosome.getPhenotype()));
			chromosomeList.add(chromosome);
		}
	}

	public void assessmentOfAdaptation() {
		for (int i = 0; i < POPULATION_SIZE; i++) {
			chromosomeList.get(i).setAdaptation(2 * (((int) Math.pow(chromosomeList.get(i).getPhenotype(), 2)) + 1));
		}
	}

	public void setChromosomesProbability() {
		int tempValue = 0;
		for (int i = 0; i < POPULATION_SIZE; i++) {
			tempValue += chromosomeList.get(i).getAdaptation();
		}

		for (int i = 0; i < POPULATION_SIZE; i++) {
			chromosomeList.get(i).setProbabilityOfSelection(
					((float) chromosomeList.get(i).getAdaptation() / (float) tempValue) * 100);
			// System.out.print(chromosomeList.get(i).getProbabilityOfSelection()
			// + "\n");
		}
	}

}
