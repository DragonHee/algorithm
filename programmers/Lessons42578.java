package programmers;

import java.util.HashMap;

public class Lessons42578 {
    public int solution(String[][] clothes) {
        int answer = 0;
        HashMap<String, Integer> clothesCountMap = new HashMap<String, Integer>();
        
        addClothesMap(clothesCountMap, clothes);
        answer = calcClothCombination(clothesCountMap);
        
        return answer;
    }
    
    public void addClothesMap(HashMap<String, Integer> clothesCountMap, String[][] clothes){
        
        for(int i = 0 ; i < clothes.length; i++){
            clothesCountMap.put(clothes[i][1], clothesCountMap.getOrDefault(clothes[i][1], 0) + 1);
        }
        
    }
    
    public int calcClothCombination(HashMap<String, Integer> clothesCountMap){
        int count = 1;
        
        for(String key : clothesCountMap.keySet()){
            count *= clothesCountMap.get(key) + 1;
        }
        
        return count - 1;
    }
}