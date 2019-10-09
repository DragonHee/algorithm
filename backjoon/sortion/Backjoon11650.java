package backjoon.sortion;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
class Location implements Comparable{
    private int x;
    private int y;
    public Location(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    @Override
    public int compareTo(Object o) {
        Location l = (Location)o;
        int result = this.x - l.x;
        return (result != 0) ? result : this.y - l.y;
    }
}
public class Backjoon11650 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Location []arr = new Location[n];

        // x, y좌표 배열에 초기화 시킨다.
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new Location(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        for(int i = 0 ; i < n; i++){
            bw.write(arr[i].getX() + " " + arr[i].getY() + "\n");
        }
        br.close();
        bw.close();
    }
}
