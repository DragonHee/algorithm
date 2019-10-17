package backjoon.dynamic;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

class Wire implements Comparable{
    int x;
    int y;
    public Wire(int x, int y){this.x = x; this.y = y;}
    public int compareTo(Object o) {return x - ((Wire)o).x;}
}
public class Backjoon2565 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Wire []arr = new Wire[n + 1];
        int dp[] = new int[n + 1];

        arr[0] = new Wire(0,0);
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new Wire(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
        dp[1] = 1;
        for(int i = 1; i <= n; i++){
            for(int j = 1; j < i; j++){
                if(arr[i].y > arr[j].y){
                    dp[i] = max(dp[i], dp[j] + 1);
                }else{
                    dp[i] = max(dp[i], 1);
                }
            }
        }
        int max = 0;
        for(int i = 1; i <=n; i++) max = max(max, dp[i]);
        bw.write(n - max + "\n");
        bw.close();
        br.close();
    }
    public static int max(int a, int b){return a > b ? a : b;}
}