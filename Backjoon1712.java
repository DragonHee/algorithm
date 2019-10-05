

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon1712 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        int a, b, c, answer;
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, " ");

        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        answer = calcAnswer(a, b, c);
        System.out.println(answer);
    }
    private static int calcAnswer(int extraCost, int produceCost, int salesCost){
        int answer = 0;
        int benefitPerSale = salesCost - produceCost;
        if(benefitPerSale <= 0) return -1;
        else{
            while(true){
                extraCost -= benefitPerSale;
                answer++;
                if(extraCost < 0) break;
            }
            return answer;
        }
    }
}
