// Given the start and end times of meetings and 1 meeting room
// Find the maximum number of meeting which can happen in the meeting room
import java.util.*;
public class meeting_room_1{
    public static class pair{
        int a;
        int b;
        int pos;
        public pair(int a,int b,int pos)
        {
            this.a=a;
            this.b=b;
            this.pos=pos;
        }
    }
    public static class pairComparator implements Comparator<pair>
    {
        public int compare(pair a,pair b)
        {
            return a.b-b.b;
        }
    }
    public static String func(int start[],int end[])
    {
        PriorityQueue<pair> pq=new PriorityQueue<>(new pairComparator()); // Sort all the pairs on basis of end times
        for(int i=0;i<start.length;i++)
        {
            pq.add(new pair(start[i],end[i],i));
        }
        String ans="";
        int limit=0; // make the end time of first element as limit
        while(pq.size()>0)
        {
            pair p=pq.remove();
            if(p.a>=limit) // if the start time of next meet is greater than the end time of previous meet then it can be done
            {
                ans=ans+p.pos;
                limit=p.b;
            }
        }
        return ans;
    }
    public static void main(String args[])
    {
        int start[]={1,3,0,5,8,5};
        int end[]={2,4,6,7,9,9};
        // Printing the indices of meeting which can be completed
        System.out.println(func(start,end));
    }
}