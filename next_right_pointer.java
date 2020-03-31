// Given a binary tree with next pointers in each node
// Point the next pointer of each node to its next right node in the same level
// Done using Iterative method O(1) space solution and recursion O(n) space solution
import java.util.*;
public class next_right_pointer{
    public static class node{
        int val;
        node left;
        node right;
        node next;
        public node(int val)
        {
            this.val=val;
            this.left=null;
            this.right=null;
            this.next=null;
        }
    }
    public static void connect_recursive(node root)
    {
        // Recursive solution works only for a complete (perfect) binary tree
        if(root==null) // We traverse in simple pre-order and update the tree
        return;
        if(root.left!=null)
        root.left.next=root.right;
        if(root.right!=null&&root.next!=null)
        root.right.next=root.next.left;
        connect_recursive(root.left);
        connect_recursive(root.right);
    }
    public static void connect_iterative(node root)
    {
        // Can work for any tree
        // We use 2 nested loops one for setting next pointers of children of the node and its level nodes
        // other for iterating through the levels
        if(root==null)
        return;
        root.next=null;
        node p=root;
        while(p!=null) // outer loop for traversing through levels
        {
            node q=p;
            while(q!=null)  // inner loop for setting pointers of children of the node and among the same level
            {
                if(q.left!=null)
                {
                    if(q.right!=null)
                    q.left.next=q.right;
                    else
                    q.left.next=next_right(q); // gives the leftmost node in the same level
                }
                if(q.right!=null)
                {
                    q.right.next=next_right(q);
                }
                q=q.next;
            }
            if(p.left!=null) // after upper level is set we iterate to the lower level
            p=p.left;
            else if(p.right!=null)
            p=p.right;
            else
            p=next_right(p);
        }
    }
    public static node next_right(node root)
    {
        node temp=root.next;
        while(temp!=null)
        {
            if(temp.left!=null)
            return temp.left;
            else if(temp.right!=null)
            return temp.right;
            temp=temp.next;
        }
        return null;
    }
    public static void display(node root)
    {
        Queue<node> q=new LinkedList<node>();
        q.add(root);
        while(q.size()>0)
        {
            node temp=q.remove();
            System.out.print(temp.val);
            if(temp.next!=null)
            System.out.print(temp.next.val+" ");
            else
            System.out.print("null ");
            if(temp.left!=null)
            q.add(temp.left);
            if(temp.right!=null)
            q.add(temp.right);
        }
    }
    public static void main(String args[])
    {
        /* 
              1
            /    \
            2     3
           / \    / \
           4 (7)  5   6
        */
        node root=new node(1);
        root.left=new node(2);
        root.right=new node(3);
        root.left.left=new node(4);
      //  root.left.right=new node(7);
        root.right.left=new node(5);
        root.right.right=new node(6);
        root.next=null;
      //  connect_recursive(root);
        connect_iterative(root);
        display(root);
        System.out.println();
    }
}