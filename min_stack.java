public class min_stack{
    // We use linked list for stack implementation and store the min value of the stack in the top node
    // We use this and not the traditional formula due to overflow errors by multipying the min element
    // formula used : when pushing a number less than min push (2*input-min) and min=input
    //                when popping a number and the number is less than min then min=2*min-popped value
    public static class node{
        int val;
        int min;
        node next;
        public node(int val,int min)
        {
            this.val=val;
            this.min=min;
        }
    }
    public static class stack{
        node head;
        public stack(){
            head=null;
        }
        public void push(int x)
        {
            if(head==null)
            {
                head=new node(x,x);
            }
            else
            {
                node temp=new node(x,Math.min(x,head.min)); // we update min as min of current min or input value
                temp.next=head;
                head=temp;
            }
        }
        public int pop(){
            int ans=head.val;
            head=head.next;
            return ans;
        }
        public int peek()
        {
            return head.val;
        }
        public int get_min()
        {
            return head.min;
        }
    }
    public static void main(String args[])
    {
        stack obj=new stack();
        obj.push(1);
        obj.push(6);
        System.out.println(obj.get_min());
        System.out.println(obj.peek());
        System.out.println(obj.pop());
        obj.push(-3);
        obj.push(10);
        obj.push(-4);
        System.out.println(obj.get_min());
    }
}