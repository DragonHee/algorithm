package programmers;

import java.util.*;

class Index{
    int depth;
    int node;
    
    public Index(int depth, int node){
        this.depth = depth;
        this.node = node;
    }
}

public class Lessons49189 {
    public int solution(int n, int[][] edge) {
        int answer = 0;
        
        ArrayList[] graph = initEdge(n, edge);
        int[] minDepth = search(n, graph);
        int maxDepth = getMaxDepth(minDepth);
        answer = getAnswer(maxDepth, minDepth);
        
        return answer;
    }
    
    public int getAnswer(int maxDepth, int[] minDepth){
        int result = 0;
        
        for(int i = 1; i < minDepth.length; i++){
            if(maxDepth == minDepth[i]) result++;
        }
        
        return result;
    }
    
    public int getMaxDepth(int[] minDepth){
        int maxDepth = 0;
        
        for(int i = 1; i < minDepth.length; i++){
            maxDepth = Math.max(maxDepth, minDepth[i]);
        }
        
        return maxDepth;
    }
    
    public ArrayList[] initEdge(int n, int[][] edge){
        ArrayList[] graph = new ArrayList[n + 1];
        for(int i = 0 ; i <= n; i++) graph[i] = new ArrayList<>();
        
        for(int i = 0; i < edge.length; i++){
            for(int j = 0 ; j < 2; j++){
                graph[edge[i][0]].add(edge[i][1]);
                graph[edge[i][1]].add(edge[i][0]);
            }
        }
        
        return graph;
    }
    
    public int[] search(int n, ArrayList[] graph){
        int[] minDepth = new int[n + 1];
        boolean[] check = new boolean[n + 1];
        
        Queue<Index> queue = new LinkedList<>();
        check[1] = true;
        queue.add(new Index(0, 1));
        
        while(!queue.isEmpty()){
            Index curIndex = queue.poll();
            int curDepth = curIndex.depth;
            int curNode = curIndex.node;
            
            minDepth[curNode] = curDepth;
            
            for(int i = 0; i < graph[curNode].size() ; i++){
                int toNode = (Integer)graph[curNode].get(i);
                
                // 기 방문점인 경우 생략
                if(check[toNode] == true) continue;
                
                queue.add(new Index(curDepth + 1, toNode));
                check[toNode] = true;
            }     
        }
        
        return minDepth;        
    }
}