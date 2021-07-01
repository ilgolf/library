package InternShip;

import java.util.*;

class P {
    int x, y;

    public P(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution01 {

    static int[][] moving = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static String[][] map = new String[5][5];

    // bfs탐색후 올바른 멘헤튼 거리두기 이면 true를 리턴
    static boolean bfs(String[] arr, int x, int y) {
        Queue<P> queue = new LinkedList<>();
        
        for(int i=0; i<arr.length; i++) {
            map[i] = arr[i].split("");
        }
        
        if(map[x][y].equals("P")){
            queue.offer(new P(x, y));
        }

        while(!queue.isEmpty()) {
            P curr = queue.poll();

            for(int i=0; i<moving.length; i++) {
                int nx = curr.x + moving[i][0];
                int ny = curr.y +  moving[i][1];

                if(nx >= 0 && ny >= 0 && nx < 5 && ny < 5) {
                    if(map[nx][ny].equals("P")) {
                        if(cal(nx, ny, x, y) < 3) {
                            return false;
                        }
                        queue.offer(new P(nx, ny));
                    }
                }
            }
        }

        return true;
    }   

    static int cal(int nx, int ny, int x, int y) {
        return Math.abs(nx - x) + Math.abs(ny - y); 
    }

    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];

        int i =0;
        for(String[] arr : places) {
            if(bfs(arr, 0, 0)) {
                answer[i++] = 1;
            }  else {
                answer[i++] = 0;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String[][] places = {
            {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, 
            {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, 
            {"PXOPX", "OXOXP", "OXPXX", "OXXXP", "POOXX"}, 
            {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, 
            {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}
        };

        Solution01 sol = new Solution01();
        System.out.println(Arrays.toString(sol.solution(places)));
    }
}