package backjoon.sortion;

import java.io.*;
import java.util.*;

class StudentScore implements Comparable{
    String name;
    int koScore, enScore, maScore;

    public StudentScore(String name, int koScore, int enScore, int maScore){
        this.name = name.toString();
        this.koScore = koScore;
        this.enScore = enScore;
        this.maScore = maScore;
    }

    @Override
    public int compareTo(Object o) {
        // TODO Auto-generated method stub
        int koScoreRes = this.koScore - ((StudentScore)o).koScore;
        int enScoreRes = this.enScore - ((StudentScore)o).enScore;
        int maScoreRes = this.maScore - ((StudentScore)o).maScore;

        if(koScoreRes < 0) return 1;
        else if(koScoreRes == 0){
            if(enScoreRes > 0) return 1;
            else if(enScoreRes == 0){
                if(maScoreRes < 0) return 1;
                else if(maScoreRes == 0) {
                    return name.compareTo(((StudentScore)o).name);
                }
                else return -1;
            }
            else return -1;
        }
        else return -1;
    }

}
public class Backjoon10825 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N;
    static StudentScore[] arr;
    public static void main(String[] args) throws IOException{
        N = Integer.parseInt(br.readLine());

        arr = new StudentScore[N];

        for(int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            int koScore = Integer.parseInt(st.nextToken());
            int enScore = Integer.parseInt(st.nextToken());
            int maScore = Integer.parseInt(st.nextToken());

            arr[i] = new StudentScore(name, koScore, enScore, maScore);
        }
        
        Arrays.sort(arr);

        for(int i = 0 ; i < N; i++){
            bw.write(arr[i].name + "\n");
        }
        
        bw.close();
        br.close();
    }
    
}
