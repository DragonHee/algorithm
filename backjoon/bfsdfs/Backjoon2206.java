package backjoon.bfsdfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
    int row, col;
    int breakCnt;

    public Node(int row, int col, int breakCnt){
        this.row = row;
        this.col = col;
        this.breakCnt = breakCnt;
    }
}

public class Backjoon2206 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int n, m;
    // 맵의 정보를 저장 할 배열
    static int[][] arr;
    // 최단 거리를 저장 할 배열
    static int[][] resultArr;
    // 해당 노드까지 왔을 때 벽을 부순 횟수를 저장 할 배열
    static int[][] breakCntArr;
    // 상하좌우 4방향을 표현 할 배열
    static int rowArr[] = {-1, 0, 1, 0}, colArr[] = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        arr = new int[n + 1][m + 1];
        resultArr = new int[n + 1][m + 1];
        breakCntArr = new int[n + 1][m + 1];

        // 벽을 부순 횟수를 2로 초기화 한다. 벽을 부순 횟수는 0, 1만 가능하기 때문에 2는 아직 방문하지 않았다는 것을 의미한다.
        for(int[] row : breakCntArr)
             Arrays.fill(row, 2);

        // 입력 값을 배열에 초기화한다.
        for(int i = 1; i <= n; i++){
            String input = br.readLine();
            for(int j = 1; j <= m; j++){
                arr[i][j] = input.charAt(j - 1) - '0';
            }
        }

        int result = bfs();
        System.out.println(result);
    }

    public static int bfs(){
        Queue<Node> queue = new LinkedList<>();
        // (1,1) 시작 노드를 큐에 추가하고 벽을 부순횟수는 0으로 초기화한다. 아직 벽을 부수지 않았기 때문
        queue.add(new Node(1,1, 0));
        resultArr[1][1] = 1;
        breakCntArr[1][1] = 0;

        while (!queue.isEmpty()){
            // 큐에서 노드를 꺼낸다.
            Node curNode = queue.poll();
            // 꺼낸 노드가 (m,n) 좌표일 경우 최단거리 값을 반환한다.
            if(curNode.row == n && curNode.col == m) return resultArr[n][m];

            for(int i = 0; i < 4; i++){
                // 상하좌우 노드의 행,열 값
                int row = curNode.row + rowArr[i];
                int col = curNode.col + colArr[i];

                // 벽인 경우
                if(isRightNode(row, col) && isWall(row, col)){
                    // 현재 노드가 부신 벽의 개수가 0일 경우만 실행
                    if(curNode.breakCnt == 0){
                        queue.add(new Node(row, col, 1));
                        resultArr[row][col] = resultArr[curNode.row][curNode.col] + 1;
                        // 벽을 만났으므로 벽을 부쉰 횟수는 1이 된다.
                        breakCntArr[row][col] = 1;
                    }
                // 벽이 아닌 경우
                }else if(isRightNode(row, col) && !isWall(row, col)){
                    // 이동할 노드의 벽을 부신 횟수가 1인경우 : 현재 노드가 벽을 부신 횟수가 0인 경우만 큐에 추가
                    // 이동할 노드의 벽을 부신 횟수가 2인경우 : 미방문이므로 현재 노드가 벽을 부신 횟수가 0, 1 둘다 큐에 추가
                    if(breakCntArr[row][col] > curNode.breakCnt) {
                        queue.add(new Node(row, col, curNode.breakCnt));
                        resultArr[row][col] = resultArr[curNode.row][curNode.col] + 1;
                        breakCntArr[row][col] = curNode.breakCnt;
                    }
                }
            }

        }

        // 반복문 중간에 66번라인이 실행되지 않았다는 것은 (m,n)에 도달하지 못했다는 것이다.
        return -1;
    }
    // (1,1) ~ (n,m)의 범위에 있을 경우 true 반환
    public static boolean isRightNode(int row,int col){
        if(row < 1 || row > n || col < 1 || col > m) return false;
        else return true;
    }
    // 벽인 경우 true 반환
    public static boolean isWall(int row, int col){
        if(arr[row][col] == 1) return true;
        else return false;
    }
}
