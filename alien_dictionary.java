import java.util.*;
public class alien_dictionary{
    // Given a dictionary of words in an alien language return a string containing characters of the language in their order
    // We create a graph of characters in the language
    // no. of vertices is the no of characters in the language
    // we start by taking 2 adjacent words each time and traverse in the words
    // whenever we get a mismatching character in the 2 strings we make an edge from the mismatching character of first string to the second string
    // now we perform a topological sort of the above created graph
    public static void helper(HashMap<Character,ArrayList<Character>> graph,Stack<Character> st,char ch,HashMap<Character,Boolean> visited)
    {
        visited.put(ch,true);
        ArrayList<Character> temp=graph.get(ch);
        for(int i=0;i<temp.size();i++)
        {
            if(visited.get(temp.get(i))==false)
            helper(graph,st,temp.get(i),visited);
        }
        st.push(ch);
    }
    public static Stack<Character> topological_sort(HashMap<Character,ArrayList<Character>> graph)
    {
        Stack<Character> st=new Stack<>();
        HashMap<Character,Boolean> visited=new HashMap<>();
        for(Map.Entry<Character,ArrayList<Character>> entry:graph.entrySet())
        {
            visited.put(entry.getKey(),false);
        }
        for(Map.Entry<Character,ArrayList<Character>> entry:graph.entrySet())
        {
            if(visited.get(entry.getKey())==false)
            helper(graph,st,entry.getKey(),visited);
        }
        return st;
    }
    public static String func(String words[])
    {
        HashSet<Character> set=new HashSet<>(); // for counting the number of distinct characters
        for(int i=0;i<words.length;i++)
        {
            String temp=words[i];
            for(int j=0;j<temp.length();j++)
            {
                set.add(temp.charAt(j));
            }
        }
        HashMap<Character,ArrayList<Character>> graph=new HashMap<>();
        for(Character c:set)
        {
            graph.put(c,new ArrayList<>());
        }
        for(int i=0;i<words.length-1;i++)
        {
            String first=words[i];
            String second=words[i+1];
            for(int j=0;j<Math.min(first.length(),second.length());j++)
            {
                if(first.charAt(j)!=second.charAt(j))
                {
                    graph.get(first.charAt(j)).add(second.charAt(j)); // mismatching occurs we create an edge and break
                    break;
                }
            }
        }
        Stack<Character> st=topological_sort(graph);
        String ans="";
        while(!st.empty())
        {
            ans=ans+st.pop();
        }
        return ans;
    }
    public static void main(String args[])
    {
        String words[]={"baa","abcd","abca","cab","cad"};
        System.out.println(func(words));
    }
}