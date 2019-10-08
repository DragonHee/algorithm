package backjoon.bruteforce;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon7568 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
      int n = Integer.parseInt(br.readLine());
      StringTokenizer st;
      int[] weightArr = new int[n];
      int[] heightArr = new int[n];
      int cnt = 0;

      for(int i = 0 ; i < n; i++){
          st = new StringTokenizer(br.readLine(), " ");
          weightArr[i] = Integer.parseInt(st.nextToken());
          heightArr[i] = Integer.parseInt(st.nextToken());
      }

      for(int i = 0; i < n; i++){
          cnt = 0;
          for(int j = 0 ; j < n; j++){
              if(i == j) continue;
              if(weightArr[i] < weightArr[j] && heightArr[i] < heightArr[j]) cnt++;
          }
          bw.write((cnt + 1) + " ");
      }

      bw.close();
      br.close();



    }
}
