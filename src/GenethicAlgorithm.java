
public class GenethicAlgorithm {

	public static void main(String[] args) {

		Population firstPopulation = new Population();
		firstPopulation.chooseFirstPopulation();
		firstPopulation.assessmentOfAdaptation();
		firstPopulation.setProbabilityOfSelectionForEachChromosome();

		for (int i = 0; i < 10; i++) {
			System.out.print(firstPopulation.chromosomeList.get(i).getPhenotype() + "\n");
			System.out.print(firstPopulation.chromosomeList.get(i).getAdaptation() + "\n");
			System.out.print(firstPopulation.chromosomeList.get(i).getProbabilityOfSelection() + "\n");
		}

	}

}
