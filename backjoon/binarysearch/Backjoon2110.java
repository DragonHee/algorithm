package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon2110 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken()) - 1;
        int ans = -1;
        int[] locationArr = new int[n];

        for(int i = 0 ; i < n; i++)
            locationArr[i] = Integer.parseInt(br.readLine());

        Arrays.sort(locationArr);

        int min = 1;
        int max = locationArr[n - 1] - locationArr[0];

        while(min <= max) {
            int count = 0;
            int iPlus = 1;
            int mid = (min + max) >> 1;

            for (int i = 0; i < n; i++) {
                if(i + iPlus >= n) break;
                if(locationArr[i + iPlus] - locationArr[i] >= mid){
                    i += iPlus - 1;
                    iPlus = 1;
                    count++;

                }else{
                    iPlus++;
                    i--;
                }
            }

            if(count >= c){
                min = mid + 1;
                ans = Math.max(ans, mid);
            }else{
                max = mid - 1;
            }
        }
        System.out.println(ans);
    }
}
