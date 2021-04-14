// 108. Convert Sorted Array to Binary Search Tree

class Solution {
  int[] nums;

  public TreeNode helper(int left, int right) {
    if (left > right) return null;

    // always choose left middle node as a root
    int p = (left + right) / 2;

    // preorder traversal: node -> left -> right
    TreeNode root = new TreeNode(nums[p]);
    root.left = helper(left, p - 1);
    root.right = helper(p + 1, right);
    return root;
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    this.nums = nums;
    return helper(0, nums.length - 1);
  }
}

// Complexity Analysis

// Time complexity: \mathcal{O}(N)O(N) since we visit each node exactly once.

// Space complexity: \mathcal{O}(N)O(N). \mathcal{O}(N)O(N) to keep the output, and \mathcal{O}(\log N)O(logN) for the recursion stack.


class Solution {
  int[] nums;

  public TreeNode helper(int left, int right) {
    if (left > right) return null;

    // always choose right middle node as a root
    int p = (left + right) / 2;
    if ((left + right) % 2 == 1) ++p;

    // preorder traversal: node -> left -> right
    TreeNode root = new TreeNode(nums[p]);
    root.left = helper(left, p - 1);
    root.right = helper(p + 1, right);
    return root;
  }

  public TreeNode sortedArrayToBST(int[] nums) {
    this.nums = nums;
    return helper(0, nums.length - 1);
  }
}

// Complexity Analysis

// Time complexity: \mathcal{O}(N)O(N) since we visit each node exactly once.

// Space complexity: \mathcal{O}(N)O(N). \mathcal{O}(N)O(N) to keep the output, and \mathcal{O}(\log N)O(logN) for the recursion stack




class Solution {
    int[] nums;
    Random rand = new Random();
    
    public TreeNode helper(int left, int right) {
        if (left > right) return null;
        
        // choose random middle node as a root
        int p = (left + right) / 2; 
        if ((left + right) % 2 == 1) p += rand.nextInt(2);

        // preorder traversal: node -> left -> right
        TreeNode root = new TreeNode(nums[p]);
        root.left = helper(left, p - 1);
        root.right = helper(p + 1, right);
        return root;
    }
    
    public TreeNode sortedArrayToBST(int[] nums) {
        this.nums = nums;
        return helper(0, nums.length - 1);    
    }
}

// Complexity Analysis

// Time complexity: \mathcal{O}(N)O(N) since we visit each node exactly once.

// Space complexity: \mathcal{O}(N)O(N). \mathcal{O}(N)O(N) to keep the output, and \mathcal{O}(\log N)O(logN) for the recursion stack.