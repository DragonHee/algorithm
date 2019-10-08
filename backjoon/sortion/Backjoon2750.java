package backjoon.sortion;

import java.io.*;

public class Backjoon2750 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int key, i, j, temp;

        for(i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        // 삽입정렬 코드
//        for(i = 1; i < n; i++){
//            key = arr[i];
//            for(j = i - 1; j >= 0; j--){
//                if(arr[j] > key) arr[j + 1] = arr[j];
//                else break;
//            }
//            arr[j + 1] = key;
//        }

        //버블정렬 코드
        for(i = 0; i < n - 1; i++){
            for(j = 0; j < n - i - 1; j++){
                if(arr[j] > arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        for( i = 0 ; i < n; i++){
            bw.write(arr[i] + "\n");
        }
        bw.close();
        br.close();
    }
}
