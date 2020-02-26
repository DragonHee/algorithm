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

        // str1 길이 만큼 반복
        for(int i = 0; i < str1.length(); i++){
            // str2 길이 만큼 반복
            for(int j = 0 ; j < str2.length(); j++){
                // 문자가 같은 경우
                if(str1.charAt(i) == str2.charAt(j)){
                    // 왼쪽 위 대각선의 있는 값 + 1을 한다.
                    lcmArr[i + 1][j + 1] = lcmArr[i][j] + 1;
                // 문자가 다른 경우
                }else{
                    // 위, 왼쪽 중 큰 값을 저장한다.
                    lcmArr[i + 1][j + 1] = max(lcmArr[i + 1][j], lcmArr[i][j + 1]);
                }
                // 최대값을 정답으로 저장한다.
                answer = max(answer, lcmArr[i + 1][j + 1]);
            }
        }

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }
    public static int max(int a, int b){return a > b ? a : b;}
}
