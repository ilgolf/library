package KAKAOBlind;

import java.util.*;

class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        String[] str = s.replaceAll("[{}]", " ").trim().split(" ,");
        answer = new int[str.length];
        Set<Integer> hs = new HashSet<>();
        Arrays.sort(str, (a,b) -> (a.length() - b.length()));

        int i = 0;
        for(String strr : str) {
            for(String strrr : strr.split(",")) {
                int a = Integer.parseInt(strrr.trim());
                
                if(hs.contains(a)) { continue; }
                hs.add(a);
                answer[i ++] = a;
            }
        }
        return answer;
    }
}
