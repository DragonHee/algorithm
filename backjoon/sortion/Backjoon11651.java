package backjoon.sortion;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
class LocationXY implements Comparable{
    private int x;
    private int y;
    public LocationXY(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){return x;}
    public int getY(){return y;}
    @Override
    public int compareTo(Object o) {
        LocationXY l = (LocationXY)o;
        int result = this.y - l.y;
        return (result != 0) ? result : this.x - l.x;
    }
}
public class Backjoon11651 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        LocationXY []arr = new LocationXY[n];

        // x, y좌표 배열에 초기화 시킨다.
        for(int i = 0 ; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");
            arr[i] = new LocationXY(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(arr);

        for(int i = 0 ; i < n; i++){
            bw.write(arr[i].getX() + " " + arr[i].getY() + "\n");
        }
        br.close();
        bw.close();
    }
}
