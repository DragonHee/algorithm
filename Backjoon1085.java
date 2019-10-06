import java.io.*;
import java.util.StringTokenizer;

public class Backjoon1085 {
    private static final int MAX = 1000;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        int h = Integer.parseInt(st.nextToken());

        calcMinDistance(x, y, w, h);

        br.close();
        bw.close();
    }

    private static void calcMinDistance(int x, int y, int w, int h) throws IOException {
        int minX, minY;

        minX = x <= w - x ? x : w - x;
        minY = y <= h - y ? y : h - y;

        bw.write((minX <= minY ? minX : minY) + "\n");
    }
}
