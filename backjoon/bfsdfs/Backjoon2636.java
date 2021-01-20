package backjoon.bfsdfs;

import java.io.*;
import java.util.*;

class XY{
    int x;
    int y;

    public XY(int x, int y){
        this.x = x;
        this.y = y;
    }
}
public class Backjoon2636 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int ROW;
    static int COL;
    static int[][] graph;
    static boolean[][] check;
    static int[] rowArr = new int[]{-1, 0, 1, 0};
    static int[] colArr = new int[]{0, 1, 0, -1};
    static boolean checkLast;
    static int lastCnt;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        ROW = Integer.parseInt(st.nextToken());
        COL = Integer.parseInt(st.nextToken());

        graph = new int[ROW + 1][COL + 1];
        check = new boolean[ROW + 1][COL + 1];

        for(int i = 1; i <= ROW; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= COL; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = solve();

        bw.write(result + "\n");
        bw.write(lastCnt + "\n");
        bw.close();
        br.close();

    }

    static int solve(){
        int result = 0;

        while(true){
            
            for(int i = 2; i < ROW; i++){
                for(int j = 2; j < COL; j++){
                    if(graph[i][j] == 1){
                        for(int k = 0; k < rowArr.length; k++){
                            int toRow = i + rowArr[k];
                            int toCol = j + colArr[k];
                            
                            if(checkLoc(toRow, toCol) == true){
                                if(bfs(toRow, toCol) == true){
                                    graph[i][j] = 2;
                                    break;
                                }
                            }
                        }
                        
                    }
                }
            }

            if(setGraph() == true) result++;
            else break;



        }
        return result;
    }

    static boolean bfs(int row, int col){
        boolean result = false;

        for(int i = 0; i <= ROW; i++){
            Arrays.fill(check[i], false);
        }

        Queue<XY> queue = new LinkedList<>();
        queue.add(new XY(row, col));
        check[row][col] = true;

        while(!queue.isEmpty()){
            XY xy = queue.poll();

            for(int i = 0; i < rowArr.length; i++){
                int x = xy.x + rowArr[i];
                int y = xy.y + colArr[i];

                if(x == 1 || x == ROW || y == 1 || y == COL){
                    return true;
                }

                if(checkLoc(x, y) == true && check[x][y] == false){
                    queue.add(new XY(x, y));
                    check[x][y] = true;
                }
            }
        }

        return result;
        
    }

    static boolean checkLoc(int row, int col){
        if(graph[row][col] == 0) return true;
        else return false;
    }
    
    static boolean setGraph(){
        boolean result = false;
        checkLast = true;
        int cnt = 0;

        for(int i = 2; i < ROW; i++){
            for(int j = 2; j < COL; j++){
                if(graph[i][j] == 2){
                    graph[i][j] = 0;
                    result = true;
                    cnt++;
                }else if(graph[i][j] == 1){
                    checkLast = false;
                }
            }
        }

        if(checkLast = true && cnt != 0){
            lastCnt = cnt;
        }
        return result;
    }
}
