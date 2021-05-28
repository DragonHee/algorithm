package backjoon.sortion;

public class QuickSort {
    public static void main(String[] args){
        int arr[] = new int[]{3,6,7,8,2,1,10,4,5,9};

        quickSort(arr, 0, arr.length - 1);

        for(int num : arr) System.out.print(num + " ");
    }

    public static void quickSort(int[] arr, int left, int right){
        if(left < right){
            int pivot = conquer(arr, left, right);

            quickSort(arr, left, pivot - 1);
            quickSort(arr, pivot + 1, right);
        }
    }

    public static int conquer(int[] arr, int left, int right){
        int pivot = arr[right];
        int i = left - 1;

        for(int j = left; j < right; j++){
            if(arr[j] <= pivot){
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, right);

        return i + 1;
    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];

        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}
