import java.util.*;
public class longest_consecutive_sequence{
    // Find out the length of longest consecutive sequence in the given array
    public static int func(int arr[])
    {
        HashSet<Integer> set=new HashSet<>(); // add all elements of the array to a hashset
        for(int i=0;i<arr.length;i++)
        {
            set.add(arr[i]);
        }
        int max_length=0; 
        for(int i=0;i<arr.length;i++)
        {
            if(!set.contains(arr[i]-1)) // if the current element is the start of a sequence then perform
            {
                int curr_length=1;
                int next=arr[i]+1; // take the next consecutive element
                while(set.contains(next)) // increase the length of curr sequence till the next consecutive element lies in the array
                {
                    next++;
                    curr_length++;
                }
                max_length=Math.max(max_length,curr_length);
            }
        }
        return max_length;
    }
    // this approach is necessarily o(n) as we are traversing the array only once
    // if this number is the start of a sequence only then the array will be traversed
    // if it is not then the array will be skipped
    // this will be n^2 only if the while loop runs in each and every case
    // while loop only runs when we have start of a sequence so it is o(n+n) ~ o(n)
    public static void main(String args[])
    {
        int arr[]={100,4,200,2,3,1};
        System.out.println(func(arr));
    }
}