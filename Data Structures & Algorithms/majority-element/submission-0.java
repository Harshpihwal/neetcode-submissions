class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int x:nums){
            if(map.containsKey(x)){
                map.put(x,(map.get(x))+1);
            }else{
                map.put(x,1);
            }
        }
        int m=Integer.MIN_VALUE;
        int k=0;
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int val=entry.getValue();
            int key=entry.getKey();
            if(val>m){
                k=key;
                m=val;
            }
        }
        return k;
    }
}