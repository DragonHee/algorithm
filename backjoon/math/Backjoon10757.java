package backjoon.math;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon10757 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        String numAStr = st.nextToken();
        String numBStr = st.nextToken();

        String sum = plusTwoString(numAStr, numBStr);
        
        bw.write(sum + "\n");

        bw.close();
        br.close();
    }

    public static String plusTwoString(String numAStr, String numBStr){
        if(numAStr == null || numBStr == null){
            throw new NullPointerException();
        }

        // char 배열로 변환
        char[] numAArr = numAStr.toCharArray();
        char[] numBArr = numBStr.toCharArray();

        // 결과값 저장할 char 배열 선언
        char[] result = new char[Math.max(numAArr.length, numBArr.length) + 1];
        Arrays.fill(result, '0');

        for(int i = 1 ; i <= result.length; i++){
            int numA = numAArr.length - i < 0 ? 0 : numAArr[numAArr.length - i] - '0';
            int numB = numBArr.length - i < 0 ? 0 : numBArr[numBArr.length - i] - '0';

            int sum = numA + numB;

            if(sum >= 10) {
                result[result.length - i - 1]++;
                sum -= 10;
            }
            
            result[result.length - i] += sum;

            if(result[result.length - i] - '0' >= 10) {
                result[result.length - i] -= 10;
                result[result.length - i - 1]++;
            }
        }

        if(result[0] == '0') return String.valueOf(result).substring(1);
        else return String.valueOf(result);
    }
}
