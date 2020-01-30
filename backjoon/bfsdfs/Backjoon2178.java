package backjoon.bfsdfs;


import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Location{
    int row, col;
    public Location(int row, int col) {this.row = row; this.col = col;}
}

public class Backjoon2178 {
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int arr[][];
    static int isVisit[][];
    static int n, m;

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m + 1];
        isVisit = new int[n + 1][m + 1];

        for(int i = 1; i <= n; i++){
            String input = br.readLine();
            for(int j = 1; j <= m; j++) {
                arr[i][j] = input.charAt(j - 1) - '0';
            }
        }
        bfs();
    }

    public static void bfs(){
        Queue<Location> queue = new LinkedList<>();
        queue.add(new Location(1,1));
        int[] xArr = {-1, 0, 1, 0};
        int[] yArr = {0, 1, 0, -1};
        isVisit[1][1] = 1;

        while(!queue.isEmpty()){
            Location location = queue.poll();
            int row = location.row;
            int col = location.col;

            for(int i = 0 ; i < 4; i++){
                int x = row + xArr[i];
                int y = col + yArr[i];

                if(checkLocation(x, y)){
                    queue.add(new Location(x, y));
                    isVisit[x][y] = isVisit[row][col] + 1;
                }
            }
        }
        System.out.println(isVisit[n][m]);
    }


    public static boolean checkLocation(int row, int col){
        // 노드가 범위 밖인 경우
        if(row < 1 || row > n || col < 1 || col > m) return false;
        // 이미 방문한 노드인 경우
        if(isVisit[row][col] != 0 || arr[row][col] == 0) return false;
        return true;
    }
}
