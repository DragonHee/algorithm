import java.io.*;

public class Backjoon2775 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int testCnt = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < testCnt; i++){
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            bw.write(calcResidentNum(k, n) + "\n");
            bw.flush();
        }
        br.close();
        bw.close();
    }

    private static int calcResidentNum(int k , int n){
        if(k == 0) {
            return n;
        }else{
            int sum = 0;
            for(int i = 1 ; i <= n; i++){
                sum += calcResidentNum(k - 1, i);
            }
            return sum;
        }
    }
}
