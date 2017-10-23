
public class Chromosome {
	private int maxSize;
	private Integer phenotype;
	private int[] genotype;
	private int adaptation;

	public Chromosome() {
		this.maxSize = 127;
		this.phenotype = 0;
		this.adaptation = 0;
	}

	public Chromosome(int maxSize) {
		this.maxSize = maxSize;
	}

	public int getMaxSize() {
		return maxSize;
	}

	public void setMaxSize(int maxSize) {
		this.maxSize = maxSize;
	}

	public Integer getPhenotype() {
		return phenotype;
	}

	public void setPhenotype(Integer phenotype) {
		this.phenotype = phenotype;
	}

	public int[] getGenotype() {
		return genotype;
	}

	public void setGenotype(int[] genotype) {
		this.genotype = genotype;
	}

	public int getAdaptation() {
		return adaptation;
	}

	public void setAdaptation(int adaptation) {
		this.adaptation = adaptation;
	}
}
