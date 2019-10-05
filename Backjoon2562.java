import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Backjoon2562 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int index = 0;
        int maxNum = 0;
        int i = 0;
        String num;

        while((num = br.readLine()) != null){
            i++;
            if(Integer.parseInt(num) >= maxNum) {
                maxNum = Integer.parseInt(num);
                index = i;
            }
        }

        System.out.println(maxNum + "\n" + index);
    }
}
