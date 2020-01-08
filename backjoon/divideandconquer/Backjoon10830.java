package backjoon.divideandconquer;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon10830 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[][] arr;
    static int[][] res;
    static int N;
    static long B;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        arr = new int[N][N];
        res = new int[N][N];

        for(int i = 0; i < arr.length; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < arr[0].length; j++)
                arr[i][j] = Integer.parseInt(st.nextToken());
        }

        fill(res, arr);
        B -= 1;
        solve(B);

        for(int i = 0; i < arr.length; i++){
            for(int j = 0 ; j < arr[0].length; j++)
                bw.write(res[i][j] + " ");
            bw.write("\n");
        }
        br.close();
        bw.close();
    }
    public static void solve(long total){
        long num = 1;
        int [][] intArr = new int[N][N];
        fill(intArr, arr);

        while(true){
            if(total <= 0) return;
            else if(total == 1) break;

            if(num * 2 < total){
                num *= 2;
                intArr = multi(intArr, intArr);
            }else if(num * 2 == total){
                intArr = multi(intArr, intArr);
                break;
            }else{
                solve(total - num);
                break;
            }
        }

        res = multi(res, intArr);
    }
    public static int[][] multi(int[][] a, int[][] b){
        int[][] resArr = new int[N][N];

        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < N; j++){
                for(int k = 0 ; k < N; k++){
                    resArr[i][j] += a[i][k] * b[k][j];
                }
                resArr[i][j] %= 1000;
            }
        }
        return resArr;
    }
    public static void fill(int [][] a, int[][] b){
        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++)
                a[i][j] = b[i][j] % 1000;
        }
    }
}
