public class IsBalanced {
    public static void main(String[] args) {
        IsBalanced obj = new IsBalanced();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        System.out.print(obj.checkBalanced(root));
    }

    public boolean checkBalanced(TreeNode root) {
      if(root==null)
          return true;
      //Calculate the height of the left subtree
      int left=height(root.left);
      
      //Calculate the height of the right subtree
      int right=height(root.right);
      
      if(Math.abs(left-right)<=1 && checkBalanced(root.left) && checkBalanced(root.right))
          return true;
      return false;

    }

    public int height(TreeNode root)
    {
        if(root==null)
            return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
}
