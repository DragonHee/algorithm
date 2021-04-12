package backjoon.bfsdfs;

import java.io.*;
import java.util.*;

public class Backjoon14226 {
    static class Element {
        int count;
        int clipCount;
        int length;

        public Element(int count, int clipCount, int length){
            this.count = count;
            this.clipCount = clipCount;
            this.length = length;
        }
    }

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static final int MAX = 1000;
    static boolean checkArr[][];

    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        int result = solve();

        bw.write(result + "\n");
        bw.close();
        br.close();
    }
    
    static int solve(){
        Element elmt = new Element(1, 0, 0);
        Queue<Element> queue = new LinkedList<>();

        checkArr = new boolean[MAX + 1][MAX + 1];

        queue.add(elmt);
        
        while(!queue.isEmpty()){
            Element curElmt = queue.poll();
            int curCount = curElmt.count;
            int curClipCount = curElmt.clipCount;
            int curLength = curElmt.length;
            
            // 정답을 찾은 경우 
            // 소요 시간을 반환함.
            if(curCount == N) return curLength;

            // 지우기
            // 지울 count가 있음 && 미 방문점인 경우
            if(curCount > 1 && checkArr[curCount - 1][curClipCount] == false){
                checkArr[curCount - 1][curClipCount] = true;
                queue.add(new Element(curCount - 1, curClipCount, curLength + 1));
            }

            // 복사
            // 미 방문점
            if(checkArr[curCount][curCount] == false){
                checkArr[curCount][curCount] = true;
                queue.add(new Element(curCount, curCount, curLength + 1));
            }

            // 붙이기
            // 붙일 곳이 MAX 이하 && 클립보드 != 0 && 미 방문점
            if(curCount + curClipCount <= MAX && curClipCount != 0 && checkArr[curCount + curClipCount][curClipCount] == false){
                checkArr[curCount + curClipCount][curClipCount] = true;
                queue.add(new Element(curCount + curClipCount, curClipCount, curLength + 1));
            }
        }
        
        // 갈 수 없는 경우
        return -1;
    }
}
