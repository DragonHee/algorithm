package backjoon.dp_minpath;

import java.io.*;

// 사실 lcm알고리즘을 모르고 있다면
// 생각해서 풀기 힘들기 때문에
// 숙지하고 있도록 하자.

class Point{
    int length;
    String seq;

    public Point(){
        this.length = 0;
        this.seq = "";
    }
}

public class Backjoon9252 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int resultLength;
    static String resultSeq;

    public static void main(String[] args) throws IOException {
        String str1 = br.readLine();
        String str2 = br.readLine();

        Point lcmArr[][] = new Point[str1.length() + 1][str2.length() + 1];

        for(int i = 0 ; i <= str1.length(); i++){
            for(int j = 0 ; j <= str2.length(); j++){
                lcmArr[i][j] = new Point();
            }
        }

        for(int i = 0; i < str1.length(); i++){
            for(int j = 0 ; j < str2.length(); j++){
                if(str1.charAt(i) == str2.charAt(j)){
                    lcmArr[i + 1][j + 1].length  = lcmArr[i][j].length + 1;
                    lcmArr[i + 1][j + 1].seq = lcmArr[i][j].seq + str1.charAt(i);
                }
                else{
                    if(lcmArr[i + 1][j].length >= lcmArr[i][j + 1].length){
                        lcmArr[i + 1][j + 1].length  = lcmArr[i + 1][j].length;
                        lcmArr[i + 1][j + 1].seq = lcmArr[i + 1][j].seq;
                    }
                    else{
                        lcmArr[i + 1][j + 1].length  = lcmArr[i][j + 1].length;
                        lcmArr[i + 1][j + 1].seq = lcmArr[i][j + 1].seq;
                    }
                }

                if(resultLength < lcmArr[i + 1][j + 1].length){
                    resultLength = lcmArr[i + 1][j + 1].length;
                    resultSeq = lcmArr[i + 1][j + 1].seq;
                }
            }
        }
        sb.append(resultLength + "\n" + resultSeq + "\n");

        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
