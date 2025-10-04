class Solution {
    public int solution(int m, int n, String[] board) {
		int answer = 0;
		char[][] arr = new char[m][n];
		
		for(int i = 0 ; i < m ; i++) {
            for(int j=0; j<n; j++){
			    arr[i][j] = board[i].charAt(j);
            }
		}
		
		while(true) {
			int cnt = checkBlock(m, n, arr);
			if(cnt == 0) break;
			answer += cnt;
			
			dropBlock(m, n, arr);
		}
		
		return answer;
    }
    
    private int checkBlock(int m, int n, char[][] arr) {
        int cnt = 0;
        boolean[][] isChecked = new boolean[m][n];

        for(int i = 0 ; i < m - 1 ; i++) {
            for(int j = 0 ; j < n - 1 ; j++) {
                if(arr[i][j] == '.') continue;
                checkFour(arr, isChecked, i, j);
            }
        }

        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(isChecked[i][j]) {
                    cnt++;
                    arr[i][j] = '.';
                }
            }
        }
        return cnt;
    }
    private void checkFour(char[][] arr, boolean[][] isChecked, int a, int b) {
		char friends = arr[a][b];
		
		for(int i = a ; i < a + 2 ; i++) {
			for(int j = b ; j < b + 2 ; j++) {
				if(arr[i][j] != friends) return;
			}
		}
		
		for(int i = a ; i < a + 2 ; i++) {
			for(int j = b ; j < b + 2 ; j++) {
				isChecked[i][j] = true;
			}
		}
	}
    
    private void dropBlock(int m, int n, char[][] arr) {
		for(int i = 0 ; i < n ; i++) {
			for(int j = m - 1 ; j >= 0 ; j--) {
				if(arr[j][i] == '.') {
					for(int k = j - 1 ; k >= 0 ; --k) {
						if(arr[k][i] != '.') {
							arr[j][i] = arr[k][i];
							arr[k][i] = '.';
							break;
						}
					}
				}
			}
		}
	}
}