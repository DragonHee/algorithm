package backjoon.samsung_sw_test;

import java.util.*;
import java.io.*;


public class SwAcademy {
    static int N, X;
    static int graph[][];
    
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
            N = sc.nextInt();
            X = sc.nextInt();

            graph = new int[N + 1][N + 1];

            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    graph[i][j] = sc.nextInt();
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
        checkHorizon();
        checkVertical();
    }

    static void checkHorizon(){
        boolean[][] check = new boolean[N + 1][N + 1];
        int count = 0;

        for(int i = 1; i <= N; i++){
            boolean flag = true;

            for(int j = 1; j < N; j++){
                int toHeight = graph[i][j + 1];
                int fromHeight = graph[i][j];

                // 높이가 같은 경우
                if(fromHeight == toHeight) continue;
                // 차이가 1 초과인 경우
                if(Math.abs(fromHeight - toHeight) > 1) {
                    flag = false;
                    break;
                }
                
                if(fromHeight > toHeight){
                    for(int k = 2; k <= X; k++){
                        // 범위를 벗어난 경우 실패
                        if(j + k > N || check[i][j + k] == true) {
                            flag = false;
                            break;
                        }

                        // 맨끝이 아닌 경우
                        if(k != X) {
                            // 크면 실패
                            if(toHeight < graph[i][j + k]) {
                                flag = false;
                                break;
                            }
                        }
                        // 맨끝인 경우
                        else{
                            // 높이가 다르면 실패
                            if(toHeight != graph[i][j + k]) {
                                flag = false;
                                break;
                            }
                        }
                        check[i][j + k] = true;
                    }
                }
                // 가는 곳의 높이가 더 큰 경우
                else{
                    for(int k = 0; k < X; k++){
                        // 범위를 벗어난 경우 실패
                        if(j - k < 1 || check[i][j - k] == true) {
                            flag = false;
                            break;
                        }

                        // 맨끝이 아닌 경우
                        if(k != X - 1) {
                            // 크면 실패
                            if(fromHeight < graph[i][j - k]) {
                                flag = false;
                                break;
                            }
                        }
                        // 맨끝인 경우
                        else{
                            // 높이가 다르면 실패
                            if(fromHeight != graph[i][j - k]) {
                                flag = false;
                                break;
                            }
                        }
                        check[i][j - k] = true;
                    }
                }
            }

            // 가능한 경우
            if(flag == true) count++;
        }

        answer += count;
    }

    static void checkVertical(){
        boolean[][] check = new boolean[N + 1][N + 1];
        int count = 0;

        for(int i = 1; i <= N; i++){
            boolean flag = true;
            for(int j = 1; j < N; j++){
                int toHeight = graph[j + 1][i];
                int fromHeight = graph[j][i];
                // 높이가 같은 경우
                if(fromHeight == toHeight) continue;
                // 차이가 1 초과인 경우
                if(Math.abs(fromHeight - toHeight) > 1) {
                    flag = false;
                    break;
                }
                if(fromHeight > toHeight){
                    for(int k = 2; k <= X; k++){
                        // 범위를 벗어난 경우 실패
                        if(j + k > N || check[j + k][i] == true) {
                            flag = false;
                            break;
                        }

                        // 맨끝이 아닌 경우
                        if(k != X) {
                            // 크면 실패
                            if(toHeight < graph[j + k][i]) {
                                flag = false;
                                break;
                            }
                        }
                        // 맨끝인 경우
                        else{
                            // 높이가 다르면 실패
                            if(toHeight != graph[j + k][i]) {
                                flag = false;
                                break;
                            }
                        }
                        check[j + k][i] = true;
                    }
                 
                }
                // 가는 곳의 높이가 더 큰 경우
                else{
                    for(int k = 0; k < X; k++){
                        // 범위를 벗어난 경우 실패
                        if(j - k < 1 || check[j - k][i] == true) {
                            flag = false;
                            break;
                        }

                        // 맨끝이 아닌 경우
                        if(k != X - 1) {
                            // 크면 실패
                            if(fromHeight < graph[j - k][i]) {
                                flag = false;
                                break;
                            }
                        }
                        // 맨끝인 경우
                        else{
                            // 높이가 다르면 실패
                            if(fromHeight != graph[j - k][i]) {
                                flag = false;
                                break;
                            }
                        }
                    }
                }
            }

            // 가능한 경우
            if(flag == true) count++;
        }

        answer += count;
    }
    
}
