import java.util.*;
public class morris_traversal{
    // Find the inorder traversal iteratively, i.e., using constant space
    public static class node{
        int val;
        node left;
        node right;
        public node(int val)
        {
            this.val=val;
            left=null;
            right=null;
        }
    }
    public static List<Integer> func(node root)
    {
        List<Integer> ans=new ArrayList<>();
        node curr=root;
        node pre=null;
        while(curr!=null)
        {
            if(curr.left==null) // if no left child exists then this is the current element in inorder fashion include this and shift right
            {
                ans.add(curr.val);
                curr=curr.right;
            }
            else
            {
                pre=curr.left; // else find the rightmost element in left subtree
                while(pre.right!=null&&pre.right!=curr)
                {
                    pre=pre.right;
                }
                if(pre.right==null) // if right child of rightmost element is null then we have not linked it to curr value
                {
                    pre.right=curr; // link to current value and shift in the left subtree first
                    curr=curr.left;
                }
                else // if we have already linked it to the curr value which means we have found inorder in left subtree so next element will be current element
                {
                    pre.right=null; // correct the disturbed tree
                    ans.add(curr.val);
                    curr=curr.right; // add the current element and shift right
                }
            }
        }
        return ans;
    }
    public static void inorder(node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.println(root.val);
        inorder(root.right);
    }
    public static void main(String args[])
    {
        node root=new node(1);
        root.left=new node(2);
        root.right=new node(3);
        root.left.left=new node(4);
        root.left.right=new node(5);
        root.right.left=new node(6);
        root.right.right=new node(7);
        List<Integer> ans=func(root);
        System.out.println(ans);
        inorder(root);
    }
}