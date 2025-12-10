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
// class Solution {
//     List<List<Integer>> result = new ArrayList<>();
//     public List<List<Integer>> levelOrder(TreeNode root) {
//         // dfs - recursive
//         helper(root, 0);
//         return result;
//     }

//     private void helper(TreeNode root, int level)
//     {
//         if(null == root) return;
//         if(level == result.size())
//         {
//             result.add(new ArrayList<>());
//         }
//         result.get(level).add(root.val);
//         helper(root.left, level+1);
//         helper(root.right, level+1);
//     }
// }

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        // bfs
        if(null == root) return new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> result = new ArrayList<>();
        
        while(!queue.isEmpty())
        {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++)
            {
                TreeNode newNode = queue.poll();
                list.add(newNode.val);
                if(null != newNode.left)
                {
                    queue.add(newNode.left);
                }
                if(null != newNode.right)
                {
                    queue.add(newNode.right);
                }
            }
            result.add(list);
        }

        return result;
    }
}