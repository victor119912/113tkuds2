class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates); // 排序方便去重
        backtrack(candidates, target, 0, new ArrayList<>(), res);
        return res;
    }

    private void backtrack(int[] candidates, int remain, int start,
                           List<Integer> path, List<List<Integer>> res) {
        if (remain == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = start; i < candidates.length; i++) {
            // 避免同層重複
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            if (candidates[i] > remain) break; // 剪枝

            path.add(candidates[i]);
            backtrack(candidates, remain - candidates[i], i + 1, path, res);
            path.remove(path.size() - 1);
        }
    }
}
