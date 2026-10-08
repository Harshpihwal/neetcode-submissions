class Solution {
    public int largestRectangleArea(int[] arr) {
        int[] nse=findnse(arr);
        int[] pse=findpse(arr);
        int maxi=0;
        for(int i=0;i<arr.length;i++){
            maxi=Math.max(maxi,arr[i]*(nse[i]-pse[i]-1));
        }
        return maxi;
    }

    private int[] findnse(int[] arr){
        int n=arr.length;
        int[] nse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            nse[i]=st.isEmpty()?n:st.peek();
            st.push(i);
        }
        return nse;
    }

    private int[] findpse(int[] arr){
        int n=arr.length;
        int[] pse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            pse[i]=st.isEmpty()?-1:st.peek();
            st.push(i);
        }
        return pse;
    }
}
