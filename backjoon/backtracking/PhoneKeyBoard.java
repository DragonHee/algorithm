package backjoon.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

// 휴대폰 자판을 눌렀을 때
// 만들 수 있는 문자열 조합을 백트래킹으로 구현한다.
// 2 -> ABC
// 3 -> DEF
// 4 -> GHI
// 5 -> JKL
// 6 -> MNO
// 7 -> PQRS
// 8 -> YUV
// 9 -> WXYZ

public class PhoneKeyBoard {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static HashMap<Integer, char[]> map = new HashMap<>();
    static int inputlength = 3;
    static int count;
    public static void main(String[] arsgs) throws IOException{
        
        // KEY - VALUE 형태로 데이터 저장
        map.put(2, new char[]{'A','B','C'});
        map.put(3, new char[]{'D','E','F'});
        map.put(4, new char[]{'G','H','I'});
        map.put(5, new char[]{'J','K','L'});
        map.put(6, new char[]{'M','N','O'});
        map.put(7, new char[]{'P','Q','R', 'S'});
        map.put(8, new char[]{'Y','U','V'});
        map.put(9, new char[]{'W','X','Y','Z'});

        System.out.print("input number (3자리, 2~9만): ");

        String input = br.readLine();

        solve(input);
        System.out.println("총 갯수 : " + count);
    }      

    static void solve(String input){
        String answer = "";
        
        int num = Integer.parseInt(input.substring(0, 1));
        char[] arr = map.get(num);

        for(int i = 0 ; i < arr.length; i++){
            char c = arr[i];
            backTrack(input, answer + c, 1);
        }
    }

    static void backTrack(String input, String answer, int length){
        if(length == 3){
            System.out.println(answer);
            count++;
            return;
        }

        int num = Integer.parseInt(input.substring(length, length + 1));
        char[] arr = map.get(num);

        for(int i = 0 ; i < arr.length; i++){
            char c = arr[i];
            backTrack(input, answer + c, length + 1);
        }
    }
}
