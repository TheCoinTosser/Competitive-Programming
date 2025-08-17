// https://leetcode.com/problems/generate-parentheses/description/

class Solution {
    int nGlobal;
    final List<String> allSolutions = new ArrayList<String>();

    public List<String> generateParenthesis(final int n) {
        nGlobal = n;
        generate(0, 0, "");
        return allSolutions;
    }

    private void generate(final int numberOfOpenedParenthesis, final int numberOfClosedParenthesis, final String solutionThusFar) {
        if (numberOfClosedParenthesis == nGlobal) {
            // No more combinations to generate
            allSolutions.add(solutionThusFar);
            return;
        }

        // Can both open "(" or close ")"
        if (numberOfOpenedParenthesis < nGlobal) {
            // Open
            generate(numberOfOpenedParenthesis + 1, numberOfClosedParenthesis, solutionThusFar + "(");
        }
        if (numberOfOpenedParenthesis > numberOfClosedParenthesis) {
            // Close
            generate(numberOfOpenedParenthesis, numberOfClosedParenthesis + 1, solutionThusFar + ")");
        }
    }
}