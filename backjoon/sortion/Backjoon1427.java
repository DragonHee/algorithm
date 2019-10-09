package backjoon.sortion;

import java.io.*;

public class Backjoon1427 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String n = br.readLine();
        int length = n.length();
        char[] charArr = new char[length];

        for(int i = 0 ; i < length; i++){
            charArr[i] = n.charAt(i);
        }
        bubbleSort(charArr);
        for(int i = 0 ; i < length; i++){
            bw.write(charArr[i]);
        }
        bw.write("\n");
        bw.close();
        br.close();
    }
    private static void bubbleSort(char[] arr){
        char temp;

        for(int i = 0; i < arr.length - 1; i++){
            for(int j = 0; j < arr.length - i - 1; j++){
                if(arr[j] < arr[j + 1]){
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
