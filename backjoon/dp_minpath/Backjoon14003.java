package backjoon.dp_minpath;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon14003 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> list = new ArrayList<>();
        int arr[] = new int[n + 1];
        int indexArr[] = new int[n + 1];

        for(int i = 1 ; i <= n; i++) arr[i] = Integer.parseInt(st.nextToken());

        list.add(Integer.MIN_VALUE);

        for(int i = 1 ; i <= n; i++){
            int num = arr[i];
            int left = 1;
            int right = list.size() - 1;

            // 확인하는 숫자가 수열이 마지막 수보다 큰 경우
            // 수열에 추가해준다.
            if(num > list.get(list.size() - 1)) {
                list.add(num);
                indexArr[i] = list.size() - 1;
            }
            else{
                while(left < right){
                    int mid = (left + right) >> 1;

                    if(list.get(mid) >= num) right = mid;
                    else left = mid + 1;
                }
                list.set(right, num);
                indexArr[i] = right;
            }
        }
        // 최장 길이 출력
        sb.append(list.size() - 1 + "\n");

        Stack<Integer> stack = new Stack();

        int size = list.size() - 1;
        for(int i = n; i > 0; i--){
            if(indexArr[i] == size){
                size--;
                stack.push(arr[i]);
            }
        }

        while (!stack.isEmpty()){
            sb.append(stack.pop() + " ");
        }


        bw.write(sb.toString());
        bw.close();
        br.close();
    }
}
