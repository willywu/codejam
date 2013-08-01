package y2012.quals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.apache.commons.lang3.tuple.Pair;

public class Dmirrors {

//	static final String fileIn = "/home/wwu/Desktop/B-large.in";
	static final String fileIn = "data/A-large-practice.in";
	static final String fileOut = "/home/wwu/Desktop/out.txt";

	public static void main(String[] args) throws Exception {
	    Scanner s = new Scanner(new File(fileIn));
	    BufferedWriter w = new BufferedWriter(new FileWriter(fileOut));
		int T = s.nextInt();
		for (int caseNum = 0; caseNum < T; caseNum++) {
			int H = s.nextInt();
			int W = s.nextInt();
			int D = s.nextInt();
			char[][] map = new char[H][W];
			Pair<Integer, Integer> myLoc = null;
			for (int i=0; i<H; i++) {
				String line = s.next();
				for (int j=0; i<W; i++) {
					map[i][j] = line.charAt(j);
					if (map[i][j] == 'X') {
						myLoc = Pair.of(i, j);
					}
				}
			}
			String str = "Case #" + (caseNum + 1) + ": " + solve(map, myLoc, D);
			w.write(str + "\n");
			System.out.println(str);
		}
		s.close();
		w.close();
	}

	private static String solve(char[][] map, Pair<Integer, Integer> myLoc, int d) {
		// http://code.google.com/codejam/contest/1460488/dashboard#s=a&a=3
		return null;
	}


}
