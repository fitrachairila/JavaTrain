package Day1;

import java.util.Arrays;

public class TestAja {
	
	public static void main(String[] args) {
		
		int[]input1 = {1, 5, 12, 17, 21};
		int[]input2 = {2, 4, 14, 20};
		
		// membuat array baru dengan length/size gabungan dari size 2 array input
		int[] gabungArr = new int[input1.length + input2.length];
		
		// menggunakan arraycopy untuk menggabungkan array ke array baru
		System.arraycopy(input1, 0, gabungArr, 0, input1.length);
		System.arraycopy(input2, 0, gabungArr, input1.length, input2.length);

		// setelah array baru dibuat lalu dilakukan sorting secara ascending
		for (int i = 0; i < gabungArr.length - 1; i++) {
			for (int j = i + 1; j < gabungArr.length; j++) {
				if (gabungArr[i] > gabungArr[j]) {
					int temp = gabungArr[i];
					gabungArr[i] = gabungArr[j];
					gabungArr[j] = temp;
				}
			}
		}
		//System.out.println(gabungArr);
		//Output: [1, 2, 4, 5, 12 ,14, 17, 20, 21]
		System.out.println(Arrays.toString(gabungArr));
	}
}
