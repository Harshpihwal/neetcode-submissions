class Solution {
    public int search(int[] nums, int target) {
        int s = 0;
        int e = nums.length - 1;
        if (nums[s] > nums[e]) {
            while (s < e) {
                int m = s + (e - s) / 2;
                if (nums[m] >= nums[s]) {
                    if (target >= nums[s]&& target <= nums[m]) {
                        return binsrch(nums, s, m, target);
                    } else {
                        s = m + 1;
                    }
                }
                else{
                    if(target>=nums[m] && target<=nums[e]){
                        return binsrch(nums,m,e,target);
                    }
                    else{
                        e=m;
                    }
                }
            }
        }
        return binsrch(nums, s, e, target);
    }
    private int binsrch(int[] arr, int s, int e, int t) {
        while (s <= e) {
            int m = s + (e - s) / 2;
            if (arr[m] == t) {
                return m;
            } else if (arr[m] < t) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return -1;
    }
}
