package backjoon.samsung_sw_test;

import java.util.*;

public class SwAcademy2115 {
    static ArrayList<Integer>answerList = new ArrayList<>();
    static int N, M, C;
    static int[][] graph;
    static int result;
    static int sum;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		/*
		   여러 개의 테스트 케이스가 주어지므로, 각각을 처리합니다.
		*/

		for(int test_case = 1; test_case <= T; test_case++)
		{
            result = 0;
            N = sc.nextInt();
            M = sc.nextInt();
            C = sc.nextInt();

            graph = new int[N + 1][N + 1];

            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    graph[i][j] = sc.nextInt();
                }
            }
            
            solve();

            answerList.add(result);
		}

        for(int i = 0; i < answerList.size(); i++){
            System.out.println("#" + (i + 1) + " " + answerList.get(i));
        }
    }

    static void solve(){
        int check[][] = new int[N + 1][N + 1];

        // 첫번째 위치 지정
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N - M + 1; j++){
                // 첫번째 위치는 1로 설정
                for(int k = j; k < j + M; k++) check[i][k] = 1;
                getSecondArea(i, j + M, 1, check);
                for(int k = j; k < j + M; k++) check[i][k] = 0;
            }
        }
    }

    static void getSecondArea(int row ,int col, int count, int[][] check){
        for(int i = row; i <= N; i++){
            for(int j = 1; j <= N - M + 1; j++){
                if(i == row && j < col) continue;

                // 첫번째 위치는 2로 설정
                for(int k = j; k < j + M; k++) check[i][k] = 2;
                calcAnswer(check);
                for(int k = j; k < j + M; k++) check[i][k] = 0;
            }
        }
    }

    static void calcAnswer(int[][] check){
        List<Integer> listA = new ArrayList<>();
        List<Integer> listB = new ArrayList<>();

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                if(check[i][j] == 1) listA.add(graph[i][j]);
                else if(check[i][j] == 2) listB.add(graph[i][j]);
            }
        }

        boolean[] checkA = new boolean[listA.size()];
        boolean[] checkB = new boolean[listB.size()];
        int sumAB = 0;
        sum = 0;
        combination(listA, 0, 0, 0, checkA);
        sumAB += sum;
        sum = 0;
        combination(listB, 0, 0, 0, checkB);
        sumAB += sum;

        result = Math.max(result, sumAB);
    }

    static void combination(List<Integer> list, int count, int curIndex, int tot, boolean[] check){

        if(count == list.size()){
            int value = 0;
            for(int i = 0; i < list.size(); i++){
                if(check[i] == true) value += (list.get(i) * list.get(i));
            }
            sum = Math.max(value, sum);
            return;
        }

        for(int i = 0; i < 2; i++){
            int num = list.get(curIndex);
           
            // 선택
            if(i == 0) {
                if(tot + num > C) continue;
                check[curIndex] = true;
                combination(list, count + 1, curIndex + 1, tot + num, check);
                check[curIndex] = false;
            }else{
                combination(list, count + 1, curIndex + 1, tot, check);
            }
        }
    }
    
}
