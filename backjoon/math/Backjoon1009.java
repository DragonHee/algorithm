package backjoon.math;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Backjoon1009 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // a^b의 경우 
    // a의 1의 자릿수에 따른 값을 배열에 초기화한다.
    // static int[] arr0 = new int[]{0};
    // static int[] arr1 = new int[]{1};
    // static int[] arr2 = new int[]{2,4,8,6};
    // static int[] arr3 = new int[]{3,9,7,1};
    // static int[] arr4 = new int[]{4,6};
    // static int[] arr5 = new int[]{5};
    // static int[] arr6 = new int[]{6};
    // static int[] arr7 = new int[]{7,9,3,1};
    // static int[] arr8 = new int[]{8,4,2,6};
    // static int[] arr9 = new int[]{9,1};

    public static void main(String[] args) throws IOException{
        int testCnt = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < testCnt; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int answer = solve(a, b);

            bw.write(answer + "\n");
        }

        br.close();
        bw.close();
    }

    public static int solve(int a, int b){
        int result = 0;

        int calcA = a % 10;
        int value = calcA;

        ArrayList<Integer> list = new ArrayList<>();
        boolean[] isCheck = new boolean[10];


        list.add(value);
        isCheck[value] = true;

        while(true){
            value = (value * calcA) % 10;
            
            if(isCheck[value] == true) break;

            list.add(value);
            isCheck[value] = true;
        }

        int calcB = (b - 1) % list.size();
        result = list.get(calcB) != 0 ? list.get(calcB) : 10;

        return result;
    }
    
  
    
}
