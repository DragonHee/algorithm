import java.io.*;
import java.util.StringTokenizer;

public class Backjoon4153 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        StringTokenizer st;
        int a, b, c;

        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
            if(a == 0 && b == 0 && c == 0) break;
            checkRectangle(a, b, c);
        }
        br.close();
        bw.close();
    }
    private static void checkRectangle(int a, int b, int c) throws IOException {
        if(a > b && a > c){
            if(a * a == b * b + c * c) bw.write("right" + "\n");
            else bw.write("wrong" + "\n");
        }else if(b > a && b > c){
            if(b * b == a * a + c * c) bw.write("right" + "\n");
            else bw.write("wrong" + "\n");
        }else if(c > a &&  c > b){
            if(c * c == a * a + b * b) bw.write("right" + "\n");
            else bw.write("wrong" + "\n");
        }else{
            bw.write("wrong" + "\n");
        }
    }
}
