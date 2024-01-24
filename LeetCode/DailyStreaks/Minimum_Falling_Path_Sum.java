class Solution {
    
    public int minFallingPathSum(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        for(int i=0; i<col; i++){
            dp[0][i] = matrix[0][i];
        }
        for(int i = 1; i<row; i++){
            for(int j= 0; j<col; j++){
                int top = Integer.MAX_VALUE;
                int topleft = Integer.MAX_VALUE;
                int topright = Integer.MAX_VALUE;
                if(j-1>= 0){
                    topleft = dp[i-1][j-1];
                }
                
                top = dp[i-1][j];
        
                if(j+1<col){
                    topright = dp[i-1][j+1];
                }
                dp[i][j] = matrix[i][j]+Math.min(topleft,Math.min(top,topright));
            }
        }
        int minim = Integer.MAX_VALUE;
        for(int i=0; i<col; i++){
            
            if(minim>dp[row-1][i]){
                minim = dp[row-1][i];
            }/*U can use the Minimun function directly like
                minim = Math.min(minim,dp[row-1][i]);     */

        }
       return minim; 
    }
}