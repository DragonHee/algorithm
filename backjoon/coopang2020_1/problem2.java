package backjoon.coopang2020_1;

class Info{
    int total;
    int cnt;

    public Info(int total, int cnt){
        this.total = total;
        this.cnt = cnt;
    }
}
public class problem2 {
    static int dp[];
    static int length;
    static int answer = 0;

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2,5,3,4,1}, 3, 11));
//        System.out.println(solution(new int[]{1,1,2,2}, 2, 3));
//        System.out.println(solution(new int[]{1,2,3,2}, 2, 2));
    }

    public static int solution(int[] arr, int k, int  t){
        length = arr.length;

        dp = new int[1 << length];

        solve(0, 0, k, t, arr);

        return answer;
    }

    private static void solve(int visit, int cnt, int k, int t, int[] arr) {
        if(dp[visit] > t){
            return;
        }else if(dp[visit] <= t && cnt >= k) {

            answer++;
        }


        for(int i = 0; i < length; i++){
            int nextVisit = visit | (1 << i);
            if((visit & (1 << i)) > 0) continue;
            if(dp[nextVisit] != 0) continue;

            dp[nextVisit] = dp[visit] + arr[i];
            solve(nextVisit, cnt + 1, k, t, arr);
        }




    }
}
