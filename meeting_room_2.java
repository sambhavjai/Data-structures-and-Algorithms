// Given the start and end times of meetings
// Find the mimimum number of meeting rooms required for all the meetings
import java.util.*;
public class meeting_room_2{
    public static int func(int start[],int end[])
    {
        Arrays.sort(start);  // Sort the start and end arrays seperately
        Arrays.sort(end);
        int count=0,i=0,j=0,max=Integer.MIN_VALUE;
        while(i<start.length&&j<end.length)
        {
            if(start[i]<end[j])
            {
                i++;  // Start of next meeting lies in between the current meeting then increase count
                count++;
            }
            else if(start[i]>=end[j])
            {
                j++; // Next meeting starts after current end so 1 meeting room gets free
                count--;
            }
            if(count>max)
            max=count;
        }
        return max;
    }
    public static void main(String args[])
    {
        int start[]={0,5,15};
        int end[]={30,10,20};
        System.out.println(func(start,end));
    }
}