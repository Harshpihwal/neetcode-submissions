class KthLargest {
    ArrayList<Integer> list=new ArrayList<>();
    int k=0;
    int[] nums;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        this.nums=nums;
        for(int x:nums){
            list.add(x);
        }
    }
    
    public int add(int val) {
        list.add(val);
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for(int x:list){
            pq.offer(x);
            if(pq.size()>k){
                pq.poll();
            }
        }
        return pq.peek();
    }
}
