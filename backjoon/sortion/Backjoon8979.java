package backjoon.sortion;

import java.io.*;
import java.util.*;

class OlympicMedalInfo implements Comparable{
    int id, goldCnt, silverCnt, ironCnt;

    public OlympicMedalInfo(int id, int goldCnt, int silverCnt, int ironCnt){
        this.id = id;
        this.goldCnt = goldCnt;
        this.silverCnt = silverCnt;
        this.ironCnt = ironCnt;
    }

    @Override
    public int compareTo(Object o) {
        int goldDiff = this.goldCnt - ((OlympicMedalInfo)o).goldCnt;
        int silverDiff = this.silverCnt - ((OlympicMedalInfo)o).silverCnt;
        int ironDiff = this.ironCnt - ((OlympicMedalInfo)o).ironCnt;

        if(goldDiff < 0) return 1;
        else if(goldDiff == 0){
            if(silverDiff < 0) return 1;
            else if(silverDiff == 0) {
                if(ironDiff < 0) return 1;
                else if(ironDiff == 0) return 0;
                else return -1;
            }
            else return -1;
        }
        else return -1;
    }

    public boolean equals(OlympicMedalInfo o){
        if(this.goldCnt == o.goldCnt
            && this.silverCnt == o.silverCnt
                && this.ironCnt == o.ironCnt)
                    return true;
        return false;             
    }

}

public class Backjoon8979 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int N, K;
    static OlympicMedalInfo[] arr;

    public static void main(String[] args) throws IOException{
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        arr = new OlympicMedalInfo[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int goldCnt = Integer.parseInt(st.nextToken());
            int silverCnt = Integer.parseInt(st.nextToken());
            int ironCnt = Integer.parseInt(st.nextToken());

            arr[i] = new OlympicMedalInfo(id, goldCnt, silverCnt, ironCnt);
        }

        Arrays.sort(arr);

        int result = searchGrade(N, K);

        bw.write(result + "\n");
        bw.close();
        br.close();
    }

    static int searchGrade(int totalCnt, int searchId){
        int index = 0;

        for(int i = 0 ; i < N; i++){
            if(arr[i].id == searchId){
                index = i;
                break;
            }
        }

        for(int i = index - 1; i >= 0; i--){
            if(!arr[i].equals(arr[index])) return i + 2;
        }

        return 1;
    }
    
}
