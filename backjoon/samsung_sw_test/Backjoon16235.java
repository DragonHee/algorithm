package backjoon.samsung_sw_test;

import java.util.*;
import java.io.*;

public class Backjoon16235 {
    static class Tree{
        int row, col;
        int age;

        public Tree(int age, int row, int col){
            this.row = row;
            this.col = col;
            this.age = age;
        }
    }
    static final int rowArr[] = new int[]{1,1,0,-1,-1,-1,0,1};
    static final int colArr[] = new int[]{0,-1,-1,-1,0,1,1,1};
    
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int N, M, K;
    static int plusGraph[][];
    static int graph[][];
    static Deque<Tree> treeArray = new ArrayDeque<>(), deadArray = new ArrayDeque<>();
    static int answer;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        graph = new int[N][N];
        plusGraph = new int[N][N];
        for(int i = 0 ; i < N; i++) Arrays.fill(graph[i], 5);

        for(int i = 0 ; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                plusGraph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i = 0 ; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            
            treeArray.add(new Tree(age, x - 1, y - 1));
        }

        solve();

        bw.write(treeArray.size() + "\n");
        bw.close();
        br.close();
    }

    static void solve(){
        int time = 0;

        while(time++ < K){
            timeFlow();
        }
    }

    static void timeFlow(){
        ArrayDeque<Tree> tempArray = new ArrayDeque<>();

        while(!treeArray.isEmpty()){
            Tree tree = treeArray.poll();
            int curRow = tree.row;
            int curCol = tree.col;

            // 봄
            if(tree.age > graph[curRow][curCol]) {
                deadArray.add(tree);
            }
            else {
                graph[curRow][curCol] -= tree.age;
                tree.age++;
                tempArray.add(tree);
            }
        }

        while(!deadArray.isEmpty()){
            Tree tree = deadArray.poll();
            int curRow = tree.row;
            int curCol = tree.col;

            graph[curRow][curCol] += tree.age / 2;
        }

        while(!tempArray.isEmpty()){
            Tree tree = tempArray.poll();

            // 가을
            if(tree.age % 5 == 0){
                for(int j = 0; j < rowArr.length; j++){
                    int toRow = tree.row + rowArr[j];
                    int toCol = tree.col + colArr[j];

                    if(toRow < 0 || toRow >= N || toCol < 0 || toCol >= N) continue;
                    else {
                        treeArray.addFirst(new Tree(1, toRow, toCol));
                    }
                }
            }
            treeArray.addLast(tree);
        }

        for(int i = 0 ; i < N; i++){
            for(int j = 0 ; j < N; j++){
                // 겨울
                graph[i][j] += plusGraph[i][j];
            }
        }
    }
}
