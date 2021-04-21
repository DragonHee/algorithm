package backjoon.samsung_sw_test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.io.FileInputStream;

public class SwAcademy2117 {
    static class Index{
        int row, col, depth;
        public Index(int row, int col, int depth){
            this.row = row;
            this.col = col;
            this.depth = depth;
        }
    }
    static int N, M;
    static int [][] graph;
    static ArrayList<Integer> answerList = new ArrayList<>();
    
    static int answer;
    static int maxK;

    static int[] rowArr = new int[]{1, 0, -1, 0};
    static int[] colArr = new int[]{0, -1, 0, 1};

    public static void main(String args[]) throws Exception
	{
		/*
		   아래의 메소드 호출은 앞으로 표준 입력(키보드) 대신 input.txt 파일로부터 읽어오겠다는 의미의 코드입니다.
		   여러분이 작성한 코드를 테스트 할 때, 편의를 위해서 input.txt에 입력을 저장한 후,
		   이 코드를 프로그램의 처음 부분에 추가하면 이후 입력을 수행할 때 표준 입력 대신 파일로부터 입력을 받아올 수 있습니다.
		   따라서 테스트를 수행할 때에는 아래 주석을 지우고 이 메소드를 사용하셔도 좋습니다.
		   단, 채점을 위해 코드를 제출하실 때에는 반드시 이 메소드를 지우거나 주석 처리 하셔야 합니다.
		 */
		//System.setIn(new FileInputStream("res/input.txt"));

		/*
		   표준입력 System.in 으로부터 스캐너를 만들어 데이터를 읽어옵니다.
		 */
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
            answer = 0;
            N = sc.nextInt();
            M = sc.nextInt();

            graph = new int[N + 1][N + 1];

            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N ; j++)
                {
                    graph[i][j] = sc.nextInt();
                }
            }
            if(N % 2 == 0) maxK = N + 1;
            else maxK = N;
            
            solve();

            answerList.add(answer);
		}

        for(int i = 1; i <= answerList.size(); i++){
            System.out.println("#" + i + " " + answerList.get(i - 1));
        }
	}

    static void solve(){
        
        for(int i = 1; i <= maxK; i++){
            for(int r = 1; r <= N; r++){
                for(int c = 1; c <= N; c++){
                    bfs(r, c, i);
                }
            }
        }
    }
    
    static void bfs(int row, int col, int k){
        int houseCnt = 0;
        LinkedList<Index> queue = new LinkedList<>();
        boolean[][] check = new boolean[N + 1][N + 1];
        queue.add(new Index(row, col, 1));
        if(graph[row][col] == 1) houseCnt++;
        check[row][col] = true;

        while(!queue.isEmpty()){
            Index curIdx = queue.poll();
            int curRow = curIdx.row;
            int curCol = curIdx.col;
            int curDepth = curIdx.depth;

            if(curDepth >= k) continue;

            for(int i = 0 ; i < rowArr.length; i++){
                int toRow = curRow + rowArr[i];
                int toCol = curCol + colArr[i];
                int toDepth = curDepth + 1;

                // 범위 벗어난 경우 생략
                if(toRow < 1 || toRow > N || toCol < 1 || toCol > N) continue;
                // 기 방문점인 경우 생략
                if(check[toRow][toCol] == true) continue;

                queue.add(new Index(toRow, toCol, toDepth));
                check[toRow][toCol] = true;

                // 집을 찾은 경우
                if(graph[toRow][toCol] == 1) houseCnt++;
            }
        }

        int earnMoney = houseCnt * M;
        int cost = getCost(k);

        if(earnMoney >= cost) answer = Math.max(answer, houseCnt);
    }

    static int getCost(int k){
        return k * k + (k - 1) * (k - 1);
    }

    
}
