public class max_sum_nodetonode{
    // Given a binary tree we have to find the max sum possible between any node to any node in the binary tree
    public static class node{
        int val;
        node left;
        node right;
        public node(int val)
        {
            this.val=val;
        }
    }
    public static int ans;
    public static int helper(node root)
    {
        if(root==null)
        return 0;
        int ls=helper(root.left); // get the max sum from left subtree
        int rs=helper(root.right); // get the max sum from right subtree
        // fight for max answer between 4 contendors root.val, ls+root.val, rs+root.val, ls+rs+root.val
        ans=Math.max(ans,Math.max(root.val,Math.max(root.val+ls,Math.max(root.val+rs,root.val+ls+rs))));
        // fight for return value between 3 contendors root.val+ls,root.val+rs,root.val;
        return Math.max(root.val+ls,Math.max(root.val+rs,root.val));
    }
    public static int func(node root)
    {
        ans=Integer.MIN_VALUE;
        if(root==null)
        return 0;
        helper(root);
        return ans;
    }
    public static void main(String args[])
    {
        node root=new node(1);
        root.left=new node(2);
        root.right=new node(3);
        System.out.println(func(root));
    }
}