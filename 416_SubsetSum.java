// 416 Leetcode Partition equal subset sum
class Solution {
    public boolean canPartition(int[] nums) {
        int len = nums.length,i,j,sum=0;
        for(i=0;i<len;i++)
            sum+=nums[i];
        if(sum%2!=0)
            return false;
        sum = sum/2;
        boolean [][]dp = new boolean[len+1][sum+1];
        dp[0][0] = true;
        for(i = 1;i<=len;i++){
            
            for(j = 0;j<=sum;j++){
                if(nums[i-1]>j)
                    dp[i][j] = dp[i-1][j];
                else if(nums[i-1]<=j)
                    dp[i][j] = dp[i-1][j]||dp[i-1][j-nums[i-1]];
            }
            // System.out.println(Arrays.toString(dp[i]));
        }
        
        if(dp[len][sum])
            return true;
        return false;
    }
}