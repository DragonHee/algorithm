package backjoon.samsung_sw_test;

import java.util.*;
import java.io.FileInputStream;

public class SwAcademy5653 {
    static class Cell{
        boolean isActive;
        int hp;
        int time;
        public Cell(int hp){
            this.hp = hp;
            this.isActive = false;
            this.time = 0;
        }
        public void timePlus(){
            time++;
            if(isActive == false && time == hp) {
                isActive = true;
                time = 0;
            }
        }
        public boolean isMove(){
            if(isActive == true && time == 0) return true;
            else return false;
        }
        public boolean isDead(){
            if(isActive = true && hp <= time) return true;
            else return false;
        }
    }

    static final int[] rowArr = new int[]{1,0,-1,0};
    static final int[] colArr = new int[]{0,-1,0,1};

    static int N, M, K;
    static ArrayList<Cell>[][] graph;
    static boolean[][] check;
    static ArrayList<Cell> cellList;
    static int minRow, maxRow, minCol, maxCol;
    
    static int answer;

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
            answer = 0;
            cellList = new ArrayList<>();
            minRow = Integer.MAX_VALUE;
            minCol = Integer.MAX_VALUE;
            maxRow = Integer.MIN_VALUE;
            maxCol = Integer.MIN_VALUE;

            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();

            graph = new ArrayList[N + 300][M + 300];
            check = new boolean[N + 300][M + 300];

            for(int i = 0; i < check.length; i++){
                for(int j = 0 ; j < check[i].length; j++){
                    graph[i][j] = new ArrayList<>();
                }
            }

            for(int i = 0; i < N; i++){
                for(int j = 0 ; j < M; j++){
                    int num = sc.nextInt();

                    if(num == 0) continue;
                    int row = i + 150;
                    int col = j + 150;

                    graph[row][col].add(new Cell(num));
                    check[row][col] = true;

                    minRow = Integer.min(minRow, row);
                    minCol = Integer.min(minCol, col);
                    maxRow = Integer.max(maxRow, row);
                    maxCol = Integer.max(maxCol, col);
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
        int time = 0;

        while(time++ < K){
            move();
        }

        calcAnswer();
    }

    static void move(){
        boolean[][] isNew = new boolean[N + 300][M + 300];

        for(int i = minRow; i <= maxRow; i++){
            for(int j = minCol ; j <= maxCol; j++){
                if(check[i][j] == false) continue;
                if(isNew[i][j] == true) continue;

                Cell curCell = graph[i][j].get(0);
                
                if(curCell.isMove()){
                    for(int k = 0 ; k < rowArr.length; k++){
                        int toRow = i + rowArr[k];
                        int toCol = j + colArr[k];
                        int toHp = curCell.hp;
    
                        if(check[toRow][toCol] == true){
                            if(isNew[toRow][toCol] == true){
                                if(toHp > graph[toRow][toCol].get(0).hp){
                                    graph[toRow][toCol].set(0, new Cell(toHp));
                                }
                            }
                        }
                        else{
                            graph[toRow][toCol].add(new Cell(toHp));
                            check[toRow][toCol] = true;
                            isNew[toRow][toCol] = true;

                            minRow = Integer.min(minRow, toRow);
                            minCol = Integer.min(minCol, toCol);
                            maxRow = Integer.max(maxRow, toRow);
                            maxCol = Integer.max(maxCol, toCol);
                        }
                    }
                }

                curCell.timePlus();      
            }
        }
    }

    static void calcAnswer(){
        for(int i = minRow; i <= maxRow; i++){
            for(int j = minCol ; j <= maxCol; j++){
                if(check[i][j] == false) continue;

                // 살아 있으면 정답에 포함
                if(graph[i][j].get(0).isDead() == false) answer++;
            }
        }
    }
}
