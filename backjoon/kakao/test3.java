package backjoon.kakao;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class test3 {
    private static int answer;
    static ArrayList<StringBuilder> list;
    static boolean[] check;
    public static void main(String[] args) {
        String[] user_id1 = new String[]{"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] user_id2 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String[] user_id3 = {"frodo", "fradi", "crodo", "abc123", "frodoc"};

        String[] bannid1 = {"fr*d*", "abc1**"};
        String[] bannid2 = {"*rodo", "*rodo", "******"};
        String[] bannid3 = {"fr*d*", "*rodo", "******", "******"};

        System.out.println(solution(user_id1, bannid3));
    }
    public static int solution(String[] user_id, String[] banned_id) {
        int[] banMap = new int[banned_id.length];
        int[] userMap = new int[user_id.length];

        for(int i = 0 ; i < banned_id.length; i++){
            for(int j = 0 ; j < user_id.length; j++){
                if(isPossible(user_id[j], banned_id[i])) {
                    banMap[i]++;
                    userMap[j]++;
                }
            }
        }

        return answer;
    }

    public static boolean isPossible(String user, String bann){
        if(user.length() != bann.length()) return false;
        for(int i = 0 ; i < bann.length(); i++){
            if(bann.charAt(i) != '*') if(bann.charAt(i) != user.charAt(i)) return false;
        }
        return true;
    }

    public static int combi(int n, int r){
        if(r==0 || r==n)
            return 1;
        else
            return combi(n-1, r-1) + combi(n-1, r);
    }
}
