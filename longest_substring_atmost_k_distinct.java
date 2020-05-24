import java.util.*;
public class longest_substring_atmost_k_distinct{
    // find the length of the longest substring with atmost k distinct characters
    // we use the simple valid-invalid approach
    public static int func(String s,int k)
    {
        HashMap<Character,Integer> map=new HashMap<>();
        int start=-1;
        int end=0;
        int max=0;
        while(end<s.length())
        {
            if(map.size()<=k)
            {
                // acquire till the size is less than or equal to k that is it is valid
                map.put(s.charAt(end),map.getOrDefault(s.charAt(end),0)+1);
                if(map.size()<=k) // since we require atmost k so we settle at every acquire step
                max=Math.max(max,end-start);
                end++;
            }
            else
            { 
                // once it comes greater than k we will have to release characters to make it valid once again
                start++;
                map.put(s.charAt(start),map.get(s.charAt(start))-1);
                if(map.get(s.charAt(start))==0)
                map.remove(s.charAt(start));
            }
        }
        return max;
    }
    public static void main(String args[])
    {
        String s="eceba";
        int k=3;
        System.out.println(func(s,k));
    }
}