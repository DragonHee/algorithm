package backjoon.math;

import java.io.*;
import java.util.*;

public class Backjoon1009 {
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException{
        // testCase 갯수 입력
        int testCnt = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < testCnt; i++){
            // a, b 값 입력
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            // 풀이 메소드 호출
            int answer = solve(a, b);

            // 출력 버퍼 write
            bw.write(answer + "\n");
        }

        br.close();
        bw.close();
    }

    public static int solve(int a, int b){
        int result = 0;

        // 입력받은 a의 1의 자릿수
        int calcA = a % 10;
        // calcA * calcA * ... 을 저장할 변수
        // 초기에는 calcA로 셋팅
        int value = calcA;

        // a^b가 이루어질 때 1의 자릿수를 저장할 리스트
        // ex) a = 3인 경우 list = {3, 9, 7, 1}
        ArrayList<Integer> list = new ArrayList<>();
        // list에 중복된 값이 들어가지 않도록 체크할 배열
        boolean[] isCheck = new boolean[10];

        list.add(value);
        isCheck[value] = true;

        while(true){
            // calcA를 곱해서 1의 자릿수만 확인
            value = (value * calcA) % 10;
            
            // value가 이미 list에 들어있는 값이라면
            // 앞으로 순환된 값이 들어오므로 break
            if(isCheck[value] == true) break;

            list.add(value);
            isCheck[value] = true;
        }

        // (b - 1)을 해야 list의 index와 같아짐
        int calcB = (b - 1) % list.size();
        // 0이면 10번째 컴퓨터임
        result = list.get(calcB) != 0 ? list.get(calcB) : 10;

        return result;
    }   
}
