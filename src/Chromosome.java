
public class Chromosome {
	private int maxSize = 0;
	Integer phenotype = 0;
	int[] genotype;

	public Chromosome() {
		this.maxSize = 127;
	}

	public Chromosome(int maxSize) {
		this.maxSize = maxSize;
	}
}
