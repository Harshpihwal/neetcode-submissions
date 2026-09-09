class Solution {
    class Pair{
        String f="";
        int s=0;
        Pair(String f,int s){
            this.f=f;
            this.s=s;
        }
    }
    public int ladderLength(String bw, String ew, List<String> wordList) {
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(bw,1));
        Set<String> set=new HashSet<>();
        for(String s:wordList){
            set.add(s);
        }
        set.remove(bw);
        while(!q.isEmpty()){
            String s=q.peek().f;
            int c=q.peek().s;
            q.remove();
            if(s.equals(ew)){
                return c;
            }
            for(int i=0;i<s.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] newch=s.toCharArray();
                    newch[i]=ch;
                    String r=new String(newch);
                    if(set.contains(r)){
                        set.remove(r);
                        q.add(new Pair(r,c+1));
                    }
                }
            }
        }
        return 0;
    }
}
