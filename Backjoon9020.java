import java.io.*;

public class Backjoon9020 {
    private static final int MAX = 10000;
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    private static int primeArr[] = new int[MAX + 1];

    public static void main(String[] args) throws IOException {
        int testCnt = Integer.parseInt(br.readLine());
        int num;

        initPrimeArr();
        for(int i = 0; i < testCnt; i++){
            num = Integer.parseInt(br.readLine());
            getGoldBachPartition(num);
        }
        bw.close();
        br.close();
    }

    private static void getGoldBachPartition(int num) throws IOException {
        for(int i = 0; i < num / 2; i++){
            if(primeArr[num / 2 + i] != 0 && primeArr[num / 2 - i] != 0){
                bw.write((num / 2 - i) + " " + (num / 2 + i) + "\n");
                return;
            }
        }
    }

    private static void initPrimeArr() {
        for(int i = 2; i <= MAX; i++){
            primeArr[i] = i;
        }
        for(int i = 2; i <= Math.sqrt(MAX); i++){
            if(primeArr[i] == 0) continue;
            for(int j = 2 * i; j <= MAX; j += i){
                primeArr[j] = 0;
            }
        }
    }
}
