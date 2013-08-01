package y2012.quals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Bdancing {

	static final String fileIn = "/home/wwu/Desktop/B-large.in";
//	static final String fileIn = "data/A-large-practice.in";
	static final String fileOut = "/home/wwu/Desktop/out.txt";

	public static void main(String[] args) throws Exception {
	    Scanner s = new Scanner(new File(fileIn));
		BufferedWriter w = new BufferedWriter(new FileWriter(fileOut));
		int T = s.nextInt();
		for (int caseNum = 0; caseNum < T; caseNum++) {
			int nGooglers = s.nextInt();
			int surprises = s.nextInt();
			int pBestResultScore = s.nextInt();
			List<Integer> totalScores = new ArrayList<Integer>();
			for (int i=0; i<nGooglers; i++) {
				totalScores.add(s.nextInt());
			}
			String str = "Case #" + (caseNum + 1) + ": " + solve(nGooglers, surprises, pBestResultScore, totalScores);
			w.write(str + "\n");
			System.out.println(str);
		}
		s.close();
		w.close();
	}

	private static String solve(int nGooglers, int surprises,
			int pBestResultScore, List<Integer> totalScores) {
		int maxPossibleGooglers = 0;
		Collections.sort(totalScores);
		Collections.reverse(totalScores);
		//int highestNoSurprise = Math.min(3*pBestResultScore+2, 30);
		//int highestWithSurprise = Math.min(3*pBestResultScore+4, 30);
		int lowestNoSurprise = Math.max(3*pBestResultScore-2, pBestResultScore);
		int lowestWithSurprise = Math.max(3*pBestResultScore-4, pBestResultScore);
		for (Integer score : totalScores) {
			if (score >= lowestNoSurprise /*&& score <= highestNoSurprise*/) {
				maxPossibleGooglers++;
			} else if (score >= lowestWithSurprise /*&& score <= highestWithSurprise*/ && surprises > 0) {
				maxPossibleGooglers++;
				surprises--;
			}
		}
		return String.valueOf(maxPossibleGooglers);
	}

}
