package backjoon.samsung_sw_test;

import java.util.*;
import java.io.*;

public class Backjoon5373 {
    static int rowArr[] = new int[]{1, 0, -1, 0};
    static int colArr[] = new int[]{0, -1, 0, 1};
    static final int SIZE = 3;

    static class Cube{
        // 위 : 0, 앞 : 1, 왼 : 2, 뒤 : 3, 오 : 4, 아래 : 5
        char[][][] arr;

        public Cube(){
            arr = new char[6][3][3];

            for(int i = 0; i < 2 * SIZE; i++)
            {
                for(int j = 0; j < SIZE; j++)
                {
                    for(int k = 0 ; k < SIZE; k++)
                    {
                        char ch;

                        if(i == 0) ch = 'w';
                        else if(i == 1) ch = 'r';
                        else if(i == 2) ch = 'g';
                        else if(i == 3) ch = 'o';
                        else if(i == 4) ch = 'b';
                        else ch = 'y';

                        arr[i][j][k] = ch;
                    }
                }
            }
        }

        public void move(char loc){
            int index = 0;

            if(loc == 'U') index = 0;
            else if(loc == 'D') index = 5;
            else if(loc == 'F') index = 1;
            else if(loc == 'L') index = 2;
            else if(loc == 'B') index = 3;
            else index = 4;
            
            char [][] temp = new char[SIZE][SIZE];
            
            for(int i = 0 ; i < SIZE; i++){
                for(int j = 0; j < SIZE; j++){
                    temp[i][j] = arr[index][i][j];
                }
            }
            

            arr[index][0][1] = temp[1][0];
            arr[index][0][2] = temp[0][0];

            arr[index][1][2] = temp[0][1];
            arr[index][2][2] = temp[0][2];

            arr[index][2][1] = temp[1][2];
            arr[index][2][0] = temp[2][2];

            arr[index][1][0] = temp[2][1];
            arr[index][0][0] = temp[2][0];

            if(loc == 'U'){
                // 주변 큐브 변경
                Queue<Character> queue = new LinkedList<>();
                int row = 0;
                
                for(int i = 1; i <= 4; i++){
                    for(int j = 2; j >= 0; j--){
                        queue.add(arr[i][row][j]);
                    }
                }
              
                for(int i = 0; i < SIZE * SIZE; i++) queue.add(queue.poll());
 
                for(int i = 1; i <= 4; i++){
                    for(int j = 2; j >= 0; j--){
                        arr[i][row][j] = queue.poll();
                    }
                }
            }
            else if(loc == 'D'){
                Queue<Character> queue = new LinkedList<>();
                int row = 2;

                for(int j = 0; j < SIZE; j++){
                    queue.add(arr[1][row][j]);
                }
                for(int j = 0; j < SIZE; j++){
                    queue.add(arr[4][row][j]);
                }
                for(int j = 0; j < SIZE; j++){
                    queue.add(arr[3][row][j]);
                }
                for(int j = 0; j < SIZE; j++){
                    queue.add(arr[2][row][j]);
                }
              
                for(int i = 0; i < SIZE * SIZE; i++) queue.add(queue.poll());
 
                for(int j = 0; j < SIZE; j++){
                    arr[1][row][j] = queue.poll();
                }
                for(int j = 0; j < SIZE; j++){
                    arr[4][row][j] = queue.poll();
                }
                for(int j = 0; j < SIZE; j++){
                    arr[3][row][j] = queue.poll();
                }
                for(int j = 0; j < SIZE; j++){
                    arr[2][row][j] = queue.poll();
                }
            }
            else if(loc == 'F'){
                // 주변 큐브 변경
                Queue<Character> queue = new LinkedList<>();
                
                for(int j = 0; j < SIZE; j++){
                    queue.add(arr[0][2][j]);
                }
                for(int j = 0; j < SIZE; j++){
                    queue.add(arr[4][j][0]);
                }
                for(int j = 0; j < SIZE; j++){
                    queue.add(arr[5][0][SIZE - j - 1]);
                }
                for(int j = 0; j < SIZE; j++){
                    
                    queue.add(arr[2][SIZE - j - 1][2]);
                }

                for(int i = 0; i < SIZE * SIZE; i++) queue.add(queue.poll());

                for(int j = 0; j < SIZE; j++){
                    arr[0][2][j] = queue.poll();
                }
                for(int j = 0; j < SIZE; j++){
                    arr[4][j][0] = queue.poll();
                }
                for(int j = 0; j < SIZE; j++){
                    arr[5][0][SIZE - j - 1] = queue.poll();
                }
                for(int j = 0; j < SIZE; j++){
       
                    arr[2][SIZE - j - 1][2] = queue.poll();
                }
            }
            else if(loc == 'L'){
                // 주변 큐브 변경
                Queue<Character> queue = new LinkedList<>();
                
                for(int i = 0 ; i < SIZE; i++){
                    queue.add(arr[0][i][0]);
                }
                for(int i = 0 ; i < SIZE; i++){
                    queue.add(arr[1][i][0]);
                }
                for(int i = 0 ; i < SIZE; i++){
                    queue.add(arr[5][i][0]);
                }
                for(int i = 0 ; i < SIZE; i++){
                    queue.add(arr[3][SIZE - i - 1][2]);
                }
              
                for(int i = 0; i < SIZE * SIZE; i++) queue.add(queue.poll());

                for(int i = 0 ; i < SIZE; i++){
                    arr[0][i][0] = queue.poll();
                }
                for(int i = 0 ; i < SIZE; i++){
                    arr[1][i][0] = queue.poll();
                }
                for(int i = 0 ; i < SIZE; i++){
                    arr[5][i][0] = queue.poll();
                }
                for(int i = 0 ; i < SIZE; i++){
                    arr[3][SIZE - i - 1][2] = queue.poll();
                }
            }
            else if(loc == 'B'){
                // 주변 큐브 변경
                Queue<Character> queue = new LinkedList<>();
                
                for(int i = 0 ; i < SIZE; i++){
                    queue.add(arr[0][0][SIZE - i - 1]);
                }
                for(int i = 0 ; i < SIZE; i++){
                    queue.add(arr[2][i][0]);
                }
                for(int i = 0 ; i < SIZE; i++){
                    queue.add(arr[5][2][i]);
                }
                for(int i = 0 ; i < SIZE; i++){
                    queue.add(arr[4][SIZE - i - 1][2]);
                }
              
                for(int i = 0; i < SIZE * SIZE; i++) queue.add(queue.poll());

                for(int i = 0 ; i < SIZE; i++){
                    arr[0][0][SIZE - i - 1] = queue.poll();
                }
                for(int i = 0 ; i < SIZE; i++){
                    arr[2][i][0] = queue.poll();
                }
                for(int i = 0 ; i < SIZE; i++){
                    arr[5][2][i] = queue.poll();
                }
                for(int i = 0 ; i < SIZE; i++){
                    arr[4][SIZE - i - 1][2] = queue.poll();
                }
            }
            else if(loc == 'R'){
                // 주변 큐브 변경
                Queue<Character> queue = new LinkedList<>();
                
                for(int i = 0 ; i < SIZE; i++){
                    queue.add(arr[0][SIZE - 1 - i][2]);
                }
                for(int i = 0 ; i < SIZE; i++){
                    queue.add(arr[3][i][0]);
                }
                for(int i = 0 ; i < SIZE; i++){
                    queue.add(arr[5][SIZE - i - 1][2]);
                }
                for(int i = 0 ; i < SIZE; i++){
                    queue.add(arr[1][SIZE - i - 1][2]);
                }
              
                for(int i = 0; i < SIZE * SIZE; i++) queue.add(queue.poll());

                for(int i = 0 ; i < SIZE; i++){
                    arr[0][SIZE - 1 - i][2] = queue.poll();
                }
                for(int i = 0 ; i < SIZE; i++){
                    arr[3][i][0] = queue.poll();
                }
                for(int i = 0 ; i < SIZE; i++){
                    arr[5][SIZE - i - 1][2] = queue.poll();
                }
                for(int i = 0 ; i < SIZE; i++){
                    arr[1][SIZE - i - 1][2] = queue.poll();
                }
            }
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    static int T, n;
    static ArrayList<String> moveList;
    static Cube cube;
    

    public static void main(String[] args) throws IOException {
        T = Integer.parseInt(br.readLine());
        
        for(int i = 0 ; i < T; i++){
            n = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            moveList = new ArrayList<>();
            for(int j = 0 ; j < n; j++){
                moveList.add(st.nextToken());
            }
            cube = new Cube();

            solve();
            
            // 맨 윗면 출력
            for(int j = 0; j < SIZE; j++){
                for(int k = 0; k < SIZE; k++){
                    bw.write(cube.arr[0][j][k] + "");
                }
                bw.write("\n");
            }
        }

        bw.close();
        br.close();
    }

    static void solve(){
        for(int i = 0 ; i < moveList.size(); i++){
            String str = moveList.get(i);
            char loc = str.charAt(0);
            char dir = str.charAt(1);

            if(dir == '+') cube.move(loc);
            else {
                cube.move(loc);
                cube.move(loc);
                cube.move(loc);
            }
        }
    }
}
