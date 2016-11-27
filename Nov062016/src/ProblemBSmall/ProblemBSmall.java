package ProblemBSmall;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProblemBSmall {

	public static void main(String[] args) throws IOException {
		File filePath = new File("B-small-practice.in");// input 파일 입력

		FileReader fileReader = new FileReader(filePath);
		BufferedReader bufferedReader = new BufferedReader(fileReader);

		FileWriter fileWriter = new FileWriter("b.txt");
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

		int testCase = Integer.parseInt(bufferedReader.readLine());
		int countT = 1;

		while (countT <= testCase) {

			int n = Integer.parseInt(bufferedReader.readLine());

			int m = solveProblem(n);

			String output = "Case #" + countT + ": " + m;
			System.out.println(output);

			bufferedWriter.write(output);
			bufferedWriter.newLine();

			countT++;

		}
		bufferedWriter.close();
		fileWriter.close();
		bufferedReader.close();
		fileReader.close();
	}

	private static int solveProblem(int n) {
		int[] baseInt = makeBaseArray(n);
		String[] countArray = new String[baseInt.length];
		boolean[] ableBase = new boolean[baseInt.length];

		int num = n;

		String baseString = "";
		
		for (int i = 0; i < baseInt.length; i++) {
			int base = baseInt[i];

			while (num > 0) {
				if ((num % base) < 10) {
					baseString = (num % base) + baseString;
					num = num / base;
				} else {
					char tmp = (char) ((num % base) + 55);
					baseString = tmp + baseString;
					num = num / base;
				}
			}

			countArray[i] = baseString;

			ableBase[i] = true;

			for (int j = 0; j < countArray[i].length(); j++) {
				if (countArray[i].charAt(j) != '1') {
					ableBase[i] = false;
					break;
				}

			}

			num = n;
			baseString = "";
		}
		// 가장 많이 1을 가지고 있는 base 값 찾기
		int result = baseInt[findMaxBase(ableBase, countArray)];

		return result;
	}

	private static int[] makeBaseArray(int n) {
		int arraylength = n - 2;
		int[] tmp = new int[arraylength];

		for (int i = 0; i < arraylength; i++) {
			tmp[i] = i + 2;
		}

		return tmp;
	}

	private static int findMaxBase(boolean[] able, String[] countArray) {
		int length = able.length;
		int maxIndex = -1;

		for (int i = 0; i < length; i++) {
			if (able[i]) {
				if (maxIndex != -1) {
					int pre = countArray[maxIndex].length();
					int now = countArray[i].length();

					if (pre < now) {
						maxIndex = i;
					} else {
						maxIndex = maxIndex;
					}
				} else {
					maxIndex = i;
				}
			}
		}

		return maxIndex;
	}

}
