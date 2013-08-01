package y2012.r1c;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;

public class CBoxFactory {

//	static final String fileIn = "/home/wwu/Desktop/test-in.txt";
	static final String fileIn = "/home/wwu/Desktop/C-small-practice.in";
	static final String fileOut = "/home/wwu/Desktop/out3.txt";

	public static void main(String[] args) throws Exception {
		BufferedReader r = new BufferedReader(new FileReader(fileIn));
		BufferedWriter w = new BufferedWriter(new FileWriter(fileOut));
		Scanner s = new Scanner(r);
		int T = s.nextInt();
		for (int caseNum = 0; caseNum < T; caseNum++) {
			int numBoxes = s.nextInt();
			int numToys = s.nextInt();
			MutablePair<Long, String>[] boxCountAndTypes = new MutablePair[numBoxes];
			MutablePair<Long, String>[] toyCountAndTypes = new MutablePair[numToys];
			for (int i=0; i<numBoxes; i++) {
				boxCountAndTypes[i] = MutablePair.of(s.nextLong(), s.next());
			}
			for (int j=0; j<numToys; j++) {
				toyCountAndTypes[j] = MutablePair.of(s.nextLong(), s.next());
			}
			String str = "Case #" + (caseNum + 1) + ": " + solve(boxCountAndTypes, toyCountAndTypes);
			w.write(str + "\n");
			System.out.println(str);
		}
		r.close();
		w.close();
	}

	private static String solve(MutablePair<Long, String>[] boxCountAndTypes, MutablePair<Long, String>[] toyCountAndTypes) {
		long[][] bestOutcome = new long[boxCountAndTypes.length][toyCountAndTypes.length];
		for (int i=0; i<boxCountAndTypes.length; i++) {
			for (int j=0; j<toyCountAndTypes.length; j++) {
				long bestPrevState = getBestPrevState(bestOutcome, i, j);
				MutablePair<Long, String> box = boxCountAndTypes[i];
				MutablePair<Long, String> toy = toyCountAndTypes[j];
				long bestHere = box.getRight().equals(toy.getRight()) ? Math.min(box.getLeft(), toy.getLeft()) : 0;
				bestOutcome[i][j] = bestHere + bestPrevState;
				// subtract out the boxed toys that you're making at this step
				box.setLeft(box.getLeft() - bestHere);
				toy.setLeft(toy.getLeft() - bestHere);
			}
		}
		return String.valueOf(bestOutcome[boxCountAndTypes.length-1][toyCountAndTypes.length-1]);
	}

	private static long getBestPrevState(long[][] bestOutcome, int i, int j) {
		long bestNeighbor = 0;
		if (i!=0 && j!=0) {
			bestNeighbor = Math.max(bestNeighbor, bestOutcome[i-1][j-1]);
		}
		if (i!=0) {
			bestNeighbor = Math.max(bestNeighbor, bestOutcome[i-1][j]);
		}
		if (j!=0) {
			bestNeighbor = Math.max(bestNeighbor, bestOutcome[i][j-1]);
		}
		return bestNeighbor;
	}

}
