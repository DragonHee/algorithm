package backjoon.samsung_sw_test;

import java.io.*;
import java.util.*;

public class Backjoon15685 {
    static class Index{
        int x, y, dir, gen;
        public Index(int x, int y, int dir, int gen){
            this.x = x;
            this.y = y;
            this.dir = dir;
            this.gen = gen;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    static int N;
    static ArrayList<Index> list = new ArrayList<>();
    static boolean[][] graph;

    static int[] xArr = new int[]{1,0,-1,0};
    static int[] yArr = new int[]{0,-1,0,1};

    static int answer;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        graph = new boolean[101][101];

        for(int i = 0; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int gen = Integer.parseInt(st.nextToken());

            list.add(new Index(x, y, dir, gen));
        }
        
        solve();

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }

    static void solve(){
        paintGraph();
        calcAnswer();
    }

    static void paintGraph(){
        for(int i = 0 ; i < list.size(); i++){
            Index idx = list.get(i);

            int x = idx.x;
            int y = idx.y;
            int dir = idx.dir;
            int gen = idx.gen;
            
            paint(x, y, dir, gen);
        }
    }

    static void paint(int x, int y, int dir, int gen){
        int curGen = 0;    

        List<Integer> dirList = new ArrayList<>();
        dirList.add(dir);

        while(gen > curGen++){
            int size = dirList.size();

            for(int i = size - 1 ; i >= 0; i--){
                dirList.add((dirList.get(i) + 1) % 4); 
            }
        }

        graph[y][x] = true;

        for(int i = 0 ; i < dirList.size(); i++){
            int toDir = dirList.get(i);
            int toX = x + xArr[toDir];
            int toY = y + yArr[toDir];

            graph[toY][toX] = true;

            x = toX;
            y = toY;
        }
    }

    static void calcAnswer(){
        int count = 0;

        for(int i = 0; i < 100; i++){
            for(int j = 0 ; j < 100; j++){
                if(graph[i][j] == true 
                && graph[i][j + 1] == true 
                && graph[i + 1][j] == true 
                && graph[i + 1][j + 1] == true)
                 count++;
            }
        }

        answer = count;
    }
    
}
