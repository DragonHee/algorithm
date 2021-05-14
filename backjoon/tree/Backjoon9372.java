package backjoon.tree;

import java.io.*;
import java.util.*;

public class Backjoon9372 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < testCase; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for(int j = 0 ; j < m; j++){
                br.readLine();
            }

            bw.write(n - 1 + "\n");
        }

        bw.close();
        br.close();
    }
}
