package y2008.r1c;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import com.google.common.primitives.Longs;

public class TextMessageOutrage {

    static final String fileIn = "/home/wwu/Desktop/A-large-practice.in";
    //    static final String fileIn = "data/txtmsg.in";
    static final String fileOut = "/home/wwu/Desktop/out.txt";

    public static void main(String[] args) throws Exception {
        Scanner s = new Scanner(new File(fileIn));
        BufferedWriter w = new BufferedWriter(new FileWriter(fileOut));
        try {
            int N = s.nextInt();
            for (int caseNum = 0; caseNum < N; caseNum++) {
                int P = s.nextInt();
                int K = s.nextInt();
                int L = s.nextInt();
                long[] freq = new long[L];
                for (int i=0; i<L; i++) {
                    freq[i] = s.nextLong();
                }
                String str = "Case #" + (caseNum + 1) + ": " + solve(P, K, L, freq);
                w.write(str + "\n");
                System.out.println(str);
            }
        } finally {
            s.close();
            w.close();
        }
    }

    private static String solve(int p, int k, int l, long[] freq) {
        Arrays.sort(freq);
        Collections.reverse(Longs.asList(freq));
        long numPresses = 0;
        int pressesThisRound = 0;
        for (int i=0; i<freq.length; i++) {
            if (i % k == 0) {
                pressesThisRound++;
            }
            numPresses += pressesThisRound*freq[i];
        }
        return Long.toString(numPresses);
    }

}
