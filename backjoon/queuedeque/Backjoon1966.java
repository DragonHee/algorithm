package backjoon.queuedeque;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Backjoon1966 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static Queue<Integer> queue;
    private static ArrayList<Integer> pList;
    private static int m, n;

    public static void main(String[] args) throws IOException {
        int tc = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < tc; i++){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            queue = new LinkedList<>();
            pList = new ArrayList<>();
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0 ; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                queue.add(num);
                pList.add(num);
            }

            int cnt = 0;
            int index = m;
            while(true){
                boolean isMax = true;
                for(int j = 1 ; j < pList.size(); j++){
                    if(pList.get(0) < pList.get(j)){
                        isMax = false;
                        break;
                    }
                }
                if(isMax){
                    queue.poll();
                    pList.remove(0);
                    cnt++;
                    if(index == 0) break;
                }else {
                    int priority = queue.poll();
                    pList.remove(0);
                    pList.add(priority);
                }
                if(index == 0) index = queue.size() - 1;
                else index--;
            }
            bw.write(cnt + "\n");
        }
        bw.close();
        br.close();
    }
}
