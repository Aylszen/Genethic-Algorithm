import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Population {
	List<Chromosome> chromosomeArray = new ArrayList<Chromosome>();
	int populationSize = 0;
	final byte MAX_CHROMOSOME_VALUE = 127;
	Converter conv = new Converter();

	public Population(int populationSize) {
		this.populationSize = populationSize;
	}

	public void drawChromosomes() {
		Random random = new Random();

		for (int i = 0; i < populationSize; i++) {
			Chromosome chromosome = new Chromosome(MAX_CHROMOSOME_VALUE);
			chromosome.value = random.nextInt(MAX_CHROMOSOME_VALUE);
			chromosome.binaryValue = conv.decimalToBinary(chromosome.value);
			chromosomeArray.add(chromosome);
		}
	}

}
