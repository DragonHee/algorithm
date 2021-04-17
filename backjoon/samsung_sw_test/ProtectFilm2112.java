package backjoon.samsung_sw_test;

  /////////////////////////////////////////////////////////////////////////////////////////////
// 기본 제공코드는 임의 수정해도 관계 없습니다. 단, 입출력 포맷 주의
// 아래 표준 입출력 예제 필요시 참고하세요.
// 표준 입력 예제
// int a;
// double b;
// char g;
// String var;
// long AB;
// a = sc.nextInt();                           // int 변수 1개 입력받는 예제
// b = sc.nextDouble();                        // double 변수 1개 입력받는 예제
// g = sc.nextByte();                          // char 변수 1개 입력받는 예제
// var = sc.next();                            // 문자열 1개 입력받는 예제
// AB = sc.nextLong();                         // long 변수 1개 입력받는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
// 표준 출력 예제
// int a = 0;                            
// double b = 1.0;               
// char g = 'b';
// String var = "ABCDEFG";
// long AB = 12345678901234567L;
//System.out.println(a);                       // int 변수 1개 출력하는 예제
//System.out.println(b); 		       						 // double 변수 1개 출력하는 예제
//System.out.println(g);		       						 // char 변수 1개 출력하는 예제
//System.out.println(var);		       				   // 문자열 1개 출력하는 예제
//System.out.println(AB);		       				     // long 변수 1개 출력하는 예제
/////////////////////////////////////////////////////////////////////////////////////////////
import java.util.Scanner;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class ProtectFilm2112
{
    static int D, W, K;
    static int[][] graph;
    static int[] changeGraph;
    static boolean[] check;
    static int result;
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
            D = sc.nextInt();
            W = sc.nextInt();
            K = sc.nextInt();

            graph = new int[D + 1][W + 1];
            changeGraph = new int[D + 1];
            check = new boolean[D + 1];
            // -1로 초기화
            Arrays.fill(changeGraph, -1);
            result = 0;

            for(int i = 1; i <= D; i++){
                for(int j = 1; j <= W; j++){
                    graph[i][j] = sc.nextInt();
                }
            }

            solve();
			
            answerList.add(result);
		}

        for(int i = 1; i <= answerList.size(); i++){
            System.out.println("#" + i + " " + answerList.get(i - 1));
        }
	}

    static void solve(){
        // 약품 투입 없이 성능통과 한 경우
        if(checkIsAvailable()) return;;
        
        int minValue = 1;

        while(true){
            for(int i = 1; i <= D; i++){
                check[i] = true;
                searchChangePos(i, 1, minValue);
                check[i] = false;
            }
            if(result != 0) break;
            minValue++;
        }
    }

    static void searchChangePos(int curIndex, int count, int limit){
        if(count == limit){
            for(int i = 0; i < 2; i++){
                int point = -1;

                for(int j = 1; j <= D; j++){
                    if(check[j] == true){
                        point = j;
                        changeGraph[j] = i;
                        break;
                    }
                }
                searchABPos(point, 1, limit);
                changeGraph[point] = -1;
            }   
            return;
        }

        for(int i = curIndex + 1; i <= D; i++){
            check[i] = true;
            searchChangePos(i, count + 1, limit);
            check[i] = false;
        }
    }

    static void searchABPos(int curIndex, int depth, int limit){
        if(depth == limit){
            if(checkIsAvailable() == true) result = limit;
            return;
        }

        for(int i = 0; i < 2; i++){
            int point = -1;

            for(int j = curIndex + 1; j <= D; j++){
                if(check[j] == true){
                    point = j;
                    changeGraph[j] = i;
                    break;
                }
            }
            searchABPos(point, depth + 1, limit);
            changeGraph[point] = -1;
        }   
    }

    static boolean checkIsAvailable(){
        for(int i = 1; i <= W; i++){
            int count = 1;
            int flagValue = changeGraph[1] == -1 ? graph[1][i] : changeGraph[1];

            for(int j = 2; j <= D; j++){
                int curValue = changeGraph[j] == -1 ? graph[j][i] : changeGraph[j];
                if(flagValue == curValue) count++;
                else{
                    flagValue = curValue;
                    count = 1;
                }
                if(count >= K) break;
            }
            if(count < K) return false;
        }

        return true;
    }
}