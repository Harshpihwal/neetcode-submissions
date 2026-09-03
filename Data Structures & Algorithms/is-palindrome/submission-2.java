class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase().replaceAll(" ","");
        StringBuilder k=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch>='a' && ch <= 'z' || ch>='0' && ch<='9'){
                k.append(ch);
            }
        }
        char[] chas=k.toString().toCharArray();
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
