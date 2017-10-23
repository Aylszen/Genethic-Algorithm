
public class Converter {

	public int[] decimalToBinary(int decimalValue) {
		final byte ARRAY_SIZE = 7;
		int temp[] = new int[ARRAY_SIZE];
		int binary[] = new int[ARRAY_SIZE];
		int index = 0;
		int j = 0;
		while (decimalValue > 0) {
			temp[index++] = decimalValue % 2;
			decimalValue = decimalValue / 2;
		}
		for (int i = ARRAY_SIZE - 1; i >= 0; i--) {
			binary[j] = temp[i];
			System.out.print(binary[j]);
			j++;
		}
		System.out.print("\n");
		return binary;
	}
}
