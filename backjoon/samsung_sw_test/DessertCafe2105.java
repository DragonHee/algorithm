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
import java.util.*;
import java.io.FileInputStream;

/*
   사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
   이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class DessertCafe2105
{
    static int N;
    static int graph[][];
    static boolean check[] = new boolean[101];
    static int maxValue;
    static int startRow, startCol;
    static ArrayList<Integer> answerList = new ArrayList<>();
    static int[] rowArr = new int[]{1, 1, -1, -1};
    static int[] colArr = new int[]{1, -1, -1, 1};
    
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
			N = sc.nextInt();
            graph = new int[N + 1][N + 1];
            maxValue = -1;
            
            // init graph
            for(int i = 1; i <= N; i++){
            	for(int j = 1; j <= N; j++){
                	graph[i][j] = sc.nextInt();
                }
            }
            
            for(int i = 1; i <= N; i++){
            	for(int j = 1; j <= N; j++){
                    startRow = i;
                    startCol = j;
                	check[graph[i][j]] = true;
                    // 시계방향으로 탐색을 진행하므로 
                    // curDirection param을 0으로 전달
                    search(i, j, 0, 0);
                    check[graph[i][j]] = false;
                }
            }
            answerList.add(maxValue);
		}

        int testCnt = 1;
        for(int num : answerList){
            System.out.println("#" + testCnt++ + " " + num);
        }
	}
    
    // curDirection -> 0 : 오른쪽아래, 1 : 왼쪽아래, 2 : 왼쪽위, 3 : 오른쪽위
    static void search(int row, int col, int length, int curDirection){
        for(int i = 0; i < rowArr.length; i++){
            // 시계방향으로만 탐색을 진행한다.
            if(curDirection == 0 && (i == 2 || i == 3)) continue;
            if(curDirection == 1 && (i == 0 || i == 3)) continue; 
            if(curDirection == 2 && (i == 0 || i == 1)) continue; 
            if(curDirection == 3 && (i == 0 || i == 1 || i == 2)) continue;

            int toRow = row + rowArr[i];
            int toCol = col + colArr[i];
            int toLength = length + 1;
            int toCurDirection = i;

            // 범위에 벗어나면 생략
            if(toRow < 1 || toRow > N || toCol < 1 || toCol > N) continue;
            // 시작점 보다 위쪽으로 탐색은 생략
            if(toRow < startRow) continue;
            // 중복된 디저트 갯수의 경로 생략
            if(check[graph[toRow][toCol]] == true) {
                // 시작점이 아닌 경우만 생략
                if(startRow != toRow || startCol != toCol) continue;
                // 찾은 경우
                else{
                    maxValue = Math.max(maxValue, toLength);
                    continue;
                }
                
            }

            check[graph[toRow][toCol]] = true;
            search(toRow, toCol, toLength, toCurDirection);
            check[graph[toRow][toCol]] = false;
        }
    }
}