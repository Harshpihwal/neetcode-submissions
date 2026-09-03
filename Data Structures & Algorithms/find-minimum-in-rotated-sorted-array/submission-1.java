class Solution {
    public int findMin(int[] nums) {
        int s=0;
        int e=nums.length-1;
        while(s<e){
            int m=s+(e-s)/2;
            if(nums[m]>=nums[e] && nums[m]>=nums[s]){
                s=m+1;
            }
            else if(nums[m]>=nums[e] && nums[m]<=nums[s]){
                s=m+1;
            }
            else if(nums[m]<=nums[e] && nums[m]>=nums[s]){
                e=m;
            }
            else if(nums[m]<=nums[e] && nums[m]<=nums[s]){
                e=m;
            }
        }
        return nums[s];
    }
}
