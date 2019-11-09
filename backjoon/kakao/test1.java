package backjoon.kakao;

import java.util.Stack;

public class test1 {
    public static void main(String[] args) {
        int[][] a = new int[][]{{0,0,0,0,0}, {0,0,1,0,3}, {0,2,5,0,1}, {4,2,4,4,2}, {3,5,1,3,1}};
        int[] m = new int[]{1,5,3,5,1,2,1,4};
        System.out.println(solution(a, m));
    }
    public static int solution(int[][] board, int[] moves){
        Stack<Integer> basket = new Stack<>();
        int ans = 0;
        for(int i = 0; i < moves.length; i++){
            int select;
            int row = 0;
            while(row < board.length){
                if(board[row][moves[i] - 1] != 0){
                    select = board[row][moves[i] - 1];
                    if(!basket.isEmpty() && basket.peek() == select){
                        ans += 2;
                        basket.pop();
                    }
                    else basket.push(select);
                    board[row][moves[i] - 1] = 0;
                    break;
                }
                row++;
            }
        }
        return ans;
    }
}
