package KAKAOBlind;

import java.util.*;

class Road {
    int x, y, cost, dir;

    public Road(int x, int y, int cost, int dir) {
        this.x = x;
        this.y = y;
        this.cost = cost;
        this.dir = dir;
    }
}

class Solution_last {

    static int answer;
    static boolean[][] checked;
    static int[][] moving = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int[][] Board;

    static void bfs(int x, int y, int cost, int dir) {
        int n = Board.length;
        Queue<Road> queue = new LinkedList<>();
        queue.offer(new Road(x, y, cost, dir));
        checked[x][y] = true;

        while(!queue.isEmpty()) {
            Road curr = queue.poll();

            if(curr.x == n - 1 && curr.y == n - 1) {
                answer = Math.min(answer, curr.cost);
                continue;
            }
            
            for(int i=0; i<moving.length; i++) {
                int nx = curr.x + moving[i][0];
                int ny = curr.y + moving[i][1];

                if(nx >= 0 && ny >= 0 && nx < n && ny < n) {
                    if(Board[nx][ny] != 1  || !checked[x][y]) {
                        int nCost = 0;
                        if(curr.dir == -1 || curr.dir == i) {
                            nCost = curr.cost + 100;
                        } else if(curr.dir != i) {
                            nCost = curr.cost + 600;
                        }

                        if(Board[nx][ny] == 0) {
                            Board[nx][ny] = nCost;
                            queue.offer(new Road(nx, ny, nCost, i));
                        } else if(Board[nx][ny] >= nCost) {
                            Board[nx][ny] = nCost;
                            queue.offer(new Road(nx, ny, nCost, i));
                        }
                    }
                }
            }
        }
    }

    public int solution(int[][] board) {
        answer = Integer.MAX_VALUE;
        Board = board;
        checked = new boolean[board.length][board[0].length];

        bfs(0, 0, 0, -1);

        return answer;
    }
}