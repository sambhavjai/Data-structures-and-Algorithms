import java.util.*;
public class generate_parenthesis{
    // Given a value n generate all sequences of valid paranthesis using n pairs of paranthesis
    public static ArrayList<String> ans=new ArrayList<>();
    public static void func(int n,int open,int close,String asf)
    {
        // For the sequence to be valid number of opening and closing brackets must be same and equal to n
        if(close==n) // When the close brackets have reached the maximum possible we have got an answer
        {
            ans.add(asf);
            return;
        }
        if(open<n) // if open is less than what needs to be then we add more
        {
            func(n,open+1,close,asf+"(");
        }
        if(close<open) // if close is less than open we add more close to balance the brakcets
        {
            func(n,open,close+1,asf+")");
        }
    }
    public static void main(String args[])
    {
        ans=new ArrayList<>();
        int n=3;
        func(n,0,0,"");
        System.out.println(ans);
    }
}