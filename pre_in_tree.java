// Construct a binary tree from given pre-order and post-order
public class pre_in_tree{
    public static class node{
        int val;
        node left;
        node right;
        public node(int val)
        {
            this.val=val;
            this.left=null;
            this.right=null;
        }
    }
    public static int search(int arr[],int start,int end,int val)
    {
        for(int i=start;i<=end;i++)
        {
            if(arr[i]==val)
            return i;
        }
        return -1;
    }
    public static int pre_idx=0;
    public static node func(int pre[],int in[],int in_start,int in_end)
    {
        if(in_start>in_end)
        return null;
        node temp=new node(pre[pre_idx]);
        pre_idx++;
        if(in_start==in_end)
        return temp;
        int idx=search(in,in_start,in_end,temp.val);
        temp.left=func(pre,in,in_start,idx-1);
        temp.right=func(pre,in,idx+1,in_end);
        return temp;
    }
    public static void inorder(node root)
    {
        if(root==null)
        return;
        inorder(root.left);
        System.out.print(root.val+" ");
        inorder(root.right);
    }
    public static void main(String args[])
    {
        int pre[]={3,9,20,15,7};
        int in[]={9,3,15,20,7};
        node ans=func(pre,in,0,in.length-1);
        inorder(ans);
        System.out.println();
    }
}