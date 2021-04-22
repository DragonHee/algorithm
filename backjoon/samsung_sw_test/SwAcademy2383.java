package backjoon.samsung_sw_test;

import java.io.*;
import java.util.*;

public class SwAcademy2383 {
    static class Index{
        int row, col;
        int waitFlag;

        public Index(int row, int col){
            this.row = row;
            this.col = col;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static int[][] graph;
    static int answer;
    static ArrayList<Index> humanList;
    static ArrayList<Index> stairList;

    static final int LIMIT = 3;

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
            answer = Integer.MAX_VALUE;

            N = sc.nextInt();
            humanList = new ArrayList<>();
            stairList = new ArrayList<>();
            graph = new int[N + 1][N + 1];

            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    graph[i][j] = sc.nextInt();
                    if(graph[i][j] == 1) humanList.add(new Index(i, j));
                    else if(graph[i][j] > 1) stairList.add(new Index(i, j));
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
        boolean[] visit = new boolean[humanList.size()];

        combination(0, humanList.size(), visit);
    }

    static void combination(int index, int limit, boolean[] visit){
        if(index == limit){
            calcAnswer(visit);

            return;
        }

        for(int i = 0; i < 2; i++){
            // A 계단으로
            if(i == 0) visit[index] = true;
            combination(index + 1, limit, visit);
            if(i == 0) visit[index] = false;
        }
    }

    static void calcAnswer(boolean[] visit){
        // A 계단으로 가는 사람
        ArrayList<Integer> listA = new ArrayList<>();
        // B 계단으로 가는 사람
        ArrayList<Integer> listB = new ArrayList<>();

        for(int i = 0 ; i < visit.length; i++){
            if(visit[i] == true) {
                int stairRow = stairList.get(0).row;
                int stairCol = stairList.get(0).col;
                int fromRow = humanList.get(i).row;
                int fromCol = humanList.get(i).col;

                int cost = Math.abs(stairRow - fromRow) + Math.abs(stairCol - fromCol);

                listA.add(cost);
            }else{
                int stairRow = stairList.get(1).row;
                int stairCol = stairList.get(1).col;
                int fromRow = humanList.get(i).row;
                int fromCol = humanList.get(i).col;

                int cost = Math.abs(stairRow - fromRow) + Math.abs(stairCol - fromCol);

                listB.add(cost);
            }
        }

        calcTime(listA, listB);
    }

    static void calcTime(ArrayList<Integer> listA, ArrayList<Integer> listB){
        int costTime = 0;

        ArrayList<Integer> stairListA = new ArrayList<>();
        ArrayList<Integer> stairListB = new ArrayList<>();

        int stairALen = graph[stairList.get(0).row][stairList.get(0).col];
        int stairBLen = graph[stairList.get(1).row][stairList.get(1).col];

        while(true){
            for(int i = 0; i < listA.size(); i++){
                int num = listA.get(i);

                listA.set(i, num - 1);

                if(listA.get(i) == -1 && stairListA.size() < LIMIT){
                    listA.remove(i--);
                    stairListA.add(stairALen + 1);
                }else if(listA.get(i) < -1 && stairListA.size() < LIMIT){
                    listA.remove(i--);
                    stairListA.add(stairALen);
                }
            }

            for(int i = 0; i < listB.size(); i++){
                int num = listB.get(i);

                listB.set(i, num - 1);

                if(listB.get(i) == -1 && stairListB.size() < LIMIT){
                    listB.remove(i--);
                    stairListB.add(stairBLen + 1);
                }else if(listB.get(i) < -1 && stairListB.size() < LIMIT){
                    listB.remove(i--);
                    stairListB.add(stairBLen);
                }
            }
            
            for(int i = stairListA.size() - 1 ; i >= 0; i--){
                int num = stairListA.get(i);
                
                stairListA.set(i, num - 1);

                if(num - 1 == 0) stairListA.remove(i);
            }

            for(int i = stairListB.size() - 1 ; i >= 0; i--){
                int num = stairListB.get(i);

                stairListB.set(i, num - 1);
                if(num - 1 == 0) stairListB.remove(i);
            }

            costTime++;

            if(listA.size() == 0 && listB.size() == 0 && stairListA.size() == 0 && stairListB.size() == 0) break;
        }

        answer = Math.min(answer, costTime);
    }
}
