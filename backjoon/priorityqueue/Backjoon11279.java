package backjoon.priorityqueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class MyHip{
    List<Integer> list;
    int size;

    public MyHip(){
        list = new ArrayList<>();
        size = 0;
    }

    public void operation(int x){
        if(x != 0){
            add(x);
        }else if(size == 0 && x == 0){
            System.out.println("0");
        }else{
            System.out.println(list.remove(size - 1));
            size--;
        }
    }

    public void add(int x){
        int left = 0;
        int right = list.size() - 1;

        while(left <= right){
            int mid = (left + right) >> 1;

            if(list.get(mid) >= x){
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        list.add(left, x);
        size++;
    }
}
public class Backjoon11279 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        MyHip myHip = new MyHip();

        for(int i = 0 ; i < n; i++){
            int value = Integer.parseInt(br.readLine());
            myHip.operation(value);
        }
    }
}
