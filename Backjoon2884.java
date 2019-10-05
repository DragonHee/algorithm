import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Backjoon2884 {
    private static final int ALARM_MIN = 45;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int hour, min;

        hour = Integer.parseInt(st.nextToken());
        min = Integer.parseInt(st.nextToken());

        if(hour == 0){
            if(min < ALARM_MIN){
                hour = 23;
                min = min + 15;
            }
            else{
                min = min - ALARM_MIN;
            }
        }
        else{
            if(min < ALARM_MIN){
                hour -= 1;
                min = min + 15;
            }
            else{
                min -= ALARM_MIN;
            }
        }

        System.out.println(hour + " " + min);
    }
}
