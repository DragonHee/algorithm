    package backjoon.bruteforce;

    import java.io.*;

    public class Backjoon1065 {
        private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        private static int N;
        private static int CNT;

        public static void main(String[] args) throws Exception{
            N = Integer.parseInt(br.readLine());
            
            while(N >= 1){
                solve(N--);
            }
        
            bw.write(CNT + "\n");

            br.close();
            bw.close();
        }

        public static void solve(int number){
            if(number < 100){
                CNT++;
                return;
            }

            int num1 = number / 100;
            number %= 100;
            int num2 = number / 10;
            number %= 10;
            int num3 = number;

            int cha1 = num1 - num2;
            int cha2 = num2 - num3;
            
            if(cha1 == cha2) CNT++;
        }
    }
