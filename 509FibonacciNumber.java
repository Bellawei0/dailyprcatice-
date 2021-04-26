//Approach 2: Bottom-Up Approach using Memoization

class Solution {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        return memoize(N);
    }

    public int memoize(int N) {
      int[] cache = new int[N + 1];
      cache[1] = 1;

      for (int i = 2; i <= N; i++) {
          cache[i] = cache[i-1] + cache[i-2];
      }
      return cache[N];
    }
}



//Approach 3: Top-Down Approach using Memoization
class Solution {
    private Integer[] cache = new Integer[31];

    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        cache[0] = 0;
        cache[1] = 1;
        return memoize(N);
    }

    public int memoize(int N) {
      if (cache[N] != null) {
          return cache[N];
      }
      cache[N] = memoize(N-1) + memoize(N-2);
      return memoize(N);
    }
}

//Complexity Analysis

//Time complexity : O(N)O(N). Each number, starting at 2 up to and including N, is visited, computed and then stored for O(1)O(1) access later on.

//Space complexity : O(N)O(N). The size of the data structure is proportionate to N.

Approach 4: Iterative Top-Down Approach
class Solution {
    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        if (N == 2) {
            return 1;
        }

        int current = 0;
        int prev1 = 1;
        int prev2 = 1;

        for (int i = 3; i <= N; i++) {
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}

//Time complexity : O(N)O(N). Each value from 2 to N will be visited at least once. The time it takes to do this is directly proportionate to N where N is the Fibonacci Number we are //looking to compute.

//Space complexity : O(1)O(1). This requires 1 unit of Space for the integer N and 3 units of Space to store the computed values (curr, prev1 and prev2) for every loop iteration. The amount of Space doesn't change so this is constant Space complexity.

