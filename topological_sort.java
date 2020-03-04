import java.util.*;
public class topological_sort{
    public static boolean flag=true;
    public static void func(ArrayList<ArrayList<Integer>> graph,int src,Stack<Integer> st,int visited[])
    {   // works for directed acyclic graphs only
        if(flag==false)
            return;
        visited[src]=1;
        for(int i=0;i<graph.get(src).size();i++)
        {
            int v=graph.get(src).get(i);
            if(visited[v]==0)
                func(graph,v,st,visited);
            else if(visited[v]==1) // detecting cycle
                flag=false;
        }
        visited[src]=2; // for cases like only 1->0
        st.push(src);
    }
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        flag=true;
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
        {
            graph.add(new ArrayList<Integer>());
        }
        for(int i=0;i<prerequisites.length;i++)
        {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        Stack<Integer> st=new Stack<>();
        int visited[]=new int[numCourses];
        for(int i=0;i<graph.size();i++)
        {
            if(visited[i]==0)
                func(graph,i,st,visited);
        }
        if(flag==false)
            return new int[0];
        int ans[]=new int[st.size()];
        int i=0;
        while(!st.empty())
        {
            ans[i]=st.pop();
            i++;
        }
        return ans;
    }
    public static void main(String args[])
    {
        int prerequisites[][]={{1,0},{2,0},{3,1},{3,2}}; // graph : 0->1  0->2  1->3  2->3 
        int ans[]=findOrder(4, prerequisites);
        for(int i=0;i<ans.length;i++)
        {
            System.out.println(ans[i]);
        }
    }
}