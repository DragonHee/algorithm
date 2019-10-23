package backjoon.array;

import java.io.*;


public class Backjoon3052 {
    private static final int TEST_CNT = 10;
    private static final int MODULUS_NUM = 42;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        boolean []numArr = new boolean[MODULUS_NUM];
        int res = 0;

        for(int i = 0;i < TEST_CNT; i++){
            int num = Integer.parseInt(br.readLine()) % MODULUS_NUM;
            if(numArr[num] == false) {
                res++;
                numArr[num] = true;
            }
        }

       bw.write(res + "\n");
       bw.close();

    }
}
