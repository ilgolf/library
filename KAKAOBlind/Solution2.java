package KAKAOBlind;

class Solution2 {

    String makeCorrect(String w) {
        if(w.length() == 0) return "";

        int cut = division(w);
        String u = w.substring(0, cut);
        String v = w.substring(cut, w.length());

        if(isCorrect(u)) {
            return u + makeCorrect(v);
        } else {
            String temp = "(" + makeCorrect(v) + ")";
            u = u.substring(1, u.length() - 1);
            u = reverse(u);
            return temp + u;
        }
    }

    int division(String w) {
        int open = 0; int close = 0;

        for(int i=0; i<w.length(); i++) {
            if(w.charAt(i) == '(') open ++;
            else close ++;

            if(open == close) return i + 1;
        }
        return -1;
    }

    boolean isCorrect(String w) {
        int cnt = 0;

        for(char ch : w.toCharArray()) {
            if(ch == '(') cnt ++;
            else cnt --;

            if(cnt < 0) return false;
        }

        return true;
    }

    String reverse(String w) {
        StringBuilder sb = new StringBuilder();

        for(char ch : w.toCharArray()) {
            if(ch == '(') sb.append(")");
            else sb.append("(");
        }

        return sb.toString();
    }

    public String solution(String p) {
        return makeCorrect(p);
    }

    public static void main(String[] args) {
        String s = "()))((()";
        Solution2 sol = new Solution2();
        System.out.println(sol.solution(s));
    }
}
