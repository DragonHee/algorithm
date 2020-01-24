package backjoon.binarysearch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon12015 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int size = 1;
        arr[0] = Integer.parseInt(st.nextToken());
        for(int i = 1 ; i <= n - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > arr[i - 1]) size++;
            else{
                arr[i] = arr[i - 1];
            }
        }
        System.out.println(size);
    }
}
