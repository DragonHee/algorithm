package backjoon.binarysearch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Backjoon12015 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        List<Integer> list = new ArrayList<>();
        list.add(0);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i <= n - 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if(arr[i] > list.get(list.size() - 1)) list.add(arr[i]);
            else{
                int left = 0;
                int right = list.size() - 1;

                while(left < right){
                    int mid = (left + right) >> 1;
                    if(list.get(mid) >= arr[i]){
                        right = mid;
                    }else{
                        left = mid + 1;
                    }
                }
                list.set(right, arr[i]);
            }
        }
        System.out.println(list.size() - 1);
    }

}
