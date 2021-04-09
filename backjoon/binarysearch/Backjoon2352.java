package backjoon.binarysearch;

import java.io.*;
import java.util.*;

public class Backjoon2352 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // 입력 값 저장 변수
    static int N;
    // LIS를 저장할 List 자료구조 선언
    static List<Integer> list = new ArrayList<>();
    
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        solve();

        bw.write(list.size() - 1 + "\n");
        bw.close();
        br.close();
    }

    static void solve() throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        // list 가장 처음에 -INF 저장
        list.add(Integer.MIN_VALUE);

        for(int i = 1; i <= N; i++){
            int num = Integer.parseInt(st.nextToken());
            // 이분 탐색을 위한 left, right 변수 선언
            int left = 1;
            int right = list.size() - 1;

            // list 가장 마지막 숫자보다 입력이 큰 경우
            // list에 추가
            if(num > list.get(list.size() - 1)) list.add(num);
            // list 가장 마지막 숫자보다 입력이 작은 경우
            else{
                // num을 집어 넣을 가장 최적의 위치 탐색
                // ref) binary search
                while(left < right){
                    int mid = (left + right) >> 1;

                    if(list.get(mid) >= num) right = mid;
                    else left = mid + 1; 
                }
                // list 최적의 위치에 저장
                list.set(right, num);
            }
        }
    }
}
