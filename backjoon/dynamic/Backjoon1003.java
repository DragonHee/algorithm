package backjoon.dynamic;

import java.io.*;
class Count{
    private int x;
    private int y;
    public Count(int x, int y){this.x = x; this.y = y;}
    public int getX(){return x;}
    public int getY(){return y;}
}
public class Backjoon1003 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < n; i++){
            Count c = solve(Integer.parseInt(br.readLine()));
            bw.write(c.getX() + " " + c.getY() + "\n");
        }
        bw.close();
        br.close();
    }
    private static Count solve(int n){
       if(n == 0) return new Count(1, 0);
       else if(n == 1) return new Count(0, 1);
       else{
           Count c = solve(n - 1);
           return new Count(c.getY(), c.getX() + c.getY());
       }
    }
}
