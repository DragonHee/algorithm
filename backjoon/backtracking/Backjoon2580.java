package backjoon.backtracking;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;
class Point{
    int row, col;
    public Point(int row, int col){this.row = row; this.col = col;}
}
public class Backjoon2580 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int[][] arr = new int[10][10];
    private static ArrayList<Point> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        StringTokenizer st;

        for(int i = 1; i <= 9; i++){
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= 9; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if(arr[i][j] == 0) list.add(new Point(i, j));
            }
        }
        solve(0);

        bw.close();
        br.close();
    }
    private static int solve(int index) throws IOException {
        if(index == list.size()) {
            for(int i = 1; i <= 9; i++){
                for(int j = 1; j <= 9; j++) bw.write(arr[i][j] + " ");
                bw.write("\n");
            }
            return 1;
        }
        for(int i = 1; i <= 9; i++){
            if(isPossible(index, i)){
                arr[list.get(index).row][list.get(index).col] = i;
                if(solve(index + 1) == 1) return 1;
                arr[list.get(index).row][list.get(index).col] = 0;
            }
        }
        return 0;
    }
    private static boolean isPossible(int listIndex, int num){
        int row = list.get(listIndex).row;
        int col = list.get(listIndex).col;

        for(int i = 1; i <= 9; i++){
            if(col != i) if(arr[row][i] == num) return false;
            if(row != i) if(arr[i][col] == num) return false;
        }

        for(int i = ((row - 1) / 3) * 3 + 1; i <= ((row - 1) / 3) * 3 + 3; i++){
            for(int j = ((col - 1) / 3) * 3 + 1; j <= ((col - 1) / 3) * 3 + 3; j++){
                if(i != row && j != col) if(arr[i][j] == num) return false;
            }
        }

        return true;
    }
}
