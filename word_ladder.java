import java.util.*;
public class word_ladder{
    // Given a begin word and an end word and a dictionary of words we have to find the minimum steps in which we can reach from begin word to end word
    // in each step we can change only 1 letter and each intermediate word must be present in the dictionary
    // We create a graph of words which differ only by 1 character from the dictionary
    // then we start from the begin word and apply bfs till the end word maintaining a level value at each word and incrementing it for the next word
    // we create a graph by taking all the generic forms of each word by having 1 letter missing each time
    // i.e, if we have "hit" the generic form "*it","h*t","hi*" will be present in the key of the graph with edges to all the words which can formed using this generic form
    // then we apply the bfs
    public static class pair{
        String word;
        int level;
        public pair(String word,int level)
        {
            this.word=word;
            this.level=level;
        }
    }
    public static int simple_bfs(String begin,String end,ArrayList<String> dict)
    {
        HashMap<String,ArrayList<String>> graph=new HashMap<>();
        for(int i=0;i<dict.size();i++) // creating the graph of generic forms
        {
            String word=dict.get(i);
            for(int j=0;j<word.length();j++)
            {
                String key=word.substring(0,j)+"*"+word.substring(j+1);
                ArrayList<String> value=graph.getOrDefault(key, new ArrayList<String>());
                value.add(word);
                graph.put(key,value);
            }
        }
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(begin,1));
        HashSet<String> visited=new HashSet<>();
        while(q.size()>0)
        {
            pair temp=q.remove();
            if(temp.word.equals(end))
            return temp.level;
            visited.add(temp.word);
            for(int i=0;i<temp.word.length();i++)
            {
                String key=temp.word.substring(0,i)+"*"+temp.word.substring(i+1);
                if(graph.containsKey(key)) // create generic forms for the temp word and look for other words which can be reached from this word using the generic form
                {                          // those will be the words which can be reached from the current word by just 1 change hence their neighbours in graph
                    ArrayList<String> value=graph.get(key);
                    for(int j=0;j<value.size();j++)
                    {
                        if(!visited.contains(value.get(j)))
                        {
                            q.add(new pair(value.get(j),temp.level+1));
                        }
                    }
                }
            }
        }
        return 0;
    }
    public static int bfs_hop(Queue<pair> q,HashMap<String,Integer> visited,HashMap<String,Integer> other_visited,HashMap<String,ArrayList<String>> graph)
    {
        pair temp=q.remove();
        for(int i=0;i<temp.word.length();i++)
        {
            String key=temp.word.substring(0,i)+"*"+temp.word.substring(i+1);
            if(graph.containsKey(key))
            {
                ArrayList<String> value=graph.get(key);
                for(int j=0;j<value.size();j++)
                {
                    if(other_visited.containsKey(value.get(j))) // if this node has been found by the other bfs
                    {
                        return other_visited.get(value.get(j))+temp.level;
                    }
                    if(!visited.containsKey(value.get(j)))
                    {
                        visited.put(value.get(j),temp.level+1);
                        q.add(new pair(value.get(j),temp.level+1));
                    }
                }
            }
        }
        return -1;
    }
    // Since we original bfs can be very tedious for a complete tree so we switch to bi-directional bfs
    // we start 2 bfs, one from the start node and other from the end node and let them meet in the middle
    // answer will be sum of number of steps taken by each bfs till the node where they meet
    public static int bidirectional_bfs(String begin,String end,ArrayList<String> dict)
    {
        if(!dict.contains(end))
        return 0; // adding condition to check if the end node is even present in the dictionary or not
        HashMap<String,ArrayList<String>> graph=new HashMap<>();
        for(int i=0;i<dict.size();i++)
        {
            String word=dict.get(i);
            for(int j=0;j<word.length();j++) // creating the graph
            {
                String key=word.substring(0,j)+"*"+word.substring(j+1);
                ArrayList<String> value=graph.getOrDefault(key, new ArrayList<String>());
                value.add(word);
                graph.put(key,value);
            }
        }
        Queue<pair> begin_q=new LinkedList<>();
        Queue<pair> end_q=new LinkedList<>();
        HashMap<String,Integer> visited_begin=new HashMap<>();
        HashMap<String,Integer> visited_end=new HashMap<>();
        begin_q.add(new pair(begin,1));
        end_q.add(new pair(end,1));
        visited_begin.put(begin,1); // mark both as visited in the start
        visited_end.put(end,1);
        while(begin_q.size()>0&&end_q.size()>0)
        {
            int ans=bfs_hop(begin_q,visited_begin,visited_end,graph); // apply a single hop in both the bfs at the same time and look for answer
            if(ans!=-1)
            return ans;
            ans=bfs_hop(end_q,visited_end,visited_begin,graph);
            if(ans!=-1)
            return ans;
        }
        return 0;
    }
    public static void main(String args[])
    {
        ArrayList<String> dict=new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"));
        String beginWord="hit";
        String endWord="cog";
        //System.out.println(simple_bfs(beginWord,endWord,dict));
        System.out.println(bidirectional_bfs(beginWord,endWord,dict));
    }
}
