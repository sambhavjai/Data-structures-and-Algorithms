import java.util.*;
public class min_window_substring{
    // Given a text and a pattern find the minimum sized window in the text such that it contains all the characters of pattern
    // We follow valid-invalid approach
    // If the char at end is valid we keep on acquiring it till it remains valid
    // once it becomes max valid we settle for the answer then we start dropping chars at start idx till it become invalid again
    // then acquire through end idx again to make it valid 
    // The the validity is checked by using match count we increase the value of match count whenever we encounter a valid character
    // max validity is checked when max count becomes equal to the pattern length
    public static String func(String text,String pat)
    {
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<pat.length();i++)
        {
            map.put(pat.charAt(i),map.getOrDefault(pat.charAt(i),0)+1); // frequency map of pattern
        }
        HashMap<Character,Integer> q=new HashMap<>(); // for storing the valid character count in text
        int start=-1;
        int end=0;
        int mc=0; // match count 
        int i=1,j=Integer.MAX_VALUE; // storing the answer idx values
        while(end<text.length())
        {
            if(mc!=pat.length()) // if it in not valid
            {
                if(map.containsKey(text.charAt(end))) // if it is present in the pattern
                {
                    q.put(text.charAt(end),q.getOrDefault(text.charAt(end),0)+1); // update the frequency
                    if(q.get(text.charAt(end))<=map.get(text.charAt(end))) // check if the count updated is less than required
                    mc++; // if yes then increase match count as we have found a match
                }
                end++;
            }
            else
            {
                if(end-start-1<j-i+1) // settle for the min score
                {
                    i=start+1;
                    j=end-1;
                }
                start++;
                if(map.containsKey(text.charAt(start))) // if it present in pattern
                {
                    q.put(text.charAt(start),q.get(text.charAt(start))-1); // reduce the char count in current frequency
                    if(q.get(text.charAt(start))<map.get(text.charAt(start))) // if it becomes smaller than required decrease the match count to declare invalid condition
                    mc--; // if it becomes invalid decrease the match count
                }
            }
        }
        // for completing the course of start variable so that we can find the min length window
        while(start<text.length()&&mc==pat.length())
        {
            if(end-start-1<j-i+1)
                {
                    i=start+1;
                    j=end-1;
                }
                start++;
                if(map.containsKey(text.charAt(start)))
                {
                    q.put(text.charAt(start),q.get(text.charAt(start))-1);
                    if(q.get(text.charAt(start))<map.get(text.charAt(start)))
                    mc--;
                }
        }
        if(j==Integer.MAX_VALUE) // if no window is found still it means the min length of window is 0 so return ""
        return "";
        return text.substring(i,j+1);
    }
    public static void main(String args[])
    {
        String text="ADOBECODEBANC";
        String pat = "ABC";
        System.out.println(func(text,pat));
    }
}