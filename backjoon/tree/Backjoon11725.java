package backjoon.tree;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon11725 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static List<Integer> list[];

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        list = new ArrayList[N + 1];
        int parent[] = new int[N + 1];
        boolean isVisit[] = new boolean[N + 1];

        for(int i = 1; i <= N; i++){
            list[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            list[num1].add(num2);
            list[num2].add(num1);
        }

        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        isVisit[1] = true;

        while(!stack.isEmpty()){
            int start = stack.pop();

            for(int i = 0 ; i < list[start].size(); i++){
                int end = list[start].get(i);

                if(isVisit[end] == false) {
                    parent[end] = start;
                    stack.push(end);
                    isVisit[end] = true;
                }
            }
        }

        for(int i = 2; i <= N; i++) sb.append(parent[i] + "\n");


        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
