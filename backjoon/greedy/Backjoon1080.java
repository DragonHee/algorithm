package backjoon.greedy;

import java.io.*;
import java.util.*;


public class Backjoon1080 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, M;
    static int result;
    static boolean arrA[][];
    static boolean arrB[][];
    static boolean check[][];

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arrA = new boolean[N + 1][M + 1];
        arrB = new boolean[N + 1][M + 1];
        check = new boolean[N + 1][M + 1];

        input();
        if(N >= 3 && M >= 3) result = solveACase();
        else result = solveBCase();
        
        bw.write(result + "\n");
        bw.close();
        br.close();
    }

    // 3 * 3 보다 주어진 N, M이 크거나 같은 경우
    static int solveACase(){

        // check 배열 초기화 
        // A, B의 행렬의 값이 같으면 true -> 바꿀 필요 X
        // A, B의 행렬의 값이 다르면 false -> 바꿀 필요 O
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(arrA[i][j] == arrB[i][j]) check[i][j] = true;
                else check[i][j] = false;
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(i <= N - 2 && j <= M - 2 && check[i][j] == false) 
                    convertCheckArr(i, j);
                else if((i > N - 2 || j > M - 2) && check[i][j] == false)
                    return -1;
            }
        }

        return result;
    }

    // 3 * 3 보다 주어진 A, B 행렬이 작은 경우
    static int solveBCase(){

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(arrA[i][j] != arrB[i][j]) return -1;
            }
        }

        return 0;
    }

    // 3 * 3의 부분 행렬을 역전 시키는 함수
    static void convertCheckArr(int row, int col){
        result++;

        for(int i = row; i <= row + 2; i++){
            for(int j = col; j <= col + 2; j++){
                check[i][j] = !check[i][j];
            }
        }
    }

    static void input() throws IOException{

        for(int i = 1; i <= N; i++){
            String input = br.readLine();
            for(int j = 1; j <= M; j++){
                arrA[i][j] = input.charAt(j - 1) == '1' ? true : false;
            }
        }

        for(int i = 1; i <= N; i++){
            String input = br.readLine();
            for(int j = 1; j <= M; j++){
                arrB[i][j] = input.charAt(j - 1) == '1' ? true : false;
            }
        }
    }
}
