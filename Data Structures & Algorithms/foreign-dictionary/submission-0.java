class Solution {
    public String foreignDictionary(String[] words) {
      List<List<Integer>> adj=new ArrayList<>();
      for(int i=0;i<26;i++){
        adj.add(new ArrayList<>());
      }
      boolean[] pres=new boolean[26];
      for(String w:words){
        for(char ch:w.toCharArray()){
            pres[ch-'a']=true;
        }
      }
      for(int i=0;i<words.length-1;i++){
        String s1=words[i];
        String s2=words[i+1];
        int len=Math.min(s1.length(),s2.length());
        boolean found=false;
        for(int j=0;j<len;j++){
            if(s1.charAt(j)!=s2.charAt(j)){
                int u=s1.charAt(j)-'a';
                int v=s2.charAt(j)-'a';
                adj.get(u).add(v);
                found=true;
                break;
            }
        }
        if(!found && s1.length()>s2.length()){
            return "";
        }
      }
      int[] indegree=new int[26];
      for(int i=0;i<26;i++){
        for(int x:adj.get(i)){
            indegree[x]++;
        }
      }
      Queue<Integer> queue=new LinkedList<>();
      for(int i=0;i<26;i++){
        if(pres[i] && indegree[i]==0){
            queue.add(i);
        }
      }
      StringBuilder sb=new StringBuilder();
      while(!queue.isEmpty()){
        int node=queue.remove();
        sb.append((char)(node+97));
        for(int x:adj.get(node)){
            indegree[x]--;
            if(indegree[x]==0){
                queue.add(x);
            }
        }
      }
      int t=0;
      for(boolean x:pres){
        if(x){
            t++;
        }
      }
      if(t!=sb.length()){
        return "";
      }
      return sb.toString();
    }
}
