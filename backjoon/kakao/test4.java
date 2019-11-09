package backjoon.kakao;

import java.util.ArrayList;

public class test4 {
    public static void main(String[] args) {
        int k = 10;
        long [] room_number = new long[]{1,3,4,1,3,1};

        long[] ans = solution(k, room_number);

        for(long l : ans){
            System.out.println(l);
        }

    }

    public static long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];

        for(int i = 0 ; i < room_number.length; i++){
            boolean flag = true;
            for(int j = 0 ; j <= i; j++){
                if(room_number[i] == answer[j]) {
                    flag = false;
                    break;
                }
            }
            if(flag == false){
                long num = room_number[i];
                while(true){
                    num += 1;
                    for(int j = 0 ; j <= i; j++){
                        if(num == answer[j]) {
                            flag = false;
                            break;
                        }
                    }
                    if(flag == true){
                        answer[i] = num;
                        break;
                    }
                }
            }
            else{
                answer[i] = room_number[i];
            }

            answer[i] = room_number[i];
        }


        return answer;
    }
}
