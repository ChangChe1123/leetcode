package leetcode100;

public class L63 {
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int row = 0; row < m; row++){
            if(obstacleGrid[row][0] == 1){
                break;
            }
            dp[row][0] = 1;
        }
        for(int col = 0; col < n; col++){
            if(obstacleGrid[0][col] == 1){
                break;
            }
            dp[0][col] = 1;
        }
        for(int row = 1; row < m; row++){
            for(int col = 1; col < n; col++){
                if(obstacleGrid[row][col] == 1){
                    dp[row][col] = 0;
                }else{
                    dp[row][col] = dp[row-1][col] + dp[row][col-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
