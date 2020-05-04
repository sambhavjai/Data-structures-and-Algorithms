// Given an array of strings and a string s find the longest common prefix among the array of strings and s
public class longest_common_prefix_4{
    // We store the array of strings in the form of a trie and find the common prefix of the string s and the trie
    public static class node{
        char val;
        boolean isEnd;
        node child[];
        int childCount;
        public node(char val)
        {
            this.val=val;
            child=new node[26];
            for(int i=0;i<child.length;i++)
            {
                this.child[i]=null;
            }
            this.isEnd=false;
            childCount=0;
        }
    }
    public static class trie{
        node root;
        public trie()
        {
            root=new node('$');
        }
        public void insert(String s) // inserting into the trie
        {
            node temp=root;
            int idx=0;
            while(idx<s.length()&&temp.child[s.charAt(idx)-'a']!=null)
            {
                temp=temp.child[s.charAt(idx)-'a'];
                idx++;
            }
            if(idx==s.length())
            temp.isEnd=true;
            else{
                while(idx<s.length())
                {
                    temp.child[s.charAt(idx)-'a']=new node(s.charAt(idx));
                    temp.childCount++;
                    temp=temp.child[s.charAt(idx)-'a'];
                    idx++;
                }
                temp.isEnd=true;
            }
        }
        public String find_prefix(String s) // finding prefix
        {
               String prefix="";
	            node temp=root.child[s.charAt(0)-'a']; // put temp into the first character of s
	            if(temp==null)
	            return ""; // if not found then no lcp exists
	            int idx=0;
	            while(idx<s.length())
	            {
	                prefix=prefix+s.charAt(idx); // add current character to prefix
	                if(temp.childCount>1&&temp.isEnd) // if the trie seperates from here on then we have the prefix as the next character will be different for some string
	                return prefix;// if the trie has an ending word here we have found the prefix as this is the min length word ending here
	                idx++;
	                temp=temp.child[s.charAt(idx)-'a'];
	                if(temp==null) // if no further character of s is present in the trie it means we have found the prefix
	                	return prefix;
	            }
	            return prefix;
        }
    }
    public static void main(String args[])
    {
        String arr[]={"flower","flue","flight"};
        String s="flame";
        trie obj=new trie();
        for(int i=0;i<arr.length;i++)
        {
            obj.insert(arr[i]);
        }
        System.out.println(obj.find_prefix(s));
    }
}