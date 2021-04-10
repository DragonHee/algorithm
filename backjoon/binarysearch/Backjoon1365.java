package backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class Backjoon1365 {
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        int result = solve();

        bw.write(result + "\n");
        bw.close();
        br.close();
    }

    static int solve() throws IOException{ 
        StringTokenizer st = new StringTokenizer(br.readLine());
        list.add(Integer.MIN_VALUE);
        int value = 0;

        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(st.nextToken());
            int left = 1;
            int right = list.size() - 1;

            if(num > list.get(right)) list.add(num);
            else{
                value++;
                while(left < right){
                    int mid = (left + right) >> 1;

                    if(list.get(mid) < num) left = mid + 1;
                    else right = mid;
                }
                list.set(right, num);
            }
        }

        return value;
    }
}
