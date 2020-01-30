package backjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Backjoon2667 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n;
    static int[][] arr;
    static boolean[][] check;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        arr = new int[n + 1][n + 1];
        check = new boolean[n + 1][n + 1];
        // 단지 별 집의 개수를 저장하는 list
        List<Integer> list = new ArrayList<>();

        // input값을 배열에 저장
        for(int i = 1; i <= n; i++){
            String input = br.readLine();
            for(int j = 1; j <= n; j++){
                arr[i][j] = input.charAt(j - 1) - '0';
            }
        }

        // 깊이우선 탐색 진행
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(checkLocation(i, j)) {
                    // 단지번호를 뜻함
                    int val = dfs(i, j);
                    list.add(val);
                }
            }
        }

        Collections.sort(list);
        sb.append(list.size() + "\n");
        for(int num : list) sb.append(num + "\n");

        System.out.println(sb);
    }
    public static int dfs(int x, int y){
        // 단지 별 집의 개수
        int val = 1;
        check[x][y] = true;

        // '상'의 좌표
        if(checkLocation(x - 1, y)) val += dfs(x - 1, y);
        // '우'의 좌표
        if(checkLocation(x, y + 1)) val += dfs(x, y + 1);
        // '하'의 좌표
        if(checkLocation(x + 1, y)) val += dfs(x + 1, y);
        // '좌'의 좌표
        if(checkLocation(x, y - 1)) val += dfs(x, y - 1);

        return val;
    }
    public static boolean checkLocation(int x, int y){
        //좌표 값이 잘못된 경우
        if(x < 1 || x > n || y < 1 || y > n) return false;
        //이미 지나간 경로인 경우 || 집이 아닌 경우
        if(check[x][y] == true || arr[x][y] == 0) return false;
        return true;
    }
}
