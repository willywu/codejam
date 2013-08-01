package y2012.r1a;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

import org.apache.commons.lang3.tuple.Pair;


public class BKingdomRush {

//	static final String fileIn = "/home/wwu/Desktop/test-in.txt";
	static final String fileIn = "/home/wwu/Desktop/B-large-practice.in";
	static final String fileOut = "/home/wwu/Desktop/out.txt";

	public static void main(String[] args) throws Exception {
	    Scanner s = new Scanner(new File(fileIn));
		BufferedWriter w = new BufferedWriter(new FileWriter(fileOut));
		int T = s.nextInt();
		for (int caseNum = 0; caseNum < T; caseNum++) {
			int N = s.nextInt();
			int[][] levelsAndStars = new int[N][2];
			for (int i=0; i<N; i++) {
				levelsAndStars[i][0] = s.nextInt();
				levelsAndStars[i][1] = s.nextInt();
			}
			String str = "Case #" + (caseNum + 1) + ": " + solve(N, levelsAndStars);
			w.write(str + "\n");
			System.out.println(str);
		}
		s.close();
		w.close();
	}

	private static String solve(int N, int[][] levelsAndStars) {
		int numGamesPlayed = 0;
		int numStarsEarned = 0;
		int numTwoStarGamesPlayed = 0;
		while (numTwoStarGamesPlayed != N) {
			Pair<Integer, Integer> levelToPlay = Pair.of(-1, -1);
			for (int i=0; i<N; i++) {
				//first try to play any 2 star level
				if (levelsAndStars[i][1] <= numStarsEarned) {
					levelToPlay = Pair.of(i, 1); // play level i, 2 stars
					break;
				}
			}
			// if you didn't find a 2 star game, choose the best 1 star game
			if (levelToPlay.getLeft() == -1) {
				int biggestStarDiff = Integer.MIN_VALUE;
				for (int i=0; i<N; i++) {
					if (levelsAndStars[i][0] <= numStarsEarned) {
						if (levelsAndStars[i][1]-numStarsEarned > biggestStarDiff) {
							levelToPlay = Pair.of(i, 0); // play level i, 1 star
							biggestStarDiff = levelsAndStars[i][1]-numStarsEarned;
						}
					}
				}
			}

			// play the game, damn it!
			if (levelToPlay.getRight() == 1) { // do accounting if it's a 2 star game
				if (levelsAndStars[levelToPlay.getLeft()][0] == Integer.MAX_VALUE) {
					numStarsEarned++;
				} else {
					numStarsEarned += 2;
					levelsAndStars[levelToPlay.getLeft()][0] = Integer.MAX_VALUE;
				}
				numGamesPlayed++;
				numTwoStarGamesPlayed++;
				levelsAndStars[levelToPlay.getLeft()][1] = Integer.MAX_VALUE;
				//System.out.println(String.format("Playing (%s, %s)", levelToPlay.getFirst(), levelToPlay.getSecond()));
			} else if (levelToPlay.getRight() == 0) { // less exciting accounting for a 1 star game
				numGamesPlayed++;
				numStarsEarned += 1;
				levelsAndStars[levelToPlay.getLeft()][0] = Integer.MAX_VALUE;
				//System.out.println(String.format("Playing (%s, %s)", levelToPlay.getFirst(), levelToPlay.getSecond()));
			} else {
				// not enough stars to play anything.  womp womp.
				return "Too Bad";
			}
		}
		return String.valueOf(numGamesPlayed);
	}
}
