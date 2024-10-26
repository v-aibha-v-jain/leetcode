import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class App {
    public static void main(String[] args) throws Exception {
        Solution obj = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(5);
        root.right.left.right = new TreeNode(7);
        int[] queries = {4};
        int[] result = obj.treeQueries(root, queries);
        System.out.println(Arrays.toString(result));
    }
}
class Solution {
    public int[] treeQueries(TreeNode root, int[] queries) {
        Map<Integer, Integer> depth = new HashMap<>();
        Map<Integer, Integer> height = new HashMap<>();
        dfs(root, depth, height, 0);
        Map<Integer, Queue<Integer>> cousins = new HashMap<>();
        for(int val:depth.keySet()){
            int d = depth.get(val);
            if(!cousins.containsKey(d)) cousins.put(d, new PriorityQueue<>((a,b)->(height.get(b)-height.get(a))));
            cousins.get(d).add(val);
        }
        int[] ans = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int val = queries[i];
            int d = depth.get(val);
            if(cousins.get(d).size()==1) ans[i] = d-1;
            else if(cousins.get(d).peek()!=val){
                ans[i] = d+height.get(cousins.get(d).peek());
            }
            else{
                cousins.get(d).poll();
                ans[i] = d+height.get(cousins.get(d).peek());
                cousins.get(d).add(val);
            }
        }
        return ans;
    }
    public void dfs(TreeNode root, Map<Integer, Integer> depth, Map<Integer, Integer> height, int d){
        depth.put(root.val, d);
        if(root.left!=null) dfs(root.left, depth, height, d+1);
        if(root.right!=null) dfs(root.right, depth, height, d+1);
        if(root.left==null && root.right==null) height.put(root.val, 0);
        else height.put(root.val, Math.max(root.left==null?0:height.get(root.left.val), root.right==null?0:height.get(root.right.val))+1);
    }
}