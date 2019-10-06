
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Backjoon2581 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int m = Integer.parseInt(br.readLine());
        int n = Integer.parseInt(br.readLine());
        Map<String, Integer> result = new HashMap<String, Integer>();

        result = calcPrimeNum(m, n);
        if(result.get("tot") == 0) bw.write("-1\n");
        else{
            bw.write(result.get("tot") + "\n");
            bw.write(result.get("min") + "\n");
        }
        bw.close();
        br.close();
    }

    private static Map<String, Integer> calcPrimeNum(int m, int n){
        int arr[] = new int[n + 1];
        int tot = 0, min = 0;
        boolean flag = false;
        Map<String, Integer> result = new HashMap<String, Integer>();

        for(int i = 2 ; i <arr.length; i++){
            arr[i] = i;
        }

        for(int i = 2; i < arr.length; i++){
            if(arr[i] == 0) continue;
            for(int j = 2 * i; j < n + 1; j += i){
                arr[j] = 0;
            }
        }

        for(int i = m; i <= n; i++){
            if(arr[i] != 0) {
                tot += arr[i];
                if(!flag){
                    min = arr[i];
                    flag = true;
                }
            }
        }

        result.put("tot", tot);
        result.put("min", min);
        return result;
    }

}
