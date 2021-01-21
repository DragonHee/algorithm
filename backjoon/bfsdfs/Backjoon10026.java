package backjoon.bfsdfs;

import java.io.*;
import java.util.*;

class Node5{
    int row;
    int col;
    char color;

    public Node5(int row, int col, char color){
        this.row = row;
        this.col = col;
        this.color = color;
    }
}
public class Backjoon10026 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static String[] graph;
    static boolean check[][];
    static int[] rowArr = new int[]{-1, 0, 1, 0};
    static int[] colArr = new int[]{0, 1, 0, -1};

    public static void main(String[] args)throws IOException{
        int answer1 = 0, answer2 = 0;
        N = Integer.parseInt(br.readLine());
        graph = new String[N + 1];
        check = new boolean[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            graph[i] = br.readLine();
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++)
            {
                if(check[i][j] == false){
                    bfs(i, j);
                    answer1++;
                }
            }
        }

        for(boolean[] a : check){
            Arrays.fill(a, false);
        }

        for(int i = 1; i <= N; i++){
            graph[i] = graph[i].replace("R", "G");
        }

        for(int i = 1; i <= N; i++){
            System.out.println(graph[i]);
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++)
            {
                if(check[i][j] == false){
                    bfs(i, j);
                    answer2++;
                }
            }
        }

        bw.write(answer1 + " " + answer2 + "\n");
        bw.close();
        br.close();
    }

    static void bfs(int row, int col){
        Queue<Node5> queue = new LinkedList<>();
        queue.add(new Node5(row, col, graph[row].charAt(col - 1)));
        check[row][col] = true;

        while(!queue.isEmpty()){
            Node5 curNode = queue.poll();
            int fromRow = curNode.row;
            int fromCol = curNode.col;
            char fromColor = curNode.color;

            for(int i= 0 ; i < rowArr.length; i ++){
                int toRow = fromRow + rowArr[i];
                int toCol = fromCol + colArr[i];

                if(toRow < 1 || toRow > N || toCol < 1 || toCol > N) continue;
                if(check[toRow][toCol] == true) continue;
                if(fromColor != graph[toRow].charAt(toCol - 1)) continue;

                queue.add(new Node5(toRow, toCol, fromColor));
                check[toRow][toCol] = true;
            }
        }
    }
    
}
