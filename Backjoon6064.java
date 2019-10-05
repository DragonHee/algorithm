import java.io.*;
import java.util.StringTokenizer;

public class Backjoon6064 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int testCnt = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < testCnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            bw.write(calcYear(m, n, x, y));
        }
    }
    private static int calcYear(int m, int n, int x, int y){
        int k;
        int a, b;

        k = m * a + x;
        k = n * b + y;
    }
}
