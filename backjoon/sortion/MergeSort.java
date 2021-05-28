package backjoon.sortion;

public class MergeSort {

    public static void main(String[] args){
        int arr[] = new int[]{33,14,616,72,234,41,21,3,1,5,22};

        mergeSort(arr, 0, arr.length - 1);

        for(int num : arr) System.out.print(num + " ");
    }

    public static void mergeSort(int[] arr, int left, int right){
        if(left < right){
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int[] temp = new int[arr.length];

        int index = left;
        int point1 = left;
        int point2 = mid + 1;

        while(point1 <= mid && point2 <= right){
            if(arr[point1] < arr[point2]){
                temp[index++] = arr[point1++];
            }
            else{
                temp[index++] = arr[point2++];
            }
        }

        while(point1 <= mid){
            temp[index++] = arr[point1++];
        }

        while(point2 <= right){
            temp[index++] = arr[point2++];
        }

        for(int i = left; i <= right; i++){
            arr[i] = temp[i]; 
        }
    }
    
}
