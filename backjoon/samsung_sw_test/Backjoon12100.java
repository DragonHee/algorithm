package backjoon.samsung_sw_test;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Backjoon12100 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); 
    static int N, result;
    static int[][] graph;
    static final int MAX_COUNT = 5;

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        graph = new int[N + 1][N + 1];

        for(int i = 1 ; i <= N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        solve();

        bw.write(result + "\n");
        bw.close();
        br.close();
    }

    static void solve(){
        int count = 0;
        int[] visit = new int[5];


        for(int i = 0 ; i < 4; i++){
            visit[count] = i;
            combination(count + 1, visit);
        }
    }

    static void combination(int count, int[] visit){
        hap(visit, count);
        if(count >= MAX_COUNT) return;

        for(int i = 0 ; i < 4; i++){
            visit[count] = i;
            combination(count + 1, visit);
        }
    }

    static void hap(int[] visit, int count){
        int[][] copyGraph = new int[N + 1][N + 1];

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                copyGraph[i][j] = graph[i][j];
            }
        }

        for(int i = 0 ; i < count; i++){
            int dir = visit[i];
            reArrang(copyGraph, dir);

            if(dir == 0){
                for(int r = 1; r <= N; r++){
                    for(int c = N; c > 1; c--){
                        if(copyGraph[c][r] == 0) continue;

                        if(copyGraph[c][r] == copyGraph[c - 1][r]){
                            copyGraph[c][r] <<= 1;
                            copyGraph[c - 1][r] = 0;
                        }
                    }
                }
            }
            else if(dir == 1){
                for(int r = 1; r <= N; r++){
                    for(int c = 1; c < N; c++){
                        if(copyGraph[r][c] == 0) continue;

                        if(copyGraph[r][c] == copyGraph[r][c + 1]){
                            copyGraph[r][c] <<= 1;
                            copyGraph[r][c + 1] = 0;
                        }
                    }
                }
            }
            else if(dir == 2){
                for(int r = 1; r <= N; r++){
                    for(int c = 1; c < N; c++){
                        if(copyGraph[c][r] == 0) continue;

                        if(copyGraph[c][r] == copyGraph[c + 1][r]){
                            copyGraph[c][r] <<= 1;
                            copyGraph[c + 1][r] = 0;
                        }
                    }
                }
            }
            else if(dir == 3){
                for(int r = 1; r <= N; r++){
                    for(int c = N; c > 1; c--){
                        if(copyGraph[r][c] == 0) continue;

                        if(copyGraph[r][c] == copyGraph[r][c - 1]){
                            copyGraph[r][c] <<= 1;
                            copyGraph[r][c - 1] = 0;
                        }
                    }
                }
            }
            reArrang(copyGraph, dir);
        }
        int max = 0;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                max = Math.max(max, copyGraph[i][j]);
            }
        }

        result = Math.max(max, result);
    }

    static void reArrang(int[][] graph, int dir){
        if(dir == 0){
            for(int i = 1; i <= N; i++){
                ArrayList<Integer> list = new ArrayList<>();

                for(int j = N; j >= 1; j--){
                    if(graph[j][i] != 0) {
                        list.add(graph[j][i]);
                        graph[j][i] = 0;
                    }
                }
                for(int j = 0; j < list.size(); j++){
                    graph[N - j][i] = list.get(j);
                }
            }
        }
        else if(dir == 1){
            for(int i = 1; i <= N; i++){
                ArrayList<Integer> list = new ArrayList<>();

                for(int j = 1; j <= N; j++){
                    if(graph[i][j] != 0) {
                        list.add(graph[i][j]);
                        graph[i][j] = 0;
                    }   
                }
                for(int j = 0; j < list.size(); j++){
                    graph[i][j + 1] = list.get(j);
                }
            }
        }
        else if(dir == 2){
            for(int i = 1; i <= N; i++){
                ArrayList<Integer> list = new ArrayList<>();

                for(int j = 1; j <= N; j++){
                    if(graph[j][i] != 0) {
                        list.add(graph[j][i]);
                        graph[j][i] = 0;
                    }
                }
                for(int j = 0; j < list.size(); j++){
                    graph[j + 1][i] = list.get(j);
                }
            }
        }
        else if(dir == 3){
            for(int i = 1; i <= N; i++){
                ArrayList<Integer> list = new ArrayList<>();

                for(int j = N; j >= 1; j--){
                    if(graph[i][j] != 0) {
                        list.add(graph[i][j]);
                        graph[i][j] = 0;
                    }
                }
                for(int j = 0; j < list.size(); j++){
                    graph[i][N - j] = list.get(j);
                }
            }
        }
    }
}
  