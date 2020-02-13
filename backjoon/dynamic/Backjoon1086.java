package backjoon.dynamic;

import java.io.*;

public class Backjoon1086 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int MAX_LENGTH = 51;
    static int n, k;
    static String input[];
    static int length[], arr[];
    static long dp[][];
    static int ten[];

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());

        input = new String[n];
        length = new int[n];
        arr = new int[n];
        ten = new int[MAX_LENGTH];

        for(int i = 0; i < n; i++) {
            input[i] = br.readLine();
            length[i] = input[i].length();
        }

        k = Integer.parseInt(br.readLine());
        dp = new long[1 << n][k];

        // 10^x 를 k로 나눴을 때의 나머지
        ten[0] = 1;
        for(int i = 1; i < MAX_LENGTH; i++) {
            ten[i] = (ten[i - 1] * 10);
            ten[i] %= k;
        }

        // 입력된 수의 길이가 최대 50이기 때문에
        // 이 수 자체가 필요하지 않고 나머지와 길이만 필요하다.
        for(int i = 0 ; i < n; i++){
            for(int j = 0 ; j < input[i].length(); j++){
                arr[i] = arr[i] * 10 + (input[i].charAt(j) - '0');
                arr[i] %= k;
            }
        }

        dp[0][0] = 1;
        solve();

        // 나머지가 0인 갯수
        long ans1 = dp[(1 << n) - 1][0];
        // 총 수열의 갯수
        long ans2 = fac(n);
        // ans1, ans2의 최대공약수
        long gcd = gcd(ans1, ans2);

        bw.write((ans1 / gcd) + "/" + (ans2/gcd));

        bw.close();
        br.close();
    }

    private static void solve(){
        for(int state = 0 ; state < (1 << n); state++){
            for(int remain = 0; remain < k; remain++){
                if(dp[state][remain] > 0) {
                    for (int move = 0; move < n; move++) {
                        // 이미 방문인 경우
                        if((state & (1 << move)) > 0) continue;

                        // 다음 노드를 선택 했을 때 나머지
                        int nextRemain;
                        // 다음 노드를 선택 했을 때 state
                        int nextState;

                        // 원래 나머지값
                        nextRemain = remain;
                        // * 다음 노드의 숫자가 10의 몇승인지
                        nextRemain *= ten[length[move]];
                        // + 다음 노드의 숫자의 나머지
                        nextRemain += arr[move];
                        // k로 나눈 나머지
                        nextRemain %= k;

                        nextState = state | (1 << move);
                        dp[nextState][nextRemain] += dp[state][remain];
                    }
                }
            }
        }
    }

    private static long gcd(long a, long b){
        if(b == 0) return a;
        return gcd(b, a % b);
    }

    private static long fac(int a){
        if(a == 1) return 1;
        return a * fac(a - 1);
    }
}
