class Solution {
    public List<String> letterCombinations(String digits) {

        return findPermutations("", digits);
    }

    private List<String> findPermutations(String p, String up) {

        if (up.isEmpty()) {
            List<String> list = new ArrayList<>();
            if (p.isEmpty()) {
                return list;
            }
            list.add(p);
            return list;
        }

        List<String> ans = new ArrayList<>();
        int digit = up.charAt(0) - '0';
        if (digit <= 6 && digit >= 2) {
            
            for (int i = 3 * (digit - 2); i < (digit - 1) * 3; i++) {
                char ch = (char) ('a' + i);
                ans.addAll(findPermutations(p + ch, up.substring(1)));
            }
        } else if (digit == 7) {
            for (int i = 3 * (digit - 2); i < (digit - 1) * 3 + 1; i++) {
                char ch = (char) ('a' + i);
                ans.addAll(findPermutations(p + ch, up.substring(1)));
            }
        }

        else if (digit == 8) {
            for (int i = 3 * (digit - 2) + 1; i < (digit - 1) * 3 + 1; i++) {
                char ch = (char) ('a' + i);
                ans.addAll(findPermutations(p + ch, up.substring(1)));
            }
        }

        else {
            for (int i = 3 * (digit - 2) + 1; i < (digit - 1) * 3 + 2; i++) {
                char ch = (char) ('a' + i);
                ans.addAll(findPermutations(p + ch, up.substring(1)));
            }
        }
        return ans;

    }
}