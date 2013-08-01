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

public class Crecycled {

	static final String fileIn = "/home/wwu/Desktop/C-large.in";
//	static final String fileIn = "data/A-large-practice.in";
	static final String fileOut = "/home/wwu/Desktop/out.txt";

	public static void main(String[] args) throws Exception {
	    Scanner s = new Scanner(new File(fileIn));
		BufferedWriter w = new BufferedWriter(new FileWriter(fileOut));
		int T = s.nextInt();
		for (int caseNum = 0; caseNum < T; caseNum++) {
			int A = s.nextInt();
			int B = s.nextInt();
			String str = "Case #" + (caseNum + 1) + ": " + solve(A, B);
			w.write(str + "\n");
			System.out.println(str);
		}
		s.close();
		w.close();
	}

	private static String solve(int a, int b) {
		int numRecyled = 0;
		for (int outerCompare=a; outerCompare<=b; outerCompare++) {
			numRecyled += getRecycledPairNum(outerCompare, a, b);
		}
		return String.valueOf(numRecyled/2);
	}

	private static int getRecycledPairNum(int outerCompare, int a, int b) {
		int retVal = 0;
		int lenOfOuter = String.valueOf(outerCompare).length();
		int nextRecycledNum = (int) Math.pow(10, lenOfOuter-1)*(outerCompare % 10) + outerCompare/10;
		for (int i=0; i<=lenOfOuter; i++) {
			if (outerCompare == nextRecycledNum) {
				continue;
			} else if (a <= nextRecycledNum && nextRecycledNum <= b) {
				retVal++;
			}
			nextRecycledNum = (int) Math.pow(10, lenOfOuter-1)*(nextRecycledNum % 10) + nextRecycledNum/10;
		}
		return retVal;
	}

}
