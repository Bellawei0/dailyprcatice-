// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/

// Approach 1: Brute Force

class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.isEmpty() || k > s.length()) {
            return 0;
        }
        int[] countMap = new int[26];
        int n = s.length();
        int result = 0;
        for (int start = 0; start < n; start++) {
            // reset the count map
            Arrays.fill(countMap, 0);
            for (int end = start; end < n; end++) {
                countMap[s.charAt(end) - 'a']++;
                if (isValid(s, start, end, k, countMap)) {
                    result = Math.max(result, end - start + 1);
                }
            }
        }
        return result;
    }

    private boolean isValid(String s, int start, int end, int k, int[] countMap) {
        int countLetters = 0, countAtLeastK = 0;
        for (int freq : countMap) {
            if (freq > 0) countLetters++;
            if (freq >= k) countAtLeastK++;
        }
        return countAtLeastK == countLetters;
    }
}

/**
Time Complexity : \mathcal{O}(n^{2})O(n^2), where nn is equal to length of string ss. The nested for loop that generates all substrings from string ss takes \mathcal{O}(n^{2})O(n 
2) time, and for each substring, we iterate over \text{countMap}countMap array of size 26. This gives us time complexity as \mathcal{O}(26 \cdot n^{2})O(26⋅n^) = \mathcal{O}(n^{2})O(n^2).
This approach is exhaustive and results in Time Limit Exceeded (TLE).

Space Complexity: \mathcal{O}(1)O(1) We use constant extra space of size 26 for countMap array.
**/

Approach 2: Divide And Conquer

class Solution {
    public int longestSubstring(String s, int k) {
        return longestSubstringUtil(s, 0, s.length(), k);
    }

    int longestSubstringUtil(String s, int start, int end, int k) {
        if (end < k) return 0;
        int[] countMap = new int[26];
        // update the countMap with the count of each character
        for (int i = start; i < end; i++)
            countMap[s.charAt(i) - 'a']++;
        for (int mid = start; mid < end; mid++) {
            if (countMap[s.charAt(mid) - 'a'] >= k) continue;
            int midNext = mid + 1;
            while (midNext < end && countMap[s.charAt(midNext) - 'a'] < k) midNext++;
            return Math.max(longestSubstringUtil(s, start, mid, k),
                    longestSubstringUtil(s, midNext, end, k));
        }
        return (end - start);
    }
}

Complexity Analysis

Time Complexity : O(N^2), where NN is the length of string ss. Though the algorithm performs better in most cases, the worst case time complexity is still \mathcal{O}(N ^ {2})O(N 
2).In cases where we perform split at every index, the maximum depth of recursive call could be O(N). For each recursive call it takes O(N) 
 time to build the countMap resulting in O(n^2) time complexity.

Space Complexity: O(N) This is the space used to store the recursive call stack. The maximum depth of recursive call stack would be O(N).



Approach 3: Sliding Window

public class Solution {
    public int longestSubstring(String s, int k) {
        char[] str = s.toCharArray();
        int[] countMap = new int[26];
        int maxUnique = getMaxUniqueLetters(s);
        int result = 0;
        for (int currUnique = 1; currUnique <= maxUnique; currUnique++) {
            // reset countMap
            Arrays.fill(countMap, 0);
            int windowStart = 0, windowEnd = 0, idx = 0, unique = 0, countAtLeastK = 0;
            while (windowEnd < str.length) {
                // expand the sliding window
                if (unique <= currUnique) {
                    idx = str[windowEnd] - 'a';
                    if (countMap[idx] == 0) unique++;
                    countMap[idx]++;
                    if (countMap[idx] == k) countAtLeastK++;
                    windowEnd++;
                }
                // shrink the sliding window
                else {
                    idx = str[windowStart] - 'a';
                    if (countMap[idx] == k) countAtLeastK--;
                    countMap[idx]--;
                    if (countMap[idx] == 0) unique--;
                    windowStart++;
                }
                if (unique == currUnique && unique == countAtLeastK)
                    result = Math.max(windowEnd - windowStart, result);
            }
        }

        return result;
    }

    // get the maximum number of unique letters in the string s
    int getMaxUniqueLetters(String s) {
        boolean map[] = new boolean[26];
        int maxUnique = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!map[s.charAt(i) - 'a']) {
                maxUnique++;
                map[s.charAt(i) - 'a'] = true;
            }
        }
        return maxUnique;
    }
}


Time Complexity : O(maxUnique⋅N). We iterate over the string of length NN, maxUnqiue times. Ideally, the number of unique characters in the string would not be more than 26 (a to z). Hence, the time complexity is approximately O(26⋅N) = O(N)

Space Complexity: O(1) We use constant extra space of size 26 to store the countMap.





