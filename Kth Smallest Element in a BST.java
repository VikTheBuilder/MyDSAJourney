/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
//Brute--
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> res = new ArrayList<Integer>();
        res = inorderTraversal(root);
        return res.get(k-1);
    }
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> res = new ArrayList<Integer>();
        var curr = root;
        while (curr != null){
            if (curr.left == null){
                res.add(curr.val);
                curr = curr.right; 
            } else { 
                var pre = curr.left;
                while (pre.right != null){ 
                    pre = pre.right;
                }
                pre.right = curr;
                var temp = curr; 
                curr = curr.left; 
                temp.left = null;
            }
        }
        return res;
    }
}
//optimal--
class Solution {
    public int kthSmallest(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        TreeNode curr = root;
        while (curr != null || !stack.isEmpty()){
            while (curr != null){
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (--k == 0){
                return curr.val;
            }
            curr = curr.right;
        }
        return -1;
    }
}
