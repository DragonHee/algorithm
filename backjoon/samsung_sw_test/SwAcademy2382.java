package backjoon.samsung_sw_test;

import java.util.*;
import java.io.*;

public class SwAcademy2382 {
    static class Virus{
        int row, col, num, dir;
        public Virus(int row, int col, int num, int dir){
            this.row = row;
            this.col = col;
            this.num = num;
            this.dir = dir;
        }
    }
    // 1:상, 2:하, 3:좌, 4:우
    static int[] rowArr = new int[]{0, -1, 1, 0, 0};
    static int[] colArr = new int[]{0, 0, 0, -1, 1};

    static int N, M, K;
    static int answer;
    static ArrayList<Virus> virusList = new ArrayList<>();

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

            N = sc.nextInt();
            M = sc.nextInt();
            K = sc.nextInt();

            virusList = new ArrayList<>();
			
            for(int i = 0; i < K; i++){
               int row = sc.nextInt();
               int col = sc.nextInt();
               int num = sc.nextInt();
               int dir = sc.nextInt();
                
               virusList.add(new Virus(row, col, num, dir));
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

        while(time++ < M){
            move();
        }

        calcAnswer();
    }

    static void move(){

        for(int i = 0 ; i < virusList.size(); i++){
            Virus v = virusList.get(i);
            int curRow = v.row;
            int curCol = v.col;
            int curNum = v.num;
            int curDir = v.dir;

            int toRow = curRow + rowArr[curDir];
            int toCol = curCol + colArr[curDir];
            int toNum = curNum;
            int toDir = curDir;

            // 테두리에 간 경우
            if(toRow == 0 || toRow == N - 1 || toCol == 0 || toCol == N - 1){
                toNum >>= 1;
                toDir = (toDir % 2) == 0 ? toDir - 1 : toDir + 1;
            }

            if(toNum == 0) virusList.remove(i--);
            else virusList.set(i, new Virus(toRow, toCol, toNum, toDir));
        }


        for(int i = 0; i < virusList.size(); i++){
            boolean flag = false;
            ArrayList<Integer> indexList = new ArrayList<>();
            indexList.add(i);
            Virus v = virusList.get(i);

            int row = v.row;
            int col = v.col;
            int tot = v.num;
            int dir = v.dir;
            int num = v.num;

            for(int j = i + 1; j < virusList.size(); j++){
                Virus toV = virusList.get(j);

                if(row == toV.row && col == toV.col){
                    flag = true;
                    tot += toV.num;
                    
                    if(num < toV.num){
                        dir = toV.dir;
                        num = toV.num;
                    }
                    
                    indexList.add(j);
                }
            }

            if(flag == true){
                for(int j = i; j < virusList.size(); j++){
                    if(virusList.get(j).row == row && virusList.get(j).col == col) virusList.remove(j--); 
                }
                i--;
                virusList.add(new Virus(row, col, tot, dir));
            }
        }
    }

    static void calcAnswer(){
        int count = 0;

        for(Virus v : virusList){
            count += v.num;
        }

        answer = count;
    }
}
