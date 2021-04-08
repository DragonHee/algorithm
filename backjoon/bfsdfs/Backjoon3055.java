package backjoon.bfsdfs;

import java.io.*;
import java.util.*;

public class Backjoon3055 {
    static class Index{
        int row;
        int col;
        int count;

        public Index(int row, int col, int count){
            this.row = row;
            this.col = col;
            this.count = count;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int R,C;
    static char[][] map;
    static boolean[][] waterVisit;
    static boolean[][] hedgehogVisit;
    static final String KAKTUS = "KAKTUS";
    static int startRow, startCol, endRow, endCol;
    static int[] rowArr = new int[]{0,1,0,-1};
    static int[] colArr = new int[]{1,0,-1,0};
    static ArrayList<Index> waterList = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        // 배열 생성
        map = new char[R + 1][C  + 1];
        waterVisit = new boolean[R + 1][C + 1];
        hedgehogVisit = new boolean[R + 1][C + 1];


        for(int i = 1; i <= R; i++){
            String input = br.readLine();
            for(int j = 1; j <= C; j++){
                char ch = input.charAt(j - 1);
                map[i][j] = ch;
                if(ch == 'D'){
                    endRow = i;
                    endCol = j;
                }else if(ch == 'S'){
                    startRow = i;
                    startCol = j;
                }else if(ch == '*'){
                    waterList.add(new Index(i, j, 0));
                }
            }
        }

        
        solve();

        bw.close();
        br.close();
    }

    static void solve() throws IOException{
        Queue<Index> waterQueue = new LinkedList<>();

        if(!waterList.isEmpty()){
            for(Index idx : waterList){
                waterQueue.add(idx);
                waterVisit[idx.row][idx.col] = true;
            }
        }

        Queue<Index> hedgeQueue = new LinkedList<>();
        hedgeQueue.add(new Index(startRow, startCol, 0));
        hedgehogVisit[startRow][startCol] = true;

        while(true){
            if(!waterQueue.isEmpty()) waterBfs(waterQueue);

            int result = hedgeBfs(hedgeQueue);
            if(result == 1) {
                bw.write(hedgeQueue.peek().count + "\n");
                break;
            }else if(result == -1){
                bw.write(KAKTUS + "\n");
                break;
            }
        }
    }

    static void waterBfs(Queue<Index> queue){
        int curCount = queue.peek().count;

        while(!queue.isEmpty()){
            int count = queue.peek().count;
            if(count != curCount) break;

            Index idx = queue.poll();
            int fromRow = idx.row;
            int fromCol = idx.col;
            int fromCount = idx.count;

            for(int i = 0 ; i < rowArr.length; i++){
                int toRow = fromRow + rowArr[i];
                int toCol = fromCol + colArr[i];
                int toCount = fromCount + 1;

                if(toRow < 1 || toRow > R || toCol < 1 || toCol > C) continue;
                if(hedgehogVisit[toRow][toCol] == true) continue;
                if(waterVisit[toRow][toCol] == true) continue;
                if(map[toRow][toCol] != '.') continue;

                queue.add(new Index(toRow, toCol, toCount));
                hedgehogVisit[toRow][toCol] = true;
            }
        }
    }

    // 굴을 찾은 경우 1 리턴
    // 갈 곳이 없는 경우 -1 리턴
    // 일반적인 경우 0 리턴
    static int hedgeBfs(Queue<Index> queue){
        int curCount = queue.peek().count;

        while(!queue.isEmpty()){
            int count = queue.peek().count;
            if(count != curCount) return 0;
            if(queue.peek().row == endRow && queue.peek().col == endCol) return 1;

            Index idx = queue.poll();
            int fromRow = idx.row;
            int fromCol = idx.col;
            int fromCount = idx.count;


            for(int i = 0 ; i < rowArr.length; i++){
                int toRow = fromRow + rowArr[i];
                int toCol = fromCol + colArr[i];
                int toCount = fromCount + 1;

                if(toRow < 1 || toRow > R || toCol < 1 || toCol > C) continue;
                if(hedgehogVisit[toRow][toCol] == true) continue;
                if(waterVisit[toRow][toCol] == true) continue;
                if(map[toRow][toCol] != '.' && map[toRow][toCol] != 'D') continue;

                queue.add(new Index(toRow, toCol, toCount));
                waterVisit[toRow][toCol] = true;
            }
        }

        return -1;
    }
}
