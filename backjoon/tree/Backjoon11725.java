package backjoon.tree;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon11725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int INF = 100_000;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        boolean check[] = new boolean[INF + 1];
        int parent[] = new int[INF + 1];

        check[1] = true;
        parent[1] = 1;


        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            if(check[num1] == false){
                parent[num1] = num2;
                check[num1] = true;
            }else{
                parent[num2] = num1;
                check[num2] = true;
            }
        }

        for(int i = 2; i <= N; i++)
            sb.append(parent[i] + "\n");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
