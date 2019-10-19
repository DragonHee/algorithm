package backjoon.dynamic;

import java.io.*;

public class Backjoon9251 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] lcmArr = new int[str1.length() + 1][str2.length() + 1];
        int answer = 0;

        for(int i = 0; i < str1.length(); i++){
            for(int j = 0 ; j < str2.length(); j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    lcmArr[i + 1][j + 1] = lcmArr[i][j] + 1;
                }else{
                    lcmArr[i + 1][j + 1] = max(lcmArr[i + 1][j], lcmArr[i][j + 1]);
                }
                answer = max(answer, lcmArr[i + 1][j + 1]);
            }
        }

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }
    public static int max(int a, int b){return a > b ? a : b;}
}
