public class intersection_linked_list{
    public static class node{
        int val;
        node next;
        public node(int val)
        {
            this.val=val;
        }
    }
    public static int get_length(node head)
    {
        int length=0;
        while(head!=null)
        {
            length++;
            head=head.next;
        }
        return length;
    }
    public static node func(node head1,node head2)
    {
        if(head1==null||head2==null)
        return null;
        int length_1=get_length(head1);
        int length_2=get_length(head2);
        node temp1=head1;
        node temp2=head2;
        int d=Math.abs(length_1-length_2); // we calculate the difference in length of linked list and traverse the larger linked list till the difference exists
        if(length_1>length_2)
        {
            while(d>0)
            {
                temp1=temp1.next;
                d--;
            }
        }
        else if(length_2>length_1)
        {
            while(d>0)
            {
                temp2=temp2.next;
                d--;
            }
        }
        // now both pointers are at the same distance from the merging node so when they meet we have our common node
        while(temp1!=temp2)
        {
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return temp1;
    }
    public static void main(String args[])
    {
        node head1=new node(1);
        head1.next=new node(2);
        head1.next.next=new node(3);
        head1.next.next.next=new node(4);
        head1.next.next.next.next=new node(5);
        node head2=new node(6);
        head2.next=new node(7);
        head2.next.next=head1.next.next;
        // 1 - 2 - 3 - 4 - 5
        // 6 - 7 - |
        node ans=func(head1,head2);
        System.out.println(ans.val);
    }
}