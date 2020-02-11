package backjoon.dynamic;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

// 비트 마스크 문제
public class Backjoon11723 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        boolean arr[] = new boolean[21];
       while(n-- > 0){
           StringTokenizer st = new StringTokenizer(br.readLine());
           String op = st.nextToken();
            int num;
            switch (op){
                case "add" :
                    num = Integer.parseInt(st.nextToken());
                    arr[num] = true;
                    break;
                case "remove" :
                    num = Integer.parseInt(st.nextToken());
                    arr[num] = false;
                    break;
                case "check" :
                    num = Integer.parseInt(st.nextToken());
                    sb.append(arr[num] == true ? "1\n" : "0\n");
                    break;
                case "toggle" :
                    num = Integer.parseInt(st.nextToken());
                    arr[num] = !arr[num];
                    break;
                case "all" :
                    Arrays.fill(arr, true);
                    break;
                case "empty" :
                    Arrays.fill(arr, false);
                    break;
            }
        }
        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
