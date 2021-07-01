package InternShip;

import java.util.*;

class Solution02 {

    public String solution(int n, int k, String[] cmd) {
        String answer = "";

        Map<Integer, Integer> table = new HashMap<>();
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        
        int curIdx = k;
        
        table.put(0, 1);
        table.put(k, 1); 

        for(String c : cmd) {
            StringTokenizer st = new StringTokenizer(c, " ");
			String temp = st.nextToken();
            if(temp.equals("D")) {
                int num = Integer.parseInt(st.nextToken());
                if(curIdx + num > n) continue;

                table.put(curIdx + num, 1);
                curIdx = curIdx + num;
            }
            if(temp.equals("U")) {
                int num = Integer.parseInt(st.nextToken());
                if(curIdx - num < 0) continue;

                table.put(curIdx - num, 1);
                curIdx = curIdx - num;
            }
            if(temp.equals("C")) {
                if(curIdx >= n - 1) {
                    table.put(curIdx - 1, 1);
                    stack1.push(curIdx);
                    stack2.push(table.get(curIdx));
                    table.remove(curIdx);
                } else {
                    table.put(curIdx + 1, 1);
                    stack1.push(curIdx);
                    stack2.push(table.get(curIdx));
                    table.remove(curIdx);
                }
            }
            if(temp.equals("Z")) {
                int num1 = stack1.pop();
                int num2 = stack2.pop();
                table.put(num1, num2);
            }
        }

        for(int key = 0; key < n; key++) {
            if(table.containsKey(key)) {
                if(table.get(key) == 1) {
                    answer += "O";
                } else {
                    answer += "X";
                }                
            } else {
                answer += "X";
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        int n = 8;
        int k = 2;
        String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
        Solution02 so = new Solution02();
        System.out.println(so.solution(n, k, cmd));
    }
}
