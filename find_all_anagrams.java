import java.util.*;
public class find_all_anagrams {
    // Find the indices of all the anagrams of string p in string s
    // Create a hashmap of p and form hashmap of s in sliding window of size p and check for equality of 2 hashmaps
    public static List<Integer> func(String s, String p)
    {
        List<Integer> ans=new ArrayList<>();
        HashMap<Character,Integer> map=new HashMap<>();
        HashMap<Character,Integer> temp=new HashMap<>();
        for(int i=0;i<p.length();i++)
        {
            map.put(p.charAt(i),map.getOrDefault(p.charAt(i),0)+1); // hashmap of p
        }
        int start=-1,end=0;
        while(end-start<=p.length())
        {
            if(end<s.length())
            temp.put(s.charAt(end),temp.getOrDefault(s.charAt(end),0)+1); // form a window of size p along with map of s
            end++;
        }
        if(map.equals(temp))
        ans.add(start+1); // check if anagram is present at index 0
        while(end<s.length())
        {
            if(end<s.length())
                temp.put(s.charAt(end),temp.getOrDefault(s.charAt(end),0)+1); // add chars entering the window to map of s
            start++;
            temp.put(s.charAt(start),temp.get(s.charAt(start))-1); // remove chars leaving from window from map of s
            if(temp.get(s.charAt(start))==0)
                temp.remove(s.charAt(start));
             end++;
            if(map.equals(temp))
                ans.add(start+1); // check for equality of 2 maps
        }
        return ans;
    }
    // the process to check equality of 2 maps can be said to be of atmost 26 iterations as chars are always between a-z making it an almost constant operation
    public static void main(String args[])
    {
        String s="cbaebabacd";
        String p="abc";
        System.out.println(func(s,p));
    }
}
