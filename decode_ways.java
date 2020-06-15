import java.util.*;
public class decode_ways{
    // Find the total number of ways a given number in string form can be broken down such that each entry represents a decoding for alphabets
    // that is A=>1,B=>2,C=>3.....
    // We use simple memoization using hashmap
    public static HashMap<String,Integer> dp;
    public static int helper(String s)
    {
        if(dp.containsKey(s))
        return dp.get(s);
        if(s.length()==1&&s.charAt(0)=='0')
        return 0;
        if(s.length()==1||s.length()==0) // base case
        return 1;
        int count=0;
        if(s.charAt(0)!='0') // if the current char is not 0 then call for the next char and add it in the answer
        count=count+helper(s.substring(1));
        if(s.charAt(0)=='1'||(s.charAt(0)=='2'&&s.charAt(1)<='6')) // if the current chars make a valid code then call for the next chars and add in the answer
        count=count+helper(s.substring(2));
        dp.put(s,count);
        return count;
    }
    public static int func(String s)
    {
        if(s.length()==0)
        return 0;
        dp=new HashMap<>();
        return helper(s);
    }
    public static void main(String args[])
    {
        String s="12";
        System.out.println(func(s));
    }
}