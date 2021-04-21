package backjoon.samsung_sw_test;

import java.util.Scanner;
import java.util.ArrayList;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class SwAcademy1949
{   
    static class Index{
        int row, col, depth;
        public Index(int row, int col, int depth){
            this.row = row;
            this.col = col;
            this.depth = depth;
        }
    }
    static int N, K;
    static int[][] graph;
    static ArrayList<Index> startList;
    static int answer;
    static int maxHeight;
    static int[] rowArr = new int[]{1, 0, -1, 0};
    static int[] colArr = new int[]{0, -1, 0, 1};

    static ArrayList<Integer> answerList = new ArrayList<>();

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
            maxHeight = 0;
            answer = Integer.MIN_VALUE;
            startList = new ArrayList<>();

            N = sc.nextInt();
            K = sc.nextInt();

            graph = new int[N + 1][N + 1];

            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    graph[i][j] = sc.nextInt();
                   
                    if(graph[i][j] > maxHeight){
                        maxHeight = graph[i][j];
                        startList = new ArrayList<>();
                        startList.add(new Index(i, j, 0));
                    }else if(graph[i][j] == maxHeight){
                        startList.add(new Index(i, j, 0));
                    }
                }
            }
			
            solve();

            answerList.add(answer);
		}

        for(int i = 1; i <= answerList.size(); i++){
            System.out.println("#" + i + " " + answerList.get(i - 1));
        }
	}

    static void solve(){
        
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                for(int k = 0; k <= K; k++){
                    graph[i][j] -= k;
                    searchLIS();
                    graph[i][j] += k;
                }
            }
        }
    }

    static void searchLIS(){
        for(int i = 0 ; i < startList.size(); i++){
            Index curIndex = startList.get(i);
            int row = curIndex.row;
            int col = curIndex.col;

            if(graph[row][col] == maxHeight) {
                getLength(row, col, 1, new boolean[N + 1][N + 1]);
            }
        }
    }

    static void getLength(int row, int col, int depth, boolean[][] check){
        boolean isThereWay = false;

        for(int i = 0 ; i < rowArr.length; i++){
            int toRow = row + rowArr[i];
            int toCol = col + colArr[i];
            int toDepth = depth + 1;

            // 범위 벗어난 경우 생략
            if(toRow < 1 || toRow > N || toCol < 1 || toCol > N) continue;
            // 기 방문점인 경우 생략
            if(check[toRow][toCol] == true) continue;
            // 같거나 높은 지형 생략
            if(graph[toRow][toCol] >= graph[row][col]) continue;
            
            check[toRow][toCol] = true;
            getLength(toRow, toCol, toDepth, check);
            check[toRow][toCol] = false;

            // 갈 수 있는 곳이 있는지 확인
            isThereWay = true;
        }

        // 갈 수 있는 곳이 없다면 계산
        if(isThereWay == false){
            answer = Math.max(answer, depth);
        }
    }
}