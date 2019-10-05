import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon1157 {
    private static final int ALPHA_CNT = 26;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] charNum = new int[ALPHA_CNT];
        int length;
        int max = 0;
        char answer = '?';

        String message = br.readLine().toUpperCase();

        for(int i = 0 ; i < message.length(); i++){
           int cnt = ++charNum[message.charAt(i) - 'A'];
           if(max < cnt){
               max = cnt;
               answer = message.charAt(i);
           }
           else if(max == cnt){
               answer = '?';
           }
        }

        System.out.println(answer);
    }
}
