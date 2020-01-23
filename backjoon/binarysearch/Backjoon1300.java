package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon1300 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        long n = Integer.parseInt(br.readLine());
        long k = Integer.parseInt(br.readLine());

        long min = 1, max = n * n, mid = 0, res = 0;

        while(min <= max){
            mid = (min + max) >> 1;
            long count = 0;

            for(int i = 1; i <= n; i++)
                count += Math.min(n, mid / i);

            if(count >= k) {
                res = mid;
                max = mid - 1;
            }
            else min = mid + 1;
        }
        System.out.println(res);
    }
}
