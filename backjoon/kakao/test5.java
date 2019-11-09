package backjoon.kakao;

public class test5 {
    public static void main(String[] args) {
        int[] stones = new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1};
        int k = 3;
        System.out.println(solution(stones, k));
    }
    public static int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;

        for(int i = 0; i < stones.length - (k - 1); i++){
            int[] arr = new int[k];
            for(int j = 0 ; j < k; j++){
                arr[j] = stones[i + j];
            }
            int min = max(arr);
            answer = Math.min(min, answer);
        }

        return answer;
    }
    public static int max(int ... v){
        int max = Integer.MIN_VALUE;
        for(int a : v) max = Math.max(max, a);
        return max;
    }
}
