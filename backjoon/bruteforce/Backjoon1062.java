package backjoon.bruteforce;

import java.util.*;
import java.io.*;

public class Backjoon1062 {
    // 입출력을 위한 객체
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    // A_NUM = 'a' - 'a', C_NUM = 'c' - 'a' ....
    // 배열의 인덱스를 나타낼 상수
    private static final int A_NUM = 0, C_NUM = 2, I_NUM = 8, N_NUM = 13, T_NUM = 19;
    // 소문자 영단어의 갯수
    private static final int TOT_CH_NUM = 26;

    static int N, K;
    // 입력된 단어들의 모음
    static List<String> list = new ArrayList<String>();
    // 백트래킹을 통해 가르친 단어정보를 저장할 배열(조합된 정보)
    static boolean[] check = new boolean[TOT_CH_NUM];
    // 가르쳐야 할 단어의 정보를 저장할 배열
    static boolean[] checkArr = new boolean[TOT_CH_NUM];
    // 가르쳐야 할 총 단어의 갯수
    static int teachTotCount;
    // 답
    static int result;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        for(int i = 0 ; i < N; i++){
            // 단어 입력
            String input = br.readLine();
            // 입력된 단어의 필요한 부분한 자름
            // 맨앞 4글자, 맨뒤 4글자는 필요 없음
            input = input.substring(4, input.length() - 4);
            // list에 추가
            list.add(input);

            // 입력된 단어의 각 문자 조사
            for(int j = 0 ; j < input.length(); j++){
                // j번째 index의 문자
                char ch = input.charAt(j);
                // ch를 숫자로 변환
                int chInt = ch - 'a';
                // 맨앞 4글자, 맨뒤 4글자와 같지 않은 경우
                // a, c, i, n, t의 경우 생각하지 않는다.
                if(chInt != A_NUM && chInt != C_NUM && chInt != I_NUM && chInt != N_NUM && chInt != T_NUM) {
                    // 가르쳐야 할 단어 정보 업데이트
                    if(checkArr[chInt] == false){
                        checkArr[chInt] = true;
                        // 총 가르쳐야 할 단어 갯수 증가
                        teachTotCount++;
                    } 
                }
            }
        }

        // a, c, i, n, t는 제외하고 생각
        K -= 5;

        // 어떠한 문장도 불가한 경우 
        // result <- 0을 저장하고 끝냄
        if(K < 0) result = 0;
        else{
            // 가르쳐야할 문자 갯수 < K 경우
            // 모든 문장을 읽을 수 있으므로 result <- N을 저장하고 끝냄
            if(K >= teachTotCount) result = N;
            else solve();
        }

        bw.write(result + "\n");
        bw.close();
        br.close();
    }

    static void solve(){
        check[A_NUM] = true;
        check[C_NUM] = true;
        check[I_NUM] = true;
        check[N_NUM] = true;
        check[T_NUM] = true;

        confirmCheck(0, 0);
    }

    // 백트래킹을 통해 현재 가르킨 단어를 조합함
    static void confirmCheck(int curIndex, int count){
        if(count == K){
            result = Math.max(result, getReadableCount());
            return;
        }

        for(int i = curIndex; i < TOT_CH_NUM; i++){
            if(checkArr[i] == false) continue;

            check[i] = true;
            confirmCheck(i + 1, count + 1);
            check[i] = false;
        }
    }

    // 읽을 수 있는 단어의 갯수를 반환하는 메소드
    static int getReadableCount(){
        int tot = 0;

        for(int i = 0 ; i < list.size(); i++){
            // 단어의 각 문자를 뽑음
            String str = list.get(i);
            boolean res = true;
            for(int j = 0; j < str.length(); j++){
                // 가르치지 않은 경우
                if(check[str.charAt(j) - 'a'] == false) {
                    res = false;
                    break;
                }
            }
            // 가르치지 않은 문자가 없는 경우만
            // 단어를 읽을 수 있다는 뜻이므로 tot를 증가시킨다.
            if(res == true) tot++;
        }

        return tot;
    }
}
