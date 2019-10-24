package backjoon.greedy;
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon11399 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];
        int greedy[] = new int[n + 1];
        int ans = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());
        Arrays.sort(arr);

        for(int i = 1; i <= n; i++){
            greedy[i] = arr[i] + greedy[i - 1];
            ans += greedy[i];
        }

        bw.write(ans + "\n");
        br.close();
        bw.close();
    }

}
