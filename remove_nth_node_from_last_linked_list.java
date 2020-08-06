public class remove_nth_node_from_last_linked_list{
    // remove nth from the end of linked list in a single pass
    // we place the 2 pointers at a distance of n nodes apart then when the first pointer reaches the end the second one will be previous to the the nth node
    public static class node{
        int val;
        node next;
        public node(int val)
        {
            this.val=val;
            this.next=null;
        }
    }
    public static node func(node head,int n)
    {
        node first=head;
        node second=head;
        while(n>0)
        {
            first=first.next;
            n--;
        }
        if(first==null)
        {
            head=head.next;
            return head;
        }
        while(first.next!=null)
        {
            first=first.next;
            second=second.next;
        }
        second.next=second.next.next;
        return head;
    }
    public static void main(String args[])
    {
        node head=new node(1);
        head.next=new node(2);
        head.next.next=new node(3);
        head.next.next.next=new node(4);
        head.next.next.next.next=new node(5);
        int n=2;
        head=func(head,n);
        while(head!=null)
        {
            System.out.println(head.val+" ");
            head=head.next;
        }
    }
}