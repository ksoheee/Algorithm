class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int n = arr1.length;          // arr1의 행 개수
        int m = arr1[0].length;       // arr1의 열 개수 = arr2의 행 개수
        int p = arr2[0].length;       // arr2의 열 개수

        int[][] answer = new int[n][p]; // 결과 행렬 (n × p)

        for (int i = 0; i < n; i++) {          // arr1의 각 행
            for (int j = 0; j < p; j++) {      // arr2의 각 열
                for (int k = 0; k < m; k++) {  // arr1의 열 = arr2의 행
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }

        return answer;
    }
}
