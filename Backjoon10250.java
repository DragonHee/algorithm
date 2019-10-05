
import java.io.*;
import java.util.StringTokenizer;

public class Backjoon10250 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        int testCnt = Integer.parseInt(br.readLine());
        int answer;

        for(int i = 0 ; i < testCnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int h = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            answer = ((n - 1) % h + 1) * 100;
            answer += (n - 1) / h + 1;
            bw.write(answer + "\n");
            bw.flush();
        }

        br.close();
        bw.close();
    }
}
