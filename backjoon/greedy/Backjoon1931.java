package backjoon.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;
class Meeting implements Comparable{
    private int start;
    private int end;
    public Meeting(int start, int end){this.start = start;this.end = end;}
    public int getStart(){return start;}
    public int getEnd(){return end;}

    @Override
    public int compareTo(Object o) {
        Meeting m = (Meeting)o;
//        if(end == m.end) return start - m.start;
        return end - m.end;
    }
}
public class Backjoon1931 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        Meeting [] arr = new Meeting[n];
        int ans = 0;
        int curEnd = 0;

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = new Meeting(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            if(arr[i].getStart() >= curEnd){
                ans++;
                curEnd = arr[i].getEnd();
            }
        }
        for(int i = 0 ; i < n; i++){
            bw.write(arr[i].getStart() + " " + arr[i].getEnd() + "\n");
        }
        bw.write(ans + "\n");
        bw.close();
        br.close();
    }
}
