package backjoon.sortion;

import java.io.*;

// 수의 범위가 작을 때는 카운팅 정렬
public class Backjoon10989 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] sortedArr;

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int max = 0;
        sortedArr = new int[n];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            if(max < arr[i]) max = arr[i];
        }
        countingSort(arr, max);
        for(int i = 0 ; i < n; i++){
            bw.write(sortedArr[i] + "\n");
        }

        bw.close();
        br.close();
    }

    private static void countingSort(int[] arr, int max){
        int[] countArr = new int[max + 1];

        for(int i = 0 ; i < arr.length; i++){
            countArr[arr[i]]++;
        }
        for(int i = 1 ; i < countArr.length; i++){
            countArr[i] += countArr[i - 1];
        }
        for(int i = arr.length - 1; i >= 0; i--){
            sortedArr[countArr[arr[i]]-- - 1] = arr[i];
        }
    }
}
