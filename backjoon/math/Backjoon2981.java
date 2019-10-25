package backjoon.math;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Backjoon2981 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        int arr[] = new int[n];

        for(int i = 0; i < n; i++) arr[i] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        int gcdNum = arr[1] - arr[0];

        for(int i = 2 ; i < n; i++){
            gcdNum = gcd(gcdNum, arr[i] - arr[i - 1]);
        }
        for(int i = 2; i * i <= gcdNum; i++){
            if(gcdNum % i == 0) {
                list.add(i);
                if(i != gcdNum / i) list.add(gcdNum / i);
            }
        }
        list.add(gcdNum);
        Collections.sort(list);
        for(int i = 0 ; i < list.size(); i++) bw.write(list.get(i) + " ");
        bw.write("\n");
        bw.close();
        br.close();
    }
    public static int gcd(int a, int b){
        while(b != 0){
            int r = a % b;
            a = b;
            b = r;
        }
        return a;
    }
}
