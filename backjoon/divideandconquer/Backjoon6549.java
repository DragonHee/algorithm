package backjoon.divideandconquer;


import java.io.*;
import java.util.StringTokenizer;

class SegmentTree{
    int n, arr[], rangeMinIndex[];

    public SegmentTree(int arr[]){
        n = arr.length;
        this.arr = arr.clone();
        rangeMinIndex = new int[n << 2];

        init(0, n - 1, 1);
    }

    private int init(int left, int right, int node){
        if(left == right) {
            return rangeMinIndex[node] = left;
        }

        int mid = (left + right) / 2;
        int leftMinIndex = init(left, mid, node << 1);
        int rightMinIndex = init(mid + 1, right, (node << 1) + 1);

        return rangeMinIndex[node] = arr[leftMinIndex] < arr[rightMinIndex] ?
                leftMinIndex : rightMinIndex;
    }
    private int query(int left, int right, int node, int nodeLeft, int nodeRight){
        if(nodeRight < left || right < nodeLeft) return Integer.MAX_VALUE;
        if(left <= nodeLeft && right >= nodeRight) return rangeMinIndex[node];

        int mid = (nodeLeft + nodeRight) >>> 1;
        int leftMinIndex = query(left, right, node << 1, nodeLeft, mid);
        int rightMinIndex = query(left, right, (node << 1) + 1, mid + 1, nodeRight);

        if(leftMinIndex == Integer.MAX_VALUE) return rightMinIndex;
        else if(rightMinIndex == Integer.MAX_VALUE) return leftMinIndex;
        else return arr[leftMinIndex] < arr[rightMinIndex] ? leftMinIndex : rightMinIndex;


    }

    public long getMaxWidth(int left, int right){
        long maxWidth, tmpWidth;
        int minIndex = query(left, right, 1, 0, n - 1);

        maxWidth = (long)(right - left + 1) * (long)arr[minIndex];

        if(left <= minIndex - 1){
            tmpWidth = getMaxWidth(left, minIndex - 1);
            maxWidth = Math.max(maxWidth, tmpWidth);
        }

        if(minIndex + 1 <= right){
            tmpWidth = getMaxWidth(minIndex + 1, right);
            maxWidth = Math.max(maxWidth, tmpWidth);
        }
        return maxWidth;
    }

}
public class Backjoon6549 {
    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] arr;
    static int n;
    public static void main(String[] args) throws IOException {
        StringTokenizer st;

        while(true){
            st = new StringTokenizer(br.readLine(), " ");
            n = Integer.parseInt(st.nextToken());
            arr = new int[n];
            if(n == 0) break;

            for(int i = 0 ; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            SegmentTree segmentTree = new SegmentTree(arr);
            bw.write(segmentTree.getMaxWidth(0, n - 1) + "\n");
        }
        bw.close();
        br.close();
    }

}
