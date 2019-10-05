import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon11729 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();
    private static int answer;

    public static void main(String[] args) throws IOException {
        int circleNum = Integer.parseInt(br.readLine());

        moveHanoiTower(circleNum, 1, 2, 3);
        System.out.println(answer);
        System.out.println(sb);
    }
    private static void moveHanoiTower(int circleNum, int from, int by, int to){
        if(circleNum == 1){
            sb.append(from + " " + to + "\n");
            answer++;
        }
        else{
            moveHanoiTower(circleNum - 1, from, to, by);
            sb.append(from + " " + to + "\n");
            answer++;
            moveHanoiTower(circleNum - 1, by, from, to);
        }
    }

}
