package backjoon.queuedeque;

import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Backjoon5430 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int testCnt = Integer.parseInt(br.readLine());

        while(testCnt-- > 0){
            String op = br.readLine(); br.readLine();
            String arrStr = br.readLine(); arrStr = arrStr.substring(1, arrStr.length() - 1);

            LinkedList<Integer> q = new LinkedList<>();
            StringTokenizer st = new StringTokenizer(arrStr, ",");
            boolean flag = true;
            // true -> 정방향 , false -> 반대 방향
            while(st.hasMoreTokens()) q.push(Integer.parseInt(st.nextToken()));

            for(int i = 0 ; i < op.length(); i++){
                if(op.charAt(i) == 'R'){
                    flag = !flag;
                }else{
                    if(q.isEmpty()){
                        bw.write("error\n");
                        break;
                    }
                    if(flag) q.pollLast();
                    else q.pollFirst();
                }
                if(i + 1 == op.length()) printAns(q, flag);
            }
        }
        bw.close();
        br.close();
    }
    private static void printAns(LinkedList<Integer> q, boolean flag) throws IOException {
        StringBuilder ans = new StringBuilder();

        ans.append("[");
        while(!q.isEmpty()){
            if(flag) ans.append(q.pollLast() + ",");
            else ans.append(q.pollFirst() + ",");
        }
        if(ans.length() > 1) ans.deleteCharAt(ans.length() - 1);
        ans.append("]");
        bw.write(ans + "\n");
    }
}
