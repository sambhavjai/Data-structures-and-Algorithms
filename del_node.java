public class del_node{
    // delete a node in the linked list given only the node to be deleted not the head
    public static class node{
        int val;
        node next;
        public node(int val)
        {
            this.val=val;
            next=null;
        }
    }
    public static void func(node head)
    {
        head.val=head.next.val; // copy the value of next node in current node
        head.next=head.next.next; // delete the next node
    }
    public static void main(String args[])
    {
        node head=new node(1);
        head.next=new node(2);
        head.next.next=new node(3);
        head.next.next.next=new node(4);
        head.next.next.next.next=new node(5);
        func(head.next.next);
        while(head!=null)
        {
            System.out.print(head.val+" ");
            head=head.next;
        }
        System.out.println();
    }
}