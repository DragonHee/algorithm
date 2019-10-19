package backjoon.dynamic;

import java.io.*;
import java.util.*;

public class Backjoon11066 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int testCnt = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCnt; i++) {
            int n = Integer.parseInt(br.readLine());
            long answer = 0;
            int curVal = 0, min, idx = 0;

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            List<Integer> list = new ArrayList<>();

            for(int j = 0 ; j < n; j++){
                list.add(Integer.parseInt(st.nextToken()));
            }
            while(list.size() > 1){
            }

            bw.write(answer + "\n");
        }
        bw.close();
        br.close();
    }
}
