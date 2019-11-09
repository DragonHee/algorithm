package backjoon.kakao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class test2 {
    public static void main(String[] args) {
        String s1 = "{{2},{2,1},{2,1,3},{2,1,3,4}}";
        String s2 = "{{1,2,3},{2,1},{1,2,4,3},{2}}";
        String s3 = "{{20,111},{111}}";
        String s4 = "{{123}}";
        String s5 = "{{4,2,3},{3},{2,3,4,1},{2,3}}";

        int[] arr = solution(s4);
        for(int i : arr) System.out.print(i + " ");
    }

    public static int[] solution(String s) {
        int[] answer ={};
        ArrayList<Integer> list = new ArrayList<>();

        s = s.substring(2, s.length() - 2);
        String[] arr = s.split("},\\{");
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        for(String ss : arr){
            StringTokenizer st = new StringTokenizer(ss, ",");
            while(st.hasMoreTokens()){
                int num = Integer.parseInt(st.nextToken());
                if(list.size() == 0) list.add(num);
                else if(list.indexOf(num) == -1) list.add(num);
            }
        }
        answer = new int[list.size()];
        for(int i = 0 ; i < answer.length; i++) answer[i] = list.get(i);

        return answer;
    }
}
