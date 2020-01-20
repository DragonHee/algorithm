package backjoon.binarysearch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon1654 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int k = Integer.parseInt(st.nextToken()); int n = Integer.parseInt(st.nextToken());

        int[] arr = new int[k];
        long tot = 0 ;

        for(int i = 0 ; i < k; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            tot += arr[i];
        }

        long high = tot / n;
        long low = 1;
        long mid;
        long temp;
        long ans = -1;

        while(low <= high){
            temp = 0;
            mid = (high + low) / 2;

            for(int i = 0 ; i < k; i++)
                temp += arr[i] / mid;

            if(temp >= n) {
                ans = Math.max(mid, ans);
                low = mid + 1;
            }
            else if(temp < n) high = mid - 1;
        }


        System.out.println(ans);
    }
}
