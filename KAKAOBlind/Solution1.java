package KAKAOBlind;

class Solution1 {

    // 문자열 파싱 갯수만큼 파싱한 문자열 앞에 추가
    public String processHit(int hit) {
        return hit > 1 ? String.valueOf(hit) : "";
    }

    public int solution(String s) {
        if(s.length() == 1) return 1;
        int answer = 1001;
        
        for(int i=1; i<=s.length()/2; i++) {
           String now, next = "", result =  "";  // 지금 문자열 다음 문자열 결과 문자열
           int hit = 1;
           for(int j=0; j<=s.length()/i; j++) {
               int start = i * j; // 시작점
               int end = i * (j + 1) > s.length() ? s.length() : i * (j + 1); // 끝점일경우 s.length를 넘어가는것 방지
               now = next;
               next = s.substring(start, end);

               if(now.equals(next)) {
                   hit ++;  // 같은 문자열 갯수만큼 합치기 
               } else {
                   result += (processHit(hit) + now); // 같지 않은거 대로 따로 합치기
                   hit = 1;
               }
           }
           
           result += (processHit(hit) + next); // 같은 것들끼리 합치기
           answer = Math.min(answer, result.length());
        }
        return answer;
    }

    public static void main(String[] args) {
        String s = "aabbaccc";
        Solution1 sol = new Solution1();
        System.out.println(sol.solution(s));
    }
}