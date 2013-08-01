package y2012.r1b;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;

public class ASafety {

//	static final String fileIn = "/home/wwu/Desktop/test-in.txt";
	static final String fileIn = "/home/wwu/Desktop/A-large-practice.in";
	static final String fileOut = "/home/wwu/Desktop/out.txt";

	public static void main(String[] args) throws Exception {
		BufferedReader r = new BufferedReader(new FileReader(fileIn));
		BufferedWriter w = new BufferedWriter(new FileWriter(fileOut));
		String line = r.readLine();
		int T = Integer.parseInt(line);
		for (int caseNum = 0; caseNum < T; caseNum++) {
		    line = r.readLine();
		    String[] lineSplit = line.split(" ");
		    int[] NandS = new int[lineSplit.length];
		    for (int i=0; i<lineSplit.length; i++) {
		        NandS[i] = Integer.valueOf(lineSplit[i]);
		    }
		    int N = NandS[0];
			int[] S = new int[N];
			for (int i=0; i<N; i++) {
				S[i] = NandS[i+1];
			}
			String str = "Case #" + (caseNum + 1) + ":" + solve(N, S);
			w.write(str + "\n");
			System.out.println(str);
		}
		r.close();
		w.close();
	}

	private static String solve(int n, int[] s) {
		int totalVotes = 0;
		for (int i : s) {
			totalVotes += i;
		}
		double breakEvenPointTotal = 2.0*totalVotes/n;
		// figure out the number of people that need points vs overflowers
		int numNeedPoints = 0;
		double amountOfOverflow = 0.0;
		for (int personPoints : s) {
			if (personPoints > breakEvenPointTotal) {
				amountOfOverflow += personPoints - breakEvenPointTotal;
			} else {
				numNeedPoints += 1;
			}
		}
		breakEvenPointTotal -= amountOfOverflow/numNeedPoints; // suppress the break even point based on how excellently other people did
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<n; i++) {
			sb.append(" ");
			double ans = (breakEvenPointTotal-s[i])/totalVotes*100;
			sb.append(ans > 0 ? ans : 0);
		}
		return sb.toString();
	}

}
