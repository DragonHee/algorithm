package backjoon.dynamic;

import java.io.*;
import java.util.*;

public class Backjoon2631 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static List<Integer> list = new ArrayList<>();
    static int result;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        solve();

        bw.write(result + "\n");
        bw.close();
        br.close();
    }
    
    static void solve() throws IOException{
        list.add(Integer.MIN_VALUE);

        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(br.readLine());
            int left = 1;
            int right = list.size() - 1;

            if(list.get(right) < num) list.add(num);
            else{
                while(left < right){
                    int mid = (left + right) >> 1;

                    if(list.get(mid) > num) right = mid;
                    else left = mid + 1;
                }

                list.set(right, num);
                result++;
            } 

        }
    }

}
