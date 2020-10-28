package backjoon.sortion;

import java.io.*;

public class Backjoon2751 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[] arr;
    private static int[] sortedArr;
    static int N;
    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());

        arr = new int[N];
        sortedArr = new int[N];

        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        mergeSort(0, N - 1);

        for(int i = 0 ; i < N; i++){
            bw.write(arr[i] + "\n");
        }

        bw.close();
        br.close();
    }

    public static void mergeSort(int low, int high){
        if(low < high){
            int mid = low + (high - low) / 2;

            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, high);
        }
    }

    public static void merge(int low, int high){
        
        int mid = low + (high - low) / 2;
        int i = low;
        int j = mid + 1;
        int k = low;

        while(i <= mid && j <= high){
            if(arr[i] <= arr[j]){
                sortedArr[k++] = arr[i++];
            }else{
                sortedArr[k++] = arr[j++];
            }
        }

        if(i <= mid){
            while(k <= high){
                sortedArr[k++] = arr[i++];
            }
        }else{
            while(k <= high){
                sortedArr[k++] = arr[j++];
            }
        }

        k--;

        while(k >= low){
            arr[k] = sortedArr[k];
            k--;
        }
    }
}