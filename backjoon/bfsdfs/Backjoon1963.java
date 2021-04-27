package backjoon.bfsdfs;

import java.io.*;
import java.util.*;


public class Backjoon1963 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int T;
    static int numA, numB;

    public static void main(String[] args) throws IOException{
        T = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            numA = Integer.parseInt(st.nextToken());
            numB = Integer.parseInt(st.nextToken());

            int answer = solve();

            bw.write(answer == -1 ? "Impossible" : answer + "\n");
        }

        bw.close();
        br.close();
    }

    static int solve(){
        boolean check[] = new boolean[10000];
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> depthQueue = new LinkedList<>();

        queue.add(numA);
        depthQueue.add(0);
        check[numA] = true;

        while(!queue.isEmpty()){
            int num = queue.poll();
            int depth = depthQueue.poll();

            if(num == numB){
                return depth;
            }

            for(int i = 1; i <= 4; i++){
                for(int j = 0; j <= 9; j++){
                    int toNum = 0;
                    int toDepth = depth + 1;
                    if(i == 1){
                        toNum = num - (num % 10) + j;
                    }
                    else if(i == 2){
                        toNum = num - (num % 100) + 10 * j + num % 10;
                    }
                    else if(i == 3){
                        toNum = num - (num % 1000) + 100 * j + num % 100;
                    }
                    else if(i == 4 && j >= 1){
                        toNum = num % 1000 + j * 1000;
                    }
                    if(isPrimeNum(toNum) == false) continue;
                    if(check[toNum] == true) continue;

                    check[toNum] = true;
                    queue.add(toNum);
                    depthQueue.add(toDepth);
                }
            }
        }

        // 못찾은 경우
        return -1;
    }
    
    static boolean isPrimeNum(int num){
        int limit = (int)Math.sqrt(num);

        for(int i = 2; i <= limit; i++){
            if(num % i == 0){
                return false;
            }
        }

        if(num <= 1) return false;
        return true;
    }
}
