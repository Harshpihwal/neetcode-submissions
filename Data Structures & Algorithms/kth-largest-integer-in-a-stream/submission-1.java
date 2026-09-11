class KthLargest {
    PriorityQueue<Integer> pq=new PriorityQueue<>();
    int k=0;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int x:nums){
            pq.offer(x);
            if(pq.size()>k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        
        if(pq.size()>k){
            pq.poll();
        }
        
        return pq.peek();
    }
}
