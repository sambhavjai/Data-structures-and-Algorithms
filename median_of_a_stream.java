import java.util.*;
public class median_of_a_stream{
    // Find the median in a stream of integers
    // We maintain 2 priorityQueues max and min
    // max is a max pq containing all integers from lower half of the array
    // min is a min pq containing all integers from upper half of the array
    // the pq are maintained such that max pq has 1 element greater than min pq incase of odd no of elements
    // so median at any point will be if size of both pq are not equal then the peek value of max pq
    // if size of both pq is equal then average of peeks of both pq
    public static class median{
        PriorityQueue<Integer> max;
        PriorityQueue<Integer> min;
        public median()
        {
            max=new PriorityQueue<>(Collections.reverseOrder());
            min=new PriorityQueue<>();
        }
        public void add(int val)
        {
            // to add elements in the array
            // add element to the max pq
            // then to compensate take the max element from bottom half and put in upper half (min pq)
            // if size of min pq becomes greater than size of max pq that is our condition breaches then readjust it
            // by giving the min element of upper half to lower half
            max.add(val);
            min.add(max.remove());
            if(min.size()>max.size())
            max.add(min.remove());
        }
        // time complexity of add() will be o(log n) as at max there will be only 3 insertions and 2 removals from a pq which are all of log n time
        public double get_median()
        {
            if(min.size()==max.size())
            return (min.peek()+max.peek())/2.0;
            else
            return (max.peek())/1.0;
        }
    }
    public static void main(String args[])
    {
        median obj=new median();
        obj.add(1);
        obj.add(2);
        System.out.println(obj.get_median());
        obj.add(2);
        System.out.println(obj.get_median());
    }
}