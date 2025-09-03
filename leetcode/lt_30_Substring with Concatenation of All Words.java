class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words.length == 0) return result;

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;

        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);

        for (int i = 0; i <= s.length() - totalLen; i++) {
            String sub = s.substring(i, i + totalLen);
            Map<String, Integer> seen = new HashMap<>();
            int j;
            for (j = 0; j < totalLen; j += wordLen) {
                String part = sub.substring(j, j + wordLen);
                if (!wordCount.containsKey(part)) break;
                seen.put(part, seen.getOrDefault(part, 0) + 1);
                if (seen.get(part) > wordCount.get(part)) break;
            }
            if (j == totalLen) result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.findSubstring("barfoothefoobarman", new String[]{"foo","bar"})); // [0,9]
        System.out.println(sol.findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"})); // []
        System.out.println(sol.findSubstring("barfoofoobarthefoobarman", new String[]{"bar","foo","the"})); // [6,9,12]
    }
}