package KAKAOBlind;

class Solution5 {

    int[][] pidx = {
        {3, 1}, // 0
        {0, 0}, // 1
        {0, 1}, // 2
        {0, 2}, // 3
        {1, 0}, // 4
        {1, 1}, // 5
        {1, 2}, // 6  
        {2, 0}, // 7
        {2, 1}, // 8
        {2, 2}, // 9
    };
    
    int[] left_start = {3, 0};  // *
    int[] right_start = {3, 2}; // #
    String hand;


    // 탐색 case 에 따라 L 또는 R 리턴
    public String pushNumber(int num) {
        if(num == 1 || num == 4 || num == 7) return "L";
        if(num == 3 || num == 6 || num == 9) return "R";
        
        if(DistNum(left_start, num) > DistNum(right_start, num)) return "R";
        if(DistNum(left_start, num) < DistNum(right_start, num)) return "L";

        return this.hand;
    }

    // 거리 계산 메서드 
    public int DistNum(int[] pos, int num) {
        return Math.abs(pos[0] - pidx[num][0]) + Math.abs(pos[1] - pidx[num][1]); // 가장 가까운 거리 리턴
    }

    public String solution(int[] numbers, String hand) {
        this.hand = (hand.equals("right")) ? "R":"L";
        String answer = "";

        
        for(int num : numbers) {
            String fing = pushNumber(num);
            answer += fing;

            if(fing.equals("L")) left_start = pidx[num];
            if(fing.equals("R")) right_start = pidx[num];
        }

        return answer;
    }
}