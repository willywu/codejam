package y2012.quals;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.HashMap;
import java.util.Map;

public class Atongues {

	static final String fileIn = "/home/wwu/Desktop/A-small-attempt0.in";
	static final String fileOut = "data/out2.txt";

	public static Map<Character, Character> charMap;

	public static void main(String[] args) throws Exception {
		BufferedReader r = new BufferedReader(new FileReader(fileIn));
		BufferedWriter w = new BufferedWriter(new FileWriter(fileOut));
		String line = r.readLine();
		int T = Integer.parseInt(line);
		charMap = new HashMap<Character, Character>();
		trainCharMap();
		for (int caseNum = 0; caseNum < T; caseNum++) {
			String googlese = r.readLine();
			String str = "Case #" + (caseNum + 1) + ": " + solve(googlese);
			w.write(str + "\n");
			System.out.println(str);
		}
		r.close();
		w.close();
	}

	private static String solve(String googlese) {
		StringBuilder sb = new StringBuilder();
		for (int i=0; i<googlese.length(); i++) {
			sb.append(charMap.get(googlese.charAt(i)));
		}
		return sb.toString();
	}

	private static void trainCharMap() {
		String s1 = "ejp mysljylc kd kxveddknmc re jsicpdrysi";
		String a1 = "our language is impossible to understand";
		String s2 = "rbcpc ypc rtcsra dkh wyfrepkym veddknkmkrkcd";
		String a2 = "there are twenty six factorial possibilities";
		String s3 = "de kr kd eoya kw aej tysr re ujdr lkgc jv";
		String a3 = "so it is okay if you want to just give up";
		charMap.put('a', 'y');
		charMap.put('o', 'e');
		charMap.put('z', 'q');
		charMap.put('q', 'z');
		for (int i=0; i<s1.length(); i++) {
			charMap.put(s1.charAt(i), a1.charAt(i));
		}
		for (int i=0; i<s1.length(); i++) {
			charMap.put(s2.charAt(i), a2.charAt(i));
		}
		for (int i=0; i<s1.length(); i++) {
			charMap.put(s3.charAt(i), a3.charAt(i));
		}
	}

}
