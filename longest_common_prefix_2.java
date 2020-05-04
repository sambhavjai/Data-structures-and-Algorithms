public class longest_common_prefix_2{
    // Find the longest common prefix among the string array
    // We use divide and conquer; complexity : o(sum of all characters in the string array)
    public static String lcp(String left,String right)
    {
        int min=Math.min(left.length(),right.length()); // lcp cannot be greater than min of the 2 lengths
        String prefix=left; // assume the lcp to be left part
        for(int i=0;i<min;i++)
        {
            if(prefix.charAt(i)!=right.charAt(i)) // if a non similarity found then return the substring of prefix upto i
            return prefix.substring(0,i);
        }
        return prefix; // this means that both the strings are same
    }
    public static String func(String arr[],int start,int end)
    {
        if(start==end)
        return arr[start];
        int middle=(start+end)/2;
        String left=func(arr,start,middle); // get the lcp for left part
        String right=func(arr,middle+1,end); // get the lcp for right part
        return lcp(left,right); // find the lcp for left and right lcp's
    }
    public static void main(String args[])
    {
        String strs[]={"flower","flow","flight"};
        System.out.println(func(strs,0,strs.length-1));
    }
}