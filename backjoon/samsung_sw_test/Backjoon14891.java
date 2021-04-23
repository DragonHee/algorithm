package backjoon.samsung_sw_test;

import java.io.*;
import java.util.*;

public class Backjoon14891 {
    static class Gear{
        static final int TOP_INDEX = 0;
        static final int RIGHT_INDEX = 2;
        static final int LEFT_INDEX = 6;

        ArrayList<Integer> gearNS;

        public Gear(ArrayList<Integer> gearNS){
            this.gearNS = gearNS;
        }
        // dir : 1 (시계), -1 (반시계)
        public void moveGear(int dir){
            if(gearNS == null) return;

            if(dir == 1){
                gearNS.add(0, gearNS.remove(gearNS.size() - 1));
            }
            else if(dir == -1){
                gearNS.add(gearNS.remove(0));
            }
        }
        public int getValue(int VALUE){
            if(gearNS == null) return -1;
            return gearNS.get(VALUE);
        }
    }
    static final int GEAR_NUM = 4;

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    static int answer;

    static ArrayList<Gear> gearList = new ArrayList<>();

    public static void main(String[] args) throws IOException{
        
        for(int i = 0; i < GEAR_NUM; i++){
            ArrayList<Integer> gearNS = new ArrayList<>();
            String input  = br.readLine();

            // N -> 0, S -> 1
            for (int j = 0; j < input.length(); j++){
                gearNS.add((int)(input.charAt(j) - '0'));
            }

            Gear g = new Gear(gearNS);
            gearList.add(g);
        }
        int K = Integer.parseInt(br.readLine());

        for(int i = 0; i < K; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            move(gearNum, dir);
        }
        
        calcAnswer();

        bw.write(answer + "\n");
        bw.close();
        br.close();
    }

    static void move(int gearNum, int dir){
        int gearIndex = gearNum - 1;

        int rightNS = gearList.get(gearIndex).getValue(Gear.RIGHT_INDEX);
        int leftNS =  gearList.get(gearIndex).getValue(Gear.LEFT_INDEX);
        
        ArrayList<Integer> rDirList = new ArrayList<>();
        ArrayList<Integer> lDirList = new ArrayList<>();

        int toDir = dir;

        // 오른쪽 톱니바퀴 회전
        for(int i = gearIndex + 1; i < GEAR_NUM; i++){
            // 같은 경우
            if(rightNS == gearList.get(i).getValue(Gear.LEFT_INDEX)) break;

            // 다른 경우 반대로 회전
            toDir *= -1;
            rDirList.add(toDir);
            rightNS = gearList.get(i).getValue(Gear.RIGHT_INDEX);
        }
        
        toDir = dir;

        // 왼쪽 톱니바퀴 회전
        for(int i = gearIndex - 1; i >= 0; i--){
            // 같은 경우
            if(leftNS == gearList.get(i).getValue(Gear.RIGHT_INDEX)) break;
            
            // 다른 경우 반대로 회전
            toDir *= -1;
            lDirList.add(toDir);
            leftNS = gearList.get(i).getValue(Gear.LEFT_INDEX);
        }

        // 자신의 톱니바퀴 회전
        gearList.get(gearIndex).moveGear(dir);
        // 자신기준 오른쪽 톱니바퀴 회전
        for(int i = 0; i < rDirList.size(); i++){
            gearList.get(gearIndex + i + 1).moveGear(rDirList.get(i));
        }
        // 자신기준 왼쪽 톱니바퀴 회전
        for(int i = 0; i < lDirList.size(); i++){
            gearList.get(gearIndex - i - 1).moveGear(lDirList.get(i));
        }
    }

    static void calcAnswer(){
        int count = 0;

        for(int i = 0; i < GEAR_NUM; i++){
            Gear g = gearList.get(i);
            int ns = g.getValue(Gear.TOP_INDEX);

            if(ns == 1) count += Math.pow(2, i);
        }

        answer = count;
    }
}
