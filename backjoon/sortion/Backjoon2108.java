package backjoon.sortion;

import java.io.*;

public class Backjoon2108 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] sortedArr;
    private static final int MAX = 8001;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        sortedArr = new int[n];
        int countArr[] = new int[MAX];
        int countMax = 0;
        int equalCnt = 0;
        int equalValue = 0;
        int sum = 0;

        for(int i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
            countArr[arr[i] + 4000]++;
            if(countArr[arr[i] + 4000] > countMax) countMax = countArr[arr[i] + 4000];
            sum += arr[i];
        }
        //산술 평균
        bw.write(Math.round((double)sum/n) + "\n");
        mergeSort(arr, 0, arr.length - 1);
        //중앙 값
        bw.write(arr[(n - 1) / 2] + "\n");
        //최빈 값
        for(int i = arr[0] + 4000; i <= arr[n - 1] + 4000; i++){
            if(countMax == countArr[i]){
                equalCnt++;
                if(equalCnt == 1) equalValue = i - 4000;
                else if(equalCnt == 2) {
                    equalValue = i- 4000;
                    break;
                }
            }
        }
        bw.write(equalValue + "\n");
        //범위
        bw.write(arr[n - 1] - arr[0] + "\n");
        bw.close();
        br.close();
    }
    private static void mergeSort(int[] arr, int start, int end){
        int mid = (start + end) / 2;

        if(start < end){
            mergeSort(arr, start, mid);
            mergeSort(arr, mid + 1, end);
            merge(arr, start, mid, end);
        }
    }
    private static void merge(int[] arr, int start, int mid, int end){
        int i, j, k;
        k = i = start;
        j = mid + 1;

        while(i <= mid && j <= end){
            if(arr[i] >= arr[j]) {
                sortedArr[k++] = arr[j++];
            }else{
                sortedArr[k++] = arr[i++];
            }
        }

        if(i > mid){
            while(j <= end){
                sortedArr[k++] = arr[j++];
            }
        }else{
            while(i <= mid){
                sortedArr[k++] = arr[i++];
            }
        }

        for(i = start; i <= end; i++){
            arr[i] = sortedArr[i];
        }
    }
}
