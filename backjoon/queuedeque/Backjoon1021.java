package backjoon.queuedeque;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon1021 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int ans = 0;
        ArrayList<Integer> list = new ArrayList<>();
        Queue<Integer> pq = new LinkedList<>();

        for(int i = 1; i <= n ; i++) list.add(i);
        st = new StringTokenizer(br.readLine(), " ");
        while(st.hasMoreTokens()){pq.add(Integer.parseInt(st.nextToken()));}

        while(!pq.isEmpty()){
            if(pq.peek() == list.get(0)){
                pq.poll();
                list.remove(0);
            }
            else if(list.indexOf(pq.peek()) >= list.size() - list.indexOf(pq.peek())){
                list.add(0, list.remove(list.size() - 1));
                ans++;
            }
            else{
                list.add(list.remove(0));
                ans++;
            }
        }
        bw.write(ans + "\n");
        bw.close();
        br.close();
    }
}
