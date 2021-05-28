package backjoon.trie;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Backjoon5052 {
    static class Node{
        int num;
        Node[] childNodeArr;

        public Node(){
            childNodeArr = new Node[10];
        }

        public Node(int num){
            this.num = num;
            childNodeArr = new Node[10];
        }

        public boolean addNode(Node node){
            if(childNodeArr[node.num] == null){
                childNodeArr[node.num] = node;
                return true;
            }
            else return false;
        }

        public boolean hasChildren(){
            for(int i = 0 ; i < 10; i++){
                if(childNodeArr[i] != null) return true;
            }

            return false;
        }
    }
    static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static final BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    
    public static void main(String[] args) throws IOException{
        int testCnt = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < testCnt; i++){
            int n = Integer.parseInt(br.readLine());
            String[] phoneNumArr = new String[n];
            
            // 전화번호 입력 받기
            getPhoneNum(phoneNumArr);
            // 입력받은 배열 길이 오름차순으로 정렬
            sortPhoneNumByLength(phoneNumArr);

            Node rootNode = new Node();
            boolean res = false;

            for(int j = 0 ; j < n; j++){
                res = addTrie(phoneNumArr[j], rootNode);
                if(res == false) break;
            }
           
            if(res == false) bw.write("NO\n");
            else bw.write("YES\n");
        }

        bw.close();
        br.close();
    }

    public static void sortPhoneNumByLength(String[] phoneNumArr){
        Arrays.sort(phoneNumArr, new Comparator<String>(){

            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
            
        });
    }

    public static void getPhoneNum(String[] phoneNumArr) throws IOException{
        for(int i = 0 ; i < phoneNumArr.length; i++){
            phoneNumArr[i] = br.readLine();
        }
    }

    public static boolean addTrie(String phoneNum, Node rootNode){
        // 포인터가 루트노드를 가르키도록 설정
        Node pointer = rootNode;

        for(int j = 0 ; j < phoneNum.length(); j++){
            // 전화번호의 각자리의 수
            int num = phoneNum.charAt(j) - '0';
            Node node = new Node(num);
            
            // 이미 있으면 false 리턴
            // 없어서 추가되었으면 true 리턴
            boolean res = pointer.addNode(node);

            // 현재 pointer를 자식 노드로 변경
            pointer = pointer.childNodeArr[num];
            
            // 이미 있었고 && 자식이 없다면
            // 일관성에 어긋난다.
            if(res == false && !pointer.hasChildren()){
                return false;
            }
        }

        return true;
    }
}
