package programmers;

import java.util.Arrays;
import java.util.Comparator;

public class Lessons42577 {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        
        // 길이순으로 정렬
        Arrays.sort(phone_book, new Comparator<String>(){
            public int compare(String str1, String str2){
                return str1.length() - str2.length();
            } 
        });
        
        Trie rootNode = new Trie();
        for(int i = 0 ; i < phone_book.length; i++){
            if(addTrie(rootNode, phone_book[i]) == false){
                answer = false;
                break;
            }
        }
        
        return answer;
    }
    
    public boolean addTrie(Trie rootNode, String phoneNumber){
        boolean res = true;
        
        Trie curPoint = rootNode;
        
        for(int i = 0 ; i < phoneNumber.length(); i++){
            int number = phoneNumber.charAt(i) - '0';
            
            if(curPoint.addChildren(new Trie(number)) == false){
                if(curPoint.isThereMoreNode(number) == false){
                    res = false;
                    break;
                }
            }
            
            curPoint = curPoint.children[number];            
        }
        
        return res;
    }
}

class Trie{
    int number;
    Trie[] children;
    
    public Trie(){
        children = new Trie[10];
    }
    
    public Trie(int number){
        this.number = number;
        children = new Trie[10];
    }
    
    public boolean addChildren(Trie child){
        int number = child.number;
        // 이미 자식 노드가 있는 경우
        // false return
        if(children[number] != null) return false;
        
        // 자식 노드가 없는 경우
        children[number] = child;
        return true;
    }
    
    public boolean isThereMoreNode(int number){
        // number에 해당하는 자식노드에 자식노드가 있는 경우
        for(int i = 0 ; i <= 9; i++) 
            if(children[number].children[i] != null) return true;
        
        // number에 해당하는 자식노드에 자식노드가 없는 경우
        return false;
    }
}
