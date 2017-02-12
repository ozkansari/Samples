package hackerrank.warmup.sherlockAndQueries;

import java.io.*;
import java.util.*;

public class SolutionOther2 {
    
    private static final int MOD = 1000000007; 
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long[] A = new long[N];
        int[] B = new int[M];
        long[] C = new long[M];
        st = new StringTokenizer(in.readLine()); 
        for (int i = 0; i < N; ++i) { A[i] = Integer.parseInt(st.nextToken()); }
        st = new StringTokenizer(in.readLine()); 
        for (int i = 0; i < M; ++i) { B[i] = Integer.parseInt(st.nextToken())   ; }
        st = new StringTokenizer(in.readLine()); 
        for (int i = 0; i < M; ++i) { C[i] = Integer.parseInt(st.nextToken())   ; }
        Map<Integer, Long> bValueMultiplier = new TreeMap<Integer, Long>();
        for (int i = 0; i < M; ++i) {
            if (!bValueMultiplier.containsKey(B[i])) {
                bValueMultiplier.put(B[i], 1L);
            }
            bValueMultiplier.put(B[i], (bValueMultiplier.get(B[i])*C[i]) % MOD);            
        }
        if (bValueMultiplier.size() < 1000) {
            for (int i = 0; i < N; i++) {
                for (Map.Entry<Integer, Long> e : bValueMultiplier.entrySet()) {
                    if ((i+1) % e.getKey() == 0) {
                        A[i] *= e.getValue(); A[i] %= MOD;
                    }
                }
            }    
        } else {
            for (int i = 0; i < M; ++i) {
                for (int j = B[i]; j <= N; j += B[i]) {
                    A[j-1] *= C[i]; A[j-1] %= MOD;
                }
            }
        }
        for (int i = 0; i < A.length - 1; ++i) {
            out.print(A[i]); out.print(" ");
        }
        out.println(A[A.length - 1]);
        in.close();
        out.close();

    }
}
