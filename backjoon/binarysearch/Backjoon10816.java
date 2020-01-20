package backjoon.binarysearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon10816 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] arr = new int[20_000_001];
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n; i++)
            arr[Integer.parseInt(st.nextToken()) + 10_000_000]++;

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < m; i++)
            System.out.print(arr[Integer.parseInt(st.nextToken()) + 10_000_000] + " ");
    }
}
