package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon2805 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args)throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        long max = 0, min = 1, ans = 0;

        int[] arr = new int[n];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n ; i++){
            arr[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, arr[i]);
        }

        while(min <= max){
            long mid = (min + max) >> 1;
            long val = 0;

            for(int i = 0 ; i < n; i++)
                val += arr[i] > mid ? arr[i] - mid : 0;

            if(val >= m) {
                min = mid + 1;
                ans = Math.max(mid, ans);
            }
            else
                max = mid - 1;
        }

        System.out.println(ans);
    }
}
