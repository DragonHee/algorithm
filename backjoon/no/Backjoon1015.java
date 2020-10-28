package backjoon.no;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PipedInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

class Point implements Comparable<Point>{
    int index;
    int value;
    public Point(int index, int value){
        this.index = index;
        this.value = value;
    }

    @Override
    public int compareTo(Point o) {
        return value - o.value;
    }
}
public class Backjoon1015 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        ArrayList<Point> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < N; i++)
            list.add(new Point(i, Integer.parseInt(st.nextToken())));

        Collections.sort(list);
        int result[] = new int[N];

        for(int i = 0 ; i < list.size(); i++){
            result[list.get(i).index] = i;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < N; i++){
            sb.append(result[i] + " ");
        }
        System.out.println(sb.toString());

    }
}
