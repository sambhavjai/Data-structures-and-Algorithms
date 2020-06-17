public class largest_BST{
    // Find the root the largest bst in the given binary tree
    public static class node{
        int val;
        node left;
        node right;
        public node(int val)
        {
            this.val=val;
        }
    }
    public static class pair{
        // long values to handle the Integer.MAX_VALUE and Integer.MIN_VALUE corner cases
        long min; // minimum value found
        long max; // maximum value found
        boolean isBst; // is the current root a bst
        node lbr; // largest bst root
        int lbs; // largest bst size
        public pair()
        {}
    }
    public static pair helper(node root)
    {
        if(root==null)
        {
            pair base=new pair();
            base.min=Long.MAX_VALUE;
            base.max=Long.MIN_VALUE;
            base.isBst=true;
            base.lbr=null;
            base.lbs=0;
            return base;
        }
        pair lp=helper(root.left);
        pair rp=helper(root.right);
        pair mp=new pair();
        mp.min=Math.min(root.val,Math.min(lp.min,rp.min));
        mp.max=Math.max(root.val,Math.max(lp.max,rp.max));
        mp.isBst=lp.isBst&&rp.isBst&&(root.val>lp.max&&root.val<rp.min);
        if(mp.isBst)
        {
            mp.lbr=root;
            mp.lbs=lp.lbs+rp.lbs+1;
        }
        else
        {
            if(lp.lbs>rp.lbs)
            {
                mp.lbr=lp.lbr;
                mp.lbs=lp.lbs;
            }
            else
            {
                mp.lbr=rp.lbr;
                mp.lbs=rp.lbs;
            }
        }
        return mp;
    }
    public static node func(node root)
    {
        pair ans=helper(root);
        return ans.lbr;
    }
    public static void inorder(node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    public static void main(String arg[])
    {
        node root=new node(5);
        root.left=new node(1);
        root.right=new node(4);
        root.right.left=new node(3);
        root.right.right=new node(6);
        node ans=func(root);
        inorder(ans);
        System.out.println();
    }
}