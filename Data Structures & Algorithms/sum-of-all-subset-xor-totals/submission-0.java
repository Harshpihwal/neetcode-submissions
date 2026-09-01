class Solution {
    public int subsetXORSum(int[] nums) {
        int xorsum=0;
        List<List<Integer>> subset=sub(nums);
        for(int i=0;i<subset.size();i++){
            int insum=0;
            for(int j=0;j<subset.get(i).size();j++){
                insum=insum^subset.get(i).get(j);
            }
            xorsum+=insum;
        }
        return xorsum;
    }
    private List<List<Integer>> sub(int[] nums){
        List<List<Integer>> outer=new ArrayList<>();
        outer.add(new ArrayList<>());
        for(int x:nums){
            int n=outer.size();
            for(int i=0;i<n;i++){
                List<Integer> internal=new ArrayList<>(outer.get(i));
                internal.add(x);
                outer.add(internal);
            }
        }
        return outer;
    }
}