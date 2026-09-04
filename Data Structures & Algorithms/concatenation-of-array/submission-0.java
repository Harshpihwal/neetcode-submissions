class Solution {
    public int[] getConcatenation(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n*2];
        int p=0;
        for(int i=0;i<n;i++){
            ans[i]=nums[i];
            ans[n+p]=nums[i];
            p++;
        }
        return ans;
    }
}