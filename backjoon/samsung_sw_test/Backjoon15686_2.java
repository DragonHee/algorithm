package backjoon.samsung_sw_test;

import java.util.*;

public class Backjoon15686_2 {
    static int BIT = (1 << 3);
    static int CUT = (1 << BIT) - 1;
    static int N, M, result = Integer.MAX_VALUE;
    static int[] houseArr, chickenArr;
    static int houseCnt, chickenCnt;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        houseArr = new int[N << 1];
        chickenArr = new int[13];

        for(int i = 0; i < N; i++){
            for(int j = 0 ; j < N; j++){
                int input = sc.nextInt();
                if(input == 1){
                    houseArr[houseCnt++] = (i << BIT) | j;
                }else if(input == 2){
                    chickenArr[chickenCnt++] = (i << BIT) | j;
                }
            }
        }

        combination(0,0,0);

        System.out.println(result);
    }

    static void combination(int startIndex, int count, int visit){
        if(count == M){

            int num = 0;
            int[] selected = new int[M];

            for(int i = 0 ; i < chickenCnt; i++){
                if((visit & (1 << i)) == 0) continue;

                selected[num++] = chickenArr[i];
            }

            result = Math.min(result, getDist(selected));

            return;
        }

        for(int i = startIndex; i < chickenCnt; i++){
            visit |= (1 << i);
            combination(i + 1, count + 1, visit);
            visit &= ~(1 << i);
        }
    }

    static int getDist(int[] selected){
        int dist = 0;

        for(int i = 0 ; i < houseCnt; i++){
            dist += getDist(i, selected);
        }

        return dist;
    }

    static int getDist(int houseIndex, int[] selected){
        int dist = Integer.MAX_VALUE;

        int value = houseArr[houseIndex];
        int row = value >> BIT;
        int col = value & CUT;

        for(int i = 0 ; i < M; i++){
            int toRow = selected[i] >> BIT;
            int toCol = selected[i] & CUT;

            int a = Math.abs(toRow - row);
            int b = Math.abs(toCol - col);

            dist = Math.min(dist, a + b);
        }

        return dist;
    }
    
}
