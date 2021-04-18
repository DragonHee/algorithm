package backjoon.samsung_sw_test;

import java.util.*;
import java.io.*;

public class Backjoon14889 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    static int N;
    static int[][] abilityMap;
    static boolean[] check;
    static int minValue = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        abilityMap = new int[N + 1][N + 1];
        check = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                abilityMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

        bw.write(minValue + "\n");
        bw.close();
        br.close();
    }

    static void solve(){
        // 첫번째 선택이 절반이상을 지나가면 
        // 중복된 결과가 나옴
        // 따라서 절반까지만 검사
        for(int i = 1; i <= (N >> 1); i++){
            check[i] = true;
            combination(i, 1);
            check[i] = false;
        }
    }

    static void combination(int curIndex, int count){
        // 절반 선택한 경우 계산
        if(count == (N >> 1)){
            calc();
            return;
        }

        for(int i = curIndex + 1; i <= N; i++){
            check[i] = true;
            combination(i, count + 1);
            check[i] = false;
        }
    }

    static void calc(){
        // true인 경우
        int totA = 0;
        // false인 경우
        int totB = 0;

        for(int i = 1; i <= N; i++){
            for(int j = i + 1; j <= N; j++){
                // 
                if(check[i] == true && check[j] == true){
                    totA += (abilityMap[i][j] + abilityMap[j][i]);
                }else if(check[i] == false && check[j] == false){
                    totB += (abilityMap[i][j] + abilityMap[j][i]);
                }
            }
        }

        int cha = Math.abs(totA - totB);

        minValue = Math.min(minValue, cha);
    }
}
