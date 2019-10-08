package backjoon.sortion;

import java.io.*;

public class Backjoon2751 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] sortedArr;
    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int []arr = new int[n];
        sortedArr = new int[n];
        int i, j;

        for(i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(arr, 0, n - 1);
        for(i = 0 ; i < n; i++){
            System.out.println(arr[i]);
        }
    }

    private static void mergeSort(int[] arr, int start, int end){
       int mid;

       if(start < end){
           mid = (start + end) / 2;
           mergeSort(arr, start, mid);
           mergeSort(arr, mid + 1, end);
           merge(arr, start, mid, end);
       }
    }

    private static void merge(int[] arr, int start, int mid, int end){
        int i, j, k ,q;

        k = i = start;
        q = j = mid + 1;

        while(i <= mid && j <= end){
            if(arr[i] >= arr[j]){
                sortedArr[k++] = arr[j++];
            }else{
                sortedArr[k++] = arr[i++];
            }
        }

        if(i > mid){
            while(j <= end){
                sortedArr[k++] = arr[j++];
            }
        }
        if(j > end){
            while(i <= mid){
                sortedArr[k++] = arr[i++];
            }
        }

        while(start <= end){
            arr[start] = sortedArr[start++];
        }
    }
}
