
700. Search in a Binary Search Tree

class Solution {
  public TreeNode searchBST(TreeNode root, int val) {
    if (root == null || val == root.val) return root;

    return val < root.val ? searchBST(root.left, val) : searchBST(root.right, val);
  }
}

//Complexity Analysis

//Time complexity : \mathcalO(H), where HH is a tree height. That results in \mathcal{O}(\log N)O(logN) in the average case, and \mathcal{O}(N)O(N) in the worst case.

//Space complexity : \mathcal{O}(H)O(H) to keep the recursion stack, i.e. \mathcal{O}(\log N)O(logN) in the average case, and \mathcal{O}(N)O(N) in the worst case.


class Solution {
  public TreeNode searchBST(TreeNode root, int val) {
    while (root != null && val != root.val)
      root = val < root.val ? root.left : root.right;
    return root;
  }
}

//Time complexity : \mathcal{O}(H)O(H), 

// Space complexity : \mathcal{O}(1)O(1) since it's a constant space solution.