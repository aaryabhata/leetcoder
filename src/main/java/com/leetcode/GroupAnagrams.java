package com.leetcode;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String, List<String>> anagramMap = new HashMap<>();
        for (String s : strs) {
            char[] tempArray = s.toCharArray();
            Arrays.sort(tempArray);
            String key = new String(tempArray);
            anagramMap.putIfAbsent(key, new ArrayList<String>());
            anagramMap.get(key).add(s);
        }
        List<List<String>> ret = new ArrayList<>();
        for (List<String> strings : anagramMap.values()) {
            Collections.sort(strings);
            ret.add(strings);
        }

        return ret;
    }

    public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        int[] count = new int[26];
        for (String s : strs) {
            Arrays.fill(count, 0);
            for (char c : s.toCharArray()) count[c - 'a']++;

            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < 26; i++) {
                sb.append('#');
                sb.append(count[i]);
            }
            String key = sb.toString();
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

    public static void main(String[] args) {
        GroupAnagrams g = new GroupAnagrams();
        for (List<String> strings : g.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})) {
            System.out.println(strings);
        }
    }
}
