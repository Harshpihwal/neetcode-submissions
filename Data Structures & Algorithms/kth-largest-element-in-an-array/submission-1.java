class Solution {
    public int findKthLargest(int[] nums, int k) {
        return selection(nums,1,k,nums.length-1);
    }
    private int max(int[] arr,int e){
        int m=0;
        int n=arr[0];
        for(int i=1;i<=e;i++){
            if(arr[i]>n){
                n=arr[i];
                m=i;
            }
        }
        return m;
    }
    private int selection(int[] arr,int n,int k,int end){
        if(n==k){
            return arr[max(arr,end)];
        }
        int m=max(arr,end);
        
        int temp=arr[m];
        arr[m]=arr[end];
        arr[end]=temp;
        return selection(arr,n+1,k,end-1);
    }
}
