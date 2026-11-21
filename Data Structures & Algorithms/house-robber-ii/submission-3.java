class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int[] dp=new int[n];
        int[] dp2=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=0;
            dp2[i]=0;
        }
        dp[0]=nums[0];
        dp2[1]=nums[1];
        for(int i=1;i<n-1;i++){
            int pick=nums[i];
            if(i>1) pick+=dp[i-2];
            int notpick=dp[i-1];
            dp[i]=Math.max(pick,notpick);
        }
        for(int i=2;i<n;i++){
            int pick=nums[i];
            if(i>1) pick+=dp2[i-2];
            int notpick=dp2[i-1];
            dp2[i]=Math.max(pick,notpick);
        }
        return Math.max(dp[n-2],dp2[n-1]);
    }
}
