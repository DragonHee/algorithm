package backjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Backjoon1991 {
    static class Node{
        int parent;
        int leftChild;
        int rightChild;
        public Node(int parent, int leftChild, int rightChild){
            this.parent = parent;
            this.leftChild = leftChild;
            this.rightChild = rightChild;
        }
    }
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());


        Node arr[] = new Node[N];
        int parentArr[] = new int[N];
        Arrays.fill(parentArr, -1);

        for(int i = 0 ; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            char parent = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if(left == '.') left = '0';
            if(right == '.') right = '0';

            arr[parent - 'A'] = new Node(parent - 'A', left - 'A', right - 'A');
            if(left != '0') parentArr[left - 'A'] = parent - 'A';
            if(right != '0') parentArr[right - 'A'] = parent - 'A';

        }

        Stack<Node> stack = new Stack<>();
        Queue<Integer> stackAns = new LinkedList<>();

        stack.push(arr[0]);



        //
        while(!stack.isEmpty()){
            Node node = stack.pop();


            stackAns.add(node.parent);
            if(node.rightChild >= 0) stack.push(arr[node.rightChild]);

            if(node.leftChild >= 0) stack.push(arr[node.leftChild]);
        }

        while (!stackAns.isEmpty()){
            sb.append((char)(stackAns.poll() + 'A'));
        }

        stack.push(arr[0]);

        while(!stack.isEmpty()){
            Node node = stack.pop();

            stackAns.add(node.parent);
            if(node.rightChild >= 0) stack.push(arr[node.rightChild]);
            if(node.leftChild >= 0) stack.push(arr[node.leftChild]);
        }

        while (!stackAns.isEmpty()){
            sb.append((char)(stackAns.poll() + 'A'));
        }


        sb.append("\n");
        System.out.println(sb.toString());
    }

}
