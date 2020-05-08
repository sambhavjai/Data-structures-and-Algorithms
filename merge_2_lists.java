public class merge_2_lists
{
    // Merge 2 sorted linked lists
    public static class node{
        int val;
        node next;
        public node(int val)
        {
            this.val=val;
        }
    }
    public static node func(node head1,node head2)
    {
        if(head1==null) // if either of the lists is null return the other one
        return head2;
        if(head2==null)
        return head1;
        if(head1.val<=head2.val)
        {
            head1.next=func(head1.next,head2); // add the merged lists for the remaining one after the smaller node among the heads
            return head1;
        }
        else
        {
            head2.next=func(head1,head2.next);
            return head2;
        }
    }
    public static void main(String args[])
    {
        node head1=new node(1);
        head1.next=new node(2);
        head1.next.next=new node(4);
        node head2=new node(1);
        head2.next=new node(3);
        head2.next.next=new node(4);
        node ans=func(head1,head2);
        while(ans!=null)
        {
            System.out.print(ans.val+" ");
            ans=ans.next;
        }
        System.out.println();
    }
}