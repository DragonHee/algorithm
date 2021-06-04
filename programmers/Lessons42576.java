package programmers;

import java.util.Arrays;

class Lessons42576 {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        
        Arrays.sort(participant);
        Arrays.sort(completion);
        
        for(int i = 0 ; i < participant.length - 1; i++){
            if(!participant[i].equals(completion[i])){
                answer = participant[i].toString();
                break;
            }
        }
        
        if(answer.equals("")) answer = participant[participant.length - 1].toString();
        
        return answer;
    }
}