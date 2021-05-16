package backjoon.simulation;

import java.util.*;
import java.io.*;

public class Backjoon10804 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static final int CARD_COUNT = 20;
    static int[] arr = new int[CARD_COUNT + 1];

    public static void main(String[] args) throws IOException{
        // 배열에 카드 번호 초기화 1~CARD_COUNT
        initCardArr(arr);

        for(int i = 0; i < 10; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            swapRange(arr, a, b);
        }

        for(int i = 1; i <= CARD_COUNT; i++){
            bw.write(arr[i] + " ");
        }

        bw.close();
        br.close();
    }

    public static void swapRange(int[] arr, int start, int end){
        while(true){
            if(start >= end) break;

            swap(arr, start++, end--);
        }
    }

    public static void swap(int[] arr, int start, int end){
        int temp = arr[start];
        arr[start] = arr[end];
        arr[end] = temp;
    }

    public static void initCardArr(int[] arr){
        for(int i = 1; i <= CARD_COUNT; i++) arr[i] = i;
    }
}
