package backjoon.bruteforce;


import java.io.*;
import java.util.StringTokenizer;

public class Backjoon1018 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int LENGTH = 8;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        String[] chessBoard = new String[m];
        int startWhiteCnt = 0, startBlackCnt = 0;
        int min = LENGTH * LENGTH;

        for(int i = 0 ; i < m; i++){
            chessBoard[i] = br.readLine();
        }

        for(int i = 0 ; i <= m - LENGTH; i++){
            for(int j = 0 ; j <= n - LENGTH; j++){
                startBlackCnt = 0;
                startWhiteCnt = 0;
                for(int k = 0; k < 8; k++){
                    for(int q = 0 ; q < 8; q++){
                        if((k + q) % 2 == 0) {
                            if(chessBoard[i + k].charAt(j + q) != 'W') startWhiteCnt++;
                        }
                        else{
                            if(chessBoard[i + k].charAt(j + q) != 'B') startWhiteCnt++;
                        }
                    }
                }

                for(int k = 0; k < 8; k++){
                    for(int q = 0 ; q < 8; q++){
                        if((k + q) % 2 == 0) {
                            if(chessBoard[i + k].charAt(j + q) != 'B') startBlackCnt++;
                        }
                        else{
                            if(chessBoard[i + k].charAt(j + q) != 'W') startBlackCnt++;
                        }
                    }
                }
                if(min > startBlackCnt) min = startBlackCnt;
                if(min > startWhiteCnt) min = startWhiteCnt;
            }
        }
        bw.write(min + "\n");
        bw.close();
        br.close();
    }
}
