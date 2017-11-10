
public class Converter {

	final byte ARRAY_SIZE = 7;

	public int[] decimalToBinary(int decimalValue) {
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
			j++;
		}
		return binary;
	}

	public int binaryToDecimal(int[] binaryArray) {
		int decimalValue = 0;
		int power = 0;
		for (int i = ARRAY_SIZE - 1; i >= 0; i--) {
			if (binaryArray[i] == 1)
				decimalValue += (int) Math.pow(2, power);
			power++;
		}
		return decimalValue;
	}
}
