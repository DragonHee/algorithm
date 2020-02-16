package backjoon.dp_minpath;


import java.io.*;
import java.util.StringTokenizer;

class Info{
    int num;
    String path;

    public Info() {
        num = 0;
        path = "";
    }

    public Info setNum(int num) {
        this.num = num;
        return this;
    }

    public Info setPath(String path) {
        this.path = path;
        return this;
    }
}

public class Backjoon14002 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];
        Info dp[] = new Info[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 1 ; i <= n; i++){
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
            dp[i] = new Info();
        }

        dp[0] = new Info();
        for(int i = 1; i <= n; i++){
            for(int j = 0 ; j < i; j++){
                if(arr[i] > arr[j]){
                    int length;
                    String path;

                    if(dp[j].num + 1 > dp[i].num){
                        length = dp[j].num + 1;
                        path = dp[j].path + arr[i] + " ";

                        dp[i].setNum(length).setPath(path);
                    }
                }
            }
        }

        int maxLength = 0;
        String maxPath = "";

        for(int i = 1; i <= n; i++){
            if(dp[i].num > maxLength){
                maxLength = dp[i].num;
                maxPath = dp[i].path;
            }
        }

        bw.write(maxLength + "\n");
        bw.write(maxPath + "\n");

        bw.close();
        br.close();
     }
}
