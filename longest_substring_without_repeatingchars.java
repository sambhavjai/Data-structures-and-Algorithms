import java.util.*;
public class longest_substring_without_repeatingchars{
    // Find the longest substring without repeating characters
    // we follow the valid-invalid approach
    // we acquire till we have no repeating character then we settle and release
    public static int func(String s)
    {
        HashSet<Character> set=new HashSet<>();
        int start=-1,end=0;
        int ans=Integer.MIN_VALUE;
        while(end<s.length())
        {
            if(!set.contains(s.charAt(end)))
            {
                set.add(s.charAt(end));
                end++;
            }
            else
            {
                if(end-start-1>ans)
                ans=end-start-1;
                start++;
                set.remove(s.charAt(start));
            }
        }
        while(start<s.length())
        {
            if(end-start-1>ans)
            ans=end-start-1;
            start++;
        }
        return ans;
    }
    public static void main(String args[])
    {
        String s="abcabcbb";
        System.out.println(func(s));
    }
}