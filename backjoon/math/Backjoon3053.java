package backjoon.math;

import java.io.*;

public class Backjoon3053 {
    private static final double PI = 3.1415926535897932384626433;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int radius = Integer.parseInt(br.readLine());
        System.out.format("%.6f %n", radius * radius * PI);
        System.out.format("%.6f %n", (double)2 * radius * radius);
        br.close();
    }
}
