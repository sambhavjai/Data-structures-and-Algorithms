import java.util.*;
public class word_search{
    public static List<String> ans;
    public static HashSet<String> words;
    public static HashSet<String> set;
    public static class node{
        char c;
        boolean end;
        node child[];
        public node(char c)
        {
            this.c=c;
            end=false;
            child=new node[26];
        }
    }
    public static class trie{
        node root;
        public trie()
        {
            root=new node('$');
        }
        public void insert(String s)
        {
            int idx=0;
            node temp=root;
            while(idx<s.length()&&temp.child[s.charAt(idx)-'a']!=null)
            {
                temp=temp.child[s.charAt(idx)-'a'];
                idx++;
            }
            while(idx<s.length())
            {
                temp.child[s.charAt(idx)-'a']=new node(s.charAt(idx));
                temp=temp.child[s.charAt(idx)-'a'];
                idx++;
            }
            temp.end=true;
        }
        public void search(char board[][],int i,int j,String asf,boolean visited[][],node temp)
        {
            temp=temp.child[board[i][j]-'a'];
            asf=asf+board[i][j];
            if(temp.end==true&&!set.contains(asf))
            {
                set.add(asf);
                ans.add(asf);
            }
            if(i+1<board.length&&temp.child[board[i+1][j]-'a']!=null&&!visited[i+1][j])
            search(board,i+1,j,asf,visited,temp);
            if(j+1<board[0].length&&temp.child[board[i][j+1]-'a']!=null&&!visited[i][j+1])
            search(board,i,j+1,asf,visited,temp);
            if(i-1>=0&&temp.child[board[i-1][j]-'a']!=null&&!visited[i-1][j])
            search(board,i-1,j,asf,visited,temp);
            if(j-1>=0&&temp.child[board[i][j-1]-'a']!=null&&!visited[i][j-1])
            search(board,i,j-1,asf,visited,temp);
        }
    }
    public static void recur_helper(char board[][],int i,int j,String asf,boolean visited[][])
    {
        asf=asf+board[i][j];
        if(words.contains(asf)&&!set.contains(asf)) // set is used to avoid repetition
        {
            ans.add(asf);
            set.add(asf);
        }
        visited[i][j]=true;
        if(i+1<board.length&&!visited[i+1][j])
        recur_helper(board,i+1,j,asf,visited);
        if(j+1<board[0].length&&!visited[i][j+1])
        recur_helper(board,i,j+1,asf,visited);
        if(i-1>=0&&!visited[i-1][j])
        recur_helper(board,i-1,j,asf,visited);
        if(j-1>=0&&!visited[i][j-1])
        recur_helper(board,i,j-1,asf,visited);
        asf=asf.substring(0,asf.length()-1);
        visited[i][j]=false;
    }
    public static List<String> using_recursion(char board[][],String dict[])
    {
        // This is a solution using simple recursion
        ans=new ArrayList<>();
        words=new HashSet<>();
        set=new HashSet<>();
        for(int i=0;i<dict.length;i++)
        {
            words.add(dict[i]);
        }
        for(int i=0;i<board.length;i++)
        { // We call recursion for each element assuming that a word can start from any element in the board
            for(int j=0;j<board[0].length;j++)
            {
                boolean visited[][]=new boolean[board.length][board[0].length];
                recur_helper(board,i,j,"",visited);
            }
        }
        return ans;
    }
    public static List<String> using_trie(char board[][],String dict[])
    {
        // This solution is using trie and it is the efficient solution
        // we add the dictionary words in a trie then we traverse onto the entire board and search for only those characters which are children of the root node of trie
        // We search the board starting from root for every character matched and if it gives a true in the trie then it becomes and answer
        ans=new ArrayList<>();
        set=new HashSet<>();
        words=new HashSet<>();
        for(int i=0;i<dict.length;i++)
        {
            words.add(dict[i]);
        }
        trie obj=new trie();
        for(int i=0;i<dict.length;i++)
        {
            obj.insert(dict[i]);
        }
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[0].length;j++)
            {
                if(obj.root.child[board[i][j]-'a']!=null)
                {
                    boolean visited[][]=new boolean[board.length][board[0].length];
                    obj.search(board,i,j,"",visited,obj.root);
                }
            }
        }
        return ans;
    }
    public static void main(String args[])
    {
        String dict[]={"oath","pea","eat","rain"};
        char board[][]={"oaan".toCharArray(),"etae".toCharArray(),"ihkr".toCharArray(),"iflv".toCharArray()};
        System.out.println(using_recursion(board,dict));
        System.out.println(using_trie(board,dict));
    }
}