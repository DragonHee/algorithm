package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon1920 {
    public static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];

        for(int i = 0 ; i < n; i++)
            arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0 ; i < m; i++){
            System.out.println(isContain(arr, Integer.parseInt(st.nextToken())));
        }
    }

    public static int isContain(int[] arr, int num){
        if(Arrays.binarySearch(arr, num) >= 0) return 1;
        else return 0;
    }
}
