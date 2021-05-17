package backjoon.backtracking;

import java.util.*;
import java.io.*;

public class Backjoon10974 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;

    public static void main(String[] args) throws NumberFormatException, IOException{
        N = Integer.parseInt(br.readLine());

        solve();

        br.close();
        bw.close();
    }

    public static void solve() throws IOException{
        boolean[] check = new boolean[N + 1];
        int[] arr = new int[N + 1];
        combination1ToN(1, check, arr);
    }

    public static void combination1ToN(int curIndex, boolean[] check, int[] arr) throws IOException{
        if(curIndex > N){
            for(int i = 1; i <= N; i++) bw.write(arr[i] + " ");
            bw.write("\n");
            return;
        }

        for(int i = 1; i <= N; i++){
            if(check[i] == true) continue;
            check[i] = true;
            arr[curIndex] = i;
            combination1ToN(curIndex + 1, check, arr);
            check[i] = false;
        }
    }
    
}
