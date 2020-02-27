package backjoon.dp_minpath;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 사실 lcm알고리즘을 모르고 있다면
// 생각해서 풀기 힘들기 때문에
// 숙지하고 있도록 하자.
public class Backjoon9252 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int answer;

    public static void main(String[] args) throws IOException {
        String str1 = br.readLine();
        String str2 = br.readLine();

        int lcmArr[][] = new int[str1.length() + 1][str2.length() + 1];


        for(int i = 0; i < str1.length(); i++){
            boolean check1 = false;
            for(int j = 0 ; j < str2.length(); j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    lcmArr[i + 1][j + 1] = lcmArr[i][j] + 1;
                }
                else{
                    lcmArr[i + 1][j + 1] = Math.max(lcmArr[i][j + 1], lcmArr[i + 1][j]);
                }
                answer = Math.max(answer, lcmArr[i + 1][j + 1]);
            }
        }
        sb.append(answer + "\n");


        sb.append("\n");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
