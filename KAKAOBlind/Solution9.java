package KAKAOBlind;

import java.util.*;

class Solution9 {

    static Map<String, Integer> map = new HashMap<>(); 
    static Set<String> hs = new HashSet<>(); // 중복 걸러내기 위한 Set
    static Queue<String> queue = new LinkedList<>();
    static int startPoint = 0; 
    static int length = Integer.MAX_VALUE; // 최솟값 갱신

    public int[] solution(String[] gems) {
        for(String g : gems) {
            hs.add(g); // 중복을 제외하고 저장 
        }
        int start = 0;
        for(int i=0; i<gems.length; i++) {
            if(!map.containsKey(gems[i])) map.put(gems[i], 1); // 중복이 아닐경우 디폴트값 1
            else map.put(gems[i], map.get(gems[i]) + 1); // 중복일 경우 기존 value값에 + 1

            queue.add(gems[i]); 

            while(true) {
                String temp = queue.peek();
                // 처음 시작점을 겹치지 않는 곳에서 시작
                if(map.get(temp) > 1) {
                    map.put(temp, map.get(temp) - 1);
                    queue.poll();
                    startPoint ++;
                } else {
                    break;
                }
            }

            if(map.size() == hs.size() && length > queue.size()) {
                length = queue.size();
                start = startPoint;
            }
        }

        return new int[]{start + 1, start + length};
    }
}