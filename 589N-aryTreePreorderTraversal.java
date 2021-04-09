// 589. N-ary Tree Preorder Traversal

class Solution {
  public List<Integer> preorder(Node root) {
    LinkedList<Node> stack = new LinkedList<>();
    LinkedList<Integer> output = new LinkedList<>();
    if (root == null) {
      return output;
    }

    stack.add(root);
    while (!stack.isEmpty()) {
      Node node = stack.pollLast();
      output.add(node.val);
      Collections.reverse(node.children);
      for (Node item : node.children) {
        stack.add(item);
      }
    }
    return output;
  }
}

// Complexity Analysis

// Time complexity : we visit each node exactly once, and for each visit, the complexity of the operation (i.e. appending the child nodes) is proportional to the number of child nodes n (n-ary tree). Therefore the overall time complexity is \mathcal{O}(N)O(N), where NN is the number of nodes, i.e. the size of tree.

//Space complexity : depending on the tree structure, we could keep up to the entire tree, therefore, the space complexity is \mathcal{O}(N)O(N).