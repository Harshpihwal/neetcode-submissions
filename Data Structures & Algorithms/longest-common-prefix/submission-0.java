class Solution {
    public String longestCommonPrefix(String[] strs) {
        String s=strs[0];
        for(int i=1;i<strs.length;i++){
            String t=strs[i];
            while(!s.startsWith(t)){
                t=t.substring(0,t.length()-1);
            }
            s=t;
        }
        return s;
    }
}