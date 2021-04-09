package backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class Backjoon2352 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        solve();

        bw.write(list.size() - 1 + "\n");
        bw.close();
        br.close();
    }

    static void solve() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        list.add(Integer.MIN_VALUE);

        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(st.nextToken());
            int left = 1;
            int right = list.size() - 1;

            if(num > list.get(list.size() - 1)) list.add(num);
            else{
                
                while(left < right){
                    int mid = (left + right) >> 1;

                    if(list.get(mid) >= num) right = mid;
                    else left = mid + 1; 
                }
                list.set(right, num);
            }
        }
    }
}
