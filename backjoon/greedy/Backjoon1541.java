package backjoon.greedy;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Backjoon1541 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input = '+' + br.readLine();
        char ch;
        int num = 0;
        int ans = 0;
        List<Integer> numList = new ArrayList<Integer>();
        List<Character> operationList = new ArrayList<Character>();

        for(int i = 0; i < input.length(); i++){
            ch = input.charAt(i);
            if(ch == '+' || ch == '-') {
                operationList.add(ch);
                numList.add(num);
                num = 0;
            }else{
                num = num * 10 + (ch - '0');
            }
        }
        numList.add(num);
        numList.remove(0);

        int check = operationList.indexOf('-');
        if(check == -1) check = 50;
        for(int i = 0 ; i < numList.size(); i++) {
            if(i >= check) ans -= numList.get(i);
            else ans += numList.get(i);
        }
        bw.write(ans + "\n");
        bw.close();
        br.close();
    }
}
