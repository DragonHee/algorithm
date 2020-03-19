package backjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Backjoon1991 {
    static class Node{
        int me;
        int left;
        int right;
        public Node(int me, int left, int right){
            this.me = me;
            this.left = left;
            this.right = right;
        }
    }
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());


        Node arr[] = new Node[N];

        for(int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if(left == '.') left = '0';
            if(right == '.') right = '0';

            arr[parent - 'A'] = new Node(parent - 'A', left - 'A', right - 'A');
        }

        Stack<Node> stack = new Stack<>();
        stack.push(arr[0]);

        while(!stack.isEmpty()){
            Node node = stack.pop();

            if(node.left >= 0){
                stack.push(arr[node.left]);
            }
            if(node.right >= 0){
                stack.push(arr[node.right]);
            }
            System.out.print(node.me);
        }

    }

    public static void search1(){

    }
}
