package backjoon.greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Backjoon2810{

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    // 총 인원 수
    static int N;
    // 자리 배치도 S:일반좌석, L:커플석
    static StringBuilder input = new StringBuilder();

    // 정답을 저장하는 변수
    static int answer;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());
        input.append(br.readLine());

        solve();

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }

    public static void solve(){
        int[] calcArr = new int[N << 1 + 1];
        initArray(calcArr);
        calcAnswer(calcArr);
    }

    static void initArray(int[] array){
        int index = 0;
        // 시작은 컵홀더로 설정
        array[index++] = -1;

        for(int i = 0 ; i < input.length(); i++){
            char ch = input.charAt(i);

            if(ch == 'S'){
                // 1: 사람, -1 : 컵홀더
                array[index++] = 1;
                array[index++] = -1;
            }
            else{
                array[index++] = 1;
                array[index++] = 1;
                i++;
                array[index++] = -1;
            }
        }
    }

    static void calcAnswer(int[] array){
        int index = 0;
        boolean check[] = new boolean[N << 1 + 1];

        while(true){
            index++;

            int num = array[index];
            if(num == 0) break;
            else if(num == -1) continue;

            if(array[index - 1] == -1 && check[index - 1] == false){
                check[index - 1] = true;
                answer++;
            }
            else if(array[index + 1] == -1 && check[index + 1] == false){
                check[index + 1] = true;
                answer++;
            }        
        }
    }
}