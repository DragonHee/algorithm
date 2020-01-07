package backjoon.divideandconquer;

import java.io.*;
import java.util.StringTokenizer;

public class Backjoon2740 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int a[][];
    private static int b[][];
    private static int result[][];
    static int r;
    static int c;
    public static void main(String[] args) throws IOException{
        initialA();
        initialB();

        result = new int[a.length][b[0].length];

        for(int i = 0 ; i < result.length; i++){
            for(int j = 0 ; j < result[0].length; j++){
                result[i][j] = getValue(i,j);
            }
        }

        for(int i = 0; i < result.length; i++){
            for(int j = 0 ; j < result[0].length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
    public static int getValue(int r, int c){
        int res = 0;
        int length = a[0].length;

        for(int i = 0 ; i < length; i++){
            res += a[r][i] * b[i][c];
        }
        return res;
    }
    public static void initialA() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        a = new int[r][c];
        for(int i = 0 ; i < r; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < c; j++)
                a[i][j] = Integer.parseInt(st.nextToken());
        }
    }
    public static void initialB() throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        b = new int[r][c];
        for(int i = 0 ; i < r; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0 ; j < c; j++)
                b[i][j] = Integer.parseInt(st.nextToken());
        }
    }
}
