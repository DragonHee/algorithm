package backjoon.sortion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Backjoon2751_Re {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int arr[];
    static int tmpArr[];
    public static void main(String[] args) throws IOException{
        int N = Integer.parseInt(br.readLine());

        arr = new int[N];
        tmpArr = new int[N];

        readInt(N);
      
        mergeSort(0, N - 1);
        
        writeInt(N);

        br.close();
        bw.close();
    }

    static void readInt(int cnt) {
        try{
            for(int i = 0 ; i < cnt; i++){
                arr[i] = Integer.parseInt(br.readLine());
            }
        }catch(Exception ex){
            System.err.println("Exception occurs while readInt");
        }
    }

    static void writeInt(int cnt){
        try{
            for(int i = 0 ; i < cnt; i++){
                bw.write(arr[i] + "\n");
            }
        }catch(Exception ex){
            System.err.println("Exception occurs while writeInt");
        }
    }

    static void mergeSort(int low, int high){
        if(low < high){
            int mid = low + (high - low) / 2;

            mergeSort(low, mid);
            mergeSort(mid + 1, high);
            merge(low, high);
        }
    }

    static void merge(int low, int high){
        int mid = low + (high - low) / 2;
        int i = low;
        int j = mid + 1;
        int k = low;

        while(i <= mid && j <= high){
            if(arr[i] >= arr[j]){
                tmpArr[k++] = arr[j++]; 
            }else{
                tmpArr[k++] = arr[i++];
            }
        }

        if(i <= mid){
            while(i <= mid){
                tmpArr[k++] = arr[i++];
            }
        }else{
            while(j <= high){
                tmpArr[k++] = arr[j++];
            }
        }
        
        k--;

        while(k >= low){
            arr[k] = tmpArr[k--];
        }
    }
}
