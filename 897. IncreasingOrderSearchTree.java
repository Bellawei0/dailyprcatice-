//Approach 1: In-Order Traversal
class Solution {    
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> vals = new ArrayList();
        inorder(root, vals);
        TreeNode ans = new TreeNode(0), cur = ans;
        for (int v: vals) {
            cur.right = new TreeNode(v);
            cur = cur.right;
        }
        return ans.right;
    }

    public void inorder(TreeNode node, List<Integer> vals) {
        if (node == null) return;
        inorder(node.left, vals);
        vals.add(node.val);
        inorder(node.right, vals);
    }
}

//Complexity Analysis

// Time Complexity: O(N)O(N), where NN is the number of nodes in the given tree.

// Space Complexity: O(N)O(N).


// Approach 2: Traversal with Relinking
class Solution {
    TreeNode cur;
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans = new TreeNode(0);
        cur = ans;
        inorder(root);
        return ans.right;
    }

    public void inorder(TreeNode node) {
        if (node == null) return;
        inorder(node.left);
        node.left = null;
        cur.right = node;
        cur = node;
        inorder(node.right);
    }
}

// Complexity Analysis

// Time Complexity: O(N)O(N), where NN is the number of nodes in the given tree.

// Space Complexity: O(H)O(H) in additional space complexity, where HH is the height of the given tree, 
// and the size of the implicit call stack in our in-order traversal.