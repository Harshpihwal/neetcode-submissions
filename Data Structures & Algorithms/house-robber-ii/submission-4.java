class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1) return nums[0];
        int prev1=nums[0];
        int prev12=0;
        int prev2=nums[1];
        int prev22=0;
        for(int i=1;i<n-1;i++){
            int pick=nums[i];
            if(i>1) pick+=prev12;
            int notpick=prev1;
            int curr1=Math.max(pick,notpick);
            prev12=prev1;
            prev1=curr1;
        }
        for(int i=2;i<n;i++){
            int pick=nums[i];
            if(i>1) pick+=prev22;
            int notpick=prev2;
            int curr2=Math.max(pick,notpick);
            prev22=prev2;
            prev2=curr2;
        }
        return Math.max(prev1,prev2);
    }
}

