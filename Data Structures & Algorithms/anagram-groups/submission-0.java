class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            int[] freq = new int[26];
            for (char ch : s.toCharArray()) {
                freq[ch - 'a']++;
            }
            String t = Arrays.toString(freq);
            ArrayList<String> list = new ArrayList<>();
            list.add(s);
            if (map.containsKey(t)) {
                map.get(t).add(s);
            } else {
                map.put(t, list);
            }
        }
        List<List<String>> ans = new ArrayList<>();
        for (Map.Entry<String, List<String>> x : map.entrySet()) {
            ans.add(x.getValue());
        }
        return ans;
    }
}
