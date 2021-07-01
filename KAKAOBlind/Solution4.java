package KAKAOBlind;

class Solution4 {

    int[][] D = new int[200][200];
    final int INF = 400000;

    // 1번부터 n번까지 완전탐색
    void floyd(int n) {
        for(int k=0; k<n; k++) {
            for(int i=0; i<n; i++) {
                for(int j=0; j<n; j++) {
                    if(D[i][k] + D[k][j] < D[i][j]) {
                        D[i][j] = D[i][k] + D[k][j];
                    }
                }
            }
        }
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j) D[i][j] = 0;
                else D[i][j] = INF; // 초기값을 최댓값으로 지정해 최솟값 갱신
            }
        }

        for(int[] edge : fares) {
            D[edge[0] - 1][edge[1] - 1] = edge[2]; // 간선 연결 양방향
            D[edge[1] - 1][edge[0] - 1] = edge[2];
        }

        floyd(n);

        // 1부터 시작
        --s;
        --a;
        --b;

        int answer = INF;
        for(int k=0; k<n; k++) {
            // 시작점에서부터 합승하여 각 도착점의 합이 최솟값이면 갱신
           answer = Math.min(answer, D[s][k] + D[k][a] + D[k][b]);  
        }
        return answer;
    }
}