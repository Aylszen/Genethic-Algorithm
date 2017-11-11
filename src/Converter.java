
public class Converter {

	final byte ARRAY_SIZE = 7;

	public int[] decimalToBinary(int decimalValue) {
		int tempArray[] = new int[ARRAY_SIZE];
		int binaryArray[] = new int[ARRAY_SIZE];
		int index = 0,j = 0;
		while (decimalValue > 0) {
			tempArray[index++] = decimalValue % 2;
			decimalValue = decimalValue / 2;
		}
		for (int i = ARRAY_SIZE - 1; i >= 0; i--) {
			binaryArray[j] = tempArray[i];
			j++;
		}
		return binaryArray;
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
