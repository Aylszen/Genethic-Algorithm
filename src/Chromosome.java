
public class Chromosome {
	private int maxSize;
	private Integer phenotype;
	private int[] genotype;
	private int adaptationLevel;
	private float probabilityOfSelection;

	public Chromosome() {
		this.maxSize = 127;
		this.phenotype = 0;
		this.adaptationLevel = 0;
		this.probabilityOfSelection = 0;
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

	public int getAdaptationLevel() {
		return adaptationLevel;
	}

	public void setAdaptationLevel(int adaptation) {
		this.adaptationLevel = adaptation;
	}

	public float getProbabilityOfSelection() {
		return probabilityOfSelection;
	}

	public void setProbabilityOfSelection(float probabilityOfSelection) {
		this.probabilityOfSelection = probabilityOfSelection;
	}
}
