package KAKAOBlind;

import java.util.*;

class Solution6 {
    public static long answer = Long.MIN_VALUE;
    
    public static List<Long> numList = new ArrayList<>();  // 계산할 값 list
    public static List<String> operList = new ArrayList<>();  // 연산자 list

    public static String[] oper = {"+", "-", "*"};
    public static String[] outputs = new String[3];
    public static boolean[] checked = new boolean[3];

    public static void per(int depth, int r) {
        
        // 깊이 탐색
        if(depth == r) {
            solve();

            return;
        }

        for(int i=0; i<oper.length; i++) {
            if(!checked[i]) {
                checked[i] = true;
                outputs[depth] = oper[i];
                per(depth + 1, r);
                checked[i] = false;
            }
        }
    }

    public static void solve() {
        List<String> oper = new ArrayList<>();
        oper.addAll(operList);

        List<Long> num = new ArrayList<>();
        num.addAll(numList);

        for(int i=0; i<outputs.length; i++) {
            String curOper = outputs[i]; // 현재 연산자 

            for(int j=0; j<oper.size(); j++) {
                if(oper.get(j).equals(curOper)) { // 연산자 같을시 연산
                    long n1 = num.get(j); 
                    long n2 = num.get(j + 1);
                    long res = cal(n1, n2, curOper);

                    num.remove(j + 1);
                    num.remove(j);
                    oper.remove(j);

                    num.add(j, res);
                    j--;
                }
            }
        }
        answer = Math.max(answer, Math.abs(num.get(0))); // 절댓값 리턴
    }

    // 분할 계산
    public static long cal(long n1, long n2, String o) {
        long res = 0;
        switch(o) {
            case "+" :
                res = n1 + n2;
                break;
            case "-" :
                res = n1 - n2;
                break;
            case "*" :
                res = n1 * n2;
                break;
        }

        return res;
    }

    public long solution(String expression) {
        String n = "";
        for(int i=0; i<expression.length(); i++) {
            char exp = expression.charAt(i);

            if(exp == '+' || exp  == '-' || exp == '*') {  // 부호가 나왔을시 그 전 숫자들을 numList에 저장
                operList.add(exp + "");
                numList.add(Long.parseLong(n));
                n = "";
            } else {
                n += exp;
            }
        }

        numList.add(Long.parseLong(n));

        per(0, oper.length);
        
        return answer;
    }
}