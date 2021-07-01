package KAKAOBlind;

class Solution3 {

    public void match(int[][] arr, int[][] key, int rot, int r, int c) {
        int n = key.length;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {

                // case 별 회전하며 탐색 
                if(rot == 0) {
                    arr[r + i][c + j] += key[i][j];
                } else if(rot == 1) {
                    arr[r + i][c + j] = key[j][n - 1 - i];
                } else if(rot == 2) {
                    arr[r + i][c + j] = key[n - 1 - i][n - 1 - j];
                } else {
                    arr[r + i][c + j] = key[n - 1 - j][i];
                }
            }
        }
    }

    // 자물쇠가 잠겼는지 체크
    boolean check(int[][] arr, int offset, int n) {
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {

                // 갖다 대봤을때 전부 1이어야 true 리턴
                if(arr[offset + i][offset + j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }

    public boolean solution(int[][] key, int[][] lock) {
        int offset = key.length - 1;

        for(int r=0; r<offset + lock.length; r++) {   // 행 이동
            for(int c=0; c<offset + lock.length; c++) {  // 열 이동
                for(int rot = 0; rot<4; rot ++) {  // 90도 회전
                    int[][] arr = new int[58][58]; // 최대길이*3 해주고 -2 해주기 맨위, 맨밑 두칸은 어차피 겹칠수가 없기때문
                    for(int i=0; i<lock.length; i++) {
                        for(int j=0; j<lock.length; j++) {
                            arr[offset + i][offset + j] = lock[i][j];  // 가운데 자물쇠 적용
                        }
                    }

                    match(arr, key, rot, r, c);
                    if(check(arr, offset, lock.length)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}