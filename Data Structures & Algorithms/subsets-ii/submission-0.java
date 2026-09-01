class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> outer = new ArrayList<>();
        outer.add(new ArrayList<>());
        int s = 0;
        int e = 0;
        for (int j = 0; j < nums.length; j++) {
            s=0;
            if (j > 0 && nums[j] == nums[j - 1]) {
                s = e + 1;
            }
            e = outer.size() - 1;
            int n = outer.size();
            for (int i = s; i < n; i++) {
                List<Integer> internal = new ArrayList<>(outer.get(i));
                internal.add(nums[j]);
                outer.add(internal);
            }
        }
        return outer;
    }
}
