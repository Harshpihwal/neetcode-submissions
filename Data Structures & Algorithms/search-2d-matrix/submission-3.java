class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int idx = -1;
        if (m == 1) {
            return binsrch(matrix[0],target);
        }
        if (target >= matrix[0][0] && target <= matrix[0][n - 1]) {
            idx = 0;
        } else {
            for (int i = 1; i < m; i++) {
                if (matrix[i - 1][n - 1] < target && matrix[i][n - 1] >= target) {
                    idx = i;
                    break;
                }
            }
        }
        if (idx == -1) {
            return false;
        }
        return binsrch(matrix[idx], target);
    }
    private boolean binsrch(int[] arr, int t) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (arr[m] == t) {
                return true;
            } else if (arr[m] < t) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return false;
    }
}
