package backjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class MyQueue{
    List<Integer> list = new ArrayList<>();

    public void add(int num){
        int left = 0;
        int right = list.size() - 1;

        while (left <= right){
            int mid = (left + right) >> 1;
            if(list.get(mid) >= num)
                right = mid - 1;
            else left = mid + 1;
        }
        list.add(left, num);
    }
}
public class Backjoon1655 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        MyQueue queue = new MyQueue();
        for(int i = 0 ; i < n; i++){
            int num = Integer.parseInt(br.readLine());
            queue.add(num);
            sb.append(queue.list.get(i / 2) + "\n");
        }
        System.out.println(sb);
    }
}
