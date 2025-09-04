// https://leetcode.com/problems/word-search/
class Solution {
    final boolean alreadyVisited[][] = new boolean[6][6];

    // Non-mandatory, but increases speed (Pruning technique 2)
    final Map<Character, Integer> wordCharacterFrequency = new HashMap<>();
    final Map<Character, Integer> boardCharacterFrequency = new HashMap<>();

    int m = 0; // # lines
    int n = 0; // # columns

    // O(m*n * 4^L)
    // m*n can be considered linear because we are talking about starting the DFS once per cell (worst case)
    // 4^L because the DFS has backtracking (4 because for each step we have 4 possible moving positions and we need to do this at most L times (the size of the word))
    public boolean exist(final char[][] board, final String word) {
        m = board.length;
        n = board[0].length;

        // O(1) Pruning technique 1 (non-mandatory): Word is larger than board itself!
        if (word.length() > m * n) return false;

        // O(m*n) Pruning technique 2 (non-mandatory): Each char frequency on board needs to be at least the same as the char frequency in the word itself
        for (int i=0; i < word.length(); i++) {
            final char wordChar = word.charAt(i);
            if (wordCharacterFrequency.get(wordChar) != null) {
                wordCharacterFrequency.put(wordChar, wordCharacterFrequency.get(wordChar) + 1);
            } else {
                wordCharacterFrequency.put(wordChar, 1);
            }
        } 
        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                final char boardChar = board[i][j];
                if (boardCharacterFrequency.get(boardChar) != null) {
                    boardCharacterFrequency.put(boardChar, boardCharacterFrequency.get(boardChar) + 1);
                } else {
                    boardCharacterFrequency.put(boardChar, 1);
                }
            }
        }
        for (char k : wordCharacterFrequency.keySet()) {
            if (boardCharacterFrequency.get(k) == null || (boardCharacterFrequency.get(k) < wordCharacterFrequency.get(k))) {
                return false;
            }
        }
        // End of Pruning technique 2

        final char firstLetter = word.charAt(0);
        for (int i=0; i < m; i++) {
            for (int j=0; j < n; j++) {
                if (firstLetter == board[i][j]) {
                    alreadyVisited[i][j] = true;
                    final boolean foundWholeWord =  DFS(board, i, j, word.substring(1));
                    alreadyVisited[i][j] = false;
                    if (foundWholeWord) return true;
                }
            }
        }
        return false;
    }

    // O(n)
    private boolean DFS(char[][] board, int i, int j, String remainingString) {
        if (remainingString.isEmpty()) {
            // Found the word!
            return true;
        }
        final char currentLetter = remainingString.charAt(0);
        List<Pair<Integer, Integer>> newUnvisitedIndexes = findNewNonVistedIndexes(i, j);
        for (final Pair<Integer, Integer> indexes : newUnvisitedIndexes) {
            final int x = indexes.getKey();
            final int y = indexes.getValue();
            if (board[x][y] == currentLetter) {
                alreadyVisited[x][y] = true;
                final boolean foundWholeWord = DFS(board, x, y, remainingString.substring(1));
                alreadyVisited[x][y] = false;
                if (foundWholeWord) return true;
            }
        }
        return false;
    }

    // O(1)
    private List<Pair<Integer, Integer>> findNewNonVistedIndexes(final int i, final int j) {
        final List<Pair<Integer, Integer>> validVisitIndexes = new ArrayList<>();

        final int[] dx = { 0,  0, +1, -1};
        final int[] dy = {-1, +1,  0,  0};
        for (int k=0; k<4; k++) {
            final int newX = i + dx[k];
            final int newY = j + dy[k];
            if (newX >= 0 && newY >= 0 && newX < m && newY < n && !alreadyVisited[newX][newY]) {
                validVisitIndexes.add(new Pair(newX, newY));
            }
        }

        return validVisitIndexes;
    }
}