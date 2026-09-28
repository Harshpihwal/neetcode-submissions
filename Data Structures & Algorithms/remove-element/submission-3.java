class Solution {
    public int removeElement(int[] nums, int val) {
        int k=0;
        for(int x:nums){
            if(x==val){
                k++;
            }
        }
        int n=nums.length;
        int j=n-1;
        int i=0;
        if(k==n){
            return 0;
        }
        while(i<n-k){
            if(nums[i]==val){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                j--;
            }else{
                i++;
            }
        }
        return n-k;
    }
}