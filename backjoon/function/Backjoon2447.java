package backjoon.function;

import java.io.*;
import java.util.Arrays;

public class Backjoon2447 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    private static char[][] starMap;

    public static void main(String[] args) throws IOException {


        int num = Integer.parseInt(br.readLine());
        starMap = new char[num][num];

        for(int i = 0 ; i < num; i++){
            Arrays.fill(starMap[i], ' ');
        }

        solve(0, 0, num);
        for(int i = 0 ; i < num; i++){
            for(int j = 0 ; j < num; j++){
               bw.write(starMap[i][j]);
            }
            bw.write("\n");
        }

        bw.close();
    }

    public static void solve (int x, int y, int n) {
       if(n == 1){
           starMap[x][y] = '*';
       }else{
           int m = n / 3;
           for(int i = 0 ; i < 3 ; i++){
               for(int j = 0 ; j < 3; j++){
                   if(i % 3 == 1 && j % 3 == 1) continue;
                   solve(x + m * i, y + m * j, m);
               }
           }
       }
    }
}

