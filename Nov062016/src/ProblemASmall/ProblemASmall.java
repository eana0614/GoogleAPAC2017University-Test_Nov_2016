package ProblemASmall;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ProblemASmall {
	
	/*
	 * T : Test Case, 1<=T<=100
	 * S : Pattern String, 1<= S.length <= 100
	 * I : Separated Integer 1
	 * J : Separated Integer 2 
	 * Small : 1<= I <= J <= 10^6 
	 * Large : 1<= I <= J <= 10^18
	 */

	public static void main(String[] args) throws IOException {
		
		String smallFilePath = "A-small-practice.in";
		
		File smallFile = new File(smallFilePath); 
	
		FileReader fileReader = new FileReader(smallFile);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		
		FileWriter fileWriter = new FileWriter("a.txt");
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		String readTestCase = bufferedReader.readLine();
		
		
		int t = Integer.parseInt(readTestCase); // T
		int countT = 1;
		
		while(countT <= t){
			String s =  bufferedReader.readLine(); // S
			
			String tmp = bufferedReader.readLine();
			int i = Integer.parseInt(tmp.split(" ")[0]); // I
			int j = Integer.parseInt(tmp.split(" ")[1]); // J
			
			String output = solveProblem(s, i, j, countT);
			
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

	private static String solveProblem(String s, int i, int j, int testCaseNum) {
		
		int sLength = s.length();
		int sRepeatNum = j/sLength;
		int countB = 0;
		
		String sRepeatStr = createRepeatString(s, sRepeatNum);
		countB = countBlueBulbs(sRepeatStr, i, j);
		
		return "Case #"+testCaseNum+": "+countB;
	}

	private static int countBlueBulbs(String sRepeatStr, int i, int j) {
		String sub = sRepeatStr.substring(i-1,j);
		int subLength = sub.length();
		int count = 0;
		
		for(int k=0; k<subLength;k++){
			if(sub.charAt(k) == 'B'){
				count++;
			}
		}
		
		return count;
	}

	private static String createRepeatString(String s, int repeat) {
		String repeatStr = "";
		
		for(int i=0; i<=repeat; i++){
			repeatStr += s;
		}
		return repeatStr;
	}

}
