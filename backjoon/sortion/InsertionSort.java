package backjoon.sortion;

import java.util.Scanner;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        insertionSort(arr);

        int x = 0 ;
        int y = 1;

        System.out.println((x < 1) | (y-- < 1));
        System.out.println(" x = " + x + ", y = " + y);

    }
    public static void insertionSort(int[] arr){
        int i, j;
        int key;

        for(i = 1; i < arr.length; i++){
            key = arr[i];
            j = i - 1;
            while(j >= 0 && key < arr[j]){
                arr[i] = arr[j];
                j--;
            }
            arr[j + 1] = key;
            for(int k = 0 ; k < arr.length; k++){
                System.out.print(arr[k] + " ");
            }
            System.out.println();
        }
    }
}
