// Flatten a given nested list using iterator into a 1-d array
// the given list can integer or a list of integer
// each entry in the list is denoted by NestedInteger
import java.util.*;
public class flatten_nested_iterator{
    public static class NestedInteger
    {
        int i;
        List<NestedInteger> list;
        public NestedInteger(int i,List<NestedInteger> list){
            this.i=i;
            this.list=list;
        }
        public boolean isInteger()
        {
            return list==null;
        }
        public int getInteger()
        {
            return i;
        }
        public List<NestedInteger> getList()
        {
            return list;
        }
    }
    // Using stack we are collecting all the objects of NestedInteger and using its function for flattening
    public static class NestedIterator implements Iterator<Integer>{
        Stack<NestedInteger> st=new Stack<>();
        public NestedIterator(List<NestedInteger> list)
        {
            for(int i=list.size()-1;i>=0;i--)
            {
                st.push(list.get(i));
            }
        }
        @Override
        public Integer next()
        {
            return st.pop().getInteger();
        }
        @Override
        public boolean hasNext()
        {
            while(!st.empty())
            {
                if(st.peek().isInteger()==true)
                {
                    return true;
                }
                else
                {
                    List<NestedInteger> temp=st.pop().getList();
                    for(int i=temp.size()-1;i>=0;i--)
                    {
                        st.push(temp.get(i));
                    }
                }
            }
            return false;
        }
    }
    public static void main(String args[])
    {
        List<NestedInteger> list=new ArrayList<>(Arrays.asList(new NestedInteger(1,null),new NestedInteger(Integer.MIN_VALUE,new ArrayList<NestedInteger>(Arrays.asList(new NestedInteger(4,null),new NestedInteger(Integer.MIN_VALUE,new ArrayList<NestedInteger>(Arrays.asList(new NestedInteger(6,null)))))))));
        NestedIterator obj=new NestedIterator(list);
        // list = [1,[4,[6]]]
        ArrayList<Integer> ans=new ArrayList<>();
        while(obj.hasNext())
        {
            ans.add(obj.next());
        }
        System.out.println(ans);
    }
}