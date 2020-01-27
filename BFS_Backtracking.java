//We need to print the strings generated with minimum removals in the given string such that it is valid
//We remove one item in each level and if a valid string is found then all the solutions of that level are printed
//Levels are traversed using BFS so that we get the immediate neighbour level
import java.util.*;
public class BFS_Backtracking{
    public static boolean is_valid(String a)
    {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<a.length();i++)
        {
            if(a.charAt(i)=='(')
            st.push(a.charAt(i));
            else if(a.charAt(i)==')')
            {
                if(st.empty())
                return false;
                else
                st.pop();
            }
        }
        if(!st.empty())
        return false;
        return true;
    }
    public static void helper(String s)
    {
        if(s.length()==0)
        return;
        Queue<String> q=new LinkedList<>();
        q.add(s);
        HashSet<String> set=new HashSet<>(); // to check for visited nodes in BFS
        set.add(s);
        boolean ans_level=false;
        while(!q.isEmpty())
        {
            s=q.remove();
            if(is_valid(s))
            {
                System.out.println(s);
                ans_level=true;
            }
            if(ans_level)
            continue;
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)=='('||s.charAt(i)==')')
                {
                   String z=s.substring(0,i)+s.substring(i+1);
                   if(!set.contains(z))
                   {
                       q.add(z);
                       set.add(z);
                   }
                }
            }
        } 
    }
     public static void main(String args[])
     {
         String s="(v)())()";
         helper(s);
     }
}