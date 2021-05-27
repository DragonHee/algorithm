package programmers;

public class Lessons60057 {
    public int solution(String s) {
        int answer = s.length();
        
        for(int i = 1; i <= s.length() / 2; i++){
            // 단위길이 당 압축된 길이 반환
            int num = getCompressedLength(s, i);
            // 최소값 저장
            answer = Math.min(answer, num);
        }
        
        return answer;
    }
    
    public int getCompressedLength(String s, int cutLength){
        int result = s.length();
        int curIndex = 0;
        
        // 연속된 일치인지 구분하기 위한 변수
        boolean isAlreadySame = false;
        int count = 1;
        
        while(curIndex < s.length() - cutLength){
            boolean flag = true;
        
            for(int i = curIndex; i < curIndex + cutLength; i++){
                if(i + cutLength >= s.length() || s.charAt(i) != s.charAt(i + cutLength)) {
                    flag = false;
                    break;
                }
            }

            if(flag == true) {    
                count++;
                
                if(isAlreadySame == true) {
                    if(count == 10 || count == 100 || count == 1000) 
                        result = result - cutLength + 1;
                    else 
                        result -= cutLength;
                }
                else result = result + 1 - cutLength;
                
                isAlreadySame = true;
            }
            else{
                isAlreadySame = false;
                count = 1;
            }
            
            curIndex += cutLength;
        }
       
        return result;
    }
}
