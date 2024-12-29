import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        TreeNode root = new TreeNode(7);
        root.left = new TreeNode(3);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(20);

        BSTIterator obj = new BSTIterator(root);
        System.out.println(obj.next());    // 3
        System.out.println(obj.next());    // 7
        System.out.println(obj.hasNext()); // true
        System.out.println(obj.next());    // 9
        System.out.println(obj.hasNext()); // true
        System.out.println(obj.next());    // 15
        System.out.println(obj.hasNext()); // true
        System.out.println(obj.next());    // 20
        System.out.println(obj.hasNext()); // false
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class BSTIterator {

    ArrayList<Integer> list = new ArrayList<>(); // list to store inorder traversal
    int i = -1; // iterator index

    public ArrayList<Integer> inorder(TreeNode root) {
        if (root == null)
            return list; // return list if root is null
        inorder(root.left); // traverse left subtree
        list.add(root.val); // add root value to list
        inorder(root.right); // traverse right subtree
        return list; // return list after traversal
    }

    public BSTIterator(TreeNode root) {
        inorder(root); // initialize list with inorder traversal
    }

    public int next() {
        i++; // move to next element
        return list.get(i); // return next element
    }

    public boolean hasNext() {
        if (list.size() - 1 > i) return true; // check if there are more elements
        else return false; // no more elements
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */