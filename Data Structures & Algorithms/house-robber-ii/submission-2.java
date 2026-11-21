class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if (n == 1) {
            return nums[0];
        }
        int[] dp=new int[n+1];
        for(int i=0;i<n;i++){
            dp[i]=-1;
        }
        int[] dp1=new int[n+1];
        for(int i=0;i<n;i++){
            dp1[i]=-1;
        }
        int a=helper(1,n-1,dp,nums);
        int b=helper(0,n-2,dp1,nums);
        return Math.max(a,b);
    }
    private int helper(int st,int idx,int[] dp,int[] arr){
        if(idx==st){
            return arr[st];
        }
        if(idx<st){
            return 0;
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        int pick=arr[idx]+helper(st,idx-2,dp,arr);
        int notpick=helper(st,idx-1,dp,arr);
        return dp[idx]=Math.max(pick,notpick);
    }
}
