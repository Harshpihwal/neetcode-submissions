class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n+1];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        return helper(n-1,dp,nums);
    }
    private int helper(int idx,int[] dp,int[] arr){
        if(idx==0){
            return arr[idx];
        }
        if(idx<0){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int pick=arr[idx]+helper(idx-2,dp,arr);
        int notpick=helper(idx-1,dp,arr);
        return dp[idx]=Math.max(pick,notpick);
    }
}
