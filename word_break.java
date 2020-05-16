import java.util.*;
public class word_break{
    // Given a string and a dictionary of words break the string into space seperated words such that each word exists in the dictionary
    // Do in an efficient way
    // We use dp memoisation in using simple postorder recursion
    // We use a hashmap for memoisation in from of input_string  --->  List<String> possible with the input
    public static HashSet<String> set;
    public static HashMap<String,List<String>> dp;
    public static List<String> func(String s)
    {
        if(dp.containsKey(s))
        return dp.get(s);
        if(s.length()==0)
        {
            List<String> base=new ArrayList<>();
            base.add("");
            return base;
        }
        String c="";
        List<String> ans=new ArrayList<>();
        for(int i=0;i<s.length();i++)
        {
            c=c+s.charAt(i);
            if(set.contains(c))
            {
                List<String> smallans=func(s.substring(i+1));
                for(int j=0;j<smallans.size();j++)
                {
                    ans.add(c+" "+smallans.get(j));
                }
            }
        }
        List<String> temp=new ArrayList<>();
        for(int i=0;i<ans.size();i++)
        {
            temp.add(ans.get(i));
        }
        dp.put(s,temp);
        return ans;
    }
    public static void main(String args[])
    {
        set=new HashSet<>();
        dp=new HashMap<>();
        String s="catsanddog";
        List<String> dict=new ArrayList<>(Arrays.asList("cat","cats","and","dog","sand"));
        for(int i=0;i<dict.size();i++)
        {
            set.add(dict.get(i));
        }
        List<String> ans=func(s);
        System.out.println(ans);
    }
}