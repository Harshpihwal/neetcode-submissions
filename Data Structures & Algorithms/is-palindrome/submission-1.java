class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase().replaceAll(" ","");
        String k="";
        for(char ch:s.toCharArray()){
            if(ch>='a' && ch <= 'z' || ch>='0' && ch<='9'){
                k=k+ch;
            }
        }
        char[] chas=k.toCharArray();
        int i=0;
        int j=chas.length-1;
        while(i<j){
            if(chas[i]!=chas[j]){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
