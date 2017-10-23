import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Population {
	List<Chromosome> chromosomeList = new ArrayList<Chromosome>();
	int populationSize = 0;
	final byte MAX_CHROMOSOME_VALUE = 127;

	public void chooseFirstPopulation(int populationSize) {
		Random random = new Random();
		Converter conv = new Converter();

		for (int i = 0; i < populationSize; i++) {
			Chromosome chromosome = new Chromosome(MAX_CHROMOSOME_VALUE);
			chromosome.phenotype = random.nextInt(MAX_CHROMOSOME_VALUE);
			chromosome.genotype = conv.decimalToBinary(chromosome.phenotype);
			chromosomeList.add(chromosome);
		}
	}
	
	public void assessmentOfAdaptation()
	{
		
	}

}
