package programmers;
class Lessons42839 {
    public int solution(String numbers) {
        int answer = 0;
        // 입력받은 문자열을 저장할 정수형 배열
        int[] numberArr = new int[numbers.length()];
        // 중복된 숫자가 생성시 확인 할 배열
        boolean[] check = new boolean[10_000_000];
        
        // 배열에 저장
        for(int i = 0 ; i < numberArr.length; i++){
            numberArr[i] = numbers.charAt(i) - '0';
        }
        
        boolean[] isUsed = new boolean[numberArr.length];
        answer = combination(numberArr, isUsed, check, 0, 0); 
        
        return answer;
    }
    
    public int combination(int[] numberArr, boolean[] isUsed, boolean[] check, int count, int sum){
        int answer = 0;
        
        if(check[sum] == false){
            if(isPrimeNumber(sum) == true) answer++;
        }    
        check[sum] = true;
        
        if(count > numberArr.length) return answer;
        
        for(int i = 0 ; i < numberArr.length; i++){
            if(isUsed[i] == true) continue;
            
            isUsed[i] = true;
            sum = sum * 10 + numberArr[i];
            answer += combination(numberArr, isUsed, check, count + 1, sum);
            sum = sum / 10;
            isUsed[i] = false;
        }
        
        return answer;   
    }
    
    public boolean isPrimeNumber(int number){
        if(number <= 1) return false;
        
        for(int i = 2; i <= Math.sqrt(number); i++){
            if(number % i == 0) return false;
        }
        
        return true;
    }
}