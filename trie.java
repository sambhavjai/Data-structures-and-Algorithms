public class trie{
    public static class node{
        char ch;
        node next[];
        boolean end;
        public node(char ch)
        {
            this.ch=ch;
            this.next=new node[26];
            this.end=false;
            for(int i=0;i<next.length;i++)
            {
                this.next[i]=null;
            }
        }
    }
    public static class Trie {
        node root;
        node temp;
        public Trie() {
            root=new node('$');
            temp=null;
        }
        public void insert(String word) {
            int i=0;
            temp=root;
            while(i<word.length()&&temp.next[word.charAt(i)-'a']!=null)
            {
                temp=temp.next[word.charAt(i)-'a'];
                i++;
            }
            while(i<word.length())
            {
                temp.next[word.charAt(i)-'a']=new node(word.charAt(i));
                temp=temp.next[word.charAt(i)-'a'];
                i++;
            }
            temp.end=true;
        }
        public boolean search(String word) {
            int i=0;
            temp=root;
            while(i<word.length()&&temp!=null)
            {
                temp=temp.next[word.charAt(i)-'a'];
                i++;
            }
            if(i==word.length()&&temp.end==true)
                return true;
            return false;
        }
        public boolean startsWith(String word) { // Search for a given prefix;
        int i=0;
        temp=root;
        while(i<word.length()&&temp!=null)
        {
            temp=temp.next[word.charAt(i)-'a'];
            i++;
        }
        if(i==word.length()&&temp!=null)
            return true;
        return false;
        }
    }
    public static void main(String args[])
    {
        Trie obj=new Trie();
        obj.insert("apple");
        System.out.println(obj.search("apple"));
        System.out.println(obj.startsWith("app"));
        System.out.println(obj.search("app"));
        obj.insert("app");
        System.out.println(obj.search("app"));
    }
}