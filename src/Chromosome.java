
public class Chromosome {
	private Integer phenotype;
	private int[] genotype;

	private int adaptationLevel;
	private float probabilityOfSelection;

	public Chromosome() {
		this.phenotype = 0;
		this.adaptationLevel = 0;
		this.probabilityOfSelection = 0;
		this.genotype = new int[7];
	}

	public Integer getPhenotype() {
		return phenotype;
	}

	public void setPhenotype(Integer phenotype) {
		this.phenotype = phenotype;
	}

	public void setGene(int value, int locus) {
		this.genotype[locus] = value;
	}

	public int getGene(int locus) {
		return this.genotype[locus];
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

	public int[] getGenotype() {
		return genotype.clone();
	}

	public void setGenotype(int[] genotype) {
		this.genotype = genotype;
	}
}
