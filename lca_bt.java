// Find the lowest common ancestor of given 2 nodes in a binary tree
public class lca_bt{
    public static class node
    {
        int val;
        node left;
        node right;
        public node(int val)
        {
            this.val=val;
        }
    }
    public static node ans=null;
    public static boolean helper(node root,node p,node q)
    {
        if(root==null)
        return false;
        boolean sf=false;
        if(root.val==p.val||root.val==q.val) // check if the current node may be the answer or not
        sf=true;
        boolean lf= ans!=null||helper(root.left,p,q); // call for left only when answer has not been found
        boolean rf= ans!=null||helper(root.right,p,q); // call for right only when answer has not been found
        if((lf&&rf)||(lf&&sf)||(sf&&rf)) //check if ans exists on left side, right side or with the current node
        ans= (ans==null)?root:ans;
        return lf||rf||sf; //return true if answer exists anywhere
    }
    public static node func(node root,node p,node q)
    {
        if(root==null)
        return null;
        ans=null;
        boolean flag=helper(root,p,q);
        if(flag==false)
        return null;
        else
        return ans;
     }
    public static void main(String args[])
    {
        /*
                         3
                        / \
                       5   1
                      / \ / \
                      6 2 0  8
                       / \
                       7  4
        */
        node root=new node(3);
        root.left=new node(5);
        root.right=new node(1);
        root.left.left=new node(6);
        root.left.right=new node(2);
        root.right.left=new node(0);
        root.right.right=new node(8);
        root.left.right.left=new node(7);
        root.left.right.right=new node(4);
        node lca=func(root,new node(6),new node(2));
        if(lca==null)
        System.out.println("null");
        else
        System.out.println(lca.val);
    }
}