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
                    queue.add(priority);
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

//import java.io.*;
//        import java.util.*;
//
//public class Main {
//    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
//    static StringTokenizer stk;
//    public static void main(String[] args) throws Exception {
//        int T = Integer.parseInt(br.readLine());
//        while (T-- > 0) {
//            stk = new StringTokenizer(br.readLine());
//            int N = Integer.parseInt(stk.nextToken());
//            int M = Integer.parseInt(stk.nextToken());
//            int[] print = new int[N];
//            int[] priority = new int[10];
//            stk = new StringTokenizer(br.readLine());
//            for (int i = 0; i < N; i++) {
//                print[i] = Integer.parseInt(stk.nextToken());
//                priority[print[i]]++;
//            }
//
//            int count = 0;
//            int highest = 9;
//            for (int i = 0; print[M] != 0; i = (++i) % N) {
//                for (int h = highest; priority[highest] == 0; h--)
//                    highest = h;
//                if (print[i] == highest) {
//                    priority[highest]--;
//                    print[i] = 0;
//                    count++;
//                }
//            }
//            bw.write(count + "\n");
//        }
//        bw.flush();
//    }
//
//}
