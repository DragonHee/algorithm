package backjoon.bruteforce;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Backjoon2798 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Integer> cardDeck = new ArrayList<Integer>();
        int best = 300000;
        int sum = 0;

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < n; i++){
            cardDeck.add(Integer.parseInt(st.nextToken()));
        }
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < n; j++){
                if(j == i) continue;
                for(int k = 0 ; k < n; k++){
                    if(k == i || k == j) continue;
                    sum =  cardDeck.get(i) + cardDeck.get(j) + cardDeck.get(k);
                    if(Math.abs(m-sum) < Math.abs(m - best) && sum <= m){
                        best = sum;
                    }
                }
            }
        }
        bw.write(best + "\n");
        br.close();
        bw.close();
    }
}
