package backjoon.sortion;

import java.io.*;
import java.util.*;

public class Backjoon18870 {
    static class Index{
        int num;
        int originIndex;
        int moveIndex;

        public Index(int num, int originIndex){
            this.num = num;
            this.originIndex = originIndex;
        }
    }
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws NumberFormatException, IOException{
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0 ; i < N; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }

        


        bw.close();
        br.close();
    }
    
}
