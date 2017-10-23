
public class Converter {
	final byte ARRAY_SIZE = 7;

	public int[] decimalToBinary(int value) {
		int temp[] = new int[ARRAY_SIZE];
		int binary[] = new int[ARRAY_SIZE];
		int index = 0;
		int j = 0;
		while (value > 0) {
			temp[index++] = value % 2;
			value = value / 2;
		}
		for (int i = ARRAY_SIZE - 1; i >= 0; i--) {
			binary[j] = temp[i];
			// System.out.print(binary[j]);
			j++;
		}
		return binary;
		// System.out.print("\n");
	}
}
